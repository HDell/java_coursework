// Handell Desulme
// 2/17/2019
// Assignment 4. practice with static methods and strings
//
// This program contains multiple string algorithms in static methods to solve a variety of problems.
// NOTE: I made the last method case sensitive because of the example in the comment & there was no JUnit test to specify otherwise.

/*
To pass the time during long voyages, Viking sailors would play the two-player game of Havsta. In this assignment, you'll implement the game, but play will be against the computer.

During each round, players choose a move, which may be either Applaro, Svartrå, Tunholmen, or Godafton. The rules are:

Applaro beats Svartrå and Tunholmen
Svartrå beats Tunholmen
Tunholmen beats Godafton
Godafton beats Applaro and Svartrå
The computer wins in the event of a tie.
Your program should behave as follows:

The user is asked if they'd like to play a round
if they choose 'y', a round is played
if they choose 'n', the program ends
Until the user has chosen to quit, another round is played.
In a round of play:
The user is asked to enter a move, which may be either Svartrå, Tunholmen, Äpplaro, or Godafton. The program should continue to prompt the user until a valid move is entered.
The computer makes a move at random. (Hint: remember how we generated random numbers in class.)
The program prints the computer's move, the user's move, and who is the winner of this round.
The user is asked if they'd like to continue.
When the user has decided to quit the game, the program prints the number of:
rounds played
times the user won
times the computer won
 */

import java.util.Scanner;
import java.util.Random;


public class Havsta {

    public static void main(String args[]){

        final int MIN = 1;
        final int MAX = 4;
        Random random = new Random();
        int userMove, computerMove;
        String[] moves = {"Applaro", "Svartrå", "Tunholmen", "Godafton"};

        int userScore = 0;
        int computerScore = 0;
        int roundsPlayed = 0;



        Scanner input = new Scanner(System.in);
        String response = "";

        introduction();

        System.out.print("Would you like to play a round? (y/n): ");
        response = input.next();

        while (response.length() <= 4 && (response.charAt(0) == 'y' || response.charAt(0) == 'Y')){

            //Choose Move
            System.out.print("1 for Applaro\n" +
                            "2 for Svartrå\n" +
                            "3 for Tunholmen\n" +
                            "4 for Godafton\n" + "What's your move? > ");
            userMove = input.nextInt();
            computerMove = random.nextInt(MAX)+MIN;

            //Invalid Move
            while (userMove > 4 || userMove < 1) {
                System.out.println();
                System.out.println("Invalid. Try Again.");
                System.out.print("1 for Applaro\n" +
                        "2 for Svartrå\n" +
                        "3 for Tunholmen\n" +
                        "4 for Godafton\n" + "What's your move? > ");
                userMove = input.nextInt();
            }

            //Compare Moves
            System.out.println();
            System.out.println("The Computer chose "+moves[computerMove-1]);
            System.out.println("You chose "+moves[userMove-1]);

            if ((userMove == 1 && computerMove == 2) || (userMove == 1 && computerMove == 3)){
                System.out.println("You win this round");
                userScore++;
            } else if (userMove == 2 && computerMove == 3) {
                System.out.println("You win this round");
                userScore++;
            } else if (userMove == 3 && computerMove == 4) {
                System.out.println("You win this round");
                userScore++;
            } else if ((userMove == 4 && computerMove == 1) || (userMove == 4 && computerMove == 2)) {
                System.out.println("You win this round");
                userScore++;
            } else {
                System.out.println("You lose this round");
                computerScore++;
            }

            //Play Another Round?
            System.out.print("Would you like to play another round? (y/n): ");
            response = input.next();
            roundsPlayed++;
        }

        //End of Game (No & Invalid)
        if (response.length() <= 2 && (response.charAt(0) == 'n' || response.charAt(0) == 'N')){
            System.out.println();
            System.out.println("Thanks for playing!");
            System.out.println();
            System.out.println("Rounds Played: "+roundsPlayed);
            System.out.println("Your Score: "+userScore);
            System.out.println("Opponent Score: "+computerScore);
        } else {
            System.out.println();
            System.out.println("Invalid entry. Thanks for playing!");
            System.out.println();
            System.out.println("Rounds Played: "+roundsPlayed);
            System.out.println("Your Score: "+userScore);
            System.out.println("Opponent's Score: "+computerScore);
        }
    }

    public static void introduction(){
        System.out.println("Welcome to Havsta. This is a two-player game in which you try to best your opponent by choosing the winning move each round.\n" +
                "The available moves are Applaro, Svartrå, Tunholmen, and Godafton.\n\n" +
                "Applaro beats Svartrå and Tunholmen\n" +
                "Svartrå beats Tunholmen\n" +
                "Tunholmen beats Godafton\n" +
                "Godafton beats Applaro and Svartrå\n\n" +
                "The opponent wins the round in the case of a tie.\n");
    }




}
