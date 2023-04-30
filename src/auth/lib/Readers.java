package auth.lib;

import auth.lib.email.EmailValidate;
import auth.lib.password.PasswordValidate;

import java.util.Scanner;

public class Readers {
    public static String emailReader(boolean checkUsersList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter email");
        String inputEmail = scanner.nextLine();
        boolean emailIsCorrect = EmailValidate.emailValidate(inputEmail, checkUsersList);

        if (emailIsCorrect) {
            return inputEmail;
        } else {
            return emailReader(checkUsersList);
        }
    }

    public static String passwordReader() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter password");
        String inputPassword = scanner.nextLine();
        boolean passwordIsCorrect = PasswordValidate.passwordValidate(inputPassword);

        if (!passwordIsCorrect) {
            return passwordReader();
        } else {
            return inputPassword;
        }
    }
}
