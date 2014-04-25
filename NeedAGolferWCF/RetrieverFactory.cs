using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using NeedAGolferWCF.Retrievers;

namespace NeedAGolferWCF
{
    public static class RetrieverFactory
    {
        /// <summary>
        /// 
        /// </summary>
        /// <typeparam name="TInterface"></typeparam>
        /// <returns></returns>
        public static TInterface CreateInterface<TInterface>()
        {
            Type type = typeof(TInterface);
            string typeName = type.Name;
            Object o = null;

            //
            //IMPORTANT: Enter typenames alphabetically.
            //
            switch (typeName)
            {
                case "IGolferRetriever":
                    o = GolferRetriever.Instance;
                    break;
                case "IGolferRatingsRetriever":
                    o = GolferRatingsRetriever.Instance;
                    break;
                case "IMessagesRetriever":
                    o = MessagesRetriever.Instance;
                    break;
                case "IGolfCourseRetriever":
                    o = GolfCourseRetriever.Instance;
                    break;
                default:
                    throw new ArgumentException(string.Format("Type {0} is not supported.", typeName));
            }
            return (TInterface)o;
        }
    }
}