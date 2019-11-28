package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class LeaderBoardManager {
    private static Vector<Player> leaderBoard = new Vector<>();
    private static final String filename = "dat/leaderboard.txt";

    public LeaderBoardManager() {
        if (leaderBoard.size() == 0)
            load();
    }

    public Vector<Player> getLeaderBoard() {
        return leaderBoard;
    }

    public void add(Player player) {
        leaderBoard.add(player);
        Collections.sort(leaderBoard);
    }

    public void reset() {
        leaderBoard.removeAllElements();
    }

    public boolean save() {
        try {
            FileWriter fout = new FileWriter(filename, StandardCharsets.UTF_8);
            BufferedWriter out = new BufferedWriter(fout);
            for (Player line:leaderBoard)
                out.write(line.getName() + "|" + line.getScore() + "\n");
            out.close();
            fout.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean load() {
        if (!Files.exists(Paths.get(filename)))
            return false;

        try {
            List<String> lines = Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8);
            Vector<Player> v = new Vector<>();
            for (String line:lines) {
                String name = line.split("|")[0].trim();
                int score = Integer.parseInt(line.split("|")[1]);
                v.add(new Player(name, score));
            }
            Collections.sort(v);
            leaderBoard = v;
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
