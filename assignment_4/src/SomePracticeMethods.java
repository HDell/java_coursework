// Handell Desulme
// 2/17/2019
// Assignment 4. practice with static methods and strings
//
// This program contains multiple string algorithms in static methods to solve a variety of problems.
// NOTE: I made the last method case sensitive because of the example in the comment & there was no JUnit test to specify otherwise.

public class SomePracticeMethods {
    public static void main(String args[]){
        char c = 'M';
        String s = "soMething";
        String t = "pleemt";
        String no = "ooooo";
        String reverse = "Temple";
        String palindrome = "racecar";
        String h = "Mississippi";
        String n = "ss";
        String base = "lightbugning";
        String suffix = "bug";
        System.out.println(inTU(c)); //true
        System.out.println(indexOfFirstTULetter(s)); //2
        System.out.println(indexOfFirstTULetter("elephant", 2)); //2
        System.out.println(indexOfLastTULetter(s)); //4
        System.out.println(allTempleLetters(t)); //true
        System.out.println(noTempleLetters(no)); //true
        System.out.println(withoutTULetters(s)); //"sohing"
        System.out.println(reversed(reverse)); //"elpmeT"
        System.out.println(numOccurrences(h, n)); //2
        System.out.println(sameInReverse(palindrome)); //true
        System.out.println(appendIfMissing(base, suffix)); //"lightbugningbug"
    }

    /*
     * returns true if c is a letter in the word "temple" or false otherwise
     */
    public static boolean inTU(char c) {
        String temple = "temple";
        for (int i = 0; i < temple.length(); i++){
            if (c==temple.toUpperCase().charAt(i) || c==temple.toLowerCase().charAt(i)){
                return true;
            }
        }
        return false;
    }

    /*
     * returns the index of the first occurrence of in s
     * of a letter in the word "temple" or
     * -1 if s contains no letters in the word "temple"
     */
    public static int indexOfFirstTULetter(String s) {
        String temple = "temple";
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < temple.length(); j++){
                if (s.charAt(i)==temple.toUpperCase().charAt(j) || s.charAt(i)==temple.toLowerCase().charAt(j)) {
                    return s.indexOf(s.charAt(i));
                }
            }
        }
        return -1;
    }

    /*
     * returns the index of the first occurrence of a letter in "temple" in s starting
     * from index startPosition or -1 if there are none at index
     * startPosition or later. Notice that this method has the same name as the
     * previous one, but that it takes a different number of arguments. This is
     * perfectly legal in Java. It's called "method overloading"
     */
    public static int indexOfFirstTULetter(String s, int startPosition) {
        String temple = "temple";
        for (int i = startPosition; i < s.length(); i++){
            for (int j = 0; j < temple.length(); j++){
                if (s.charAt(i)==temple.toUpperCase().charAt(j) || s.charAt(i)==temple.toLowerCase().charAt(j)){
                    return s.length() - s.substring(i).length();
                }
            }
        }
        return -1;
    }

    /*
     * returns the index of the last occurrence of a letter in the word "temple"
     * in s or -1 if s
     * contains none
     */
    public static int indexOfLastTULetter(String s) {
        String temple = "temple";
        for (int i = s.length()-1; i >= 0; i--){
            for (int j = 0; j < temple.length(); j++){
                if (s.charAt(i)==temple.toUpperCase().charAt(j) || s.charAt(i)==temple.toLowerCase().charAt(j)){
                    return s.indexOf(s.charAt(i), i);
                }
            }
        }
        return -1;
    }

    /* returns true if every letter in s is a letter
     * in the word "temple" or false otherwise */
    public static boolean allTempleLetters(String s) {
        for (int i = 0; i < s.length(); i++){
            if (inTU(s.charAt(i))==false) {
                return false;
            }
        }
        return true;
    }

    /* returns true if no letter in s is a letter
     * in the word "temple" or false otherwise */
    public static boolean noTempleLetters(String s) {
        for (int i = 0; i < s.length(); i++){
            if (inTU(s.charAt(i))==true) {
                return false;
            }
        }
        return true;
    }

    /*
     * returns a new String which is the same as s, but with all of the letters
     * in the word "temple" removed.
     */
    public static String withoutTULetters(String s) {
        String newString = "";
        for (int i = 0; i < s.length(); i++){
            if (inTU(s.charAt(i))==false) {
                newString += s.charAt(i);
            }
        }
        return newString;
    }

    /*
     * returns s in reverse. For example, if s is "Temple", the method returns the
     * String "elpmeT"
     */
    public static String reversed(String s) {
        String newString = "";
        for (int i = s.length()-1; i >= 0; i--){
            newString += s.charAt(i);
        }
        return newString;
    }

    /*
     * returns the number of times that n occurs in h. For example, if h is
     * "Mississippi" and n is "ss" the method returns 2.
     */
    public static int numOccurrences(String h, String n) {
        int occurrences = 0;
        if (h.indexOf(n)==-1){
            return occurrences; //returns 0
        } else {
            occurrences++;
            return occurrences += numOccurrences(h.substring(h.indexOf(n)+n.length()),n); //returns 1 + recursive total
        }
    }

    /*
     * returns true if s is the same backwards and forwards and false otherwise
     */
    public static boolean sameInReverse(String s) {
        String newString = "";
        for (int i = s.length()-1; i >= 0; i--){
            newString += s.charAt(i);
        }
        if (s.equals(newString)){
            return true;
        } else {
            return false;
        }
    }


    /*
     * Returns a new String that looks like base appended with suffix. If base
     * already ends with suffix, it returns base.
     *
     * For example, if base is "lightning" and suffix is "bug", returns
     * "lightningbug".
     *
     * If base is "lightningbug" and suffix is "bug", it also returns
     * "lightningbug".
     */
    public static String appendIfMissing(String base, String suffix) {
        String newString = base;
        if (base.lastIndexOf(suffix)==base.length()-suffix.length()) {
            return newString;
        }
        return newString+=suffix;
    }
}
