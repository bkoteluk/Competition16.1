package pl.homework.lib;

public class Player implements Comparable<Player> {
    private String name;
    private int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}' + "\n";
    }

    @Override
    public int compareTo(Player o) {
        if (this.score > o.score) {
            return 1;
        };
        if (this.score == o.score) {
            return 0;
        } else {
            return -1;
        }
    }

    public String toCSV() {
        return name + ";" + score + "\n";
    }
}
