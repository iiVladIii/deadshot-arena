package auth.lib.password;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidate {
    public static boolean passwordValidate(String password) {

        if (password.length() < 8) {
            System.out.println("The minimum password length is 8 characters");
            return false;
        }


        if (!checkUppercaseSymbols(password)) {
            System.out.println("Must have an uppercase Character");
            return false;
        }

        if (Character.isUpperCase(password.charAt(0))) {
            System.out.println("The first character cannot be uppercase");
            return false;
        }

        if (!checkSpecialCharacter(password)) {
            System.out.println("Password must have a special Character !@#$%^&*");
            return false;
        }

//        boolean hasUppercase = !password.equals(password.toLowerCase());
//        if (!hasUppercase) {
//            System.out.println("Must have an uppercase Character");
//            return false;
//        }
//
//        boolean hasLowercase = !password.equals(password.toUpperCase());
//
//        if (!hasLowercase) {
//            System.out.println("Must have a lowercase Character");
//            return false;
//        }
        return true;
    }

    private static boolean checkSpecialCharacter(String password) {
        Pattern pattern = Pattern.compile("(?=.*[@#$%^&+=])");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    private static boolean checkUppercaseSymbols(String password) {
        Pattern pattern = Pattern.compile("(?=.*[A-Z])");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }
}
