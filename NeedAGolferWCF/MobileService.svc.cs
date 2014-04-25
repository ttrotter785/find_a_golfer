﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using System.Web.Security;
using System.Web;
using NeedAGolferWCF.Interfaces;

namespace NeedAGolferWCF
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "Service1" in code, svc and config file together.
    public class MobileService
    {
        public MembershipUser MembershipUser
        {
            get
            {
                return Membership.GetUser(HttpContext.Current.User.Identity.Name, true);
            }
        }

        public Golfer CurrentSession
        {
            get
            {
                return RetrieverFactory.CreateInterface<IGolferRetriever>().LoadByGolferId((int)MembershipUser.ProviderUserKey);
            }
        }
    }
}
