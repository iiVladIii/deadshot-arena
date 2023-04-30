package auth.user;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UsersList {
    private static List<User> usersList;
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final File file = new File("src/db.json");

    public static void loadUsers() {
        try {
            usersList = objectMapper.readValue(file, new TypeReference<>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addUserToList(User user) {
        usersList.add(user);
    }

    public static void saveUsersFile() {
        try {
            objectMapper.writeValue(file, usersList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkUsrIsReg(String email) {
        for (User user : usersList) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public static User getUserByEmail(String email) {
        for (User user : usersList) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public static void setUserByUser(User usr) {
        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).getId() == usr.getId()) {
                usersList.remove(i);
                usersList.add(usr);
                break;
            }
        }
    }
}
