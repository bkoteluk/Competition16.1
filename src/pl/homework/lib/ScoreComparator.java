package pl.homework.lib;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        if (o1.getScore() > o2.getScore()) {
            return 1;
        };
        if (o1.getScore() == o2.getScore()) {
            return 0;
        } else {
            return -1;
        }
    }
}
