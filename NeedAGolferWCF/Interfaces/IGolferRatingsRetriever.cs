using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace NeedAGolferWCF.Interfaces
{
    public interface IGolferRatingsRetriever
    {
        List<GolferRatings_View> GetGolferRatingsById(string golferid);
    }
}