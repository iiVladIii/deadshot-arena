package auth.lib.email;

import auth.user.UsersList;

import java.util.regex.Pattern;

public class EmailValidate {
    private static boolean checkPattern(String email) {
        String regexPattern = "^(.+)@(\\S+)$";

        return Pattern.compile(regexPattern)
                .matcher(email)
                .matches();
    }

    public static boolean emailValidate(String emailToCheck, boolean checkUsersList) {

        if (!checkPattern(emailToCheck)) {
            System.out.println("Not valid Email");
            return false;
        }

        if (checkUsersList) {
            boolean userIsReg = UsersList.checkUsrIsReg(emailToCheck);
            if (userIsReg) {
                System.out.println("Email is already use");
                return false;
            }
        }

        if (emailToCheck.length() == 0) {
            System.out.println("invalid email");
            return false;
        }

        return true;
    }
}
