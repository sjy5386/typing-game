package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class WordManager {
    private static HashSet<String> words = new HashSet<>();
    private static final String filename = "res/words.txt";

    public WordManager() {
        if (words.size() == 0)
            load();
    }

    public String getRandomWord() {
        if (words.size() == 0)
            return null;

        int r = new Random().nextInt(words.size());
        String word = (String)words.toArray()[r];
        return word;
    }

    public Vector<String> getAllWords() {
        Vector<String> v = new Vector<>();
        v.addAll(words);
        Collections.sort(v);
        return v;
    }

    public void add(String word) {
        words.add(word);
    }

    public void remove(String word) {
        words.remove(word);
    }

    public boolean save() {
        try {
            FileWriter fout = new FileWriter(filename, StandardCharsets.UTF_8);
            BufferedWriter out = new BufferedWriter(fout);
            for (String line:words)
                out.write(line + "\n");
            out.close();
            fout.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean load() {
        if (!Files.exists(Paths.get(filename)))
            return false;

        try {
            List<String> lines = Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8);
            HashSet<String> hs = new HashSet<>();
            hs.addAll(lines);
            words = hs;
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
