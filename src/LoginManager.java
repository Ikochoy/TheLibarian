import org.omg.PortableInterceptor.USER_EXCEPTION;

public class LoginManager {
    String VALID = "valid";
    String USERNAME_INVALID = "Username is invalid";
    String PASSWORD_INVALID = "Password is invalid";

    private UsersManager usersManager = new UsersManager();

    String validate(String username, String password){
        User user = usersManager.getUserByUsername(username);
        if(user == null){
            return USERNAME_INVALID;
        }else if(user.getPassword().equals(password)){
            return VALID;
        }else{
            return PASSWORD_INVALID;
        }
    }
}
