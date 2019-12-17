import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Main extends JFrame{

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        Main main = new Main();
        ChooseIDentity chooseIDentity = new ChooseIDentity(main);
        chooseIDentity.setVisible(true);
    }

    void setUserFirstPage(ChooseIDentity chooseIDentity){
        chooseIDentity.setVisible(false);
        UserFirstPage userFirstPage = new UserFirstPage(this);
        userFirstPage.setVisible(true);
    }

    public void setUserLogInPage(UserFirstPage userFirstPage) {
        userFirstPage.setVisible(false);
        UserLogin userLogin = new UserLogin(this);
        userLogin.setVisible(true);
    }

    public void setUserSignUpPage(UserFirstPage userFirstPage) {
        userFirstPage.setVisible(false);
        UserSignUp userSignUp = new UserSignUp(this);
        userSignUp.setVisible(true);

    }

    public void setProfilePage(UserLogin userLogin, String username) {
        userLogin.setVisible(false);
        UserProfile userProfile = new UserProfile(this, username);
        userProfile.setVisible(true);
    }

    public void setProfilePageFromSignup(UserSignUp userSignUp, String username) {
        userSignUp.setVisible(false);
        UserProfile userProfile = new UserProfile(this, username);
        userProfile.setVisible(true);
    }
}
