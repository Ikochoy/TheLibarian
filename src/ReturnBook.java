import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnBook extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JButton returnBookButton;
    private JLabel error;
    private JButton adminHOMEButton;
    private JPanel root;

    public ReturnBook(Main main) {
        add(root);
        setSize(400, 300);
        Library library = new Library();
        String bookId = textField2.getText();
        String username = textField1.getText();
        User user = library.getUserByUserName(username);
        returnBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    user.returnBook(bookId);
                }catch(BookNotBorrowedException ex){
                    error.setText("The system shows that this user has not borrowed this book");
                }
            }
        });
        adminHOMEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setHomePage(ReturnBook.this);
            }
        });

    }
}
