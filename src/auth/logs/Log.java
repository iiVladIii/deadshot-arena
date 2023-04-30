package auth.logs;

import auth.user.User;

import java.util.Date;

public class Log {
    private long id;
    private Date time;
    private int code;
    private String description;
    private User user;

    public Log() {
    }

    public Log(int code, String description, User user) {
        this.code = code;
        this.description = description;
        this.user = user;
        this.time = new Date();
        this.id = new Date().getTime();
    }

    //getters

    public long getId() {
        return id;
    }

    public Date getTime() {
        return time;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Log {\n" +
                "id=" + id +
                "\ntime:" + time +
                "\ncode:" + code +
                "\ndescription:" + description +
                "\nuser:" + user +
                "\n}";
    }
}
