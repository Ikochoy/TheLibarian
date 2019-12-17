public class UserAccountManager {
    /* this class manage the account of a user
     */
    private String userName;
    private String password;
    private String userId;

    public UserAccountManager(String userName, String password, String userId) {
        this.userName = userName;
        this.password = password;
        this.userId = userId;
    }

    /* get the user name of the user
     */
    public String getUserName() {
        return userName;
    }

    /* set the user Name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /* get the password of the user
     */
    public String getPassword() {
        return password;
    }

    /* set the password of the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /* get the user id of the user
     */
    public String getUserId() {
        return userId;
    }
}
