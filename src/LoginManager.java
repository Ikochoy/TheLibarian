import org.omg.PortableInterceptor.USER_EXCEPTION;

public class LoginManager {
    String VALID = "valid";
    String USERNAME_INVALID = "Username is invalid";
    String PASSWORD_INVALID = "Password is invalid";

    private Library library = new Library();

    String validate(String username, String password){
        User user = library.getUserByUserName(username);
        if(user == null){
            return USERNAME_INVALID;
        }else if(user.getPassword().equals(password)){
            return VALID;
        }else{
            return PASSWORD_INVALID;
        }
    }
}
