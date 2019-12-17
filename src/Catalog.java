import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Catalog extends JFrame{
    private JPanel panel1;
    private JTable table1;
    private JTextField searchBookByBookTextField;
    private JButton searchButton;
    private Library library = new Library();

    Catalog(Main main, String username){
        add(panel1);
        String[] columnNames = {"BookId", "Book Name", "Book Author"};
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columnNames);
        table1.setModel(tableModel);
        ArrayList<Book> books = library.getBooks();
        insertRow(tableModel, books);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBookByBookTextField.getText();
                searchBookByBookTextField.getText();
                DefaultTableModel defaultTableModel = new DefaultTableModel();
                defaultTableModel.setColumnIdentifiers(columnNames);
                table1.setModel(defaultTableModel);
                insertRow(defaultTableModel, library.getBooksByKeyword(searchBookByBookTextField.getText()));
            }
        });

        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() > 0){
                    JTable target = (JTable)e.getSource();
                    int row = target.getSelectedRow();
                    String bookId = (String) table1.getModel().getValueAt(row, 0);
                    main.setBookPage(Catalog.this, username, bookId);
                }
            }
        });

    }

    private void insertRow(DefaultTableModel tableModel, ArrayList<Book> books) {
        for (Book book: books){
            String bookId = book.getBookId();
            String bookName = book.getBookName();
            String author = book.getAuthor();
            tableModel.addRow(new String[] {bookId, bookName, author});
        }
    }


}
