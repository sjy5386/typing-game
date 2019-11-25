import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class WordManager {
    private HashSet<String> words = new HashSet<>();
    private final String filename = "res/words.txt";

    public WordManager() {
        load();
    }

    public String getRandomWord() {
        int r = new Random().nextInt(words.size());
        String word = (String)words.toArray()[r];
        return word;
    }

    public Vector<String> getAllWords() {
        Vector<String> v = new Vector<>();
        v.addAll(words);
        return v;
    }

    public void add(String word) {
        words.add(word);
    }

    public void remove(String word) {
        words.remove(word);
    }

    public void save() {
        try {
            FileWriter fout = new FileWriter(filename, StandardCharsets.UTF_8);
            BufferedWriter out = new BufferedWriter(fout);
            for (String line:words)
                out.write(line + "\r\n");
            out.close();
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        if (!Files.exists(Paths.get(filename)))
            return;

        try {
            List<String> words = Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8);
            this.words.addAll(words);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
