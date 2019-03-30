package assignmentEight;

public class ToDoListDriver {

    public static void main(String[] args) {
        HoneyDoList myList = new HoneyDoList();
        myList.addTask(); //Manual (scanner) version of addTask
        myList.addTask(new Task("take aspirin", 1, 120)); //Overloaded, Task argument version
        System.out.println(myList); //Print entire task list
        System.out.println("|break|");
        System.out.println(myList.shortestTime()); //print index of task w/ shortest estimate completion time
        System.out.println(myList.totalTime()); //print total time of tasks
        System.out.println("|break|");
        Task[] newTasks = myList.overdueTasks(); //Make array of overdue tasks
        Task aTask = myList.completeTask(0); //Complete (and remove) task @ index 0
        System.out.println(aTask); //print individual task
        System.out.println(aTask.overdue()); //check if this task is overdue
        System.out.println("|break|");
        System.out.println(myList); //print entire task list again (w/ task removed)
        System.out.println("|break|");
        System.out.println(newTasks[0]); //print overdue task @ index 1 (if applicable)
        System.out.print("|fin|");
    }

}
