import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface BookReader {
    List<Book> readBooks(String filepath) throws IOException, ParserConfigurationException, SAXException;
}
