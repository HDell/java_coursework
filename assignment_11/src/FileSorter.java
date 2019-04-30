import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class FileSorter {

    public static void main(String args[]) throws FileNotFoundException {
        //Phase 1

            //Initializations
        File input = new File("Aesop_Fables");
        Scanner reader = new Scanner(input);
        int numLines = 0; // 3354
        int lineSections; // 167
        int counter = 0;
        int fileNum1 = 0;
        String outputFileName1 = "temp_0_"; //to add: "0.txt" -> fileNum1+".txt"

            //Getting Number of lines
        while (reader.hasNextLine()) {
            String current = reader.nextLine();
            if (current.length()>0) {
                numLines ++;
            }
        }
        lineSections = numLines/20; // 167
        int numFiles = (int)Math.ceil((double)numLines/lineSections);
        File[] fileList = new File[numFiles];

            //Chunking
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

        //Phase 2

        //Creating File List
        for (int i = 0; i<numFiles; i++) {
            fileList[i] = new File(outputFileName1+i+".txt");
        }
        mergeFiles(fileList);

    }

    //MergeSort Algorithm Methods

    public static File mergeFiles(File[] fileList) throws FileNotFoundException{

        //Base Case
        if (fileList.length==1) {
            return fileList[0];
        }

        //Creating Merged Files
        File[] mergedFileList;
        if (fileList.length%2==0) {
            mergedFileList = new File[fileList.length/2]; //10, if length=20
        } else { //fileList.length%2==1
            mergedFileList = new File[fileList.length/2+1]; //11, if length=21
            mergedFileList[fileList.length/2] = new File(generateName(fileList[fileList.length-1])); //10: 20

            PrintStream outfile = new PrintStream(mergedFileList[fileList.length/2]);
            Scanner reader = new Scanner(fileList[fileList.length-1]);
            while (reader.hasNextLine()) {
                String current = reader.nextLine();
                outfile.println(current);
            }
        }
        for (int i = 0, j = 0; i<fileList.length/2; i++, j+=2) {
            mergedFileList[i] = new File(generateName(fileList[j], fileList[j+1])); //0: 0,1; 1: 2,3; ...; 9: 18,19
        }

        //Populating/Writing to Merged Files
        for (int i = 0, j = 0; i<fileList.length/2; i++, j+=2) {
            merge(fileList[j], fileList[j+1], mergedFileList[i]);
        }

        return mergeFiles(mergedFileList);
    };

    public static File merge(File leftFile, File rightFile, File mergedFile) throws FileNotFoundException {
        //Initializing
        PrintStream outfile = new PrintStream(mergedFile);
        Scanner leftScanner = new Scanner(leftFile), rightScanner = new Scanner(rightFile);
        int leftLength = 0, rightLength = 0; //167, 167
        int leftCounter = 0, rightCounter = 0;

        //Populating
        while (leftScanner.hasNextLine()) {
            String current = leftScanner.nextLine();
            if (current.length()>0) {
                leftLength ++;
            }
        }
        while (rightScanner.hasNextLine()) {
            String current = rightScanner.nextLine();
            if (current.length()>0) {
                rightLength ++;
            }
        }
        String[] leftStrings = new String[leftLength];
        String[] rightStrings = new String[rightLength];
        leftScanner = new Scanner(leftFile);
        rightScanner = new Scanner(rightFile);
        while (leftScanner.hasNextLine()) {
            String current = leftScanner.nextLine();
            leftStrings[leftCounter] = current;
            leftCounter++;
        }
        while (rightScanner.hasNextLine()) {
            String current = rightScanner.nextLine();
            rightStrings[rightCounter] = current;
            rightCounter++;
        }

        //Merging/Writing
        leftCounter = 0;
        rightCounter = 0;
        while (leftCounter<leftLength && rightCounter<rightLength) {
            if (leftStrings[leftCounter].compareTo(rightStrings[rightCounter])<=0) { //left<=right
                outfile.println(leftStrings[leftCounter]);
                leftCounter++;
            } else { //left>right
                outfile.println(rightStrings[rightCounter]);
                rightCounter++;
            }
        }
        while(leftCounter<leftLength) {
            outfile.println(leftStrings[leftCounter]);
            leftCounter++;
        }
        while(rightCounter<rightLength) {
            outfile.println(rightStrings[rightCounter]);
            rightCounter++;
        }

        return mergedFile;
    }

    //File Name Generation Methods

    public static String generateName(File first, File second) {
        String firstName = first.getName();
        String secondName = second.getName();
        String finalName = "temp_";

        finalName += generateNum1(firstName)+"_"+generateNum2(firstName, secondName)+".txt";

        return finalName;
    }

    public static String generateName(File fileName) {
        String name = fileName.getName();
        return "temp_"+generateNum1(name)+"_"+extract2ndIntFromTempString(name)/2+".txt";
    }

    public static int generateNum1(String name) {
        int nameInt;

        //Extract
        nameInt = extract1stIntFromTempString(name);

        return (nameInt+1);
    }

    public static int generateNum2(String firstName, String secondName) {
        int firstInt, secondInt;

        //Extract
        firstInt = extract2ndIntFromTempString(firstName);
        secondInt = extract2ndIntFromTempString(secondName);

        return ((firstInt+secondInt)/4);
    }

    public static int extract1stIntFromTempString(String name) {
        int startIndex = name.indexOf("_");
        int endIndex = name.lastIndexOf("_");
        String splicedName = name.substring(startIndex+1,endIndex);
        return Integer.parseInt(splicedName);
    }

    public static int extract2ndIntFromTempString(String name) {
        int startIndex = name.lastIndexOf("_");
        int endIndex = name.indexOf(".txt");
        String splicedName = name.substring(startIndex+1,endIndex);
        return Integer.parseInt(splicedName);
    }

}
