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
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IService1" in both code and config file together.
    [ServiceContract]
    public interface IGolferService
    {
        
        [OperationContract]
        [WebInvoke(Method = "POST",
           UriTemplate = "/getgolfer",
           RequestFormat = WebMessageFormat.Json,
           ResponseFormat = WebMessageFormat.Json,
           BodyStyle = WebMessageBodyStyle.Bare)]
        GolferContract GetGolfer(LoginContract loginContract);

        [OperationContract]
        [WebInvoke(Method = "POST",
            UriTemplate = "/resetpword",
            RequestFormat = WebMessageFormat.Json,
            ResponseFormat = WebMessageFormat.Json,
            BodyStyle = WebMessageBodyStyle.Bare)]
        VoidOperationContract ResetPassword(ResetPasswordContract contract);

        [OperationContract]
        [WebInvoke(Method = "POST",
            UriTemplate = "/updategolfer",
            RequestFormat = WebMessageFormat.Json,
            ResponseFormat = WebMessageFormat.Json,
            BodyStyle = WebMessageBodyStyle.Bare)]
        GolferContract UpdateGolfer(CreateGolferContract golfer);

        [OperationContract]
        [WebInvoke(Method = "POST",
            UriTemplate = "/getnearbygolfers",
            RequestFormat = WebMessageFormat.Json,
            ResponseFormat = WebMessageFormat.Json,
            BodyStyle = WebMessageBodyStyle.Bare)]
        GolferStatusMessagesContract[] GetNearbyGolfers(GolfersNearbySearchContract searchParams);

        [OperationContract]
        [WebInvoke(Method = "POST",
            UriTemplate = "/getgolfcourse",
            RequestFormat = WebMessageFormat.Json,
            ResponseFormat = WebMessageFormat.Json,
            BodyStyle = WebMessageBodyStyle.Bare)]
        GolfCourseContract GetGolfCourseById(string courseid);

        [OperationContract]
        [WebInvoke(Method = "POST",
            UriTemplate = "/getnearbycourses",
            RequestFormat = WebMessageFormat.Json,
            ResponseFormat = WebMessageFormat.Json,
            BodyStyle = WebMessageBodyStyle.Bare)]
        GolfCourseContract[] GetNearbyGolfCourses(GolfCoursesNearbySearchContract searchParams);


        [OperationContract]
        [WebInvoke(Method = "POST",
            UriTemplate = "/updategolferstatus",
            RequestFormat = WebMessageFormat.Json,
            ResponseFormat = WebMessageFormat.Json,
            BodyStyle = WebMessageBodyStyle.Bare)]
        GolferStatusMessagesContract[] UpdateGolferStatus(GolfersNearbySearchContract searchParamsWithStatus);


        [OperationContract]
        [WebInvoke(Method = "POST",
            UriTemplate = "/creategolfer",
            RequestFormat = WebMessageFormat.Json,
            ResponseFormat = WebMessageFormat.Json,
            BodyStyle = WebMessageBodyStyle.Bare)]
        VoidOperationContract CreateGolfer(CreateGolferContract golfer);

        [OperationContract]
        [WebInvoke(Method = "POST",
            UriTemplate = "/createrating",
            RequestFormat = WebMessageFormat.Json,
            ResponseFormat = WebMessageFormat.Json,
            BodyStyle = WebMessageBodyStyle.Bare)]
        VoidOperationContract CreateRating(GolferRatingContract golferRating);

        [OperationContract]
        [WebInvoke(Method = "POST",
            UriTemplate = "/sendmessage",
            RequestFormat = WebMessageFormat.Json,
            ResponseFormat = WebMessageFormat.Json,
            BodyStyle = WebMessageBodyStyle.Bare)]
        VoidOperationContract SendPrivateMessage(GolferPrivateMessageContract golferPrivateMessage);

        [OperationContract]
        [WebInvoke(Method = "POST",
            UriTemplate = "/getprofile",
            RequestFormat = WebMessageFormat.Json,
            ResponseFormat = WebMessageFormat.Json,
            BodyStyle = WebMessageBodyStyle.Bare)]
        GolferProfileContract GetGolferProfile(string golferid);

        [OperationContract]
        [WebInvoke(Method = "POST",
            UriTemplate = "/getmessages",
            RequestFormat = WebMessageFormat.Json,
            ResponseFormat = WebMessageFormat.Json,
            BodyStyle = WebMessageBodyStyle.Bare)]
        GolferPrivateMessageContract[] GetMessagesByGolferId(string golferid);


    }

}
