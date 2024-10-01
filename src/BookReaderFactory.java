public class BookReaderFactory {


    public static BookReader getBookReader(String filePath) {
        if (filePath.endsWith(".csv")) {
            return new CSVBookReader();
        } else if (filePath.endsWith(".xml")) {
            return new XMLBookReader();
        } else if (filePath.endsWith(".json")) {
            return new JSONBookReader();
        } else {
            throw new IllegalArgumentException("Unsupported file format: " + filePath);
        }
    }
}

