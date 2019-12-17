import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserSignUp extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JButton confirmButton;
    private JSpinner spinner1;
    private JLabel error;
    private JPanel root;
    private JButton HOMEButton;
    private String[] st = {"Child", "Adult"};
    private SignUpManager signUpManager;

    public UserSignUp(Main main) {
        add(root);
        setSize(400, 300);
        SpinnerListModel sp = new SpinnerListModel(st);
        spinner1.setModel(sp);
        String status = (String) spinner1.getValue();
        String username = textField1.getText();
        String password = textField2.getText();
        signUpManager = new SignUpManager();
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = signUpManager.createNewUser(username, password, status);
                if(message.equals(signUpManager.USERNAME_DUPLICATE)){
                    error.setText(message);
                }else{
                    main.setProfilePageFromSignup(UserSignUp.this, username);
                }
            }
        });
    }
}
