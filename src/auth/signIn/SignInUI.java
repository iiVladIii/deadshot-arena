package auth.signIn;

import auth.AuthData;
import auth.lib.email.EmailValidateUI;
import auth.lib.password.PasswordHash;
import auth.logs.Log;
import auth.logs.LogsList;
import auth.user.User;
import auth.user.UsersList;

import javax.swing.*;
import java.util.Date;

public class SignInUI {
    private static String password;
    private static String email;
    private static User userCandidate;

    public static boolean signIn(String emailPs, String passwordPs) {
        email = emailPs;
        boolean emailIsValid = EmailValidateUI.emailValidate(emailPs, false);

        if (!emailIsValid) {
            return false;
        }

        userCandidate = UsersList.getUserByEmail(email);

        if (userCandidate == null) {
            JOptionPane.showMessageDialog(null, "User with this email was not found");
            return false;
        }

        password = passwordPs;
        return enterPasswd();
    }

    private static boolean checkPass() {
        boolean passwordIsCorrect = PasswordHash.checkPassword(password, userCandidate.getPassword());
        if (passwordIsCorrect) {
            userCandidate.setLoginAttempt(0);
            UsersList.setUserByUser(userCandidate);
            AuthData.auth(userCandidate);
            LogsList.addLogToList(new Log(2, "Success login", userCandidate));
            JOptionPane.showMessageDialog(null, "Success login");
            LogsList.saveLogsFile();
            return true;
        } else {
            userCandidate.setLoginAttempt(userCandidate.getLoginAttempt() + 1);
            switch (userCandidate.getLoginAttempt()) {
                case 1 -> userCandidate.setUserLoginBreak(new Date().getTime() + 10000);
                case 2 -> userCandidate.setUserLoginBreak(new Date().getTime() + 60000);
                case 3 -> userCandidate.setUserLoginBreak(new Date().getTime() + 600000);
                default -> userCandidate.setUserLoginBreak(new Date().getTime() + 60 * 60 * 1000);
            }
            UsersList.setUserByUser(userCandidate);
            LogsList.addLogToList(new Log(3, "Un success login", userCandidate));
            JOptionPane.showMessageDialog(null, "Wrong password");
            return false;
        }
    }

    private static boolean enterPasswd() {
        boolean canEnterPasswd = userCandidate.getUserLoginBreak() - new Date().getTime() <= 0;
        if (canEnterPasswd) {
            return checkPass();
        } else {
            JOptionPane.showMessageDialog(null, "You can't enter the password for another " + (userCandidate.getUserLoginBreak() - new Date().getTime()) / 1000 + " seconds");
            return false;
        }
    }
}
