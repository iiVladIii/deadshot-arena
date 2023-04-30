package auth.registration;
//https://attacomsian.com/blog/java-read-write-json-files
//https://attacomsian.com/blog/jackson-write-json-file

import auth.AuthData;
import auth.logs.Log;
import auth.logs.LogsList;
import auth.user.User;
import auth.user.UsersList;
import auth.lib.password.PasswordHash;

import java.util.Date;
import java.util.Scanner;

import static auth.lib.Readers.emailReader;
import static auth.lib.Readers.passwordReader;

public class Registration {
    private static String password;
    private static String email;
    private static String username;

    public static void signup() {
        email = emailReader(true);
        password = passwordReader();
        username = usernameReader();

        password = PasswordHash.createPasswordHash(password);
        createNewUser();
        System.out.println("Registration is success");
        password = null;
        email = null;
        username = null;
    }

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
    }

    private static String usernameReader() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username");
        return scanner.nextLine();
    }
}
