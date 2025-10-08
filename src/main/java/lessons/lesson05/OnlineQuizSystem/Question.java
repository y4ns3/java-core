package lessons.lesson05.OnlineQuizSystem;

class Question {
    private String text;
    private String correctAnswer;

    public Question(String text, String correctAnswer) {
        this.text = text;
        this.correctAnswer = correctAnswer.toLowerCase();
    }

    public boolean checkAnswer(String answer) {
        return correctAnswer.equals(answer.toLowerCase());
    }

    public String getText() {
        return text;
    }
}