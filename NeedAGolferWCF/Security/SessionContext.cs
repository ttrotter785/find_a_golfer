using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using NeedAGolferWCF.Interfaces;

namespace NeedAGolferWCF.Security
{
    public class SessionContext
    {
        private Golfer _golfer;
        private static readonly IGolferRetriever golferRetriever = RetrieverFactory.CreateInterface<IGolferRetriever>();
        
        #region Contructors

        /// <summary>
        /// 
        /// </summary>
        private SessionContext() { }

        #endregion

        #region Properties

        /// <summary>
        /// Indicates if the session has an authenticated user.
        /// </summary>
        public bool Authenticated
        {
            get { return _golfer != null; }
        }

        /// <summary>
        /// Gets the current <see cref="SessionContext"/>.
        /// </summary>
        public static SessionContext Current
        {
            get
            {
                if (HttpContext.Current == null) { return null; }
                if (HttpContext.Current.Session == null) { return null; }
                SessionContext currentContext = HttpContext.Current.Session[SessionDictionaryKeys.SessionContext] as SessionContext;
                if (currentContext == null)
                {
                    currentContext = new SessionContext();
                    HttpContext.Current.Session.Add(SessionDictionaryKeys.SessionContext, currentContext);
                }
                return currentContext;
            }
        }

        
        /// <summary>
        /// Gets <see cref="WebUserSessionView"/>
        /// </summary>
        public Golfer SessionData
        {
            get { return _golfer; }
        }

        #endregion

        #region Methods

        /// <summary>
        /// 
        /// </summary>
        private void Clear()
        {
            _golfer = null;
        }

        /// <summary>
        /// Clears the session user.
        /// </summary>
        public void ClearSessionUser()
        {
            Clear();
        }

        /// <summary>
        /// Redirects the user to the required URL if one is set.
        /// </summary>
        public void RedirectToRequired()
        {

        }

        /// <summary>
        /// Sets the current URL as the required URL.  Any calls to RedirectToRequired will redirect the user to this URL.
        /// </summary>
        /// <param name="required"></param>
        public void SetCurrentUrlAsRequired(bool required)
        {

        }

        /// <summary>
        /// Sets the <see cref="BusinessContactView">user</see> for the current session.
        /// </summary>
        /// <param name="businessContactId"></param>
        internal void SetSessionUser(int golferId)
        {
            Clear();
            _golfer = golferRetriever.LoadByGolferId(golferId);
            if (_golfer == null) { throw new ArgumentException("No such golfer found."); }
        }

        /// <summary>
        /// Validates the specified user.
        /// </summary>
        /// <param name="user"></param>
        private static void ValidateUser(Golfer golfer)
        {
            if (golfer == null) { throw new ArgumentNullException("No session user specified."); }
        }

        #endregion
    }
}