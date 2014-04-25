using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace NeedAGolferWCF.Contracts
{
    [DataContract]
    public class GolferContract
    {

        public GolferContract()
        {
            
        }

        public GolferContract(Golfer _golfer)
        {
            golfer = _golfer;
        }

        [DataMember]
        public Golfer golfer { get; set; }
        [DataMember]
        public int GolferId { get; set; }
        [DataMember]
        public string EmailAddress { get; set; }
        [DataMember]
        public bool AllowEmails { get; set; }
        [DataMember]
        public string PhoneNumber { get; set; }
        [DataMember]
        public bool IsAvailable { get; set; }
        [DataMember]
        public int Handicap { get; set; }
        [DataMember]
        public decimal Latitude { get; set; }
        [DataMember]
        public decimal Longitude { get; set; }
        [DataMember]
        public DateTime? LastUpdated { get; set; }
        [DataMember]
        public string ScreenName { get; set; }
        [DataMember]
        public int AvailabilityDistance { get; set; }
        [DataMember]
        public string Password { get; set; }
    }
}