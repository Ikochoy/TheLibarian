import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserProfile extends JFrame{
    private JTextField usrname;
    private JTextField pwd;
    private JButton EDITButton;
    private JButton EDITButton1;
    private JButton SEEBORROWINGHISTORYButton;
    private JButton SEEBOOKSNOTRETURNEDButton;
    private JButton LOGOUTButton;
    private JPanel root;
    private JButton SEARCHBOOKButton;
    private JLabel id;

    UserProfile(Main main, String username){
        add(root);
        setSize(400, 400);
        Library library = new Library();
        User user = library.getUserByUserName(username);
        usrname.setText(user.getUserName());
        id.setText(user.getUserId());
        pwd.setText(user.getPassword());
        SEEBORROWINGHISTORYButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setBorrowHistory(UserProfile.this, username);

            }
        });
        EDITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String new_usrn = usrname.getText();
                user.changeUserName(new_usrn);
            }
        });
        EDITButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String new_pwd = pwd.getText();
                user.changePassword(new_pwd);
            }
        });


        LOGOUTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setHomePage(UserProfile.this);
            }
        });
        SEARCHBOOKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setCatalog(UserProfile.this, username);
            }
        });
        SEEBOOKSNOTRETURNEDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setUnreturnedBooks(UserProfile.this, username);
            }
        });

    }


}
