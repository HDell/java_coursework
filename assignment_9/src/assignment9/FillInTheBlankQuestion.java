package assignment9;

import java.util.Scanner;

public class FillInTheBlankQuestion extends ObjectiveQuestion {

    //Constructor
    public FillInTheBlankQuestion(int points, int difficulty, int answerSpace, String questionText, String correctAnswer) {
        super(points, difficulty, answerSpace, questionText, correctAnswer);
        Scanner in = new Scanner(System.in);
        while(!questionText.contains("__")) {
            System.out.println("Question must include a blank space (two underscores).");
            questionText = in.nextLine();
        }
    }

    //Instance Methods
    @Override
    public String toString() {
        return super.toString();
    }

    public String getQuestionAndAnswer() {
        String filledInQuestion = "";
        Scanner in = new Scanner(questionText);
        while(in.hasNext()) {
            String current = in.next();
            if(current.contains("__")){
                int size = current.length();
                int leftHalf = size/2;
                int rightHalf = size/2;
                for(int i=0; i<leftHalf; i++) {
                    filledInQuestion+="_";
                }
                filledInQuestion+=correctAnswer;
                for(int i=0; i<rightHalf; i++) {
                    filledInQuestion+="_";
                }
            }else{
                filledInQuestion+=current;
            }
            if(in.hasNext()) {
                filledInQuestion+=" ";
            }
        }
        return "Answer: "+filledInQuestion;
    }

}
