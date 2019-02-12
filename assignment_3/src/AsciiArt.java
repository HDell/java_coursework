// Handell Desulme
// 2/11/2019
// Assignment 3. Draw a Pretty Picture
//
// This program prints to the console a three designs that can be scaled via changes to the SIZE constant.
//

/*
- Your program must use class constants (e.g., static final int SIZE=10) in place of any numeric constants (except for 0 and 1),
and in place of any character constants.

- Your program must use at least 3 nested loops.

- At least one of the three must be a doubly-nested loop (a for loop inside a for loop inside a for loop).
 */

import java.util.Scanner;

public class AsciiArt {

    public static final int SIZE = 4; //constant (used in designs + extra credit) - recommended range of values: size >= 2

    public static void main(String[] args){

        drawStarDesign(); //design 1 - meets specs

        drawBuilding(); //design 2 - more aesthetic, no nested for loop in doubly-nested for loop

        drawLinc(); //extra credit

    }

    //Design 1

    public static void drawStarDesign(){
        int lines = (SIZE*2)-1;

        for(int line = 1; line<=lines; line++){

            int distance = Math.abs(line-SIZE); //absolute value of line - size

            for(int i = 1; i<=distance; i++) { //doubly nested for-loop (1)
                if(4*distance==SIZE-1){
                    i = distance+1;
                    for(int j=1; j<=SIZE; j++) { //nested for-loop in doubly-nested for-loop (1)
                        System.out.print("<");
                    }
                }
                else if(4*distance>1){
                    for(int j=1; j<=SIZE; j++) { //doubly nested for-loop (2)
                        System.out.print("<");
                    }
                    System.out.print("  *****");
                }
                else{
                    for(int j=1; j<=SIZE; j++) { //doubly nested for-loop (3)
                        System.out.print("<");
                    }
                }
            }
            if(line==SIZE) {
                System.out.println("***");
            }
            else if(line<lines) {
                System.out.println();
            }
        }

        System.out.println();
        System.out.println();
    }

    //Design 2

    public static void drawBuilding(){

        drawBuildingTop();
        drawBuildingInner();
        drawBuildingBottom();

    }

    public static void drawBuildingTop() {

        for (int lines = 1; lines <= SIZE; lines++){
            for (int i = 1; i <= (SIZE*2+2); i++){
                if ((i <= (SIZE-(lines-1)))||(i > (SIZE+lines+1))) { //(1 <= 4-(0)) || ()
                    System.out.print(" ");
                } else{
                    System.out.print(".");
                }
            }
            System.out.println();
        }

        System.out.print("X");
        for (int i = 1; i <= SIZE*2; i++){
            System.out.print("-");
        }
        System.out.println("X");
    }

    public static void drawBuildingInner() {
        for (int lines = 1; lines <= SIZE*4; lines++){
            System.out.print("X");
            if (lines%2 != 0){
                // System.out.println("X::::::::X");
                for (int i = 1; i <= SIZE*2; i++){
                    System.out.print(":");
                }
            } else { //lines%2 == 0
                // System.out.println("X::o::o::X");
                for (int i = 1; i <= SIZE*2; i++){
                    if ((i < (SIZE) || i > (SIZE+1))&&((i > (SIZE-2) && i < (SIZE+3)) )) {
                        System.out.print("o");
                    } else {
                        System.out.print(":");
                    }
                }
            }
            System.out.println("X");
        }
    }

    public static void drawBuildingBottom() {
        System.out.print("X");
        for (int i = 1; i <= SIZE*2; i++){
            if (i == SIZE){
                System.out.print("[");
            } else if (i == SIZE+1) {
                System.out.print("]");
            } else {
                System.out.print(":");
            }
        }
        System.out.println("X");
    }

    //Extra Credit

    public static void drawLinc(){
        System.out.println();
        drawLot();
        System.out.println();
        drawStadium();
    }

    public static void drawLot() {

        for (int line = 0; line <= SIZE*SIZE; line++){
            if (line == 0) { //This could have been left out of an if-then. But by starting loop from 0, I can account for this case.
                System.out.print(" ");
                for (int i = 0; i <= ((SIZE*2)+(SIZE*2)); i++){
                    System.out.print("_");
                }
                System.out.println();
            } else {
                System.out.print("|");
                for (int i = 1; i <= SIZE * 2; i++) {
                    System.out.print("_");
                }
                System.out.print("|");
                for (int i = 1; i <= SIZE * 2; i++) {
                    System.out.print("_");
                }
                System.out.println("|");
            }
        }
    }

    public static void drawStadium() {
        drawStadiumTop();
        drawStadiumInner();
        drawStadiumBottom();
        System.out.println();
    }

