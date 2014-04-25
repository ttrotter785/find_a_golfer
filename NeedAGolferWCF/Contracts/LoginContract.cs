using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Runtime.Serialization;

namespace NeedAGolferWCF.Contracts
{
    [DataContract]
    public class LoginContract
    {
        [DataMember]
        public string DeviceId { get; set; }
        [DataMember]
        public string DeviceType { get; set; }
        [DataMember]
        public string OSVersion { get; set; }
        [DataMember]
        public string UserAccount { get; set; }
        [DataMember]
        public string Password { get; set; }
        
    }
}