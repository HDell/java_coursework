package assignment9;

import java.util.Scanner;

public class Question {

    //Constants
    final int MIN_DIFFICULTY = 1;
    final int MAX_DIFFICULTY = 10;

    //Fields
    int points;
    int difficulty;
    int answerSpace;
    String questionText;

    //Constructor
    public Question(int points, int difficulty, int answerSpace, String questionText) {
        this.points = points;
        this.difficulty = difficulty;
        Scanner in = new Scanner(System.in);
        while(!(difficulty<=MAX_DIFFICULTY&&difficulty>=MIN_DIFFICULTY)) {
            System.out.println("Difficulty must be between 1 and 10.");
            this.difficulty = in.nextInt();
        }
        this.answerSpace = answerSpace;
        this.questionText = questionText;
    }

    //Instance Methods
    @Override
    public String toString() {
        return "Question: "+questionText;
    }

    public int getPoints() {
        return this.points;
    }

}
