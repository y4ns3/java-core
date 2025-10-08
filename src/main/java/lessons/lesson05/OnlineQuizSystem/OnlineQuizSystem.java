package lessons.lesson05.OnlineQuizSystem;

import java.util.Scanner;

public class OnlineQuizSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter quiz title: ");
        String quizTitle = scanner.nextLine();

        Quiz quiz = new Quiz(quizTitle);

        quiz.addQuestion("What is the capital of France?", "Paris");
        quiz.addQuestion("How many planets are there in the Solar System?", "8");
        quiz.addQuestion("Who wrote 'Romeo and Juliet'?", "Shakespeare");
        quiz.addQuestion("What is the largest ocean on Earth?", "Pacific");

        quiz.addTeam("Team A");
        quiz.addTeam("Team B");

        quiz.start();
    }
}