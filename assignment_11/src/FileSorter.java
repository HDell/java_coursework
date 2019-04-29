import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class FileSorter {

    public static void main(String args[]) throws FileNotFoundException {
        File input = new File("Aesop_Fables");
        Scanner reader = new Scanner(input);
        int numLines = 0; // 3354
        int lineSections; // 167
        int counter = 0;
        int fileNum1 = 0;
        String outputFileName1 = "temp_0_"; //to add: "0.txt" -> fileNum1+".txt"

        while (reader.hasNextLine()) {
            String current = reader.nextLine();
            if (current.length()>0) {
                numLines += 1;
            }
        }
        lineSections = numLines/20; // 167

        reader = new Scanner(input);

        String[] inputChunk = new String[lineSections];
        while (reader.hasNextLine()) {
            String current = reader.nextLine();
            if (current.length()>0) {
                inputChunk[counter] = current; //0-166
                counter++; //1-167
            }
            if (fileNum1==20) {
                String[] inputChunk2 = new String[counter];
                PrintStream outfile = new PrintStream(new File(outputFileName1+fileNum1+".txt")); //"temp_0_"+"20"+".txt" = "temp_0_20.txt"
                for (int i=0; i<counter; i++) {
                    inputChunk2[i] = inputChunk[i];
                }
                Arrays.sort(inputChunk2);
                for (int i=0; i<inputChunk2.length; i++) {
                    outfile.println(inputChunk2[i]);
                }
            }
            if (counter==lineSections) {
                counter=0;
                Arrays.sort(inputChunk);
                PrintStream outfile = new PrintStream(new File(outputFileName1+fileNum1+".txt")); //"temp_0_"+"0"+".txt" = "temp_0_0.txt"
                fileNum1++;

                for (int i=0; i<inputChunk.length; i++) {
                    outfile.println(inputChunk[i]);
                }
            }
        }


    }

}
