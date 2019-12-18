import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBook extends JFrame {
    private JButton addButton;
    private JTextField textField1;
    private JTextField textField2;
    private JButton adminHOMEButton;

    public AddBook(Main main) {
        String bookName = textField1.getText();
        String bookAuthor = textField2.getText();
        Library library = new Library();
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = Integer.toString(library.getBooksLength());
                Book book = library.getBookByInfo(bookName, bookAuthor);
                if(book != null){
                    book.increaseCopy();
                }else{
                    library.addBook(new Book(id, bookName, bookAuthor, 1));
                }
            }
        });
        adminHOMEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setHomePage(AddBook.this);
            }
        });
    }
}
