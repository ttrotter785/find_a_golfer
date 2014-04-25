using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using NeedAGolferWCF.Interfaces;
namespace NeedAGolferWCF.Retrievers
{
    public class GolferRatingsRetriever : IGolferRatingsRetriever
    {
        private static GolferRatingsRetriever _instance = new GolferRatingsRetriever();
        private static NeedAGolferDataContext dataContext = new NeedAGolferDataContext();

        
        #region Properties

          public static GolferRatingsRetriever Instance
          {
             get { return (_instance); }
          }

      #endregion

        #region Constructor

      /// <summary>
      /// Default Constructor
      /// </summary>
      private GolferRatingsRetriever()
      {
      }

      #endregion

          public List<GolferRatings_View> GetGolferRatingsById(string golferid)
          {
              var gr = (from golferRating in dataContext.GolferRatings_Views 
                        where golferRating.GolferId == int.Parse(golferid) 
                        orderby golferRating.CreateDateTime descending 
                        select golferRating).Take(10);
              return gr.ToList();
          }


    }
}