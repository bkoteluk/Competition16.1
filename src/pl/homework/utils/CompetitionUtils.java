package pl.homework.utils;

import pl.homework.lib.Player;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static pl.homework.app.Competition.CSV_FILE;
import static pl.homework.app.Competition.players;

public class CompetitionUtils {
    public static void readPlayersScores() {
        Player player;
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj wynik zawodnika (lub wpisz stop)");
        String line = "";
        while (!(line = sc.nextLine()).equals("stop")) {
            String[] array = line.split(" ");

            if ((player = checkData(array)) != null) {
                players.add(player);
                player = null;
            } else {
                System.out.println("Podaj dane w poprawnej formie lub wpisz stop");
            }
            System.out.println("Podaj wynik kolejnego zawodnika (lub wpisz stop)");
        }
    }

    public static void savePlayerScores(List<Player> list) throws IOException {
        File file = new File(CSV_FILE);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        for (Player player: list) {
            bufferedWriter.write(player.toCSV());
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static Player checkData(String[] array) {
        Player player = null;
        String name = "";
        int score;
        if (array.length == 3 || array.length == 2) {
            try {
                score = Integer.parseInt(array[array.length-1]);
                for (int i = 0; i < array.length-1; i++) {
                    name += array[i] + " ";
                }
                player = new Player(name, score);
            } catch (NumberFormatException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return player;
    }
}
