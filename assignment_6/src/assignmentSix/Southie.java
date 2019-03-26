package assignmentSix;

// Handell Desulme
// 3/15/2019
// Assignment 6. A Southie Styles
//
// This program reads from a text source, converts dialogue to a predetermined accent/style, and outputs it to an output file.

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Southie {

    //Dialogue Checking fields
    static final String openQuote = "“";
    static final String closeQuote = "”";
    static final String openParen = "(";
    static final String closeParen = ")";

    //State tracking Fields
    static boolean betweenQuotes = false;

    public static void main(String args[]) throws FileNotFoundException{

//        System.out.println(trimTrailingNonLetters("ammunitiona:”"));
//        System.out.println(trimStartingLetters("ammunitiona:”"));
//        System.out.println(transformToken("Recalled--!"));
//        System.out.println();


//        southifyDialogue(new Scanner(new File("A_Tale_of_Two_Cities-Text.txt")), new PrintStream(new File("A_Tale_of_Southern_Style.txt")));
        southifyDialogue(new Scanner(new File("test.txt")), new PrintStream(new File("A_Tale_of_Southern_Style.txt"))); //sanity check
    }
    





    public static void southifyDialogue(Scanner input, PrintStream output) throws FileNotFoundException {

        //Line Manipulation Fields
        String transformedToken = "";
        String lineToken = "";

        //State tracking Fields
        boolean checkNextLine = false;
        boolean hasLineToken = false;

        while (input.hasNextLine()) { //while the story has a next line
            String currentLine = input.nextLine(); //take the current line
            Scanner currentLineInput = new Scanner(currentLine); //(make the current line readable)
            //make into method
            printText(currentLineInput, currentLine);
            //System.out.println(currentLine); //sanity check
//            System.out.println(); //sanity check

//            while (currentLineInput.hasNext()) {
//                String currentToken = currentLineInput.next();
//                System.out.print(currentToken);
//                if (!currentLineInput.hasNext()) {
//                    System.out.println();
//                    continue;
//                }
//                try {
//                    currentToken = currentLineInput.nextLine();
//                    System.out.println(currentToken);
//                } catch (NoSuchElementException e) {
//                    ;
//                }
//            }

//            String currentLine = input.nextLine();
//            Scanner currentLineInput = new Scanner(currentLine).useDelimiter("'");
//            Scanner quoteLineInput = new Scanner(currentLine);
//
//            if (quoteLineInput.hasNext()) { //preserves line spacing
//                while (quoteLineInput.hasNext()) {
//                    transformedToken = "";
//                    String currentToken = quoteLineInput.next();
//                    //Dialogue
//                    try {
//                        if (startOfDialogue(currentToken)) { //If beginning of dialogue
//                            betweenQuotes = true;
//                            transformedToken = transformToken(currentToken);
//                            output.print(transformedToken + " "); //first token w/ open quote
//                            try {
//                                if (endOfDialogue(currentToken)) {
//                                    betweenQuotes = false;
//                                }
//                                currentToken = quoteLineInput.next(); //why the try-catch exists
//                                if (endOfDialogue(currentToken)) {
//                                    betweenQuotes = false;
//                                }
//                            } catch (NoSuchElementException e) {
//                                checkNextLine = true; //move to the next line
//                                if (endOfDialogue(currentToken)) {
//                                    betweenQuotes = false;
//                                }
//                            }
//                            while (quoteLineInput.hasNext()) {
//                                //while the dialogue is not at the end
//
//                                if (currentToken.charAt(0) == openQuote.charAt(0)) { //If at start of new dialogue
//                                    betweenQuotes = true;
//                                }
//                                if (betweenQuotes) {
//                                    transformedToken = transformToken(currentToken);
//                                    output.print(transformedToken + " "); //print inner dialogue text
//                                    currentToken = quoteLineInput.next(); //move to next token
//                                    if (!quoteLineInput.hasNext() && !(currentToken.charAt(currentToken.length() - 1) == closeQuote.charAt(0))) {
//                                        //if the dialogue is at the end of the line BUT[and] not the close quotes
//                                        checkNextLine = true;
//                                    } else if (endOfDialogue(currentToken)) {
//                                        //if the dialogue IS at the close quotes
//                                        checkNextLine = false;
//                                        betweenQuotes = false;
//                                        if (quoteLineInput.hasNext()) {
//                                            transformedToken = transformToken(currentToken);
//                                            output.print(transformedToken + " "); //print inner dialogue text
//                                            currentToken = quoteLineInput.next();
//                                        }
//                                    }
//                                } else {
//                                    //while the dialogue is not at the end
//                                    output.print(currentToken + " "); //print inner dialogue text
//                                    currentToken = quoteLineInput.next(); //move to next token
//                                }
//                            }
//                            if (betweenQuotes) {
//                                transformedToken = transformToken(currentToken);
//                                output.println(transformedToken); //will be called when dialogue IS at the ending
//                            } else {
//                                output.println(currentToken);
//                            }
//                        } else {
//                            if (!checkNextLine) {
//                                if (endOfDialogue(currentToken)) {
//                                    betweenQuotes = false;
//                                }
//                                if (quoteLineInput.hasNext()) {
//                                    output.print(currentToken + " ");
//                                } else {
//                                    output.println(currentToken);
//                                }
//                            }
//                        }
//                        if (!quoteLineInput.hasNext() && !(currentToken.charAt(currentToken.length() - 1) == closeQuote.charAt(0)) && !((currentToken.charAt(currentToken.length() - 1) == closeParen.charAt(0) && currentToken.charAt(currentToken.length() - 2) == closeQuote.charAt(0)))) {
//                            continue;
//                        }
//                        if (checkNextLine) {
//                            if (quoteLineInput.hasNext()) {
//                                transformedToken = transformToken(currentToken);
//                                output.print(transformedToken + " "); //first token - called if it isn't the only token in the line
//                            }
//                            try {
//                                if (currentToken.charAt(currentToken.length() - 1) == closeQuote.charAt(0)) {
//                                    betweenQuotes = false;
//                                }
//                                currentToken = quoteLineInput.next();
//                                if (currentToken.charAt(currentToken.length() - 1) == closeQuote.charAt(0)) {
//                                    betweenQuotes = false;
//                                }
//                            } catch (NoSuchElementException e) {
//                                checkNextLine = true; //move to the next line
//                                if (endOfDialogue(currentToken)) {
//                                    betweenQuotes = false;
//                                }
//                            }
//                            while (quoteLineInput.hasNext()) {
//                                if (currentToken.charAt(0) == openQuote.charAt(0)) { //If at start of new dialogue
//                                    betweenQuotes = true;
//                                }
//                                if (betweenQuotes) {
//                                    //while the dialogue HAS next & IS NOT at the ending (close quotes)
//                                    transformedToken = transformToken(currentToken);
//                                    output.print(transformedToken + " "); //print inner dialogue text
//                                    currentToken = quoteLineInput.next(); //move to next token
//                                    if (!quoteLineInput.hasNext() && !(currentToken.charAt(currentToken.length() - 1) == closeQuote.charAt(0))) {
//                                        //if the dialogue is at the end of the line BUT[and] not the close quotes
//                                        checkNextLine = true;
//                                    } else if (endOfDialogue(currentToken)) {
//                                        //if the dialogue IS at the close quotes
//                                        checkNextLine = false;
//                                        betweenQuotes = false;
//                                        if (quoteLineInput.hasNext()) {
//                                            transformedToken = transformToken(currentToken);
//                                            output.print(transformedToken + " "); //print inner dialogue text
//                                            currentToken = quoteLineInput.next();
//                                        }
//                                    }
//                                } else {
//                                    //while the dialogue HAS next & IS NOT at the ending (close quotes)
//                                    output.print(currentToken + " "); //print inner dialogue text
//                                    currentToken = quoteLineInput.next(); //move to next token
//                                }
//                            }
//                            if (betweenQuotes) {
//                                transformedToken = transformToken(currentToken);
//                                output.println(transformedToken); //will be called when dialogue IS at the ending
//                            } else {
//                                output.println(currentToken);
//                            }
//                        }
//                    } catch (StringIndexOutOfBoundsException e) {
//                        output.println();
//                    }
//                }
//            } else {
//                output.println(); //preserves line spacing
//            }
//            //if (currentLineInput.hasNext()) {
//            //  lineToken = currentLineInput.next();
//            //if (!(lineToken.charAt(0) == openQuote.charAt(0)||(lineToken.charAt(0) == openParen.charAt(0)&&lineToken.charAt(1) == openQuote.charAt(0))||betweenQuotes||lineToken.contains(openQuote)||lineToken.contains(closeQuote)||(lineToken.charAt(lineToken.length() - 1) == closeQuote.charAt(0)))) {
//            //  output.println(lineToken);
//            //}
//            //}
//
//            //Prints story as it currently exists (preserving whitespace)
//            //output.print(currentLine);
//            //output.println();
//
        }
    }

    public static void printText(Scanner currentLineInput, String currentLine) {
        //
        String dialogueString;
        String nonDialogueString;

        if (hasOpeningQuote(currentLineInput)) { //Check if the current line has an opening quote in it [[currentLineInput vs. new Scanner(currentLine)]]
            // if it does, //check if it also has closing quotes
            Scanner secondLineInput = new Scanner(currentLine); //a duplicate of the currentLineInput, to be used in the secondLineInput line input loop
            int tokenCount = 0;
            int startCounts = 0;
            System.out.println();
            System.out.println("Current Line:"+currentLine);
            while (secondLineInput.hasNext()) {
                //Scanner thirdLineInput = new Scanner(currentLine); //a duplicate of the currentLineInput, to be used in the thirdLineInput line input loop (tTCQ function)
                String currentToken = secondLineInput.next();
                //System.out.println(currentToken); //sanity check
                //Dialogue
                try {
                    if (startOfDialogue(currentToken)) { //check if the buffer is at the beginning of dialogue
                        hasOpeningQuote(new Scanner(currentToken));
                        tokenCount++;
                        startCounts++;
                        try { //work with the secondLineInput token for the dialogue String
                            dialogueString = "";
                            dialogueString += currentToken; //set the dialogue string to the opening quote token

                            //sanity checks
//                            System.out.println("current line: "+currentLine);
//                            System.out.println("dialogue string: "+dialogueString);
//                            if(hasClosingQuote(currentLineInput)) {
//                                System.out.println("has closing. Count: "+startCounts);
//                                String trimmedLine = "";
//                                trimmedLine += currentLine;
                                //System.out.println(trimmedLine);
                                //int numOccurrences =numOccurrencesInString(trimmedLine,dialogueString);
                                //System.out.println(numOccurrences);
//                                trimmedLine = trimLine(currentLine, dialogueString, startCounts);
//                                System.out.println("concatted line: "+dialogueString+trimmedLine);
//                            } else {
//                                System.out.println("does not have closing. Count: "+startCounts);
//                                System.out.println("\tbefore: "+dialogueString);
//                                if (secondLineInput.hasNext()) {
//                                    dialogueString += secondLineInput.nextLine();
//                                }
//                                System.out.println("\tafter: "+dialogueString);
//                                hasClosingQuote(new Scanner(dialogueString));
//                                System.out.print(betweenQuotes+"|");
//                                System.out.println(dialogueString);
//                            }
                            //sanity check complete

                            if (hasClosingQuote(currentLineInput)) { //Check if the current line also has a closing quote in it [[currentLineInput vs. new Scanner(currentLine)]]
                                String trimmedLine; //if it does, make a line that excludes the open quote token
                                //trimmedLine += currentLine;
                                int numOccurrences =numOccurrencesInString(currentLine,dialogueString);
                                trimmedLine = trimLine(currentLine, dialogueString, startCounts); //trims the trimmed line properly
                                String recurringDialogueString = dialogueString + textToClosingQuote(new Scanner(trimmedLine)); //combine the opening quote up until the closing quote
                                hasClosingQuote(new Scanner(recurringDialogueString));
                                if (numOccurrences==1) {
                                    System.out.print(betweenQuotes+"|");
                                    System.out.println(recurringDialogueString);
                                } else {
                                    //recursion from trimmed string
                                    System.out.println("   Dialogue:"+dialogueString);
                                    System.out.println("   Trimmed:"+textToClosingQuote(new Scanner(trimmedLine)));

                                    System.out.print(betweenQuotes+"||");
                                    System.out.println(recurringDialogueString);
                                }
                            } else { //No closing quote
                                if (secondLineInput.hasNext()) {
                                    dialogueString += secondLineInput.nextLine();
                                }
                                hasClosingQuote(new Scanner(dialogueString));
                                System.out.print(betweenQuotes+"|\\");
                                System.out.println(dialogueString);
                            }

                        } catch (NoSuchElementException e) {
                            dialogueString = currentToken;
                        }
                    } else { //(currentToken) IS NOT at startOfDialogue(currentToken)

                        ///WHERE I AM CURRENTLY
                        ///WHERE I AM CURRENTLY
                        ///WHERE I AM CURRENTLY

                        tokenCount++;

                        nonDialogueString = "";
                        nonDialogueString += currentToken;
                        String remainingLine = textIndexToClose(new Scanner(currentLine), tokenCount);
                        if (hasOpeningQuote(new Scanner(remainingLine))) {
                            //String betweenDialogueString = textToOpeningQuote(new Scanner(remainingLine));
                            //System.out.println("BETWEEN:"+currentToken+betweenDialogueString);
                            //break;
                        } else if (hasClosingQuote(new Scanner(remainingLine))) {
                            ;//Do nothing
                        } else if (secondLineInput.hasNext()) {
                            System.out.println("REMAINING LINE:" + remainingLine);
                            break;
                        }


                        //String remainingLine;
                        //remainingLine = trimLine(currentLine, currentToken, 1); //trims the trimmed line properly

                        //work with the text for the non-dialogue String(s)
                        //if(betweenQuotes) {
                            //hasClosingQuote(new Scanner(currentToken));
                            //System.out.print(betweenQuotes + "\\" + currentToken+" ");
                        //} else if (hasClosingQuote(new Scanner(currentToken))) { //and there is another opening quote in what remains
                            //System.out.println();
                            //Print up to the next quote
                            //System.out.println(currentToken+":end:"+betweenQuotes+":"+secondLineInput.nextLine()+":"+betweenQuotes);
                            //System.out.println();
                        //} else {
                        //    System.out.print(betweenQuotes + "\\" + currentToken+" ");
                        //    System.out.println();
                        //}

                    }
                } catch (StringIndexOutOfBoundsException e) {
                    ;
                }
            }
            if (hasClosingQuote(new Scanner(currentLine))) {

            }
        } else { //Non-dialogue lines.
            if (hasClosingQuote(currentLineInput)) { //If the current line has no opening quote in it but does have a closing quote in it
                ;
            }
            //System.out.println(currentLine);
        }
    }

    public static String trimLine (String originalString, String dialogueString, int index) {
        int innerIndex = originalString.indexOf(dialogueString, originalString.indexOf(dialogueString) + 1);
        String indexOneString = originalString.substring(originalString.indexOf(dialogueString) + dialogueString.length()); //trims the trimmed line properly
        if (index==1) {
            return indexOneString;
        } else {
            return trimLine(indexOneString, dialogueString, index-1);
        }
    }

    public static boolean startOfDialogue(String currentToken) {
        return currentToken.charAt(0) == openQuote.charAt(0) || (currentToken.charAt(0) == openParen.charAt(0) && currentToken.charAt(1) == openQuote.charAt(0));
    }

    public static boolean endOfDialogue(String currentToken) {
        return currentToken.charAt(currentToken.length() - 1) == closeQuote.charAt(0) || (currentToken.charAt(currentToken.length() - 1) == closeParen.charAt(0) && currentToken.charAt(currentToken.length() - 2) == closeQuote.charAt(0));
    }

    public static boolean hasOpeningQuote(Scanner inputLine) {
        while (inputLine.hasNext()) {
            String currentToken = inputLine.next();
            //Dialogue
            try {
                if (startOfDialogue(currentToken)) { //if beginning of dialogue exists
                        betweenQuotes = true;
                    if (endOfDialogue(currentToken)) {
                        betweenQuotes = false;
                    }
                    return true;
                }
            } catch (StringIndexOutOfBoundsException e) {
                ;
            }
        }
        return false;
    }

    public static boolean hasClosingQuote(Scanner inputLine) {
        while (inputLine.hasNext()) {
            String currentToken = inputLine.next();
            //Dialogue
            try {
                if (endOfDialogue(currentToken)) {
                    betweenQuotes = false;
                    return true;
                }
            } catch (StringIndexOutOfBoundsException e) {
                ;
            }
        }
        return false;
    }

    public static String textToClosingQuote(Scanner inputLine) {
        String outputLine = "";
        while (inputLine.hasNext()) {
            String currentToken = inputLine.next();
            //Closed Dialogue
            try {
                if (endOfDialogue(currentToken)) {
                    outputLine += " " + currentToken;
                    return outputLine;
                } else {
                    outputLine += " " + currentToken;
                }
            } catch (NoSuchElementException e) {
                ;
            }
        }
        return outputLine;
    }

    public static String textIndexToClose(Scanner inputLine, int index) {
        String outputLine = "";
        for (int i = 1; i <= index; i++) {
            try {
                inputLine.next();
            } catch (NoSuchElementException e) {
                ;
            }
        }
        while (inputLine.hasNext()) {
            String currentToken = inputLine.next();
            if (inputLine.hasNext()) {
                outputLine += currentToken + " ";
            } else {
                outputLine += currentToken;
            }
        }
        return outputLine;
    }

    public static String textToOpeningQuote(Scanner inputLine) {
        String outputLine = "";
        while (inputLine.hasNext()) {
            String currentToken = inputLine.next();
            //Closed Dialogue
            try {
                if (startOfDialogue(currentToken)) {
                    outputLine += " " + currentToken;
                    return outputLine;
                } else {
                    outputLine += " " + currentToken;
                }
            } catch (NoSuchElementException e) {
                ;
            }
        }
        return outputLine;
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

        String trimmedInput = trimTrailingNonLetters(input);
        String nonLetters = trimStartingLetters(input);
        String output = "";

        String dash = "-";
        int dashIndex = 0;

        boolean hasDash = false;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i)==dash.charAt(0)) {
                if (!(input.contains("--"))) {
                    hasDash = true;
                }
                dashIndex = i;
            }
        }

        if (hasDash) {
            String dashedInput = input.substring(0,dashIndex);
            String secondHalfInput = input.substring(dashIndex);
            output = transformToken(dashedInput);
            output += transformToken(secondHalfInput);
        }

        //Look at every character, and concatenate it into the output string.
        if (!hasDash) {
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
                        ;
                    }
                } else { //preserve non-vowel input
                    output += input.charAt(i);
                }
            }
        }

        //Preserve capitalization. Preserve spacing.

        return output;
    }

    public static String appendRsToSuffixAs(String input){

        String trimmedInput = trimTrailingNonLetters(input);
        String nonLetters = trimStartingLetters(input);

        String letterA = "a";
        String output = "";

        if (trimmedInput.length()>1) {
            if (trimmedInput.toLowerCase().charAt(trimmedInput.length()-1)==letterA.toLowerCase().charAt(0)){
                for (int i = 0; i < trimmedInput.length(); i++) {
                    output += trimmedInput.charAt(i);
                }
                output+="r";
                return output+nonLetters;
            }
        }

        return input;
    }

    public static String veryToWicked(String input){

        String trimmedInput = trimTrailingNonLetters(input);
        String nonLetters = trimStartingLetters(input);

        String allCaps = "VERY";

        if (trimmedInput.toLowerCase().equals("very")) {
            if (trimmedInput.equals(allCaps)) {
                return "WICKED"+nonLetters;
            } else if (trimmedInput.charAt(0)==allCaps.charAt(0)) {
                return "Wicked"+nonLetters;
            } else {
                return "wicked"+nonLetters;
            }
        }
        return input;
    }

    public static boolean checkIfAhApplies(String input) {

        String letterR = "r";

        if ((input.length()>3&&input.toLowerCase().substring(input.length()-3).equals("eer"))||(input.length()>2&&input.toLowerCase().substring(input.length()-2).equals("ir"))) {
            if (input.toLowerCase().charAt(input.length()-1)==letterR.toLowerCase().charAt(0)){
                return true;
            }
        } else if ((input.length()>3&&input.toLowerCase().substring(input.length()-3).equals("oor"))) {
            if (input.toLowerCase().charAt(input.length()-1)==letterR.toLowerCase().charAt(0)){
                return true;
            }
        }

        return false;
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

    public static String transformToken(String inputToken) {

        String transformedToken;
        String noOpenQuoteToken = "";
        String openQuote = "“";
        boolean hadQuote = false;

        try {
            if(inputToken.charAt(0)==openQuote.charAt(0)) {
                noOpenQuoteToken = inputToken.substring(1);
                hadQuote = true;
            } else {
                noOpenQuoteToken = inputToken;
            }
        } catch (StringIndexOutOfBoundsException e) {
            noOpenQuoteToken = inputToken;
        }

        if (checkIfAhApplies(noOpenQuoteToken)) {
            transformedToken = veryToWicked(noOpenQuoteToken);
            transformedToken = appendAhsToSuffixRs(transformedToken);
            transformedToken = replaceRsAfterVowels(transformedToken);
            transformedToken = appendRsToSuffixAs(transformedToken);
            if (hadQuote == true) {
                return ("“"+transformedToken);
            }
            return transformedToken;
        } else {
            transformedToken = veryToWicked(noOpenQuoteToken);
            transformedToken = replaceRsAfterVowels(transformedToken);
            transformedToken = appendRsToSuffixAs(transformedToken);
            if (hadQuote == true) {
                return ("“"+transformedToken);
            }
            return transformedToken;
        }

    }

    public static String trimTrailingNonLetters(String input) {
        //65-90 & 97-122
        if (input.charAt(input.length()-1)<65||(input.charAt(input.length()-1)>90&&input.charAt(input.length()-1)<97)||input.charAt(input.length()-1)>122) {
            return (trimTrailingNonLetters(input.substring(0,input.length()-1)));
        } else {
            return input;
        }
    }
    
    public static String trimStartingLetters(String input) {

        String openQuote = "“";
        String closeQuote = "”";

        //65-90 & 97-122
        if ((input.charAt(0)>=65&&input.charAt(0)<=90)||(input.charAt(0)>=97&&input.charAt(0)<=122)||input.charAt(0)==39||input.charAt(0)==96||input.charAt(0)==openQuote.charAt(0)) {
            try {
                return (trimStartingLetters(input.substring(1)));
            } catch (StringIndexOutOfBoundsException e) {
                return "";
            }
        } else {
            return input;
        }
    }

    public static int numOccurrencesInString (String parentString, String findString) {
        int last = 0;
        int occurrences = 0;

        while (last!=-1) {

            last = parentString.indexOf(findString, last);

            if (last != -1) {
                occurrences++;
                last += findString.length();
            }
        }
        return occurrences;
    }
    String randomText = "This is a random string that I am going to play with to test the Southie Style string rules.";

    /*
//Read from Scanner + File and output to File w/ PrintStream
//Preserve spacing
//Edit quotes only
//Test methods
     */

}
