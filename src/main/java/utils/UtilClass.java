package utils;

/**
 * Created by Redlaw on 28.09.2016.
 */
public class UtilClass {

    // Passwqord encoding
    public static String passEncoding(String password) {
        return String.valueOf(password.hashCode() ^ 2);
    }
}
