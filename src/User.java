import java.util.ArrayList;

public interface User {
    int getNumUnreturnedRecords();
    int getNumLateRecords();
    void borrowBook(Book book);
    void returnBook(String bookId) throws BookNotBorrowedException;
    ArrayList<Record> getBorrowHistory();
    void changeUserName(String newUserName);
    void changePassword(String newPassword);
    int getFinePayment();
    String getUserName();
    String getPassword();
    String getUserId();
    ArrayList<Record> getLateRecords();
    ArrayList<Record> getUnreturnedRecords();
}
