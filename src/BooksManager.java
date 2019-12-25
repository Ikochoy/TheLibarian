import java.util.ArrayList;

public class BooksManager {
    private static ArrayList<Book> books = new ArrayList<>();

    void addBook(Book book){
        books.add(book);
    }

    Book getBook(String bookId){
        for (Book book: books){
            if (book.getBookId().equals(bookId)){
                return book;
            }
        }
        return null;
    }

    ArrayList<Book> getBooks(){
        return books;
    }

    public ArrayList<Book> getBookByKey(String key) {
        ArrayList<Book> books = new ArrayList<>();
        for (Book book: this.books){
            if (book.getAuthor().contains(key)| book.getBookName().contains(key)){
                books.add(book);
            }
        }
        return books;
    }

    public Book getBookByInfo(String bookName, String bookAuthor) {
        for(Book book: books){
            if(book.getBookName().equals(bookName) && book.getAuthor().equals(bookAuthor)){
               return book;
            }
        }
        return null;
    }

}
