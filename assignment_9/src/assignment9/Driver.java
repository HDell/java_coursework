package assignment9;

// Handell Desulme
// 4/14/2019
// Assignment 9. Test Papers Assignment
//
// This program creates a test question class hierarchy and a driver that outputs the questions and answers.

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        String filename;
        System.out.print("Decide on a filename to send your test to (e.g. something.txt): ");
        filename = in.next();
        File file = new File(filename);
        PrintStream stream = new PrintStream(file);

        ObjectiveQuestion question1 = new FillInTheBlankQuestion(3, 2, 2, "____ is the test maker's name", "Handell");
        ObjectiveQuestion question2 = new FillInTheBlankQuestion(5, 4, 1, "____ is the test maker's old pet's name", "Tom");
        String[] possibleAnswers = {"January", "February", "March", "April"};
        ObjectiveQuestion question3 = new MultipleChoiceQuestion(3, 5, "What month was this created in?", "April", possibleAnswers);
        ObjectiveQuestion[] objectiveQuestions = {question1, question2, question3};
        Test myTest = new Test(objectiveQuestions);
        System.out.print(myTest);

        stream.print(myTest);
    }
}
