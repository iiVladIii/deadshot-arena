package auth.user;

import java.util.Date;

public class User {
    private String password;
    private String email;
    private long id;
    private String username;
    private int loginAttempt = 0;
    private long userLoginBreak = new Date().getTime();

    public User() {
    }

    public User(long id, String email, String password, String username) {
        this.password = password;
        this.email = email;
        this.id = id;
        this.username = username;
    }


    public long getUserLoginBreak() {
        return userLoginBreak;
    }

    public void setUserLoginBreak(long userLoginBreak) {
        this.userLoginBreak = userLoginBreak;
    }


    public int getLoginAttempt() {
        return loginAttempt;
    }

    public void setLoginAttempt(int loginAttempt) {
        this.loginAttempt = loginAttempt;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User info { \n" +
                "   id: " + id + "\n" +
                "   email: " + email + "\n" +
                "   password: " + password + "\n" +
                "   login attempt: " + loginAttempt + "\n" +
                "   username: " + username +
                "\n}";
    }
}
