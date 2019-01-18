// Handell Desulme
// 1/17/2019
// Assignment 2. Get You a Cat
//
// This program prints lyrics to "Get You a Cat" while using static methods to reduce redundancy.
//

public class Song {
    public static void main(String[] args){
        verseOne();
        verseTwo();
        verseThree();
        verseFour();
        verseFive();
        verseSix();
    }

    public static void verseOne(){
        System.out.println("Bought me a cat and the cat pleased me,");
        System.out.println("I fed my cat under yonder tree.");
        catGoes();
        System.out.println();
    }

    public static void verseTwo(){
        System.out.println("Bought me a hen and the hen pleased me,");
        System.out.println("I fed my hen under yonder tree.");
        henGoes();
        catGoes();
        System.out.println();
    }

    public static void verseThree(){
        System.out.println("Bought me a duck and the duck pleased me,");
        System.out.println("I fed my duck under yonder tree.");
        duckGoes();
        henGoes();
        catGoes();
        System.out.println();
    }

    public static void verseFour(){
        System.out.println("Bought me a goose and the goose pleased me,");
        System.out.println("I fed my goose under yonder tree.");
        gooseGoes();
        duckGoes();
        henGoes();
        catGoes();
        System.out.println();
    }

    public static void verseFive(){
        System.out.println("Bought me a sheep and the sheep pleased me,");
        System.out.println("I fed my sheep under yonder tree.");
        sheepGoes();
        gooseGoes();
        duckGoes();
        henGoes();
        catGoes();
        System.out.println();
    }

    public static void verseSix(){
        System.out.println("Bought me a frog and the frog pleased me,");
        System.out.println("I fed my frog under yonder tree.");
        frogGoes();
        sheepGoes();
        gooseGoes();
        duckGoes();
        henGoes();
        catGoes();
    }

    public static void catGoes(){
        System.out.println("Cat goes fiddle-i-fee.");
    }

    public static void henGoes(){
        System.out.println("Hen goes chimmy-chuck, chimmy-chuck,");
    }

    public static void duckGoes(){
        System.out.println("Duck goes quack, quack,");
    }

    public static void gooseGoes(){
        System.out.println("Goose goes hissy, hissy,");
    }

    public static void sheepGoes(){
        System.out.println("Sheep goes baa, baa,");
    }

    public static void frogGoes(){
        System.out.println("Frog goes ribbit, ribbit,");
    }
}
