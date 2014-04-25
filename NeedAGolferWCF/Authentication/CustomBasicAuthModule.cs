using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Security.Cryptography;
using System.Security.Principal;
using System.Text;
using System.Web;
using System.Web.Caching;
using System.Web.Security;

namespace NeedAGolferWCF.Authentication
{
    public class CustomBasicAuthModule : IHttpModule
    {
        private CustomBasicAuthSection _configuration = null;
        private string _cachePrefix = "wcf_customBasicAuth";

        /// <summary>
        /// Disposes of the resources (other than memory) used by the module that implements <see cref="T:System.Web.IHttpModule"/>.
        /// </summary>
        public void Dispose()
        { }

        /// <summary>
        /// Initializes a module and prepares it to handle requests.
        /// </summary>
        /// <param name="context">An <see cref="T:System.Web.HttpApplication"/> that provides access to the methods, properties, and events common to all application objects within an ASP.NET application</param>
        public void Init(HttpApplication context)
        {
            context.AuthenticateRequest += new System.EventHandler(context_AuthenticateRequest);
            context.EndRequest += new System.EventHandler(context_EndRequest);
        }

        /// <summary>
        /// Handles the EndRequest event of the context control.
        /// </summary>
        /// <param name="sender">The source of the event.</param>
        /// <param name="e">The <see cref="System.EventArgs"/> instance containing the event data.</param>
        void context_EndRequest(object sender, System.EventArgs e)
        {
            if (Configuration.Enabled)
            {
                if (HttpContext.Current.Response.StatusCode == 401)
                {
                    SendAuthenticationHeader();
                }
            }
        }

        /// <summary>
        /// Handles the AuthenticateRequest event of the context control.
        /// </summary>
        /// <param name="sender">The source of the event.</param>
        /// <param name="e">The <see cref="System.EventArgs"/> instance containing the event data.</param>
        void context_AuthenticateRequest(object sender, System.EventArgs e)
        {
            HttpContext context = HttpContext.Current;
            if (!Configuration.Enabled)
            {
                return;
            }
            
            if (Configuration.RequireSSL && !context.Request.IsSecureConnection)
            {
                throw new HttpException(403, "SSL is required");
            }
            
            if (IsHeaderPresent)
            {
                try
                {
                    if (!AuthenticateUser())
                    {
                        
                        //Need a better way to add an exclusion for the new uesrs
                        if (context.Request.Url.PathAndQuery.ToLower().Contains("creategolfer"))
                        {
                            if (!AuthenticateNewUser())
                            {
                                context.Response.StatusCode = 401;
                                context.Response.End();
                            }
                            return;
                        }

                        context.Response.StatusCode = 401;
                        context.Response.End();
                    }
                }
                catch (Exception ex)
                {
                    context.Response.Write(ex.Message);
                    context.Response.End();
                }
            }
        }

        /// <summary>
        /// Gets the configuration.
        /// </summary>
        /// <value>The configuration.</value>
        protected CustomBasicAuthSection Configuration
        {
            get
            {
                if (_configuration == null)
                {
                    _configuration = (CustomBasicAuthSection)
                                     ConfigurationManager.GetSection(
                                         CustomBasicAuthSection.SectionName);
                }

                if (_configuration == null)
                {
                    throw new ConfigurationErrorsException("Failed to load the <customBasicAuthentication> configuration section");
                }

                return _configuration;
            }
        }

        /// <summary>
        /// Gets the provider.
        /// </summary>
        /// <value>The provider.</value>
        protected MembershipProvider Provider
        {
            get
            {
                if (string.Equals(Configuration.ProviderName, "default", StringComparison.OrdinalIgnoreCase))
                {
                    return Membership.Provider;
                }
                else
                {
                    MembershipProvider provider = Membership.Providers[Configuration.ProviderName];
                    if (provider == null)
                    {
                        throw new ConfigurationErrorsException(String.Format(
                            "Provider {0} not found",
                            Configuration.ProviderName));
                    }

                    return provider;
                }
            }
        }

        /// <summary>
        /// Gets a value indicating whether this instance is header present.
        /// </summary>
        /// <value>
        /// 	<c>true</c> if this instance is header present; otherwise, <c>false</c>.
        /// </value>
        protected bool IsHeaderPresent
        {
            get
            {
                HttpContext context = HttpContext.Current;
                string authHeader = context.Request.Headers["Authorization"];
                return (!string.IsNullOrEmpty(authHeader));
            }
        }

