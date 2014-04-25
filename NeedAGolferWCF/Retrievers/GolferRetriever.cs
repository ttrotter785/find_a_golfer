using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using NeedAGolferWCF.Interfaces;
using NeedAGolferWCF.Security;
using System.Security.Permissions;

namespace NeedAGolferWCF.Retrievers
{
    public sealed class GolferRetriever : IGolferRetriever
    {
        #region Fields

        private static GolferRetriever _instance = new GolferRetriever();
        private static NeedAGolferDataContext dataContext = new NeedAGolferDataContext();
        private Golfer _golfer;

        #endregion Fields

        #region Properties

          public static GolferRetriever Instance
          {
             get { return (_instance); }
          }

      #endregion

        #region Constructor

      /// <summary>
      /// Default Constructor
      /// </summary>
      private GolferRetriever()
      {
      }

      #endregion

        #region Methods

        public Golfer LoadByGolferId(int golferId)
        {
            var g = from golfer in dataContext.Golfers where golfer.GolferId == golferId select golfer;
            return g.SingleOrDefault();
        }

        public int? GetGolferIdByUserNamePassword(string username, string password) 
        {
            string passwordHash =  GetHashedPassword(username, password);
            var g = from golfer in dataContext.Golfers
                    where (golfer.ScreenName == username && golfer.PasswordHash == passwordHash)
                    select golfer;
            if (g.Count() == 0)
            {
                return null;
            }
            return g.SingleOrDefault().GolferId;
        }

        private string GetHashedPassword(string username, string password) 
        {
            var saltQueryable = from golfer in dataContext.Golfers
                                where (golfer.ScreenName == username)
                                select golfer.PasswordSalt;
            if (saltQueryable.Count() == 0)
            {
                return string.Empty;
            }
            string salt = saltQueryable.FirstOrDefault();
            string hashedPassword = PasswordCrypto.ComputeHash(password, "SHA256", salt);
            return hashedPassword;
        }

        public int? GetGolferIdByWebLogin(string username, string oldPassword)
        {
            var g = from golfer in dataContext.Golfers
                    where (golfer.ScreenName == username && golfer.PasswordHash == GetHashedPassword(username, oldPassword))
                    select golfer;
            return g.SingleOrDefault().GolferId;
        }

        public Golfer SelectByUsername(string username) 
        {
            var g = from golfer in dataContext.Golfers
                    where (golfer.ScreenName == username)
                    select golfer;
            return g.SingleOrDefault();
        }

        public Golfer SelectByUsernameAndEmail(string username, string email)
        {
            var g = from golfer in dataContext.Golfers
                    where (golfer.ScreenName == username && golfer.EmailAddress == email)
                    select golfer;
            return g.SingleOrDefault();
        }


        public List<GolferStatusMessages_View> GetNearbyGolfers(decimal latitude, decimal longitude, int radius)
        {
            var golfers = (from golferWithMessage in dataContext.GetNearbyGolfers(latitude, longitude, radius)
                           where golferWithMessage.Message != null
                           select golferWithMessage);
            return golfers.ToList();
        }


        #endregion
    }
}