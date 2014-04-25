using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace NeedAGolferWCF.Contracts
{
    [DataContract]
    public class GolfersNearbySearchContract
    {
        [DataMember]
        public decimal Latitude { get; set; }
        [DataMember]
        public decimal Longitude { get; set; }
        [DataMember]
        public int Radius { get; set; }
        [DataMember]
        public int Handicap { get; set; }
        [DataMember]
        public int Rating { get; set; }
        [DataMember]
        public int GolferId { get; set; }
        [DataMember]
        public string Message { get; set; }

    }
}