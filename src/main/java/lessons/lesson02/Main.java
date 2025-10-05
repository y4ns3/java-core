package lessons.lesson02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuestGame game = new QuestGame(sc);
        game.start();
        sc.close();
    }
}
