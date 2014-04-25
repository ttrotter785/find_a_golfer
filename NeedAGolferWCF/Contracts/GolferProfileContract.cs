using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Runtime.Serialization;

namespace NeedAGolferWCF.Contracts
{
    [DataContract]
    public class GolferProfileContract
    {
        [DataMember]
        public IEnumerable<GolferRatingsViewContract> Ratings { get; set; }
        [DataMember]
        public string ScreenName { get; set; }
        [DataMember]
        public int Handicap { get; set; }
        [DataMember]
        public decimal Rating { get; set; }
        [DataMember]
        public int NumRatings { get; set; }
        [DataMember]
        public bool IsAvailable { get; set; }
        [DataMember]
        public string ErrorMessage { get; set; }
        [DataMember]
        public int GolferId { get; set; }
    }
}