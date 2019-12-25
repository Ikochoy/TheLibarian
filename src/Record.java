import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/*
This Program is written by Koby Choy. This is the record class from the project The Libarian.
 */
public class Record {
    /*
    This class represent a record. (a borrowing record) Each record contains a book, a borrow date (the current date),
     a return date (borrow date + 14 days), a boolean variable that indicates whether the book in the record is returned
     or not, a boolean variable that indicates whether the book in the record is returned late or not, and a boolean
     variable that indicates whether the return date of the record has been extended or not.
     */
    private Book book;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private boolean isReturned;
    private LateRecordsManager lateRecordsManager;
    private ReturnDateExtender returnDateExtender;

    // create a new borrowing record, if the book is available to borrow;
    public Record(Book book) {
        if (book.isInStock()){
        this.book = book;
        this.borrowDate = LocalDate.now();
        this.returnDate = LocalDate.now().plusDays(14);
        this.lateRecordsManager = new LateRecordsManager();
        this.isReturned = false;
        this.returnDateExtender = new ReturnDateExtender();
        bookBorrow();
        }
    }

    //extends return date
    public boolean setReturnDateExtended() {
        LocalDate extendedDate = returnDateExtender.extendReturnDate(this.returnDate);
        if(extendedDate != null){
            this.returnDate = extendedDate;
            return true;
        }
        return false;
    }

    //get number of days till returning
    public long getRemainingDays(){
        LocalDate current = LocalDate.now();
        return ChronoUnit.DAYS.between(current, this.returnDate);
    }

    public boolean bookBorrow(){
        return this.book.borrowItem();
    }

    // book return
    public boolean bookReturn(){
        LocalDate current = LocalDate.now();
        this.isReturned = true;
        this.book.returnItem();
        if (current.isAfter(this.returnDate)) {
            this.setRecordLate();
            return false;
        }
        return true;
    }

    // Mark a book borrowing record to be late
    void setRecordLate(){
        lateRecordsManager.setLate();
    }

    //clear Late record
    private void clearLateRecord(){
        lateRecordsManager.clearLateRecord();
    }

    boolean isReturned() {
        return isReturned;
    }

    boolean isLate() {
        return lateRecordsManager.isLate();
    }

    String getBookId() {
        return book.getBookId();
    }

    String getBookName(){
        return book.getBookName();
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public boolean isExtended(){
        return returnDateExtender.getIsExtended();
    }

    @Override
    public String toString() {
        return "Book Name- "+ book.getBookName()+"; BookId- "+book.getBookId() +"; Borrow Date- "+ borrowDate+
                "; Return Date- "+ returnDate + "; Returned- " + isReturned + "; Extended- "+ returnDateExtender.getIsExtended()
                + "; Late- "+isLate();
    }
}
