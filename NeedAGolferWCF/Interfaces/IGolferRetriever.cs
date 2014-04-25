using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace NeedAGolferWCF.Interfaces
{
    public interface IGolferRetriever
    {
        Golfer LoadByGolferId(int golferId);
        int? GetGolferIdByUserNamePassword(string username, string password);
        int? GetGolferIdByWebLogin(string username, string oldPassword);
        Golfer SelectByUsername(string username);
        List<GolferStatusMessages_View> GetNearbyGolfers(decimal latitude, decimal longitude, int radius);
        Golfer SelectByUsernameAndEmail(string username, string email);
    }
}
