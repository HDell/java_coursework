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
        int shortestTimeIndex = -1;
        for (int i = 0; i <tasks.length; i++) {
            if (tasks[i]!=null) {
                int thisTasksTime = tasks[i].getEstMinsToComplete();
                if (i == 0) {
                    shortestTimeIndex = 0;
                } else if (tasks[shortestTimeIndex].getEstMinsToComplete() > thisTasksTime) {
                    shortestTimeIndex = i;
                }
            }
        }
        return shortestTimeIndex;
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

    public Task[] overdueTasks() { //returns an array of Task consisting of only the items in tasks[] that are overdue.
        int count = 0;
        int index = 0;
        for (int i = 0; i<numTasks; i++) {
            if (tasks[i].overdue()) {
                count++;
            }
        }
        if (count>0) {
            Task[] newTasks = new Task[count];
            for (int i = 0; i<numTasks; i++) {
                if (tasks[i].overdue()) {
                    newTasks[index] = tasks[i];
                    index++;
                }
            }
            return newTasks;
        }
        return null;
    }

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

    public void addTask() throws NumberFormatException {
        //No error checking has been implemented as this version of addTask() wasn't necessary; see addTask(Task newTask) below
        Scanner in = new Scanner(System.in);
        System.out.print("Please name your task: ");
        String name = in.nextLine();
        System.out.print("What is the priority level? (enter integer): ");
        int priority =  Integer.parseInt(in.next());
        System.out.print("How many minutes do you estimate it will take to complete this task? (enter integer): ");
        int estMinsToComplete = Integer.parseInt(in.next());
        System.out.print("Do you want to add a due date? (y/n): ");
        String response = in.next();
        if (isMatch(response, "yes")){
            LocalDateTime dateTime = Task.setTime(in);
            try {
                tasks[numTasks] = new Task(name, priority, dateTime,estMinsToComplete);
                numTasks++;
            } catch (IndexOutOfBoundsException e) {
                Task[] newTasks = expandTaskCapacity();
                newTasks[numTasks] = new Task(name, priority, dateTime,estMinsToComplete);
                tasks = newTasks;
                numTasks++;
            }
        } else {
            try {
                tasks[numTasks] = new Task(name, priority,estMinsToComplete);
                numTasks++;
            } catch (IndexOutOfBoundsException e) {
                Task[] newTasks = expandTaskCapacity();
                newTasks[numTasks] = new Task(name, priority, estMinsToComplete);
                tasks = newTasks;
                numTasks++;
            }
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

    public static boolean isMatch(String response, String match){
        if (response.length()>match.length()){
            return false;
        }
        for (int i = 0; i < response.length(); i++){
            if(response.toLowerCase().charAt(i)!=match.toLowerCase().charAt(i)){
                return false;
            }
        }
        return true;
    }

}
