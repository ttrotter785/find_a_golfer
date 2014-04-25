using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Web;

namespace NeedAGolferWCF.Authentication
{
    public class CustomBasicAuthSection : ConfigurationSection
    {
        /// <summary>
        /// Gets the name of the section.
        /// </summary>
        /// <value>The name of the section.</value>
        public static string SectionName
        {
            get
            {
                return "customBasicAuthentication";
            }
        }

        /// <summary>
        /// Gets or sets a value indicating whether this <see cref="CustomBasicAuthSection"/> is enabled.
        /// </summary>
        /// <value><c>true</c> if enabled; otherwise, <c>false</c>.</value>
        [ConfigurationProperty("enabled", DefaultValue = false)]
        public bool Enabled
        {
            get { return (bool)base["enabled"]; }
            set { base["enabled"] = value; }
        }

        /// <summary>
        /// Gets or sets the realm.
        /// </summary>
        /// <value>The realm.</value>
        [ConfigurationProperty("realm", DefaultValue = "Need A Golfer")]
        [StringValidator(MinLength = 1)]
        public string Realm
        {
            get { return (string)base["realm"]; }
            set { base["realm"] = value; }
        }

        /// <summary>
        /// Gets or sets the name of the provider.
        /// </summary>
        /// <value>The name of the provider.</value>
        [ConfigurationProperty("providerName", DefaultValue = "default")]
        [StringValidator(MinLength = 1)]
        public string ProviderName
        {
            get { return (string)base["providerName"]; }
            set { base["providerName"] = value; }
        }

        /// <summary>
        /// Gets or sets a value indicating whether [caching enabled].
        /// </summary>
        /// <value><c>true</c> if [caching enabled]; otherwise, <c>false</c>.</value>
        [ConfigurationProperty("cachingEnabled", DefaultValue = true)]
        public bool CachingEnabled
        {
            get { return (bool)base["cachingEnabled"]; }
            set { base["cachingEnabled"] = value; }
        }

        /// <summary>
        /// Gets or sets the duration of the caching.
        /// </summary>
        /// <value>The duration of the caching.</value>
        [ConfigurationProperty("cachingDuration", DefaultValue = 15)]
        [IntegerValidator(MinValue = 1, MaxValue = 60)]
        public int CachingDuration
        {
            get { return (int)base["cachingDuration"]; }
            set { base["cachingDuration"] = value; }
        }

        /// <summary>
        /// Gets or sets a value indicating whether [require SSL].
        /// </summary>
        /// <value><c>true</c> if [require SSL]; otherwise, <c>false</c>.</value>
        [ConfigurationProperty("requireSSL", DefaultValue = true)]
        public bool RequireSSL
        {
            get { return (bool)base["requireSSL"]; }
            set { base["requireSSL"] = value; }
        }
    }
}