    public static void drawStadiumTop() {

        System.out.print(" ");
        for (int i = 1; i <= (SIZE*4*2+2); i++){ //4*4*2+2 = 34 | 5*4*2+2 = 42
            System.out.print("_");
        }

        System.out.println();

        System.out.print("|");
        for (int i = 1; i <= (SIZE*4*2+2); i++){ //(4*4)+2+(4*4) = 34 | 5*4+2+5*4 = 42
            if ((i<=(SIZE*4)) || (i>(SIZE*4)+2)) { //4*4=16 & 4*4+2=18[/19]
                System.out.print(" ");
            } else {
                System.out.print("_");
            }
        }
        System.out.print("|");

        System.out.println();

        for (int lines = 1; lines <= 4; lines++){
            System.out.print("|");
            for (int i = 1; i <= (SIZE*4*2+2); i++) { //4*4*2+2 = 34 | 5*4*2+2 = 42
                if ((i<=(SIZE*4)-(lines*2)) || (i>(SIZE*4+2)+(lines*2))) { // = 4*4=16 - (1,2,3,4 * 2) = 14,12,10,8 & > 4*4+2=18 + (1,2,3,4 * 2) = 20,22,24,26
                    System.out.print(" ");
                } else if (i == (SIZE*4)-(lines*2)+1) {
                    System.out.print("_");
                } else if (i == (SIZE*4)-(lines*2)+2) {
                    System.out.print("/");
                } else if (i == (SIZE*4+2)+(lines*2)) {
                    System.out.print("_");
                } else if (i == (SIZE*4+1)+(lines*2)) {
                    System.out.print("\\");
                } else {
                    System.out.print(".");
                }
            }
            System.out.print("|");
            System.out.println();
        }

    }

    public static void drawStadiumInner(){

        for (int lines = 1; lines <= (((SIZE*4)-(4+4))/2); lines++){ //SIZE=4, 1-->4
            System.out.print("|");
            for (int i = 1; i <= (SIZE*4*2+2); i++) { //4*4*2+2 = 34
                // spaces (4, decreasing)
                if ((i<=(SIZE*4)-((lines+4)*2)) || (i>(SIZE*4+2)+((lines+4)*2))) {
                    System.out.print(" ");
                } else if (i == (SIZE*4)-((lines+4)*2)+1) {
                    System.out.print("_");
                } else if (i == (SIZE*4)-((lines+4)*2)+2) {
                    System.out.print("/");
                } else if (i == (SIZE*4+2)+((lines+4)*2)) {
                    System.out.print("_");
                } else if (i == (SIZE*4+1)+((lines+4)*2)) {
                    System.out.print("\\");
                } else if (i > ((SIZE*4)+(1-4)) && (i <= ((SIZE*4)+(1-4)+(4+4)))) {
                    System.out.print("*");
                } else {
                    System.out.print(".");
                }
            }
            System.out.print("|");
            System.out.println();
        }

        for (int lines = 1; lines <= (((SIZE*4)-(4+4))/2); lines++){ //SIZE=4, 1-->4
            System.out.print("|");
            for (int i = 1; i <= (SIZE * 4 * 2 + 2); i++) { //4*4*2+2 = 34
                if ((i <= ((2 *(lines - 1))+1)) || (i > ((SIZE * 4 * 2 + 2)-((2 *(lines - 1))+1)))) { //4*4=16 & 4*4+2=18[/19]
                    System.out.print(" ");
                } else if (i == ((2 *(lines - 1))+1) + 1) { //(4*4)=16 - (4*2)+1=9
                    System.out.print("\\");
                } else if (i == ((2 *(lines - 1))+1) + 2) {
                    System.out.print("_");
                } else if (i == ((SIZE * 4 * 2 + 2)-((2 *(lines - 1))+2))) {
                    System.out.print("_");
                } else if (i == ((SIZE * 4 * 2 + 2)-((2 *(lines - 1))+1))) {
                    System.out.print("/");
                } else if (i > ((SIZE*4)+(1-4)) && (i <= ((SIZE*4)+(1-4)+(4+4)))) {
                    System.out.print("*");
                } else {
                    System.out.print(".");
                }
            }
            System.out.print("|");
            System.out.println();
        }

    }

    public static void drawStadiumBottom() {
        for (int lines = 4; lines >= 1; lines--) {
            System.out.print("|");
            for (int i = 1; i <= (SIZE * 4 * 2 + 2); i++) { //4*4*2+2 = 34 | 5*4*2+2 = 42
                if ((i <= (((SIZE * 4) - (lines * 2)) + 1)) || (i > (SIZE * 4 + 2) + (lines * 2) - 1)) { //4*4=16 & 4*4+2=18[/19]
                    System.out.print(" ");
                } else if (i == (((SIZE * 4) - (lines * 2)) + 2)) { //(4*4)=16 - (4*2)+1=9
                    System.out.print("\\");
                } else if (i == (((SIZE * 4) - (lines * 2)) + 3)) {
                    System.out.print("_");
                } else if (i == ((SIZE * 4 + 1) + (lines * 2))) {
                    System.out.print("/");
                } else if (i == ((SIZE * 4) + (lines * 2))) {
                    System.out.print("_");
                } else {
                    System.out.print(".");
                }
            }
            System.out.print("|");
            System.out.println();
        }

        System.out.print("|");
        for (int i = 1; i <= (SIZE * 4 * 2 + 2); i++) { //(4*4)+2+(4*4) = 34 | 5*4+2+5*4 = 42
            System.out.print("_");
        }
        System.out.print("|");
    }
}

