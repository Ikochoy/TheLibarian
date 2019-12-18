import java.util.ArrayList;

public class ChildUser implements User {
    private UserAccountManager userAccountManager;
    private UserBorrowHistoryManager userBorrowHistoryManager;
    private UserBorrowReturnManager userBorrowReturnManager;

    public ChildUser(String userName, String password, String userid) {
        userAccountManager = new UserAccountManager(userName, password, userid);
        userBorrowHistoryManager = new UserBorrowHistoryManager();
        userBorrowReturnManager = new UserBorrowReturnManager(userBorrowHistoryManager);
    }

    @Override
    public int getNumUnreturnedRecords() {
        return userBorrowHistoryManager.getNumBooksNotReturned();
    }

    @Override
    public int getNumLateRecords() {
        return userBorrowHistoryManager.getNumLateRecords();
    }

    @Override
    public void borrowBook(Book book) {
        userBorrowReturnManager.borrowBook(book);
    }

    @Override
    public void returnBook(String bookId) throws BookNotBorrowedException {
        userBorrowReturnManager.returnBook(bookId);
    }

    @Override
    public ArrayList<Record> getBorrowHistory() {
        return userBorrowHistoryManager.getBorrowHistory();
    }

    @Override
    public void changeUserName(String newUserName) {
        userAccountManager.setUserName(newUserName);
    }

    @Override
    public void changePassword(String newPassword) {
        userAccountManager.setPassword(newPassword);
    }

    @Override
    public int getFinePayment() {
        return 0;
    }

    @Override
    public String getUserName() {
        return userAccountManager.getUserName();
    }

    @Override
    public String getPassword() {
        return userAccountManager.getPassword();
    }

    @Override
    public String getUserId() {
        return userAccountManager.getUserId();
    }

    @Override
    public ArrayList<Record> getLateRecords() {
        return userBorrowHistoryManager.getLateRecords();
    }

    @Override
    public ArrayList<Record> getUnreturnedRecords() {
        return userBorrowHistoryManager.getUnreturnedRecords();
    }
}
