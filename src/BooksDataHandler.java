import java.io.*;
import java.util.ArrayList;

public class BooksDataHandler {
    static int count = 0;

    void addBook(String bookName, String Author, String noCopies) {
        try {
            FileWriter writer = new FileWriter("Books.csv");
            String bookId = Integer.toString(++count);
            String book = bookId + "," + bookName + "," + Author + "," + noCopies + "\n";
            writer.append(book);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    ArrayList<Book> getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("book.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Book book = new Book(values[0], values[1], values[2], Integer.parseInt(values[3]));
                books.add(book);
            }
            return books;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
