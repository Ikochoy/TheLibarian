import java.util.ArrayList;

public class UsersManager {
    private static ArrayList<User> users = new ArrayList<>();

    void addUser(String userName, String password, String userId, String status){
        if (status.equals("c")) {
            users.add(new ChildUser(userName, password, userId));
        }else{
            users.add(new AdultUser(userName, password, userId));
        }
    }

    void deleteUser(String username) throws UserNotExitException{
        User user = getUserByUsername(username);
        if (user != null){
            users.remove(user);
        }else{
            throw new UserNotExitException("Sorry, this user does not exit in record");
        }
    }

    User getUserByUsername(String username){
        for (User user: users){
            if (user.getUserId().equals(username)){
                return user;
            }
        }
        return null;
    }

    ArrayList<User> getUsers(){
        return users;
    }

    AdultUser changeToUser(ChildUser childUser){
        AdultUser adultUser = new AdultUser(childUser.getUserName(), childUser.getPassword(), childUser.getUserId());
        users.remove(childUser);
        users.add(adultUser);
        return adultUser;
    }
}
