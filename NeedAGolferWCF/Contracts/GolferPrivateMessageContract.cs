using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Runtime.Serialization;
using NeedAGolferWCF.Utility;
namespace NeedAGolferWCF.Contracts
{
    [DataContract]
    public class GolferPrivateMessageContract
    {
        public GolferPrivateMessageContract()
        {
            
        }

        public GolferPrivateMessageContract(GolferPrivateMessages_View message)
        {
            MessageId = message.MessageId;
            SendingGolferScreenName = message.SenderScreenName;
            SendingGolferId = message.SenderGolferId;
            ReceivingGolferScreenName = message.ReceiverScreenName;
            ReceivingGolferId = message.ReceiverGolferId;
            RootMessageId = message.RootGolferMessageId;
            Message = message.Message;
            CreateDateTime = (message.MessageCreateDate == null) ? MobileUtility.DateTimeToUnixTime(DateTime.MinValue) : MobileUtility.DateTimeToUnixTime((DateTime)message.MessageCreateDate);
        }
        [DataMember]
        public int MessageId { get; set; }
        [DataMember]
        public int ReceivingGolferId { get; set; }
        [DataMember]
        public int SendingGolferId { get; set; }
        [DataMember]
        public int RootMessageId { get; set; }
        [DataMember]
        public string Message { get; set; }
        [DataMember]
        public int CreateDateTime { get; set; }
        [DataMember]
        public string ReceivingGolferScreenName { get; set; }
        [DataMember]
        public string SendingGolferScreenName { get; set; }
        [DataMember]
        public IEnumerable<int> ReceivingGolferIds { get; set; }

    }
}