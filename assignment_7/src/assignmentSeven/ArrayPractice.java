package assignmentSeven;

// Handell Desulme
// 3/25/2019
// Assignment 7. Array Practice
//
// This program implements various Array solutions.

public class ArrayPractice {

    /* sets every item in A[] to initialValue */
    public static void initialize(int A[], int initialValue) {
        for (int i = 0; i<A.length; i++) {
            A[i] = initialValue;
        }
        return;
    }

    /* returns the average of the items in A
     * Be careful: A[] is an array of int and the method returns
     * double. What do we do to handle this? */
    public static double average(int A[]) {
        int total = 0;
        for (int i = 0; i<A.length; i++) {
            total += A[i];
        }
        return (double) total/A.length;
    }

    /* returns the number of times that x appears in A[] */
    public static int numOccurrences(int A[], int x) {
        int count = 0;
        for (int i = 0; i<A.length; i++) {
            if (A[i]==x) {
                count++;
            }
        }
        return count;
    }


    /* returns the index of the first occurrence of
     * x in A[] or -1 if x doesn't exist in A[] */
    public static int find(int A[], int x) {
        for (int i = 0; i<A.length; i++) {
            if (A[i]==x) {
                return i; //zero-based indexing
            }
        }
        return -1;
    }

    /* Returns the index of the first occurrence of
     * item within the first n elements of A[] or -1
     * if item is not among the first n elements of A[] */
    public static int findN(int A[], int item, int n) {
        for (int i = 0; i<n; i++) {
            if (A[i]==item) {
                return i;
            }
        }
        return -1;
    }

    /* returns the index of the last occurrence of
     * x in A[] or -1 if x doesn't exist in A[] */
    public static int findLast(int A[], int x) {
        for (int i = A.length-1; i>=0; i--) {
            if (A[i]==x) {
                return i;
            }
        }
        return -1;
    }

    /* returns the largest item found in A */
    public static int largest(int A[]) {
        if (A.length>0) {
            int max = A[0];
            for (int i = 0; i < A.length; i++) {
                if (A[i]>max) {
                    max = A[i];
                }
            }
            return max;
        }
        return -1;
    }

