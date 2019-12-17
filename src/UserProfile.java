import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserProfile extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JButton EDITButton;
    private JButton EDITButton1;
    private JButton SEEBORROWINGHISTORYButton;
    private JButton SEEBOOKSNOTRETURNEDButton;
    private JButton LOGOUTButton;
    private JPanel root;
    private JButton SEARCHBOOKButton;
    private Main main;

    UserProfile(Main main, String username){
        add(root);
        setSize(400, 300);
        LOGOUTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setHomePage(UserProfile.this);
            }
        });
    }


}
