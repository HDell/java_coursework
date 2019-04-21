package assignment9;

public class Test {
    ObjectiveQuestion[] questions;
    int totalPoints;

    public Test(ObjectiveQuestion[] questions) {
        this.questions = questions;
        for(int i = 0; i<questions.length; i++) {
            this.totalPoints += questions[i].getPoints();
        }
    }

    @Override
    public String toString() {
        String test = "Questions:\n";
        for (int i = 0; i<questions.length-1; i++) {
            test += questions[i].toString() + "\n\n";
        }
        try {
            test += questions[questions.length-1].toString()+"\n\nAnswers:\n";
        } catch (IndexOutOfBoundsException e) {
            //do nothing
        }

        for (int i = 0; i<questions.length-1; i++) {
            test += questions[i].getQuestionAndAnswer() + "\n\n";
        }
        try {
            test += questions[questions.length-1].getQuestionAndAnswer();
        } catch (IndexOutOfBoundsException e) {
            //do nothing
        }
        return test;
    }
}
