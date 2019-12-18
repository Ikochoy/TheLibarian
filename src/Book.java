import javafx.beans.InvalidationListener;

import java.util.ArrayList;
import java.util.Observable;

/*
This Program is written by Koby Choy. This is the book class from the project The Libarian.
 */
public class Book implements Item{
    /*
    This class represent a book. Each book has a book name, an author, a unique bookId and a boolean value to store
    whether the book is in stock or not.
     */
    private String bookName;
    private String author;
    private String bookId;
    private BookInventoryManager bookInventoryManager;

    // A method to create a new book with a name, an author and a bookId. The variable inStock is set as True as
    // default.
    public Book(String bookName, String author, String bookId, int noCopies) {
        this.bookName = bookName;
        this.author = author;
        this.bookId = bookId;
        this.bookInventoryManager = new BookInventoryManager(this,noCopies);
    }

    // get the name of the book
    String getBookName() {
        return bookName;
    }

    // get the author of the book
    String getAuthor() {
        return author;
    }

    // get the bookId of the book
    String getBookId() {
        return bookId;
    }

    // to see whether the book is in stock or not
    boolean isInStock() {
        return bookInventoryManager.isInStock();
    }

    @Override
    public boolean borrowItem() {
        if (bookInventoryManager.isInStock()){
            bookInventoryManager.decrementCopies();
            return true;
        }
        return false;
    }

    // method for returning a book
    @Override
    public void returnItem(){
        bookInventoryManager.incrementCopies();
    }

    public int getNoCopies(){
        return bookInventoryManager.getNoCopies();
    }

    public void increaseCopy(){
        bookInventoryManager.incrementCopies();
    }

    public void decreaseCopy(){
        bookInventoryManager.decrementCopies();
    }

}
