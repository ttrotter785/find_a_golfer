using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using NeedAGolferWCF.Contracts;
using System.ServiceModel.Activation;

namespace NeedAGolferWCF
{
    [AspNetCompatibilityRequirements(RequirementsMode = AspNetCompatibilityRequirementsMode.Required)]
    public class ConfigService : IConfigService
    {
        public ConfigurationServiceContract GetServiceUrlBasedOnVersion(string version)
        {
            ConfigurationServiceContract returnContract = new ConfigurationServiceContract();
            try{
                string sUrl = string.Empty;
                string sMarketUri = string.Empty;
                bool isLocked = false;
                switch (version)
                {
                    case "1.0":
                        sUrl = "http://services.needagolfer.com.HAZEL.arvixe.com/GolferService.svc";
                        break;
                    case "1.1":
                        sUrl = "http://services.needagolfer.com.HAZEL.arvixe.com/GolferService.svc";
                        isLocked = true;
                        break;
                    default:
                        sUrl = "http://services.needagolfer.com.HAZEL.arvixe.com/GolferService.svc";
                        break;
                }
                returnContract.MarketUri = "market://details?id=com.findagolfer.mobile";
                returnContract.BaseURL = sUrl;
                returnContract.IsLocked = isLocked;
                returnContract.IsSuccess = true;
                returnContract.Message = string.Empty;
            }
            catch (Exception ex){
                returnContract.Message = ex.Message;    
            }
            return returnContract;
        }
    }
}
