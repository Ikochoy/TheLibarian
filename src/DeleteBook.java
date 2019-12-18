import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteBook extends JFrame{
    private JTextField textField1;
    private JButton delButton;
    private JButton adminHOMEButton;
    private JLabel ERROR;

    public DeleteBook(Main main) {
        String bookId = textField1.getText();
        Library library = new Library();
        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (library.getBook(bookId).getNoCopies() == 1) {
                        library.deleteBook(bookId);
                    }else{
                        library.getBook(bookId).decreaseCopy();
                    }
                } catch (BookNotExistException ex) {
                    ERROR.setText("This book does not exist. Check if the bookId is correct or not");
                }
            }
        });

        adminHOMEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setHomePage(DeleteBook.this);
            }
        });

    }
}
