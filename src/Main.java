import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Main extends JFrame{

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        Main main = new Main();
        ChooseIDentity chooseIDentity = new ChooseIDentity(main);
        chooseIDentity.setLocationRelativeTo(null);
        chooseIDentity.setVisible(true);
    }

    void setUserFirstPage(JFrame chooseIDentity){
        chooseIDentity.setVisible(false);
        UserFirstPage userFirstPage = new UserFirstPage(this);
        userFirstPage.setLocationRelativeTo(null);
        userFirstPage.setVisible(true);
    }

    public void setUserLogInPage(JFrame userFirstPage) {
        userFirstPage.setVisible(false);
        UserLogin userLogin = new UserLogin(this);
        userLogin.setLocationRelativeTo(null);
        userLogin.setVisible(true);
    }

    public void setUserSignUpPage(JFrame userFirstPage) {
        userFirstPage.setVisible(false);
        UserSignUp userSignUp = new UserSignUp(this);
        userSignUp.setLocationRelativeTo(null);
        userSignUp.setVisible(true);

    }

    public void setProfilePage(JFrame userLogin, String username) {
        userLogin.setVisible(false);
        UserProfile userProfile = new UserProfile(this, username);
        userProfile.setLocationRelativeTo(null);
        userProfile.setVisible(true);
    }

    public void setProfilePageFromSignup(JFrame userSignUp, String username) {
        userSignUp.setVisible(false);
        UserProfile userProfile = new UserProfile(this, username);
        userProfile.setLocationRelativeTo(null);
        userProfile.setVisible(true);
    }

    public void setHomePage(JFrame jframe) {
        jframe.setVisible(false);
        ChooseIDentity chooseIDentity = new ChooseIDentity(this);
        chooseIDentity.setLocationRelativeTo(null);
        chooseIDentity.setVisible(true);
    }

    public void setBookPage(JFrame catalog, String username, String bookId) {
        catalog.setVisible(false);
        BookPage bookPage = new BookPage(this, username, bookId);
        bookPage.setLocationRelativeTo(null);
        bookPage.setVisible(true);
    }

    public void setBorrowHistory(JFrame userProfile, String username) {
        userProfile.setVisible(false);
        BorrowHistory borrowHistory = new BorrowHistory(this, username);
        borrowHistory.setLocationRelativeTo(null);
        borrowHistory.setVisible(true);
    }

    public void setCatalog(JFrame userProfile, String username) {
        userProfile.setVisible(false);
        Catalog catalog = new Catalog(this, username);
        catalog.setLocationRelativeTo(null);
        catalog.setVisible(true);
    }

    public void setUnreturnedBooks(JFrame userProfile, String username) {
        userProfile.setVisible(false);
        UnreturnedBooks unreturnedBooks = new UnreturnedBooks(this, username);
        unreturnedBooks.setLocationRelativeTo(null);
        unreturnedBooks.setVisible(true);
    }
}
