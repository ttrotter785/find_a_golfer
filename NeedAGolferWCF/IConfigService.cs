using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using NeedAGolferWCF.Contracts;

namespace NeedAGolferWCF
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IConfigService" in both code and config file together.
    [ServiceContract]
    public interface IConfigService
    {
        [OperationContract]
        [WebGet(UriTemplate = "/config/{version}", ResponseFormat = WebMessageFormat.Json)]
        ConfigurationServiceContract GetServiceUrlBasedOnVersion(string version);

    }
}
