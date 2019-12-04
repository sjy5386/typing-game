package model;

public class Player implements Comparable<Player> {
    private String name;
    private int score;

    public Player() {
        name = "익명";
        score = 0;
    }

    public Player(String name) {
        this.name = name.trim();
        score = 0;
    }

    public Player(String name, int score) {
        this.name = name.trim();
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Player o) {
        return o.getScore() - this.score;
    }
}
