import java.util.ArrayList;

public class UserBorrowHistoryManager {
    private ArrayList<Record> borrowHistory = new ArrayList<>();

    void addRecord(Record record){
        borrowHistory.add(record);
    }

    // get book record by book id
    Record getRecordByBookId(String bookId) {
        for (Record record: borrowHistory){
            if (record.getBookId().equals(bookId)){
                return record;
            }
        }
        return null;
    }

    // return the list of borrow history of the user
    ArrayList<Record> getBorrowHistory(){
        return borrowHistory;
    }

    /* returns number of books not returned
     */
    int getNumBooksNotReturned(){
        int count = 0;
        for (Record record: borrowHistory){
            if(!record.isReturned()){
                count++;
            }
        }
        return count;
    }

    /* returns the number of late records this user has
     */
    int getNumLateRecords(){
        int count = 0;
        for (Record record: borrowHistory){
            if(!record.isLate()){
                count++;
            }
        }
        return count;
    }

    ArrayList<Record> getLateRecords(){
        ArrayList<Record> late = new ArrayList<>();
        for(Record record: borrowHistory){
            if(record.isLate()){
                late.add(record);
            }
        }
        return late;
    }

    ArrayList<Record> getUnreturnedRecords(){
        ArrayList<Record> unreturned = new ArrayList<>();
        for( Record record: borrowHistory){
            if(!record.isReturned()){
                unreturned.add(record);
            }
        }
        return unreturned;
    }
}
