import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CheckUser extends JFrame{
    private JPanel panel1;
    private JTextField textField1;
    private JButton getUserInfoButton;
    private JLabel noUnreturnedBks;
    private JLabel noLateBks;
    private JTable table1;
    private JButton ADMINHOMEButton;
    private String[] col = {"Book Name", "Borrow Date", "Return Date", "Is Returned", "Is Extended", "is Late"};

    CheckUser(Main main){
        add(panel1);
        setSize(600, 600);
        Library library = new Library();
        getUserInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField1.getText();
                User user = library.getUserByUserName(username);
                noUnreturnedBks.setText(Integer.toString(user.getNumUnreturnedRecords()));
                noLateBks.setText(Integer.toString(user.getNumLateRecords()));
                ArrayList<Record> history = user.getBorrowHistory();
                DefaultTableModel tableModel = new DefaultTableModel();
                tableModel.setColumnIdentifiers(col);
                table1.setModel(tableModel);
                insertRow(tableModel, history);
            }
        });

    }

    private void insertRow(DefaultTableModel tableModel, ArrayList<Record> history) {
        for (Record record: history) {
            if (record.isLate() || !record.isReturned()) {
                String bookName = record.getBookName();
                String borrowDate = String.valueOf(record.getBorrowDate());
                String returnDate = String.valueOf(record.getReturnDate());
                String isReturned = String.valueOf(record.isReturned());
                String isExtended = String.valueOf(record.isExtended());
                String isLate = String.valueOf(record.isLate());

                String[] row = {bookName, borrowDate, returnDate, isReturned, isExtended, isLate};
                tableModel.addRow(row);
            }
        }
    }

}
