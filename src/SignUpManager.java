public class SignUpManager {
    private UsersManager usersManager = new UsersManager();

    String USERNAME_DUPLICATE = "Please use another username, this username is taken.";
    String VALID = "valid";

    String createNewUser(String username, String password, String status){
        User user = usersManager.getUserByUsername(username);
        if (user != null){
            return USERNAME_DUPLICATE;
        }else{
            String userid = Integer.toString(usersManager.getUsers().size()+1);
            usersManager.addUser(username, password, userid, status);
            return VALID;
        }
    }
}
