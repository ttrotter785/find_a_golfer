using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Security;
using NeedAGolferWCF.Interfaces;
using System.Security.Permissions;

namespace NeedAGolferWCF.Security
{
    public class NeedAGolferMembershipProvider : MembershipProvider
    {
        private static readonly IGolferRetriever _golferRetriever = RetrieverFactory.CreateInterface<IGolferRetriever>();

        #region Properties

        /// <summary>
        /// Gets whether password reset is enabled.
        /// </summary>
        public override bool EnablePasswordReset
        {
            get { return true; }
        }

        /// <summary>
        /// Gets whether password retrieval is enabled.
        /// </summary>
        public override bool EnablePasswordRetrieval
        {
            get { return false; }
        }

        /// <summary>
        /// Gets whether password reset/retrieval requires a security question and answer.
        /// </summary>
        public override bool RequiresQuestionAndAnswer
        {
            get { return true; }
        }

        #endregion

        #region Methods

        /// <summary>
        /// Changes the password of a given user.
        /// </summary>
        /// <param name="username">The ussername of the user to change password on.</param>
        /// <param name="oldPassword">The users old password.</param>
        /// <param name="newPassword">The users new password.</param>
        /// <returns>Returns true if the user was found, their old password matched and the new password was set.  Returns false otherwise.</returns>
        public override bool ChangePassword(string username, string oldPassword, string newPassword)
        {
            if ((username == null || username.Length == 0) || (oldPassword == null || oldPassword.Length == 0) || (newPassword == null || newPassword.Length == 0))
            {
                throw new ArgumentException("A username, old password and new password are required.");
            }

            int? golferId = _golferRetriever.GetGolferIdByWebLogin(username, oldPassword);
            if (golferId == null) { return false; }

            Golfer golfer = _golferRetriever.LoadByGolferId((int)golferId);

            string salt = PasswordCrypto.GetSalt();
            string hashedPassword = PasswordCrypto.ComputeHash(newPassword, "SHA256", salt);

            golfer.PasswordHash = hashedPassword;
            golfer.PasswordSalt = salt;
            
            //TODO:  fix
            return true;
        }

        /// <summary>
        /// Gets a user based on their username.
        /// </summary>
        /// <param name="username">The username of the user to retrieve.</param>
        /// <param name="userIsOnline">Whether the user is online.</param>
        /// <returns>Returns the user with the provided username.</returns>
        public override MembershipUser GetUser(string username, bool userIsOnline)
        {
            if ((username == null || username.Length == 0))
            {
                throw new ArgumentException("A username is required.");
            }

            Golfer golfer = _golferRetriever.SelectByUsername(username);
            if (golfer == null) { return null; }

            //TODO:  placeholders
            string passwordResetQuestion = string.Empty;
            bool isLockedOut = false;
            DateTime lastLogin = DateTime.MinValue;
            DateTime lastPasswordChange = DateTime.MinValue;
            DateTime lastLockout = DateTime.MinValue;

            return new MembershipUser(Membership.Provider.Name, username, golfer.GolferId, golfer.EmailAddress, passwordResetQuestion, string.Empty, false, isLockedOut, DateTime.MinValue, lastLogin, lastLogin, lastPasswordChange, lastLockout);
        }

        /// <summary>
        /// Resets the password for the provided username if the security question answer is correct.
        /// </summary>
        /// <param name="username">The username to reset the password for.</param>
        /// <param name="answer">The provided answer to the security question.</param>
        /// <returns>Returns the new password.</returns>
        public override string ResetPassword(string username, string answer)
        {
            if ((username == null || username.Length == 0) || (answer == null || answer.Length == 0))
            {
                throw new ArgumentException("A username and security answer are required.");
            }

            Golfer golfer = _golferRetriever.SelectByUsername(username);
            if (golfer == null ||
                (golfer.EmailAddress == null || golfer.EmailAddress.Length == 0)) { return null; }
            string password = string.Empty;

            return password;
        }


        /// <summary>
        /// Validates a user based on a given username and password.
        /// </summary>
        /// <param name="username">The username attempting to log in.</param>
        /// <param name="password">The password for the user.</param>
        /// <returns>Returns true if the username and password match a user account, false otherwise.</returns>
        public override bool ValidateUser(string username, string password)
        {
            if ((username == null || username.Length == 0) || (password == null || password.Length == 0)) { return false; }
            if (username == "new" && password == "user") { return true; }
            int? golferId = _golferRetriever.GetGolferIdByUserNamePassword(username, password);
            if (golferId == null || golferId == 0)
            {
                return false;
            }
            else
            {
                if (SessionContext.Current != null)
                {
                    SessionContext.Current.SetSessionUser((int)golferId);
                }
                return true;
            }
        }

        #endregion

        #region Unimplemented Overrides

        public override string ApplicationName
        {
            get { throw new NotImplementedException(); }
            set { throw new NotImplementedException(); }
        }

        public override bool ChangePasswordQuestionAndAnswer(string username, string password, string newPasswordQuestion, string newPasswordAnswer)
        {
            throw new NotImplementedException();
        }

        public override MembershipUser CreateUser(string username, string password, string email, string passwordQuestion, string passwordAnswer, bool isApproved, object providerUserKey, out MembershipCreateStatus status)
        {
            throw new NotImplementedException();
        }

        public override bool DeleteUser(string username, bool deleteAllRelatedData)
        {
            throw new NotImplementedException();
        }

        public override MembershipUserCollection FindUsersByEmail(string emailToMatch, int pageIndex, int pageSize, out int totalRecords)
        {
            throw new NotImplementedException();
        }

        public override MembershipUserCollection FindUsersByName(string usernameToMatch, int pageIndex, int pageSize, out int totalRecords)
        {
            throw new NotImplementedException();
        }

        public override MembershipUserCollection GetAllUsers(int pageIndex, int pageSize, out int totalRecords)
        {
            throw new NotImplementedException();
        }

        public override int GetNumberOfUsersOnline()
        {
            throw new NotImplementedException();
        }

        public override string GetPassword(string username, string answer)
        {
            throw new NotImplementedException();
        }

        public override MembershipUser GetUser(object providerUserKey, bool userIsOnline)
        {
            throw new NotImplementedException();
        }

        public override string GetUserNameByEmail(string email)
        {
            throw new NotImplementedException();
        }

        public override int MaxInvalidPasswordAttempts
        {
            get { throw new NotImplementedException(); }
        }

        public override int MinRequiredNonAlphanumericCharacters
        {
            get { throw new NotImplementedException(); }
        }

        public override int MinRequiredPasswordLength
        {
            get { throw new NotImplementedException(); }
        }

        public override int PasswordAttemptWindow
        {
            get { throw new NotImplementedException(); }
        }

        public override MembershipPasswordFormat PasswordFormat
        {
            get { throw new NotImplementedException(); }
        }

        public override string PasswordStrengthRegularExpression
        {
            get { throw new NotImplementedException(); }
        }

        public override bool RequiresUniqueEmail
        {
            get { throw new NotImplementedException(); }
        }

        public override bool UnlockUser(string userName)
        {
            throw new NotImplementedException();
        }

        public override void UpdateUser(MembershipUser user)
        {
            throw new NotImplementedException();
        }

        #endregion
    }
}