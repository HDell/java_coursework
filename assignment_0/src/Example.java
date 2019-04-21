import java.util.InputMismatchException;
import java.util.Scanner;

public class Example {

    public static void main(String args[]) {
        int highest=-2147483648, lowest=2147483647, entered, total=0, count=0; //lowest & highest possible int values in java
        double average;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter an exam score (0 or below to quit): ");
        try {
            entered = input.nextInt();
            while (entered>0) {
                count++;
                total+=entered;
                if (count==1) {
                    highest=entered;
                    lowest=entered;
                } else {
                    if (entered>highest) {
                        highest=entered;
                    }
                    if (entered<lowest) {
                        lowest=entered;
                    }
                }
                System.out.print("Enter an exam score (0 or below to quit): ");
                entered = input.nextInt();
            }
            if (count>0) {
                average = (double)total/count;
                System.out.println("Highest Score: "+highest);
                System.out.println("Lowest Score: "+lowest);
                System.out.println("Average Score: "+average);
            } else {
                System.out.println("No Scores");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid entry");
            if (count>0) {
                average = total/(double)count;
                System.out.println("Highest Score: "+highest);
                System.out.println("Lowest Score: "+lowest);
                System.out.println("Average Score: "+average);
            } else {
                System.out.println("No Scores");
            }
        }
    }

}
