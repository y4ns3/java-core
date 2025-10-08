package lessons.lesson05.OnlineQuizSystem;

class Team {
    private String name;
    private int score;

    public Team(String name) {
        this.name = name;
        this.score = 0;
    }

    public void addScore(int points) {
        score += points;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}