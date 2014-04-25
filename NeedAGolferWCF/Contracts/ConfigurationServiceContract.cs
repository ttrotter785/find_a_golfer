using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Runtime.Serialization;

namespace NeedAGolferWCF.Contracts
{
    [DataContract]
    public class ConfigurationServiceContract
    {
        public ConfigurationServiceContract()
        {

        }
        [DataMember]
        public string BaseURL { get; set; }
        [DataMember]
        public bool IsLocked { get; set; }
        [DataMember]
        public bool IsSuccess { get; set; }
        [DataMember]
        public string Message { get; set; }
        [DataMember]
        public string MarketUri { get; set; }
    }
}