import java.util.ArrayList;

public class BooksManager {
    private static ArrayList<Book> books = new ArrayList<>();

    void addBook(Book book){
        books.add(book);
    }

    void deleteBook(String bookId) throws BookNotExistException{
        Book book = getBook(bookId);
        if (book != null){
            books.remove(book);
        }else{
            throw new BookNotExistException("This book does not exist in record");
        }
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
        for (Book book: books){
            if (book.getAuthor().contains(key)| book.getBookName().contains(key)){
                books.add(book);
            }
        }
        return books;
    }
}
