package auth.lib.email;

import auth.user.UsersList;

import javax.swing.*;
import java.util.regex.Pattern;

public class EmailValidateUI {
    private static boolean checkPattern(String email) {
        String regexPattern = "^(.+)@(\\S+)$";

        return Pattern.compile(regexPattern)
                .matcher(email)
                .matches();
    }

    public static boolean emailValidate(String emailToCheck, boolean checkUsersList) {

        if (!checkPattern(emailToCheck)) {
            JOptionPane.showMessageDialog(null, "Not valid Email");
            return false;
        }

        if (checkUsersList) {
            boolean userIsReg = UsersList.checkUsrIsReg(emailToCheck);
            if (userIsReg) {
                JOptionPane.showMessageDialog(null, "Email is already use");
                return false;
            }
        }

        if (emailToCheck.length() == 0) {
            JOptionPane.showMessageDialog(null, "Invalid email");
            return false;
        }

        return true;
    }
}
