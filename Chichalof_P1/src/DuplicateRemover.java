import java.util.*;
import java.io.*;
public class DuplicateRemover {
    private static HashSet<String> uniqueWords;

    public void remove(File dataFile) throws IOException {
        if (!dataFile.exists()) {
           throw new IOException("Invalid file");
        }
        String wordsInFile;
        HashSet<String> fileWords_Set = new HashSet<String>();
        FileInputStream fileOpener = new FileInputStream(dataFile);
        Scanner wordScanner = new Scanner(fileOpener);

            try {
                if (!dataFile.exists()) {
                    throw new IOException();
                }
                while (true) {
                wordsInFile = wordScanner.next();
                fileWords_Set.add(wordsInFile);
                    if (!wordScanner.hasNext()) {
                        break;
                }
            }
        }
        catch (IOException excpt){
            System.out.println("An IO exception occurred, " + excpt.getMessage() + "\nClosing program");
            fileOpener.close();
        }
        finally {
            fileOpener.close();
        }
        this.uniqueWords = fileWords_Set;
    }

    public void write(File outputFile) throws IOException{

        FileOutputStream outputFileSelector = new FileOutputStream(outputFile);
        PrintWriter outputWords = new PrintWriter(outputFileSelector);
        outputWords.print(this.uniqueWords);
        outputWords.flush();
        outputFileSelector.close();
    }
}