        /// <summary>
        /// Authenticates the signup process
        /// </summary>
        /// <returns></returns>
        private bool AuthenticateNewUser()
        {
            string username = "", password = "";
            string authHeader = HttpContext.Current.Request.Headers["Authorization"];
            
            if (authHeader != null && authHeader.StartsWith("Basic"))
            {
                // extract credentials from header
                string[] credentials = ExtractCredentials(authHeader);
                username = credentials[0];
                password = credentials[1];

                if (IsCredentialCached(username, password))
                {
                    SetPrincipal(username);
                    return true;
                }
                else if (username == "new" && password == "user")
                {
                    if (Configuration.CachingEnabled)
                    {
                        CacheCredential(username, password);
                    }

                    SetPrincipal(username);

                    return true;
                }
            }

            return false;
        }

        /// <summary>
        /// Authenticates the user.
        /// </summary>
        /// <returns></returns>
        private bool AuthenticateUser()
        {
            string username = "", password = "";
            string authHeader = HttpContext.Current.Request.Headers["Authorization"];
            //authHeader = null;
            if (authHeader != null && authHeader.StartsWith("Basic"))
            {
                // extract credentials from header
                string[] credentials = ExtractCredentials(authHeader);
                username = credentials[0];
                password = credentials[1];

                if (IsCredentialCached(username, password))
                {
                    SetPrincipal(username);
                    return true;
                }
                else if (Provider.ValidateUser(username, password))
                {
                    if (Configuration.CachingEnabled)
                    {
                        CacheCredential(username, password);
                    }

                    SetPrincipal(username);

                    return true;
                }
            }

            return false;
        }

        /// <summary>
        /// Caches the credential.
        /// </summary>
        /// <param name="username">The username.</param>
        /// <param name="password">The password.</param>
        private void CacheCredential(string username, string password)
        {
            string identifier = GetIdentifier(username, password);

            try
            {
                HttpContext.Current.Cache.Add(
                    identifier,
                    "ok",
                    null,
                    DateTime.Now.AddMinutes(Configuration.CachingDuration),
                    Cache.NoSlidingExpiration,
                    CacheItemPriority.Normal,
                    null);

            }
            catch (Exception)
            {
            }
        }

        // checks if the credentials has been cached already
        /// <summary>
        /// Determines whether [is credential cached] [the specified username].
        /// </summary>
        /// <param name="username">The username.</param>
        /// <param name="password">The password.</param>
        /// <returns>
        /// 	<c>true</c> if [is credential cached] [the specified username]; otherwise, <c>false</c>.
        /// </returns>
        private bool IsCredentialCached(string username, string password)
        {
            if (!Configuration.CachingEnabled)
                return false;

            string identifier = GetIdentifier(username, password);
            bool cacheHit = (HttpContext.Current.Cache[identifier] != null);


            return cacheHit;
        }

        // create GenericPrincipal and set it on Context.User
        /// <summary>
        /// Sets the principal.
        /// </summary>
        /// <param name="username">The username.</param>
        private static void SetPrincipal(string username)
        {
            // create principal and set Context.User
            GenericIdentity id = new GenericIdentity(username, "CustomBasic");
            GenericPrincipal p = new GenericPrincipal(id, null);
            HttpContext.Current.User = p;
        }

        // send header to start Basic Authentication handshake
        /// <summary>
        /// Sends the authentication header.
        /// </summary>
        private void SendAuthenticationHeader()
        {
            HttpContext context = HttpContext.Current;

            context.Response.StatusCode = 401;
            context.Response.AddHeader(
                "WWW-Authenticate",
                String.Format("Basic realm=\"{0}\"", Configuration.Realm));
        }

        // extracts and decodes username and password from the auth header
        /// <summary>
        /// Extracts the credentials.
        /// </summary>
        /// <param name="authHeader">The auth header.</param>
        /// <returns></returns>
        private string[] ExtractCredentials(string authHeader)
        {
            try
            {
                // strip out the "basic"
                string encodedUserPass = authHeader.Substring(6).Trim();

                // that's the right encoding
                Encoding encoding = Encoding.GetEncoding("iso-8859-1");
                string userPass = encoding.GetString(Convert.FromBase64String(encodedUserPass));
                int separator = userPass.IndexOf(':');

                string[] credentials = new string[2];
                credentials[0] = userPass.Substring(0, separator);
                credentials[1] = userPass.Substring(separator + 1);

                return credentials;
            }
            catch
            {
                throw new HttpException("Invalid Authentication Header");
            }
        }

        // create a string identifier for the cache key
        // format: prefix + Base64(Hash(username+password))
        /// <summary>
        /// Gets the identifier.
        /// </summary>
        /// <param name="username">The username.</param>
        /// <param name="password">The password.</param>
        /// <returns></returns>
        private string GetIdentifier(string username, string password)
        {
            // unmanaged SHA1 for performance
            HashAlgorithm sha1 = new SHA1CryptoServiceProvider();

            string identifier = username + password;
            byte[] identifierBytes = Encoding.UTF8.GetBytes(identifier);
            byte[] identifierHash = sha1.ComputeHash(identifierBytes);

            return _cachePrefix + Convert.ToBase64String(identifierHash);
        }
    }
}