using System;
using System.Collections.Generic;
using System.Linq;
using System.Data.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Activation;
using System.ServiceModel.Web;
using System.Web.Security;
using System.Web;
using System.Text;
using NeedAGolferWCF.Contracts;
using NeedAGolferWCF.Interfaces;
using NeedAGolferWCF.Security;
using System.Security.Principal;

namespace NeedAGolferWCF
{
    [AspNetCompatibilityRequirements(RequirementsMode = AspNetCompatibilityRequirementsMode.Required)]
    [ServiceBehavior(IncludeExceptionDetailInFaults = true)]
    public class GolferService : MobileService, IGolferService
    {

        public VoidOperationContract CreateGolfer(CreateGolferContract createContract)
        {
            VoidOperationContract contract = new VoidOperationContract();
            
            try
            {
                using (NeedAGolferDataContext dataContext = new NeedAGolferDataContext())
                {

                    var existing = from golfers in dataContext.Golfers
                                   where (golfers.ScreenName == createContract.Name || golfers.EmailAddress == createContract.EmailAddress)
                                   select golfers;

                    if (existing.Count() == 0)
                    {
                        Golfer golfer = new Golfer();
                        golfer.EmailAddress = createContract.EmailAddress;
                        golfer.AllowEmails = false;
                        golfer.PhoneNumber = createContract.PhoneNumber;
                        golfer.IsAvailable = true;
                        golfer.Handicap = createContract.Handicap;
                        golfer.Latitude = createContract.Latitude;
                        golfer.Longitude = createContract.Longitude;
                        golfer.LastUpdated = DateTime.Now;
                        golfer.ScreenName = createContract.Name;
                        golfer.AvailabilityDistance = createContract.AvailabilityDistanceInMiles;

                        string salt = PasswordCrypto.GetSalt();
                        string hashedPassword = PasswordCrypto.ComputeHash(createContract.Password, "SHA256", salt);
                        golfer.PasswordHash = hashedPassword;
                        golfer.PasswordSalt = salt;

                        dataContext.Golfers.InsertOnSubmit(golfer);
                        dataContext.SubmitChanges();
                        dataContext.Connection.Close();
                    }
                    else
                    {
                        contract.ErrorMessage = "There is already a user registered with this screen name or email address.  Please try again.";
                    }
                }
                
            }
            catch (Exception ex)
            {
                contract.ErrorMessage = ex.Message;
            }
            return contract;
        }

        public GolferContract GetGolfer(LoginContract loginContract)
        {
            using (NeedAGolferDataContext dataContext = new NeedAGolferDataContext())
            {
                Logging loggingInfo = new Logging();
                loggingInfo.CreatedDate = DateTime.Now;
                loggingInfo.DeviceId = loginContract.DeviceId;
                loggingInfo.OSVersion = loginContract.OSVersion;
                loggingInfo.UserAccount = loginContract.UserAccount;
                loggingInfo.DeviceType = loginContract.DeviceType;
                dataContext.Loggings.InsertOnSubmit(loggingInfo);
                dataContext.SubmitChanges();
                dataContext.Connection.Close();
            }
           

            var golferRetriever = RetrieverFactory.CreateInterface<IGolferRetriever>();
            var golfer = golferRetriever.LoadByGolferId(CurrentSession.GolferId);
            GolferContract contract = new GolferContract(golfer);
            return contract;
        }


        public GolferContract UpdateGolfer(CreateGolferContract updatedGolfer)
        {

            var golferRetriever = RetrieverFactory.CreateInterface<IGolferRetriever>();
            var foundGolfer = golferRetriever.LoadByGolferId(CurrentSession.GolferId);

            using (NeedAGolferDataContext dataContext = new NeedAGolferDataContext())
            {
                foundGolfer.AllowEmails = updatedGolfer.AllowEmails;
                foundGolfer.AvailabilityDistance = updatedGolfer.AvailabilityDistanceInMiles;
                foundGolfer.EmailAddress = updatedGolfer.EmailAddress;
                foundGolfer.Handicap = updatedGolfer.Handicap;
                foundGolfer.IsAvailable = updatedGolfer.IsAvailable;
                foundGolfer.LastUpdated = DateTime.Now;
                foundGolfer.Latitude = updatedGolfer.Latitude;
                foundGolfer.Longitude = updatedGolfer.Longitude;
                foundGolfer.ScreenName = updatedGolfer.Name;
                foundGolfer.PhoneNumber = updatedGolfer.PhoneNumber;

                dataContext.Golfers.Attach(foundGolfer, true);
                dataContext.SubmitChanges();
                dataContext.Connection.Close();
                GolferContract contract = new GolferContract(foundGolfer);
                return contract;
            }


        }

