import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserFirstPage extends JFrame {
    private JButton signInButton;
    private JButton signUpButton;
    private JPanel root;
    private JButton HOMEButton;
    private Main main;

    public UserFirstPage(Main main) {
        this.main = main;
        add(root);
        setTitle("User Sign in or Sign up");
        setSize(400, 200);
        this.main = main;
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setUserLogInPage(UserFirstPage.this);
            }
        });
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setUserSignUpPage(UserFirstPage.this);
            }
        });
        HOMEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setHomePage(UserFirstPage.this);
            }
        });
    }
}
