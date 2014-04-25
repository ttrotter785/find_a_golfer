using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Runtime.Serialization;

namespace NeedAGolferWCF.Contracts
{
    [DataContract]
    public class VoidOperationContract
    {
        public VoidOperationContract()
        {

        }

        [DataMember]
        public string ErrorMessage { get; set; }
    }
}