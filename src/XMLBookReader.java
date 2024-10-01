import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;

public class XMLBookReader implements BookReader {

    @Override
    public List<Book> readBooks(String filePath) throws ParserConfigurationException, IOException, SAXException {
        List<Book> books = new ArrayList<>();

        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(filePath));
        doc.getDocumentElement().normalize();  // Optional but recommended

        NodeList bookNodes = doc.getElementsByTagName("book");

        for (int i = 0; i < bookNodes.getLength(); i++) {
            Element bookElement = (Element) bookNodes.item(i);
            books.add(parseBook(bookElement));
        }

        return books;
    }

    private Book parseBook(Element element) {
        String title = getElementTextContent(element, "title");
        String author = getElementTextContent(element, "author");
        String genre = getElementTextContent(element, "genre");
        int pages = Integer.parseInt(getElementTextContent(element, "pages"));
        String dateRead = getElementTextContent(element, "date_read");

        return new Book(title, author, genre, pages, dateRead);
    }

    private String getElementTextContent(Element element, String tagName) {
        return element.getElementsByTagName(tagName).item(0).getTextContent();
    }
}
