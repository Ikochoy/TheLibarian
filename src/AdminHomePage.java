import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminHomePage extends JFrame{
    private JButton borrowBookButton;
    private JButton returnABookButton;
    private JButton addANewBookButton;
    private JPanel root;
    private JButton HOMEButton;
    private JButton checkUserButton;
    private JButton extendRecordButton;


    public AdminHomePage(Main main) {
        add(root);
        setSize(400, 300);
        borrowBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setBorrowPage(AdminHomePage.this);
            }
        });
        returnABookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setReturnPage(AdminHomePage.this);
            }
        });
        addANewBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               main.setAddBookPage(AdminHomePage.this);
            }
        });
        HOMEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setHomePage(AdminHomePage.this);
            }
        });
        checkUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setCheckUserPage(AdminHomePage.this);
            }
        });
        extendRecordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setExtendRecordPage(AdminHomePage.this);
            }
        });
    }
}
