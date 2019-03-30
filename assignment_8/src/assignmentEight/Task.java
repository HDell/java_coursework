package assignmentEight;

// Handell Desulme
// 4/1/2019
// Assignment 8. Warm Up with Objects
//
// This program ...

import java.time.LocalDateTime;
import java.util.Scanner;

public class Task {

    //Fields
    private String name;
    private int priority;
    private int estMinsToComplete;
    private LocalDateTime whenDue;

    //Constructors

    Task () {
        this.name = "N/A";
        this.priority = 0;
        this.estMinsToComplete = 0;
    }

    Task (String name, int priority, int estMinsToComplete) {
        this.name = name;
        if (priority>=0) {
            this.priority = priority;
        } else {
            this.priority = 0;
        }
        this.estMinsToComplete = estMinsToComplete;
    }

    Task (String name, int priority, LocalDateTime whenDue, int estMinsToComplete) {
        this.name = name;
        if (priority>=0) {
            this.priority = priority;
        } else {
            this.priority = 0;
        }
        this.whenDue = whenDue;
        this.estMinsToComplete = estMinsToComplete;
    }

    /* Methods */

    //Getters - Accessor Methods
    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public int getEstMinsToComplete() {
        return estMinsToComplete;
    }

    public LocalDateTime getWhenDue() {
        return whenDue;
    }

    public boolean overdue() {
        if (whenDue!=null) {
            return LocalDateTime.now().isAfter(this.whenDue);
        } else {
            Scanner in = new Scanner(System.in);
            LocalDateTime dateTime = setTime(in);
            this.whenDue = dateTime;
            return this.overdue();
        }
    }

    public static LocalDateTime setTime(Scanner in) {
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
        return LocalDateTime.of(year, month, day, hour, min);
    }

    @Override
    public String toString() {
        if (whenDue!=null) {
            return ("Name: " + name + ", "
                    + "Priority: " + priority + ", "
                    + "est Min Left: " + estMinsToComplete + ", "
                    + "Due: " + whenDue + ".");
        } else {
            return ("Name: " + name + ", "
                    + "Priority: " + priority + ", "
                    + "est Min Left: " + estMinsToComplete + ". ");
        }
    }

    //Setters - Mutator Methods
    public void setName(String name) {
        this.name = name;
    }

    public void setEstMinsToComplete(int estMinsToComplete) {
        this.estMinsToComplete = estMinsToComplete;
    }

    public void setWhenDue(LocalDateTime whenDue) {
        this.whenDue = whenDue;
    }

    public void increasePriority(int amount) {
        if (amount>0) {
            this.priority += amount;
        }
    }

    public void decreasePriority(int amount) {
        if (amount>priority) {
            this.priority=0;
        } else {
            this.priority -= amount;
        }
    }

}
