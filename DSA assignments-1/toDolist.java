package question1;

public class toDolist {
    Node head;

    // constructor to initialize an empty to-do list therefore we make the head = null
    public toDolist() {
        head = null;
    }

    // Method to add a new task to the list
    public void addToDo(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode; //if head is null it means the todoList was empty hence assigning a head
        } else {
            Node tempNode = head;  // otherwise
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = newNode;
        }
    }

    // Method to mark a task as completed by title
    public void markToDoAsCompleted(String title) {
        Node tempNode = head;
        while (tempNode != null) {
            if (tempNode.task.getTitle().equals(title)) {
                tempNode.task.markCompleted();
                return;
            }
            tempNode = tempNode.next;
        }
        System.out.println("Task with this title not found.");
    }

    // Method to see the to-do list that we just created
    public void viewToDoList() {
        Node tempNode = head;
        while (tempNode != null) {
            Task task = tempNode.task;
            String statusIcon = task.isCompleted() ? "\u2714️" : "\u274C";
            //implemented unicode for making the marking process more aesthetic
            System.out.println(statusIcon + " Title: " + task.getTitle());
            System.out.println("   Description: " + task.getDescription());
            System.out.println();
            tempNode = tempNode.next;
        }
    }

    // Main method to test the to-do list
    public static void main(String[] args) {
        toDolist toDoList = new toDolist();

        Task task1 = new Task("Buy Groceries", "Buy milk, eggs, and bread.");
        Task task2 = new Task("Workout", "Complete a 30-minute workout.");
        Task task3 = new Task("Finish Report", "Complete the annual report.");

        toDoList.addToDo(task1);
        toDoList.addToDo(task2);
        toDoList.addToDo(task3);

        toDoList.markToDoAsCompleted("Workout");

        toDoList.viewToDoList();
    }
}
