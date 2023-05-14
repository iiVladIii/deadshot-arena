package auth.registration;

import auth.AuthData;
import auth.lib.email.EmailValidateUI;
import auth.lib.password.PasswordHash;
import auth.lib.password.PasswordValidateUI;
import auth.logs.Log;
import auth.logs.LogsList;
import auth.user.User;
import auth.user.UsersList;

import javax.swing.*;
import java.util.Date;

public class RegistrationUi {
    private static String password;
    private static String email;
    private static String username;

    private static void createNewUser() {
        Date date = new Date();
        User user = new User(
                date.getTime(),
                email,
                password,
                username
        );

        UsersList.addUserToList(user);
        LogsList.addLogToList(new Log(1, "Create new User", user));
        AuthData.auth(user);
        UsersList.saveUsersFile();
        LogsList.saveLogsFile();
    }

    public static boolean signupUI(String emailPs, String passwordPs, String usernamePs) {
        email = emailPs;
        password = passwordPs;
        username = usernamePs;

        boolean emailIsCorrect = EmailValidateUI.emailValidate(email, true);
        if (!emailIsCorrect) {
            return false;
        }

        if (username.length() == 0) {
            JOptionPane.showMessageDialog(null, "Invalid username");
            return false;
        }

        boolean passwordValidate = PasswordValidateUI.passwordValidate(password);
        if (!passwordValidate) {
            return false;
        }

        password = PasswordHash.createPasswordHash(password);
        createNewUser();
        JOptionPane.showMessageDialog(null, "Registration is success");
        return true;
    }
}
