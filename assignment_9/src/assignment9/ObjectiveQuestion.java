package assignment9;

public class ObjectiveQuestion extends Question {

    //Fields
    String correctAnswer;

    //Constructor
    public ObjectiveQuestion(int points, int difficulty, int answerSpace, String questionText, String correctAnswer) {
        super(points, difficulty, answerSpace, questionText);
        this.correctAnswer = correctAnswer;
    }

    //Instance Methods
    @Override
    public String toString() {
        return super.toString();
    }

    public String getQuestionAndAnswer() {
        return "Question: "+questionText+"\n"+
                "Answer: "+correctAnswer;
    }

}
