import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLogin extends JFrame{
    private JTextField passWord;
    private JTextField userName;
    private JButton loginButton;
    private JPanel root;
    private JLabel Error;
    private JButton HOMEButton;
    private LoginManager loginManager;

    UserLogin(Main main){
        add(root);
        setTitle("User login");
        setSize(400, 300);
        loginManager = new LoginManager();
        String username = userName.getText();
        String password = passWord.getText();
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = loginManager.validate(username, password);
                if(message.equals(loginManager.VALID)) {
                    main.setProfilePage(UserLogin.this, username);
                }else{
                    Error.setText(message);
                }
            }
        });
        HOMEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setHomePage(UserLogin.this);
            }
        });
    }
}
