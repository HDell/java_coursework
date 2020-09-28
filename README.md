# java_coursework
Course Work from CIS 1068 at Temple University. Demonstrates learning in Java (OOP) and JUnit (testing).
___

### [Assignment 0](https://github.com/HDell/java_coursework/tree/master/assignment_0/src)
Description: 
- [Working with Arrays](https://github.com/HDell/java_coursework/blob/master/assignment_0/src/ArrayExamples.java) (ArrayExamples.java)
- [Printing Exam Score Stats](https://github.com/HDell/java_coursework/blob/master/assignment_0/src/Example.java) (Example.java)
___

### [Assignment 1](https://github.com/HDell/java_coursework/blob/master/assignment_1/src/Greetings.java) 
Name: Greetings
<br/>Date: 1/18/2019
<br/>Description: This program prints to the console a greeting to my lab instructor.
___

### [Assignment 2](https://github.com/HDell/java_coursework/blob/master/assignment_2/src/Song.java) 
Name: Get You a Cat
<br/>Date: 1/24/2019
<br/>Description: This program prints lyrics to "Get You a Cat" while using static methods to reduce redundancy.
___

### [Assignment 3](https://github.com/HDell/java_coursework/blob/master/assignment_3/src/AsciiArt.java) 
Name: Draw a Pretty Picture
<br/>Date: 2/11/2019
<br/>Description: This program prints to the console three designs that can be scaled via changes to the SIZE constant.
___

### [Assignment 4](https://github.com/HDell/java_coursework/blob/master/assignment_4/src/SomePracticeMethods.java) 
Name: Practice with Static Methods and Strings 
<br/>Date: 2/17/2019
<br/>Description: This program contains multiple string algorithms in static methods to solve a variety of problems.
___

### [Assignment 5](https://github.com/HDell/java_coursework/blob/master/assignment_5/src/assignmentFourGame/Havsta.java) 
Name: A Game
<br/>Date: 2/26/2019
<br/>Description: This program implements the game of Havsta that a user can play on the console by following the instructions & using the keyboard.
___

### [Assignment 6](https://github.com/HDell/java_coursework/blob/master/assignment_6/src/assignmentSix/Southie.java) 
Name: A Southie Styles
<br/>Date: 3/15/2019
<br/>Description: This program reads from a text source, converts dialogue to a predetermined accent/style, and outputs it to an output file.
___

### [Assignment 7](https://github.com/HDell/java_coursework/blob/master/assignment_7/src/assignmentSeven/ArrayPractice.java) 
Name: Array Practice
<br/>Date: 3/25/2019
<br/>Description: This program implements various Array solutions.
___

### [Assignment 8](https://github.com/HDell/java_coursework/blob/master/assignment_8/src/assignmentEight/ToDoListDriver.java) 
Name: Warm Up with Objects
<br/>Date: 4/1/2019
<br/>Description: This program creates a task class and a task manager class that organize and manipulate task information.
___

### [Assignment 9](https://github.com/HDell/java_coursework/blob/master/assignment_9/src/assignment9/Driver.java) 
Name: Test Papers Assignment
<br/>Date: 4/14/2019
<br/>Description: This program creates a test question class hierarchy and a driver that outputs the questions and answers.
___

### [Assignment 10](https://github.com/HDell/java_coursework/blob/master/assignment_10/src/Hangman.java) 
Name: Cheating Word Guessing Game
<br/>Date: 4/19/2019
<br/>Description: Allows the user to play a game of hangman. However, the computer cheats to make the game more difficult.
___

### [Assignment 11](https://github.com/HDell/java_coursework/blob/master/assignment_11/src/FileSorter.java) 
Name: Yates' Big File Sorter (Extra Credit)
<br/>Date: 4/29/2019
>**Description:**<br/><br/>
>Because it's the end of the semester, absolutely no late assignments can be accepted >for credit.
>
>During the last few lectures, we've discussed various sorting algorithms, and how much >work it takes to sort collections of larger and larger sizes. What we have not >considered is how you might sort a collection that is so large that it doesn't fit in >the memory of the machine. One solution to this problem is to break the very large >file up into several smaller files, sort the contents of each of the small files, and >merge each of the smaller, sorted files into progressively larger sorted files until >you're left with one large sorted file.
>
>For this assignment, you will design and implement a sort program that still works >correctly, even when there is not enough memory to store an entire input file. This >will give you practice with collections, files, exceptions, and sorting algorithms.
>
>**Program Description (up to 45 extra credit points)**
>
>At runtime, your program should read the name of a "large" input file to sort, and the >name to give the sorted output file.
>
>The program will sort the lines in the input file, and save the sorted lines in the >output file. Your sort algorithm will be a hybrid of the MergeSort algorithm and >Java's built-in sorting algorithm as a two-phase process, as described below.
>
>**Phase 1: Breaking the input file into manageable chunks**
>
>In the first phase, the sort algorithm will read in a fixed number of lines from the >input file, and store them into an array. It should pick a manageable number that will >fit into memory. Next, it will sort that array using Java's built-in Arrays.sort >method. Then it will store the sorted array in a temporary file called "temp_0_0.txt".
>
>The algorithm will repeatedly read in chunks of lines until it has read in the entire >contents of the input file. Each time it reads in a chunk of lines from the input >file, it stores that chunk in an array, sorts the array, and saves the array in >another temporary file ("temp_0_1.txt", "temp_0_2.txt", ... "temp_0_n.txt"). Notice >that it is reading in an amount that will fit into memory each time, so that it does >not run out of memory.
>
>After this first phase is complete, each of the "temp_0_i.txt" files is in sorted >order, and together they contain all of the stuff that was in the input file. The >second phase must merge the files together, while making sure that the merged files >remain in sorted order.
>
>**Phase 2: Merging the chunks together**
>
>Remember from class that the MergeSort algorithm repeatedly merges two small sorted >arrays into a larger sorted array. Here, you will do the same, but instead repeatedly >merge two small sorted files into a larger sorted file. Take care that you only read >in one line of each file into memory at a time --- don't read the entire files into >memory, or you will run out of memory!
>
>Your sort algorithm should begin phase 2 by merging "temp_0_0.txt" and "temp_0_1.txt", >and saving it to a new file called "temp_1_0.txt". Next, it will merge "temp_0_2.txt" >with "temp_0_3.txt", and save the merged file as "temp_1_1.txt". This will repeat >until there are no more "temp_0_i.txt" files left. If there are an odd number of these >files, the last one will have nothing to merge with. That's ok, it can be merged in >later iterations. Just copy it into the next available "temp_1_i.txt".
>
>After merging pairs of the "temp_0_i.txt" files, the sort algorithm needs to begin >merging pairs of the "temp_1_i.txt" files. It will begin by merging "temp_1_0.txt" and >"temp_1_1.txt", and saving the result to "temp_2_0.txt". Then, it will merge "temp_1_2.>txt" and "temp_1_3.txt", and save the result to "temp_2_1.txt", and so on.
>
>Each time through the set of temporary files, the merging process cuts the number of >temporary files roughly in half, because it merges two files into one. (I say >"roughly" because there may be an odd number of files, in which case the last file >does not get merged with anything.) This phase of the sorting must keep repeating, >until there are only two temporary files left. When that happens, it should merge >those temporary files, but instead of saving the result to another temporary file, it >should save it to the output file. Then the sort is finished.
>
>**Guidelines for Testing Your Program**
>
>You may find a reasonably large text file (~7 Mb) here, which you may use to test your >program. It contains Aesop's Fables, the complete works of Shakespeare, Mary Shelley's >Frankenstein, and Mark Twain's The Adventures of Huckleberry Finn.
>
>The file is certainly small enough to fit into memory --- I didn't want to you to have >to deal with an enormous file. However, you should choose a setting so that your >program reads in less than the whole file at a time. At first, try reading in around 1/>20 of the lines at a time into memory during the first phase. You should test your >program with several different settings.
>
>**unit tests (up to 15 extra credit points)**
>
>Write a JUnit test to make sure that your merge() function works correctly. Be sure to >test that it merges arrays that are the same size and two arrays that are not the same >size.
