import java.io.File;
import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        DuplicateCounter duplicateCounter = new DuplicateCounter();
        duplicateCounter.counter(new File("problem2.txt"));
        duplicateCounter.write(new File("unique_words_count.txt"));
    }
}
