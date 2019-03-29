package assignmentEight;

import java.time.LocalDateTime;
import java.util.Scanner;

public class HoneyDoList {

    //Fields
    private Task[] tasks; // an array of Tasks
    private int numTasks; //a non-negative integer storing the number of items contained in tasks[].
    private final int INITIAL_CAPACITY = 10; //a constant non-negative integer. This is how large the task array should be at creation time.

    //Constructors
    public HoneyDoList() {
        this.tasks = new Task[INITIAL_CAPACITY];
        this.numTasks = 0;
    }

    /*Methods*/

    //Getters - Accessor Methods

    @Override
    public String toString() {
        String taskString = "";
        for (int i = 0; i<numTasks-1; i++) {
            if (tasks[i]!=null) {
                taskString += tasks[i] + "\n";
            }
        }
        if (tasks[numTasks-1]!=null) {
            taskString += tasks[numTasks-1];
        }
        return taskString;
    }

    public int find(String name) {
        for (int i = 0; i<tasks.length; i++) {
            if (tasks[i].getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public int totalTime() {
        int totalTime = 0;
        for (int i = 0; i <tasks.length; i++) {
            if (tasks[i]!=null) {
                totalTime += tasks[i].getEstMinsToComplete();
            }
        }
        return totalTime;
    }

    public int shortestTime() {
        int shortestTime = -1;
        for (int i = 0; i <tasks.length; i++) {
            if (tasks[i]!=null) {
                int thisTasksTime = tasks[i].getEstMinsToComplete();
                if (i == 0) {
                    shortestTime = thisTasksTime;
                } else if (shortestTime > thisTasksTime) {
                    shortestTime = thisTasksTime;
                }
            }
        }
        return shortestTime;
    }

    public Task completeTask(int index) {
        try {
            Task completedTask = tasks[index];
            if (completedTask==null) {
                return null;
            } else {
                for (int i = index; i<tasks.length-1; i++) {
                    tasks[i] = tasks[i+1];
                }
                tasks[tasks.length-1] = null;
                numTasks--;
                return completedTask;
            }
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    /*public Task[] overdueTasks() {
        HoneyDoList
    }*/

        //Some Additional Getters

    public int getNumTasks() {
        return numTasks;
    }

    public int getCapacity() {
        return tasks.length;
    }


    //Setters - Mutator Methods

    private Task[] expandTaskCapacity() {
        Task[] newTasks = new Task[tasks.length+10];
        for (int i = 0; i<tasks.length; i++) {
            newTasks[i] = tasks[i];
        }
        return newTasks;
    }

    public void addTask() {
        Scanner in = new Scanner(System.in);
        System.out.print("Please name your task: ");
        String name = in.nextLine();
        System.out.print("What is the priority level? (enter integer): ");
        int priority =  Integer.parseInt(in.next());
        System.out.print("How many minutes do you estimate it will take to complete this task? (enter integer): ");
        int estMinsToComplete = Integer.parseInt(in.next());
        System.out.println("When is this task due?");
        System.out.print("Year: ");
        int year = Integer.parseInt(in.next());
        System.out.print("Month: ");
        int month = Integer.parseInt(in.next());
        System.out.print("Day: ");
        int day = Integer.parseInt(in.next());
        System.out.print("Hour of Day (0-23): ");
        int hour = Integer.parseInt(in.next());
        System.out.print("Min (of hour) (0-59): ");
        int min = Integer.parseInt(in.next());
        try {
            tasks[numTasks] = new Task(name, priority, LocalDateTime.of(year, month, day, hour, min),estMinsToComplete);
            numTasks++;
        } catch (IndexOutOfBoundsException e) {
            Task[] newTasks = expandTaskCapacity();
            newTasks[numTasks] = new Task(name, priority, LocalDateTime.of(year, month, day, hour, min),estMinsToComplete);
            tasks = newTasks;
            numTasks++;
        }
    }

    public void addTask(Task newTask) {
        try {
            tasks[numTasks] = newTask;
            numTasks++;
        } catch (IndexOutOfBoundsException e) {
            Task[] newTasks = expandTaskCapacity();
            tasks = newTasks;
            numTasks++;
        }
    }

    /*
-extra credit: overdueTasks() returns an array of Task consisting of only the items in tasks[] that are overdue.
     */

}
