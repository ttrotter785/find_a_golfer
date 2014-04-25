using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using NeedAGolferWCF.Interfaces;

namespace NeedAGolferWCF.Retrievers
{
    public class GolfCourseRetriever : IGolfCourseRetriever
    {
        private static GolfCourseRetriever _instance = new GolfCourseRetriever();
        private static NeedAGolferDataContext dataContext = new NeedAGolferDataContext();

        #region Properties

        public static GolfCourseRetriever Instance
        {
            get { return (_instance); }
        }

        #endregion

        #region Constructor

      /// <summary>
      /// Default Constructor
      /// </summary>
        private GolfCourseRetriever()
      {
      }

      #endregion

        public List<GetNearbyGolfCoursesResult> GetNearbyGolfCourses(decimal latitude, decimal longitude, int radius)
        {
            var golfCourses = dataContext.GetNearbyGolfCourses(latitude, longitude, radius);
            return golfCourses.ToList();
        }

        public GolfCourse GetGolfCourseById(int id)
        {
            var singleCourse = (from course in dataContext.GolfCourses
                        where course.GolfCourse_Id == id
                        select course);
            return singleCourse.SingleOrDefault();
        }
    }
}