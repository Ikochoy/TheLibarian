import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BorrowHistory extends JFrame{
    private JPanel panel1;
    private JTable table1;
    private JButton backButton;
    private String[] col = {"Book Name", "Borrow Date", "Return Date", "Is Returned", "Is Extended", "is Late"};

    public BorrowHistory(Main main, String username) {
        add(panel1);
        setSize(400, 400);
        Library library = new Library();
        User user = library.getUserByUserName(username);
        ArrayList<Record> history = user.getBorrowHistory();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(col);
        table1.setModel(tableModel);
        insertRow(tableModel, history);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setProfilePage(BorrowHistory.this, username);
            }
        });

    }

    private void insertRow(DefaultTableModel db, ArrayList<Record> records) {
        for (Record record: records){
            String bookName = record.getBookName();
            String borrowDate = String.valueOf(record.getBorrowDate());
            String returnDate = String.valueOf(record.getReturnDate());
            String isReturned = String.valueOf(record.isReturned());
            String isExtended = String.valueOf(record.isExtended());
            String isLate = String.valueOf(record.isLate());

            String[] row = {bookName, borrowDate, returnDate, isReturned, isExtended, isLate};
            db.addRow(row);
        }

    }
}
