package assignmentFourGame;

// Handell Desulme
// 2/26/2019
// Assignment 5. A Game
//
// This program implements the game of Havsta that a user can play on the console by following the instructions & using the keyboard.
// JUnit Test included (via Intellij)

/*
This was originally done in a single main() method, but was broken down into other methods to attempt to meet the extra credit specs.
It is therefore a bit experimental, and it may be the case that some of these methods (e.g. randomNum()) were unnecessary.
The isMatch() function wasn't required, but I thought it was a more interesting way to generalize, instead of doing something like:

    (response.length() <= 3 && (response.charAt(0) == 'y' || response.charAt(0) == 'Y'))
    & something similar for "n"

Lastly, the exception handling was necessary for non-integer inputs.
 */

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;


public class Havsta {

    public static final int MIN = 1;
    public static final int MAX = 4;

    public static void main(String args[]){

        introduction();
        game();

    }

    public static void introduction(){
        System.out.println();
        System.out.println("Welcome to Havsta. This is a two-player game in which you try to best your opponent by choosing the winning move each round.\n" +
                "The available moves are Applaro, Svartrå, Tunholmen, and Godafton.\n\n" +
                "Applaro beats Svartrå and Tunholmen\n" +
                "Svartrå beats Tunholmen\n" +
                "Tunholmen beats Godafton\n" +
                "Godafton beats Applaro and Svartrå\n\n" +
                "The opponent wins the round in the case of a tie.\n");
    }

    public static void game(){
        //INITIALIZATIONS

        int userMove, computerMove;

        int userScore = 0;
        int computerScore = 0;
        int roundsPlayed = 0;


        Scanner input = new Scanner(System.in);
        String response = "";

        System.out.print("Would you like to play a round? (y/n): ");
        response = input.next();

        while (isMatch(response, "yes")){

            //Choose Move
            moveList();
            try {
                userMove = input.nextInt();
            } catch (InputMismatchException e){
                userMove = 0;
                input.next(); //moves the buffer to the next token - away from the mismatched input
            }
            computerMove = randomNum();

            //Invalid Move
            while (userMove > 4 || userMove < 1) {
                System.out.println();
                System.out.println("Invalid. Try Again.");
                moveList();
                try {
                    userMove = input.nextInt(); //the input Scanner's buffer is no longer located at the mismatched input
                } catch (InputMismatchException e) {
                    userMove = 0;
                    input.next();
                }
            }

            //Compare Moves
            System.out.println();
            System.out.println("You chose "+moveName(userMove)+".");
            System.out.println("Your Opponent chose "+moveName(computerMove)+".");

            if (userWins(userMove, computerMove)){
                userScore++;
            } else {
                computerScore++;
            }

            //Play Another Round?
            System.out.println();
            System.out.print("Would you like to play another round? (y/n): ");
            response = input.next();
            roundsPlayed++;
        }

        //End of Game
        if (!isMatch(response, "no")){ //n, no, etc.
            System.out.println();
            System.out.println("Invalid entry!");
        }

        if(roundsPlayed>0){
            System.out.println();
            System.out.println("Thanks for playing!");
            gameResults(roundsPlayed, userScore, computerScore);
        }
    }

    public static boolean isMatch(String response, String match){
        /*
        if String match = "match", return true if response =
        - m || M
        - ma || mA || Ma || MA
        - mat || maT || mAt || Mat || mAT || MaT || MAt || MAT
        - matc || 15 other combinations
        - match || 31 other combinations
         */
        if (response.length()>match.length()){
            return false;
        }
        for (int i = 0; i < response.length(); i++){
            if(response.toLowerCase().charAt(i)!=match.toLowerCase().charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static void moveList(){
        System.out.print("1 for Applaro\n" +
                "2 for Svartrå\n" +
                "3 for Tunholmen\n" +
                "4 for Godafton\n" + "What's your move?\n");
    }

    public static int randomNum(){
        Random random = new Random();
        return random.nextInt(MAX)+MIN;
    }

    public static String moveName(int moveNum){
        String[] moves = {"Applaro", "Svartrå", "Tunholmen", "Godafton"};
        return moves[moveNum-1];
    }

    public static boolean userWins(int userMove, int computerMove){
        if ((userMove == 1 && computerMove == 2) || (userMove == 1 && computerMove == 3)){
            System.out.println("You win this round");
            return true;
        } else if (userMove == 2 && computerMove == 3) {
            System.out.println("You win this round");
            return true;
        } else if (userMove == 3 && computerMove == 4) {
            System.out.println("You win this round");
            return true;
        } else if ((userMove == 4 && computerMove == 1) || (userMove == 4 && computerMove == 2)) {
            System.out.println("You win this round");
            return true;
        } else {
            System.out.println("You lose this round");
            return false;
        }
    }

    public static void gameResults(int roundsPlayed, int userScore, int computerScore){
        System.out.println();
        System.out.println("Rounds Played: "+roundsPlayed);
        System.out.println("Your Score: "+userScore);
        System.out.println("Opponent's Score: "+computerScore);
    }

}
