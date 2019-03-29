package assignmentEight;

public class SampleSubClass {

    public static void main(String[] args) {
        HoneyDoList myList = new HoneyDoList();
        myList.addTask();
        myList.addTask();
        System.out.println(myList);
        System.out.println("break");
        System.out.println(myList.completeTask(0));
        System.out.println("break");
        System.out.println(myList);
        System.out.print("fin");
    }

}
