using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Text;

namespace NeedAGolferWCF.Interfaces
{
    public interface IMessagesRetriever
    {
        List<GolferPrivateMessages_View> GetMessagesByGolferId(int golferid);
    }
}