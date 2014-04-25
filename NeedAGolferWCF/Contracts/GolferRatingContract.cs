using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Runtime.Serialization;


namespace NeedAGolferWCF.Contracts
{
    [DataContract]
    public class GolferRatingContract
    {
        public GolferRatingContract()
        {
            
        }

        [DataMember]
        public int GolferId { get; set; }
        [DataMember]
        public int SubmittingGolferId { get; set; }
        [DataMember]
        public int Rating { get; set; }
        [DataMember]
        public string Comments { get; set; }

    }
}