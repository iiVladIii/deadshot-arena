package auth;

import auth.user.User;

public class AuthData {
    private static User user;
    private static boolean isAuth = false;

    public static User getUser() {
        return user;
    }

    public static boolean getIsAuth() {
        return isAuth;
    }

    public static void auth(User user) {
        AuthData.user = user;
        AuthData.isAuth = true;
    }

    public static void logout() {
        AuthData.user = null;
        AuthData.isAuth = false;
    }
}
