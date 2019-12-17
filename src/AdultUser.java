import java.util.ArrayList;

public class AdultUser implements User {
    private UserAccountManager userAccountManager;
    private UserBorrowHistoryManager userBorrowHistoryManager;
    private UserBorrowReturnManager userBorrowReturnManager;

    AdultUser(String userName, String password, String userId){
        userAccountManager = new UserAccountManager(userName, password, userId);
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
}