    /* returns the index of the largest item found in A */
    public static int indexOfLargest(int A[]) {
        if (A.length>0) {
            int maxIndex = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i]>A[maxIndex]) {
                    maxIndex = i;
                }
            }
            return maxIndex;
        }
        return -1;
    }

    /* returns the index of the largest odd number
     * in A[] or -1 if A[] contains no odd numbers */
    public static int indexOfLargestOdd(int A[]) {
        boolean oddExists = false;
        int maxOddIndex = -1;
        if (A.length>0) {
            for (int i = 0; i < A.length; i++) {
                if (A[i]%2==1) {
                    maxOddIndex = i;
                    oddExists = true;
                }
            }
            if (oddExists) {
                for (int i = 0; i < A.length; i++) {
                    if ((A[i]%2==1)&&(A[i]>A[maxOddIndex])) {
                        maxOddIndex = i;
                    }
                }
                return maxOddIndex;
            }
        }
        return -1;
    }

    /* inserts n into A[] at A[index] shifting all */
    /*  the previous items one place to the right. For example */
    /*  if A is  */
    /*   |---+---+---+---+---+---+---+---+---+---| */
    /*   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | */
    /*   |---+---+---+---+---+---+---+---+---+---| */
    /*   | 5 | 7 | 6 | 9 | 4 | 3 | 0 | 0 | 0 | 0 | */
    /*   |---+---+---+---+---+---+---+---+---+---| */

    /*   and we call insert(A, 15, 1), A then becomes */

    /*   |---+----+---+---+---+---+---+---+---+---| */
    /*   | 0 |  1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | */
    /*   |---+----+---+---+---+---+---+---+---+---| */
    /*   | 5 | 15 | 7 | 6 | 9 | 4 | 3 | 0 | 0 | 0 | */
    /*   |---+----+---+---+---+---+---+---+---+---| */
    /*  the element in A[] that's in the right-most */
    /*    position is removed.                      */
    /*                                              */
    /*  if index < 0 or index >= A.length-1, the method */
    /*                                    does nothing */
    public static void insert(int A[], int n, int index) {
        if (index<0||index>=A.length-1) {
            return;
        }
        for (int i = A.length-1; i>index; i--) {
            A[i]=A[i-1];
        }
        A[index] = n;
    }

    /* returns a new array consisting of all of the
     * elements of A[] */
    public static int[] copy(int A[]) {
        int[] aCopy = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            aCopy[i] = A[i];
        }
        return aCopy;
    }

    /* Returns a new array consisting of all of the
       first n elements of A[]. If n>A.length, returns a
       new array of size n, with the first A.length elements
       exactly the same as A, and the remaining n-A.length elements
       set to 0. If n<=0, returns null. */
    public static int[] copyN(int A[], int n) {
        if (n<=0) {
            return null;
        } else if (n>A.length) {
            int[] aCopy = new int[n];
            for (int i = 0; i<A.length; i++) {
                aCopy[i] = A[i];
            }
            for (int i = A.length; i<n; i++) {
                aCopy[i] = 0;
            }
            return aCopy;
        } else {
            int[] aCopy = new int[n];
            for (int i = 0; i<n; i++) {
                aCopy[i] = A[i];
            }
            return aCopy;
        }
    }

    /* returns a new array consisting of all of the
     * elements of A[] followed by all of the
     * elements of B[]. For example, if
     A[] is: {10,20,30} and
     B[] is: {5, 9, 38}, the method returns the
     array : {10,20,30,5,9,38} */
    public static int[] copyAll(int A[], int B[]) {
        int[] combinedArray = new int[A.length+B.length];
        for (int i = 0; i<combinedArray.length; i++) {
            if (i<A.length) {
                combinedArray[i] = A[i];
            } else {
                combinedArray[i] = B[i-A.length];
            }
        }
        return combinedArray;
    }

    /* reverses the order of the elements in A[].
     * For example, if A[] is:
     {10,20,30,40,50}, after the method, A[] would
     be {50,40,30,20,10} */
    /*
    {10,20,30,40,50,60}
    {60,50,40,30,20,10}
     */
    public static void reverse(int A[]) {
        int temp;
        for (int i = 0; i < A.length/2; i++) {
            temp = A[i];
            A[i] = A[A.length-(1+i)];
            A[A.length-(1+i)] = temp;
        }
        return;
    }

    /* Extra credit:
     *
     * Returns a new array consisting of all of the
     * elements of A, but with no duplicates. For example,
     * if A[] is {10,20,5,32,5,10,9,32,8}, the method returns
     * the array {10,20,5,32,9,8} */
    public static int[] uniques(int A[]) throws IndexOutOfBoundsException { //This could be solved by just putting the values into a Hash or Tree Set & then refilling array

        int[] setupA = copy(A);
        int setCount = 0;
        int uniqueValue=(setupA[0]+1);
        int index = 0;

        for (int i = 1; i<setupA.length; i++) {
            uniqueValue += (setupA[i]+1); //sum of every integer element + 1; guaranteed to be unique
        }

        for (int i = 0; i<setupA.length-1; i++) {
            for (int j = i+1; j<setupA.length; j++) {
                if (setupA[i]!=uniqueValue && setupA[i]==setupA[j]) {
                    setupA[j]=uniqueValue;
                }
            }
        }

        for (int i = 0; i<setupA.length; i++) {
            if (setupA[i]!=uniqueValue) {
                setCount++;
            }
        }

        int[] setA = new int[setCount];

        for (int i = 0; i<setupA.length; i++) {
            if (setupA[i]!=uniqueValue) {
                setA[index] = setupA[i];
                index++;
            } else { //(setupA[i]==uniqueValue)
                ;//do nothing
            }
        }

        return setA;
    }

    public static void main(String[] args) {
        return;
    }

}
