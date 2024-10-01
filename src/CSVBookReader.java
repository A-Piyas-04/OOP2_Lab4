import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVBookReader implements BookReader{

    @Override
    public List<Book> readBooks(String filePath) throws IOException {
        List<Book> books = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        String splitBy = ",";

        while ((line = br.readLine()) != null) {
            String[] bookData = line.split(splitBy);
            Book book = new Book(bookData[0], bookData[1], bookData[2],
                    Integer.parseInt(bookData[3]), bookData[4]);
            books.add(book);
        }
        return books;
    }
}

