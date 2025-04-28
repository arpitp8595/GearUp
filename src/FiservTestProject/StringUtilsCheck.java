package FiservTestProject;

import java.util.Objects;
import java.util.regex.Pattern;

public class StringUtilsCheck {

    public final static String PATTERN = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
    
    public static void main(String[] args) {
        String email = null;
        validateEmail(email);
        System.out.println("validation process is done");
    }

    static void validateEmail(String email) {
        if(Objects.nonNull(email) && !email.isEmpty()) {
            if(!Pattern.compile(PATTERN).matcher(email).matches()) {
                System.out.println("Throws an Exception");
            } else {
                System.out.println("Execution goes on......");
            }
        }
    }
}
