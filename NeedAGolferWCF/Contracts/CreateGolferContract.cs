using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Runtime.Serialization;

namespace NeedAGolferWCF.Contracts
{
    [DataContract]
    public class CreateGolferContract
    {
        [DataMember]
        public string EmailAddress{ get; set; }
        [DataMember]
        public bool AllowEmails{ get; set; }
        [DataMember]
        public string PhoneNumber{ get; set; }
        [DataMember]
        public bool AllowPhoneCalls{ get; set; }
        [DataMember]
        public bool IsAvailable { get; set; }
        [DataMember]
        public int Handicap{ get; set; }
        [DataMember]
        public decimal Latitude{ get; set; }
        [DataMember]
        public decimal Longitude { get; set; }
        [DataMember]
        public string Name{ get; set; }
        [DataMember]
        public int AvailabilityDistanceInMiles{ get; set; }
        [DataMember]
        public string Password{ get; set; }

    }
}