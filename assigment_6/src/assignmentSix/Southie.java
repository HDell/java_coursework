package assignmentSix;

// Handell Desulme
// 3/15/2019
// Assignment 6. A Southie Styles
//
// This program reads from a text source, converts dialogue to a predetermined accent/style, and outputs it to an output file.

public class Southie {

    public static void main(String args[]){
        System.out.println("I left my car keys by the harbor");
        System.out.println(replaceRsAfterVowels("I left my car keys by the harbor"));
        System.out.println("tuna");
        System.out.println(appendRsToSuffixAs("a ballerina"));
        System.out.println(veryToWicked("very"));
        System.out.println(veryToWicked("Very"));
        System.out.println(veryToWicked("VERY"));

        System.out.println(appendAhsToSuffixRs("deEr"));
        System.out.println(appendAhsToSuffixRs("siR"));
        System.out.println(appendAhsToSuffixRs("deers"));
        System.out.println(appendAhsToSuffixRs("sirs"));
        System.out.println(appendAhsToSuffixRs("doOr"));
        System.out.println(appendAhsToSuffixRs("doors"));
    }

    public static int indexOfFirstVowel(String input) {
        String vowels = "aeiou";
        for (int i = 0; i < input.length(); i++){
            for (int j = 0; j < vowels.length(); j++) {
                if (input.charAt(i) == vowels.toUpperCase().charAt(j) || input.charAt(i) == vowels.toLowerCase().charAt(j)) {
                    return input.indexOf(input.charAt(i));
                }
            }
        }
        return -1;
    }

    public static int indexOfFirstVowel(String input, int startPosition) {
        String vowels = "aeiou";
        for (int i = startPosition; i < input.length(); i++){
            for (int j = 0; j < vowels.length(); j++) {
                if (input.charAt(i) == vowels.toUpperCase().charAt(j) || input.charAt(i) == vowels.toLowerCase().charAt(j)) {
                    return input.length() - input.substring(i).length();
                }
            }
        }
        return -1;
    }

    public static String replaceRsAfterVowels(String input){

        String output = "";

        //Look at every character, and concatenate it into the output string.
        for (int i = 0; i < input.length(); i++) {
            if ((indexOfFirstVowel(input.substring(i)) == input.substring(i).indexOf(input.charAt(i)))) { //Search for vowels
                output += input.charAt(i); //Copy the vowel to the output string.
                //has r next
                try {
                    if (input.substring(i).charAt(1) == 'r') { //Do a hasNextCharacter check for lowercase r's
                        output += "h"; //lowercase h
                        i++; //forces the r to be skipped
                    } else if (input.substring(i).charAt(1) == 'R') { //Do a hasNextCharacter check for uppercase R's
                        output += "H"; //uppercase H
                        i++; //forces the R to be skipped
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("does not have an r next");
                }
            } else { //preserve non-vowel input
                output += input.charAt(i);
            }
        }

        //Preserve capitalization. Preserve spacing.

        return output;
    }

    public static String appendRsToSuffixAs(String input){

        String letterA = "a";
        String output = "";

        if (input.length()>1) {
            if (input.toLowerCase().charAt(input.length()-1)==letterA.toLowerCase().charAt(0)){
                for (int i = 0; i < input.length(); i++) {
                    output += input.charAt(i);
                }
                output+="r";
            }
            return output;
        }

        return input;
    }

    public static String veryToWicked(String input){

        String allCaps = "VERY";

        if (input.toLowerCase().equals("very")) {
            if (input.equals(allCaps)) {
                return "WICKED";
            } else if (input.charAt(0)==allCaps.charAt(0)) {
                return "Wicked";
            } else {
                return "wicked";
            }
        }
        return input;
    }

    public static String appendAhsToSuffixRs(String input){

        String letterR = "r";
        String output = "";

        if ((input.length()>3&&input.toLowerCase().substring(input.length()-3).equals("eer"))||(input.length()>2&&input.toLowerCase().substring(input.length()-2).equals("ir"))) {
            if (input.toLowerCase().charAt(input.length()-1)==letterR.toLowerCase().charAt(0)){
                for (int i = 0; i < input.length()-1; i++) {
                    output += input.charAt(i);
                }
                if (input.charAt(input.length()-1)==letterR.toUpperCase().charAt(0)) {
                    output+="YAH";
                } else {
                    output += "yah";
                }
            }
            return output;
        } else if ((input.length()>3&&input.toLowerCase().substring(input.length()-3).equals("oor"))) {
            if (input.toLowerCase().charAt(input.length()-1)==letterR.toLowerCase().charAt(0)){
                for (int i = 0; i < input.length()-1; i++) {
                    output += input.charAt(i);
                }
                if (input.charAt(input.length()-1)==letterR.toUpperCase().charAt(0)) {
                    output+="WAH";
                } else {
                    output += "wah";
                }
            }
            return output;
        }

        return input;
    }

    String randomText = "This is a random string that I am going to play with to test the Southie Style string rules.";

    /*
//Read from Scanner + File and output to File w/ PrintStream
//Preserve spacing
//Edit quotes only
     */

}
