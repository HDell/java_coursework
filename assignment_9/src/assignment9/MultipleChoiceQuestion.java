package assignment9;

public class MultipleChoiceQuestion extends ObjectiveQuestion{

    String[] possibleAnswers;

    public MultipleChoiceQuestion(int points, int difficulty, String questionText, String correctAnswer, String[] possibleAnswers) {
        super(points, difficulty, 1, questionText, correctAnswer);
        this.possibleAnswers = possibleAnswers;

    }

    @Override
    public String toString() {
        String questionList = "";
        for (int i=0; i<possibleAnswers.length-1; i++) {
            questionList += (i+1) + ". " + possibleAnswers[i] + "\n";
        }
        try {
            questionList += (possibleAnswers.length) + ". " + possibleAnswers[possibleAnswers.length-1];
        } catch (IndexOutOfBoundsException e) {
            //do nothing
        }
        return questionList;
    }

    @Override
    public String getQuestionAndAnswer() {
        String questionList = "";
        for (int i=0; i<possibleAnswers.length-1; i++) {
            if(possibleAnswers[i].equals(this.correctAnswer)) {
                questionList += (i + 1) + ". " + "**** " + possibleAnswers[i] + " ****" + "\n";
            } else {
                questionList += (i + 1) + ". " + possibleAnswers[i] + "\n";
            }
        }
        try {
            if(possibleAnswers[possibleAnswers.length-1].equals(this.correctAnswer)) {
                questionList += (possibleAnswers.length) + ". " + "**** " + possibleAnswers[possibleAnswers.length-1] + " ****" + "\n";
            } else {
                questionList += (possibleAnswers.length) + ". " + possibleAnswers[possibleAnswers.length-1];
            }
        } catch (IndexOutOfBoundsException e) {
            //do nothing
        }
        return questionList;    }
}
