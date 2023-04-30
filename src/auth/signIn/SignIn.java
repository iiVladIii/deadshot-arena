package auth.signIn;

import auth.AuthData;
import auth.lib.password.PasswordHash;
import auth.logs.Log;
import auth.logs.LogsList;
import auth.user.User;
import auth.user.UsersList;

import java.util.Date;
import java.util.Scanner;

import static auth.lib.Readers.emailReader;
import static auth.lib.Readers.passwordReader;

public class SignIn {
    private static String password;
    private static String email;
    private static User userCandidate;
    private static boolean menuIsOpen;

    public static void signIn() {
        email = emailReader(false);

        userCandidate = UsersList.getUserByEmail(email);

        if (userCandidate == null) {
            System.out.println("User with this email was not found");
            return;
        }

        enterPasswd();

        password = null;
        email = null;
    }

    private static void checkPass() {
        boolean passwordIsCorrect = PasswordHash.checkPassword(password, userCandidate.getPassword());
        if (passwordIsCorrect) {
            userCandidate.setLoginAttempt(0);
            UsersList.setUserByUser(userCandidate);
            AuthData.auth(userCandidate);
            LogsList.addLogToList(new Log(2, "Success login", userCandidate));
            menuIsOpen = false;
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
            System.out.println("Password is incorrect");
        }
    }

    private static void enterPasswd() {
        menuIsOpen = true;
        while (menuIsOpen) {
            boolean canEnterPasswd = userCandidate.getUserLoginBreak() - new Date().getTime() <= 0;
            if (canEnterPasswd) {
                password = passwordReader();
                checkPass();
            } else {
                System.out.println("You can't enter the password for another " + (userCandidate.getUserLoginBreak() - new Date().getTime()) / 1000 + " seconds");
                System.out.println("0 - exit");
                Scanner scanner = new Scanner(System.in);

                if ("0".equals(scanner.nextLine())) {
                    menuIsOpen = false;
                } else {
                    System.out.println("Enter correct value");
                }
            }
        }
    }
}
