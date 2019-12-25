import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExtendRecord extends JFrame{
    private JPanel root;
    private JTextField textField1;
    private JTextField textField2;
    private JButton setExtendedButton;
    private JLabel warningMessage;
    private JButton ADMINHOMEButton;

    ExtendRecord(Main main){
        add(root);
        setSize(500, 500);
        Library library = new Library();
        setExtendedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = textField1.getText();
                String bookName = textField2.getText();
                User user = library.getUserByUserName(userName);
                Record r = user.getRecordByBookName(bookName);
                if(r.isExtended()){
                    warningMessage.setText("This return date is already extended");
                }else{
                    r.setReturnDateExtended();
                    warningMessage.setText("Return Date extended successfully");
                }

            }
        });
        ADMINHOMEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setAdminFirstPage(ExtendRecord.this);
            }
        });
    }
}
