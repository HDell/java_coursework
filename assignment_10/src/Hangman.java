// Handell Desulme
// 4/19/2019
// Assignment 10. Cheating Word Guessing Game
//
// Allows the user to play a game of hangman. However, the computer cheats to make the game more difficult.

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

    static final int RAND_MIN = 4;
    static final int RAND_MAX = 10;

    public static void main(String args[]) {

        //Initializing

        Random rand = new Random();
        boolean won = false;

        int totalGuesses = 6;
        int randLength = rand.nextInt(RAND_MAX-RAND_MIN+1)+RAND_MIN; //(0-6 + 4->4+10)

        String lastGuess;
        String[] choiceWords = new String[randLength];

        List<String> dictionaryWords = new ArrayList<>();
        List<String> correctWords = new ArrayList<>();

        Scanner in = new Scanner(System.in);

        //Populating
        dictionaryWords.add("ruin"); //4
        dictionaryWords.add("luck"); //4
        dictionaryWords.add("shine"); //5
        dictionaryWords.add("climb"); //5
        dictionaryWords.add("simile"); //6
        dictionaryWords.add("shower"); //6
        dictionaryWords.add("vacant"); //6
        dictionaryWords.add("satiate"); //7
        dictionaryWords.add("buoyant"); //7
        dictionaryWords.add("caution"); //7
        dictionaryWords.add("esoteric"); //8
        dictionaryWords.add("regional"); //8
        dictionaryWords.add("galvanize"); //9
        dictionaryWords.add("conjugate"); //9
        dictionaryWords.add("excavation"); //10
        dictionaryWords.add("patriotism"); //10

        for(int i = 0; i<dictionaryWords.size(); i++) {
            if (dictionaryWords.get(i).length()==randLength) {
                correctWords.add(dictionaryWords.get(i).toLowerCase());
            }
        }

        //Printing

        //vvv COMMENT THIS OUT IN ACTUAL GAME PLAY TO HIDE LENGTH OF WORDS
        System.out.println(randLength);
        //^^^ Comment

        //vvv COMMENT THIS OUT IN ACTUAL GAME PLAY TO HIDE WORDS
        for(int i = 0; i<correctWords.size(); i++) {
            System.out.println(correctWords.get(i));
        }
        //^^^ Comment

        while(totalGuesses>0){
            System.out.println();
            System.out.println(populateView(choiceWords));
            System.out.println("Total Guesses Remaining: "+totalGuesses);
            System.out.print("Make a guess (word or letter): ");
            lastGuess = in.next();
            lastGuess = lastGuess.toLowerCase();
            for (int i = 0; i < correctWords.size(); i++) {
                if (correctWords.size() > 1) {
                    if (lastGuess.length() > 1 && correctWords.get(i).equals(lastGuess)) {
                        correctWords.remove(i);
                        i--;
                    }
                } if (correctWords.size() > 1) {
                    if (lastGuess.length() == 1 && correctWords.get(i).contains(lastGuess)) {
                        correctWords.remove(i);
                        i--;
                    }
                }
            }
            if (correctWords.size() > 1 || (correctWords.size() == 1 && !correctWords.get(0).contains(lastGuess))) {
                System.out.println("Incorrect Guess");
            } else {
                if (lastGuess.length() > 1 && correctWords.get(0).equals(lastGuess)) {
                    System.out.println("Correct Guess. You Win!");
                    System.out.println("The word was: " + correctWords.get(0));
                    totalGuesses = 0;
                    won = true;
                } else if (lastGuess.length() == 1 && correctWords.get(0).contains(lastGuess)) {
                    choiceWords = fillGuesses(lastGuess, correctWords.get(0), choiceWords);
                    System.out.print("Correct Guess.");
                    String checkWin = "";
                    for (int i = 0; i < choiceWords.length; i++) {
                        checkWin += choiceWords[i];
                    }
                    if (correctWords.get(0).equals(checkWin)) {
                        System.out.println(" You Win!");
                        System.out.println("The word was: " + correctWords.get(0));
                        totalGuesses = 0;
                        won = true;
                    } else {
                        System.out.println();
                    }
                }
            }

            totalGuesses--;

            //vvv COMMENT THIS OUT IN ACTUAL GAME PLAY TO HIDE WORDS
            for(int i = 0; i<correctWords.size(); i++) {
                System.out.println(correctWords.get(i));
            }
            //^^^ Comment

        } //while ending (game play)
        if(!won) {
            System.out.println("Out of Guesses. You Lose!");
        }

    } //main method ending

    public static String[] fillGuesses(String lastGuess, String correctWord, String[] choiceWords) {
        for(int i=0; i<correctWord.length(); i++) {
            if(correctWord.charAt(i)==lastGuess.charAt(0)) {
                choiceWords[i] = lastGuess;
            }
        }
        return choiceWords;
    }

    public static String populateView(String[] choiceWords) {
        String view = "";
        for (int i = 0; i<choiceWords.length; i++) {
            if(i==0) {
                if (choiceWords[i] == null) {
                    view += "__";
                } else {//choiceWords[i] == letter
                    view += "_"+choiceWords[i]+"_";
                }
            } else {
                if (choiceWords[i] == null) {
                    view += " __";
                } else {//choiceWords[i] == letter
                    view += " _"+choiceWords[i]+"_";
                }
            }
        }
        return view;
    }

} //class ending
