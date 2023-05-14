package auth.lib.password;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidateUI {
    public static boolean passwordValidate(String password) {

        if (password.length() < 8) {
            JOptionPane.showMessageDialog(null, "The minimum password length is 8 characters");
            return false;
        }


        if (!checkUppercaseSymbols(password)) {
            JOptionPane.showMessageDialog(null, "Must have an uppercase Character");
            return false;
        }

        if (Character.isUpperCase(password.charAt(0))) {
            JOptionPane.showMessageDialog(null, "The first character cannot be uppercase");
            return false;
        }

        if (!checkSpecialCharacter(password)) {
            JOptionPane.showMessageDialog(null, "Password must have a special Character !@#$%^&*");
            return false;
        }

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
