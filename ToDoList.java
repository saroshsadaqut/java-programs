import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {
        ArrayList<String> toDoList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n--- To-Do List Menu ---");
            System.out.println("1. View Tasks");
            System.out.println("2. Add Task");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // consume the leftover newline

            switch (choice) {
                case 1 -> {
                    System.out.println("\nYour Tasks:");
                    if (toDoList.isEmpty()) {
                        System.out.println("No tasks found.");
                    } else {
                        for (int i = 0; i < toDoList.size(); i++) {
                            System.out.println((i + 1) + ". " + toDoList.get(i));
                        }
                    }
                }
                case 2 -> {
                    System.out.print("Enter a new task: ");
                    String task = scanner.nextLine();
                    toDoList.add(task);
                    System.out.println("Task added!");
                }
                case 3 -> {
                    System.out.print("Enter the task number to remove: ");
                    int taskNum = scanner.nextInt();
                    if (taskNum >= 1 && taskNum <= toDoList.size()) {
                        toDoList.remove(taskNum - 1);
                        System.out.println("Task removed.");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                }
                case 4 -> {
                    System.out.println("Exiting To-Do List App. Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
