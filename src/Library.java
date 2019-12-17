import java.util.ArrayList;

public class Library {
    /* library class
    represent what a library should have
     */
    private UsersManager usersManager;
    private BooksManager booksManager;

    public Library(){
        this.usersManager = new UsersManager();
        this.booksManager = new BooksManager();
    }

    /* add a user to the record
     */
    void addUser(String userName, String password, String userId, String status){
       usersManager.addUser(userName, password, userId, status);
    }
    /* delete a user from the record */
    void deleteUser(String userId) throws UserNotExitException{
        usersManager.deleteUser(userId);
    }
    /* add a book to the library */
    void addBook(Book book){
        booksManager.addBook(book);
    }
    /* delete the book from the library
     */
    void deleteBook(String bookId) throws BookNotExistException{
        booksManager.deleteBook(bookId);
    }

    /* get a user by userID
     */
    User getUserByUserName(String username){
        return usersManager.getUserByUsername(username);
    }
    /* get book by bookId
     */
    Book getBook(String bookId){
        return booksManager.getBook(bookId);
    }

    ArrayList<Book> getBooksByKeyword(String name){
        return booksManager.getBookByKey(name);
    }

    /* get list of users */
    ArrayList<User> getUsers(){
        return usersManager.getUsers();
    }
    /* get list of books */
    ArrayList<Book> getBooks(){
        return booksManager.getBooks();
    }
}
