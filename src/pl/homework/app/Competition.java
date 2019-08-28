package pl.homework.app;

import pl.homework.lib.InvalidPlayerData;
import pl.homework.lib.Player;
import pl.homework.lib.ScoreComparator;
import java.io.IOException;
import java.util.*;

import static pl.homework.utils.CompetitionUtils.readPlayersScores;
import static pl.homework.utils.CompetitionUtils.savePlayerScores;

public class Competition {
    public static final String CSV_FILE = "stats.csv";
    public static List<Player> players = new LinkedList<>();;

    public static void main(String[] args) {

        readPlayersScores();
        System.out.println(players);
        ScoreComparator scoreComparator = new ScoreComparator();
        Collections.sort(players, scoreComparator);
        System.out.println(players);
        try {
            savePlayerScores(players);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


}
