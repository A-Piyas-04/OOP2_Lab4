import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONBookReader implements BookReader {
    @Override
    public List<Book> readBooks(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();


        File file = new File(filePath);

        if (!file.exists()) {
            throw new IOException("File not found: " + filePath);
        }


        return objectMapper.readValue(file, new TypeReference<>() {
        });
    }
}
