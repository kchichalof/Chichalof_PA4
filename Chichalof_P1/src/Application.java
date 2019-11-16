import java.io.File;
import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        DuplicateRemover duplicateRemover = new DuplicateRemover();
        duplicateRemover.remove(new File("problem1.txt"));
        duplicateRemover.write(new File("unique_words.txt"));
    }
}
