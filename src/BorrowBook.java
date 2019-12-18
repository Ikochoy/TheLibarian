import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorrowBook extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JButton borrowButton;
    private JButton adminHOMEButton;

    public BorrowBook(Main main) {
        String username = textField1.getText();
        Library library = new Library();
        String bookId = textField2.getText();
        borrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = library.getUserByUserName(username);
                user.borrowBook(library.getBook(bookId));
            }
        });
        adminHOMEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setHomePage(BorrowBook.this);
            }
        });
    }
}
