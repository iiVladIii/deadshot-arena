package auth.lib.password;
//https://www.baeldung.com/java-password-hashing
//https://javascopes.com/java-password-hashing-4ea635d9/
//https://www.baeldung.com/java-password-hashing
//https://habr.com/ru/articles/482552/

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordHash {

    public static String createPasswordHash(String originalPassword) {
        String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(12));
        return generatedSecuredPasswordHash;
    }

    public static boolean checkPassword(String originalPassword, String generatedSecuredPasswordHash) {
        boolean matched = BCrypt.checkpw(originalPassword, generatedSecuredPasswordHash);
        return matched;
    }
}