        public VoidOperationContract ResetPassword(ResetPasswordContract contract)
        {
            try
            {
                using (NeedAGolferDataContext dataContext = new NeedAGolferDataContext())
                {

                    var golferRetriever = RetrieverFactory.CreateInterface<IGolferRetriever>();
                    var golfer = golferRetriever.SelectByUsernameAndEmail(contract.UserAccount, contract.EmailAddress);

                    string salt = PasswordCrypto.GetSalt();
                    string hashedPassword = PasswordCrypto.ComputeHash(contract.Password, "SHA256", salt);
                    golfer.PasswordHash = hashedPassword;
                    golfer.PasswordSalt = salt;

                    dataContext.Golfers.Attach(golfer, true);
                    dataContext.SubmitChanges();
                    dataContext.Connection.Close();

                    return new VoidOperationContract()
                    {
                        ErrorMessage = ""
                    };
                }
            }
            catch (Exception ex)
            {
                return new VoidOperationContract()
                {
                    ErrorMessage = ex.Message
                };
            }
        }

        public GolferStatusMessagesContract[] GetNearbyGolfers(GolfersNearbySearchContract searchParams)
        {
            var golfersRetriever = RetrieverFactory.CreateInterface<IGolferRetriever>();
            var nearbyGolfers = golfersRetriever.GetNearbyGolfers(searchParams.Latitude, searchParams.Longitude, searchParams.Radius);
            var listGolfers = (from singleGolfer in nearbyGolfers
                               where (singleGolfer.GolferId == searchParams.GolferId || 
                               (singleGolfer.Handicap <= searchParams.Handicap
                               && singleGolfer.Rating >= searchParams.Rating))
                               select new GolferStatusMessagesContract(singleGolfer)).ToList();
            return listGolfers.ToArray();
        }

        public GolfCourseContract[] GetNearbyGolfCourses(GolfCoursesNearbySearchContract searchParams)
        {
            var golfCourseRetriever = RetrieverFactory.CreateInterface<IGolfCourseRetriever>();
            var nearbyCourses = golfCourseRetriever.GetNearbyGolfCourses(searchParams.Latitude, searchParams.Longitude, searchParams.Radius);
            var listCourses = (from course in nearbyCourses
                               //where course.CourseType == searchParams.CourseType
                               select new GolfCourseContract(course)).ToList();
            return listCourses.ToArray();
        }

        public GolfCourseContract GetGolfCourseById(string courseid)
        {
            var golfCourseRetriever = RetrieverFactory.CreateInterface<IGolfCourseRetriever>();
            var course = golfCourseRetriever.GetGolfCourseById(int.Parse(courseid));
            return new GolfCourseContract(course);
        }

        public GolferPrivateMessageContract[] GetMessagesByGolferId(string golferid)
        {
            int GolferId = Convert.ToInt32(golferid);
            var messageRetriever = RetrieverFactory.CreateInterface<IMessagesRetriever>();
            var listMessages = (from message in messageRetriever.GetMessagesByGolferId(GolferId)
                                orderby message.MessageId ascending 
                                    select new GolferPrivateMessageContract(message)).ToList();
            return listMessages.ToArray();
        }

        public GolferProfileContract GetGolferProfile(string golferid)
        {
            try 
            {
                double rating = 0.0;
                int numRatings = 0;
                int GolferId = Convert.ToInt32(golferid);
                var golferRatingsRetriever = RetrieverFactory.CreateInterface<IGolferRatingsRetriever>();
                var golferRatings = golferRatingsRetriever.GetGolferRatingsById(golferid);
                var golferRetriever = RetrieverFactory.CreateInterface<IGolferRetriever>();
                var golfer = golferRetriever.LoadByGolferId(GolferId);

                using (NeedAGolferDataContext dataContext = new NeedAGolferDataContext())
                {
                    rating = (from allRatings in dataContext.GolferRatings
                                     where allRatings.GolferId == GolferId
                                     select (int?)allRatings.Rating).Average() ?? 0.0;
                    numRatings = (from allRatings in dataContext.GolferRatings
                                      where allRatings.GolferId == GolferId
                                      select allRatings.Rating).Count();
                    dataContext.Connection.Close();
                }

                return new GolferProfileContract()
                {
                    GolferId = golfer.GolferId,
                    Ratings = from arating in golferRatings select new GolferRatingsViewContract(arating),
                    Handicap = (int)golfer.Handicap,
                    IsAvailable = (bool)golfer.IsAvailable,
                    ScreenName = golfer.ScreenName,
                    Rating = Convert.ToDecimal(rating),
                    NumRatings = numRatings,
                    ErrorMessage = ""
                };

            }
            catch (Exception ex)
            {
                return new GolferProfileContract()
                {
                    ErrorMessage = ex.Message
                };
            }
            
        }

