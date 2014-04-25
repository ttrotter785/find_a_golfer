using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Runtime.Serialization;
using NeedAGolferWCF.Utility;
namespace NeedAGolferWCF.Contracts
{
     [DataContract]
    public class GolferStatusMessagesContract
    {
         public GolferStatusMessagesContract(GolferStatusMessages_View golferStatusMessage)
         {
             GolferId = golferStatusMessage.GolferId;
             EmailAddress = golferStatusMessage.EmailAddress;
             Handicap = (golferStatusMessage.Handicap == null) ? 0 : (int)golferStatusMessage.Handicap;
             AllowEmails = (golferStatusMessage.AllowEmails == null) ? false : (bool)golferStatusMessage.AllowEmails;
             ScreenName = golferStatusMessage.ScreenName;
             Message = golferStatusMessage.Message;
             MessageCreateDate = (golferStatusMessage.MessageCreateDate == null) ? MobileUtility.DateTimeToUnixTime(DateTime.MinValue) : MobileUtility.DateTimeToUnixTime((DateTime)golferStatusMessage.MessageCreateDate);
             Rating = (golferStatusMessage.Rating == null) ? 0 : (decimal)golferStatusMessage.Rating;
             NumRatings = (golferStatusMessage.NumRatings==null) ? 0 : (int)golferStatusMessage.NumRatings;
             CourseName = golferStatusMessage.CourseName;
         }

        [DataMember]
        public int GolferId { get; set; }
        [DataMember]
        public string EmailAddress { get; set; }
        [DataMember]
        public int Handicap { get; set; }
        [DataMember]
        public Boolean AllowEmails { get; set; }
        [DataMember]
        public string ScreenName { get; set; }
        [DataMember]
        public string Message { get; set; }
        [DataMember]
        public int MessageCreateDate { get; set; }
        [DataMember]
        public decimal Rating { get; set; }
        [DataMember]
        public int NumRatings { get; set; }
        [DataMember]
        public string CourseName { get; set; }

    }
}