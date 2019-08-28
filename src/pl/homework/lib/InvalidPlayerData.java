package pl.homework.lib;

public class InvalidPlayerData extends Exception {
    public InvalidPlayerData() {
        System.out.println("Błędny format wprowadzonych danych zawodnika");
    }
}