        public GolferRatingsViewContract[] GetGolferRatingsById(string golferid)
        {
            var golferRatingsRetriever = RetrieverFactory.CreateInterface<IGolferRatingsRetriever>();
            var golferRatings = golferRatingsRetriever.GetGolferRatingsById(golferid);
            var list = (from singleRating in golferRatings
                        select new GolferRatingsViewContract(singleRating)).ToList();
            return list.ToArray();
        }

        public GolferStatusMessagesContract[] UpdateGolferStatus(GolfersNearbySearchContract searchParamsWithStatus)
        {
            using (NeedAGolferDataContext dataContext = new NeedAGolferDataContext())
            {
                GolferStatusMessage statusMessage = new GolferStatusMessage();
                statusMessage.GolferId = searchParamsWithStatus.GolferId;
                statusMessage.Message = searchParamsWithStatus.Message;
                statusMessage.MessageCreateDate = DateTime.Now;
                dataContext.GolferStatusMessages.InsertOnSubmit(statusMessage);
                dataContext.SubmitChanges();
                dataContext.Connection.Close();
            }

            var golfersRetriever = RetrieverFactory.CreateInterface<IGolferRetriever>();
            var foundGolfer = golfersRetriever.LoadByGolferId(CurrentSession.GolferId);

            if (!(bool)foundGolfer.IsAvailable) 
            {
                NeedAGolferDataContext dataContext2 = new NeedAGolferDataContext();
                foundGolfer.IsAvailable = true;
                foundGolfer.LastUpdated = DateTime.Now;
                foundGolfer.Latitude = searchParamsWithStatus.Latitude;
                foundGolfer.Longitude = searchParamsWithStatus.Longitude;
                dataContext2.Golfers.Attach(foundGolfer, true);
                dataContext2.SubmitChanges();
            }
            var nearbyGolfers = golfersRetriever.GetNearbyGolfers(searchParamsWithStatus.Latitude, searchParamsWithStatus.Longitude, searchParamsWithStatus.Radius);
            var listGolfers = (from singleGolfer in nearbyGolfers
                               where (singleGolfer.Handicap <= searchParamsWithStatus.Handicap
                               && singleGolfer.Rating >= searchParamsWithStatus.Rating) 
                               || singleGolfer.GolferId == searchParamsWithStatus.GolferId //updating golfer always sees his latest status
                               select new GolferStatusMessagesContract(singleGolfer)).ToList();

            return listGolfers.ToArray();
        }

        public VoidOperationContract SendPrivateMessage(GolferPrivateMessageContract golferPrivateMessage)
        {
            try
            {
                using (NeedAGolferDataContext dataContext = new NeedAGolferDataContext())
                {

                    foreach (int i in golferPrivateMessage.ReceivingGolferIds)
                    {
                        GolferPrivateMessage message = new GolferPrivateMessage();
                        message.MessageCreateDate = DateTime.Now;
                        message.ReceivingGolferId = i;
                        message.SendingGolferId = golferPrivateMessage.SendingGolferId;
                        message.RootGolferMessageId = golferPrivateMessage.RootMessageId;
                        message.Message = golferPrivateMessage.Message;
                        dataContext.GolferPrivateMessages.InsertOnSubmit(message);
                        dataContext.SubmitChanges();
                        dataContext.Connection.Close();
                    }

                    return new VoidOperationContract()
                    {
                        ErrorMessage = ""
                    };
                }
            }
            catch (Exception ex)
            {
                return new VoidOperationContract()
                {
                    ErrorMessage = ex.Message
                };
            }

        }

        public VoidOperationContract CreateRating(GolferRatingContract golferRating)
        {
            try
            {
                using (NeedAGolferDataContext dataContext = new NeedAGolferDataContext())
                {
                    GolferRating rating = new GolferRating();
                    rating.Comments = golferRating.Comments;
                    rating.CreateDateTime = DateTime.Now;
                    rating.GolferId = golferRating.GolferId;
                    rating.SubmittingGolferId = golferRating.SubmittingGolferId;
                    rating.Rating = golferRating.Rating;
                    dataContext.GolferRatings.InsertOnSubmit(rating);
                    dataContext.SubmitChanges();
                    dataContext.Connection.Close();
                    return new VoidOperationContract()
                    {
                        ErrorMessage = ""
                    };
                }
            }
            catch (Exception ex)
            {
                return new VoidOperationContract()
                {
                    ErrorMessage = ex.Message
                };
            }

        }

        public GolferContract RunTest()
        {
            using (NeedAGolferDataContext dataContext = new NeedAGolferDataContext())
            {
                var listGolfers = (from singleGolfer in dataContext.Golfers
                                   select new GolferContract(singleGolfer));


                GolferContract contract = listGolfers.FirstOrDefault();
                dataContext.Connection.Close();
                return contract;
            }
            
        }
    }
}
