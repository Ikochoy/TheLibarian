public class SignUpManager {
    private Library library = new Library();

    String USERNAME_DUPLICATE = "Please use another username, this username is taken.";
    String VALID = "valid";

    String createNewUser(String username, String password, String status){
        User user = library.getUserByUserName(username);
        if (user != null){
            return USERNAME_DUPLICATE;
        }else{
            String userid = Integer.toString(library.getUsers().size()+1);
            library.addUser(username, password, userid, status);
            return VALID;
        }
    }
}
