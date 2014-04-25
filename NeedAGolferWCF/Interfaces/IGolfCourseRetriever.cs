using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace NeedAGolferWCF.Interfaces
{
    public interface IGolfCourseRetriever
    {
        List<GetNearbyGolfCoursesResult> GetNearbyGolfCourses(decimal latitude, decimal longitude, int radius);
        GolfCourse GetGolfCourseById(int id);
    }
}
