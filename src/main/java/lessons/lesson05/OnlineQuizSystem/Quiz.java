package lessons.lesson05.OnlineQuizSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Quiz {
    private String title;
    private List<Question> questions = new ArrayList<>();
    private List<Team> teams = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public Quiz(String title) {
        this.title = title;
    }

    public void addQuestion(String text, String answer) {
        questions.add(new Question(text, answer));
    }

    public void addTeam(String name) {
        teams.add(new Team(name));
    }

    public void start() {
        System.out.println("=== Starting Quiz: " + title + " ===");

        for (Question q : questions) {
            System.out.println("\nQuestion: " + q.getText());
            for (Team t : teams) {
                System.out.print("Answer from team \"" + t.getName() + "\": ");
                String answer = scanner.nextLine();
                if (q.checkAnswer(answer)) {
                    System.out.println("Correct!");
                    t.addScore(1);
                } else {
                    System.out.println("Wrong!");
                }
            }
        }

        showResults();
    }

    public void showResults() {
        System.out.println("\n=== Quiz Results: " + title + " ===");
        for (Team t : teams) {
            System.out.println(t.getName() + " → " + t.getScore() + " points");
        }
        teams.sort((a, b) -> b.getScore() - a.getScore());
        System.out.println("Winner: " + teams.get(0).getName());
    }
}
