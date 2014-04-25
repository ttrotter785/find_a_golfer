using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using NeedAGolferWCF.Utility;
namespace NeedAGolferWCF.Contracts
{
    public class GolferRatingsViewContract
    {
        public GolferRatingsViewContract() 
        {
        }

        public GolferRatingsViewContract(GolferRatings_View golferRating)
        {
            Comments = golferRating.Comments;
            CreateDateTime = (golferRating.CreateDateTime == null) ? MobileUtility.DateTimeToUnixTime(DateTime.MinValue) : MobileUtility.DateTimeToUnixTime((DateTime)golferRating.CreateDateTime);
            GolferId = golferRating.GolferId;
            Rating = golferRating.Rating;
            SubmitterName = golferRating.SubmitterName;
        }

        public string Comments { get; set; }
        public int CreateDateTime { get; set; }
        public int GolferId { get; set; }
        public int Rating { get; set; }
        public string SubmitterName { get; set; }
    }
}