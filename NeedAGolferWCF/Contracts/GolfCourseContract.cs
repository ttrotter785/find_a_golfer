using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Runtime.Serialization;

namespace NeedAGolferWCF.Contracts
{
    [DataContract]
    public class GolfCourseContract
    {
        public GolfCourseContract(GolfCourse golfCourse)
         {
             decimal defaultDecimal = 0;
             Address = (golfCourse.Address == null) ? string.Empty : golfCourse.Address;
             CourseName = (golfCourse.CourseName == null) ? string.Empty : golfCourse.CourseName;
             CourseType = (golfCourse.CourseType == null) ? string.Empty : golfCourse.CourseType;
             City = (golfCourse.City == null) ? string.Empty : golfCourse.City;
             GolfCourse_Id = golfCourse.GolfCourse_Id;
             Latitude = (golfCourse.Latitude == null) ? defaultDecimal : (decimal)golfCourse.Latitude;
             Longitude = (golfCourse.Longitude == null) ? defaultDecimal : (decimal)golfCourse.Longitude;
             PhoneNumber = (golfCourse.PhoneNumber == null) ? string.Empty : golfCourse.PhoneNumber;
             State = (golfCourse.State == null) ? string.Empty : golfCourse.State;
             ZipCode = (golfCourse.ZipCode == null) ? string.Empty : golfCourse.ZipCode;
         }

        public GolfCourseContract(GetNearbyGolfCoursesResult golfCourseNearbyResult)
        {
            decimal defaultDecimal = 0;
            Address = (golfCourseNearbyResult.Address == null) ? string.Empty : golfCourseNearbyResult.Address;
            CourseName = (golfCourseNearbyResult.CourseName == null) ? string.Empty : golfCourseNearbyResult.CourseName;
            CourseType = (golfCourseNearbyResult.CourseType == null) ? string.Empty : golfCourseNearbyResult.CourseType;
            City = (golfCourseNearbyResult.City == null) ? string.Empty : golfCourseNearbyResult.City;
            GolfCourse_Id = golfCourseNearbyResult.GolfCourse_Id;
            Latitude = (golfCourseNearbyResult.Latitude == null) ? defaultDecimal : (decimal)golfCourseNearbyResult.Latitude;
            Longitude = (golfCourseNearbyResult.Longitude == null) ? defaultDecimal : (decimal)golfCourseNearbyResult.Longitude;
            PhoneNumber = (golfCourseNearbyResult.PhoneNumber == null) ? string.Empty : golfCourseNearbyResult.PhoneNumber;
            State = (golfCourseNearbyResult.State == null) ? string.Empty : golfCourseNearbyResult.State;
            ZipCode = (golfCourseNearbyResult.ZipCode == null) ? string.Empty : golfCourseNearbyResult.ZipCode;
            Distance = (golfCourseNearbyResult.Distance == null) ? string.Empty : golfCourseNearbyResult.Distance.ToString();
        }

        [DataMember]
        public string Address { get; set; }
        [DataMember]
        public string CourseName { get; set; }
        [DataMember]
        public string CourseType { get; set; }
        [DataMember]
        public string City { get; set; }
        [DataMember]
        public int GolfCourse_Id { get; set; }
        [DataMember]
        public decimal Latitude { get; set; }
        [DataMember]
        public decimal Longitude { get; set; }
        [DataMember]
        public string PhoneNumber { get; set; }
        [DataMember]
        public string State { get; set; }
        [DataMember]
        public string ZipCode { get; set; }
        [DataMember]
        public string Distance { get; set; }
    }


}