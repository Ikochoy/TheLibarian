import java.util.Observable;
import java.util.Observer;

public class BookInventoryManager implements ItemInventoryManager{
    /* keep tracks on whether this book has been borrowed/ returned. (basically --> whether it is in Stock)
     */
    private int noCopies;
    private Book book;
    BookInventoryManager(Book book, int noCopies){
        this.book = book;
        this.noCopies = noCopies;
    }

    public int getNoCopies(){
        return noCopies;
    }

    public boolean isInStock() {
        return noCopies > 0;
    }

    public void decrementCopies(){
        this.noCopies--;
    }

    public void incrementCopies(){
        this.noCopies++;
    }
}
