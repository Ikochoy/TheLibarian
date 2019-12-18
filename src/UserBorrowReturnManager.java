public class UserBorrowReturnManager {
    private UserBorrowHistoryManager userBorrowHistoryManager;

    public UserBorrowReturnManager(UserBorrowHistoryManager userBorrowHistoryManager) {
        this.userBorrowHistoryManager = userBorrowHistoryManager;
    }

    // borrow the book
    void borrowBook(Book book){
        Record record = new Record(book);
        userBorrowHistoryManager.addRecord(record);
    }

    // return the book
    void returnBook(String bookId) throws BookNotBorrowedException{
        Record record = userBorrowHistoryManager.getRecordByBookId(bookId);
        if (record != null){
           record.bookReturn();
        }else{
            throw new BookNotBorrowedException("Record shows that you didn't borrow this book!");
        }
    }
}
