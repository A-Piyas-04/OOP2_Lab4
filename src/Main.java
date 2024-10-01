import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path of the book list: ");
        String filePath = scanner.nextLine();

        // Use factory to get the appropriate reader based on file extension
        BookReader bookReader = BookReaderFactory.getBookReader(filePath);

        try {
            // Read books using the appropriate reader
            List<Book> books = bookReader.readBooks(filePath);

            // Example: Print total number of books read
            System.out.println("\nTotal number of books read: " + books.size());

            // Additional logic to answer Alice's queries (e.g., total pages, genre frequency, etc.)
            printBookDetails(books);

        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println("Error reading the book file: " + e.getMessage());
        }
    }

    public static void printBookDetails(List<Book> books) {
        for (Book book : books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor() + " (" + book.getGenre() + ", " + book.getPages() + " pages)");
        }
    }


}
