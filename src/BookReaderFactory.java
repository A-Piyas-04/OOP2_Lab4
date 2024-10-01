public class BookReaderFactory {

    public static BookReader getBookReader(String fileType) {
        switch (fileType.toLowerCase()) {
            case "csv":
                return new CSVBookReader();
            case "json":
                return new JSONBookReader();
            case "xml":
                return new XMLBookReader();
            default:
                throw new IllegalArgumentException("Unsupported file type: " + fileType);
        }
    }
}
