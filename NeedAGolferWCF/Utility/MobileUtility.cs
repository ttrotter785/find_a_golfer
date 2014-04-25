using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace NeedAGolferWCF.Utility
{
    public static class MobileUtility
    {
        private static readonly DateTime unixEpoch = new DateTime(1970, 1, 1, 0, 0, 0, 0, DateTimeKind.Utc);

        /// <summary>
        /// Converts DateTime to UnixDate (seconds since 1970)
        /// </summary>
        /// <param name="date">The date.</param>
        /// <returns></returns>
        public static int DateTimeToUnixTime(DateTime date)
        {
            return (int)(date - unixEpoch).TotalSeconds;
        }

        /// <summary>
        /// Converts DateTime to UnixDate (seconds since 1970)
        /// </summary>
        /// <param name="date">The date.</param>
        /// <returns></returns>
        public static int? DateTimeToUnixTime(DateTime? date)
        {
            if (date.HasValue)
            {
                return (int)(date.Value - unixEpoch).TotalSeconds;
            }
            else
            {
                return null;
            }
        }

        /// <summary>
        /// Converts UnixDate (seconds since 1979) to DateTime 
        /// </summary>
        /// <param name="secondsFromEpoch">The seconds from epoch.</param>
        /// <returns></returns>
        public static DateTime UnixTimeToDateTime(int secondsFromEpoch)
        {
            return unixEpoch.AddSeconds(secondsFromEpoch);
        }
    }
}