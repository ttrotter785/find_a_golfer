using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using NeedAGolferWCF.Interfaces;

namespace NeedAGolferWCF.Retrievers
{
    public sealed class MessagesRetriever : IMessagesRetriever
    {
        #region Fields

        private static MessagesRetriever _instance = new MessagesRetriever();
        private static NeedAGolferDataContext dataContext = new NeedAGolferDataContext();
        private List<GolferPrivateMessage> _messages;

        #endregion Fields

        #region Properties

          public static MessagesRetriever Instance
          {
             get { return (_instance); }
          }

      #endregion

        #region Constructor

      /// <summary>
      /// Default Constructor
      /// </summary>
      private MessagesRetriever()
      {
      }

      #endregion

        public List<GolferPrivateMessages_View> GetMessagesByGolferId(int golferid)
        {
            var m = (from messages in dataContext.GolferPrivateMessages_Views where messages.ReceiverGolferId == golferid orderby messages.MessageId descending select messages).Take(20);
            return m.ToList();
        }
    }
}