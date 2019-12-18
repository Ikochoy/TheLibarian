import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LateRecords extends JFrame{
    private JTable table1;
    private JButton backButton;
    private JPanel root;
    private JLabel number;

    LateRecords(Main main, String userName){
        add(root);
        setSize(400, 400);
        Library library = new Library();
        User user = library.getUserByUserName(userName);
        number.setText(Integer.toString(user.getNumLateRecords()));
        String[] col = {"Book Name", "Borrow Date", "Return Date", "Is Returned", "Is Extended", "is Late"};
        ArrayList<Record> lateRecords = library.getUserByUserName(userName).getLateRecords();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(col);
        table1.setModel(tableModel);
        insertRow(tableModel, lateRecords);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setProfilePage(LateRecords.this, userName);
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
