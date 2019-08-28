package pl.homework.lib;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        if (o1 == null && o2 == null)
            return 0;
        if (o1 == null && o2 != null)
            return -1;
        if (o1 != null && o2 == null)
            return 1;
        if (o1.getScore() > o2.getScore())
            return 1;
        if (o1.getScore() == o2.getScore())
            return o1.getName().compareTo(o2.getName());
        else
            return -1;
    }
}
