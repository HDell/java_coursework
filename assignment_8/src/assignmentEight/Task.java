package assignmentEight;

// Handell Desulme
// 4/1/2019
// Assignment 8. Warm Up with Objects
//
// This program ...

import java.time.LocalDateTime;

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
        this.priority = priority;
        this.estMinsToComplete = estMinsToComplete;
    }

    Task (String name, int priority, LocalDateTime whenDue, int estMinsToComplete) {
        this.name = name;
        this.priority = priority; //add restrictions to constructor and mutator methods
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
        return LocalDateTime.now().isAfter(this.whenDue);
    }

    @Override
    public String toString() {
        return ("Name: "+name+", "
                +"Priority: "+priority+", "
                +"est Min Left: "+estMinsToComplete+", "
                +"Due: "+whenDue+".");
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
        this.priority+=amount;
    }

    public void decreasePriority(int amount) {
        this.priority-=amount;
    }

}
