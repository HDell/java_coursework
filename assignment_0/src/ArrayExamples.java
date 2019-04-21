import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayExamples {
    public static void main(String args[]) {
        int[] first = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(slice(first, 2,5)[0]);
        System.out.println(slice(first, 2,5)[1]);
        System.out.println(slice(first, 2,5)[2]);
        System.out.println(slice(first, 2,5)[3]);
    }

    public static int numPassing(int[] A, int passingScore) {
        int count=0;
        for (int i=0; i<A.length; i++) {
            if(A[i]>passingScore) {
                count++;
            }
        }
        return count;
    }

    public static boolean reverses(int[] A) {
        int[] B = new int[A.length];
        for (int i=A.length-1,j=0; i>=0; i--,j++) {
            B[j] = A[i];
        }
        for (int i=0;i<A.length;i++) {
            if(B[i]!=A[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean same(int[] A, int[] B) {
        return A.equals(B);
    }

    public static int[] copy(int[] A) {
        int[] B = new int[A.length];

        for (int i = 0; i<A.length; i++) {
            B[i] = A[i];
        }

        return B;
    }

    public static int[] slice(int[] A, int i, int j) {
        int[] B = new int[j-i+1];

        for (int start = i, z=0; start<=j; start++,z++) {
            B[z] = A[start];
        }

        return B;
    }
}