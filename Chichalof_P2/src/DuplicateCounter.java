import java.util.*;
import java.io.*;
import java.lang.*;

public class DuplicateCounter {
    private static HashMap<String, Integer> wordCounter;

    public void counter(File dataFile) throws IOException {
        if(!dataFile.exists()){
            throw new IOException("Invalid file");
        }
        String wordsInFile;
        Integer timesRepeated;
        ArrayList<String> wordsInFile_Array = new ArrayList<>();
        HashMap<String, Integer> wordCounter = new HashMap<>();
        FileInputStream fileOpener = new FileInputStream(dataFile);
        Scanner fileScanner = new Scanner(fileOpener);
        try {
            if (!dataFile.exists()) {
                throw new IOException();
            }
            while (true) {
                wordsInFile = fileScanner.next();
                wordsInFile_Array.add(wordsInFile);
                if (!fileScanner.hasNext()) {
                    break;
                }
            }
            for (String wordsInMap : wordsInFile_Array) {
                timesRepeated = wordCounter.get(wordsInMap);
                if (timesRepeated == null) {
                    timesRepeated = 0;
                }
                wordCounter.put(wordsInMap, (timesRepeated + 1));

            }
        }
        catch (IOException excpt){
            System.out.println("An IO exception occurred, " + excpt.getMessage() + "\nClosing program");
            fileOpener.close();
        }
        finally {
            fileOpener.close();
        }
        this.wordCounter = wordCounter;
        fileOpener.close();
    }
    public void write(File outputFile) throws IOException{

        FileOutputStream outputFileSelector = new FileOutputStream(outputFile);
        PrintWriter outputWords = new PrintWriter(outputFileSelector);
        outputWords.print(this.wordCounter);
        outputWords.flush();
        outputFileSelector.close();
    }
}
