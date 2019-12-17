import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookPage extends JFrame{
    private JLabel name;
    private JLabel writer;
    private JLabel inStock;
    private JButton HOMEButton;
    private JButton BACKButton;
    private JPanel root;
    private Library library;

    public BookPage(Main main, String username, String bookid){
        add(root);
        setSize(400, 400);
        library = new Library();
        Book book = library.getBook(bookid);
        name.setText(book.getBookName());
        writer.setText(book.getAuthor());
        inStock.setText(String.valueOf(book.isInStock()));
        BACKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        HOMEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setHomePage(BookPage.this);
            }
        });
    }
}
