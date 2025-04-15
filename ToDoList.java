import java.io.*;
import java.util.*;

public class ToDoList {

    private static final String FILE_NAME = "tasks.txt";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int choice;
            
            do {
                System.out.println("\n==== TO-DO LIST MENU ====");
                System.out.println("1. View Tasks");
                System.out.println("2. Add Task");
                System.out.println("3. Delete Task");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // clear buffer
                
                switch (choice) {
                    case 1 -> viewTasks();
                    case 2 -> addTask(scanner);
                    case 3 -> deleteTask(scanner);
                    case 4 -> System.out.println("Exiting... Goodbye!");
                    default -> System.out.println("Invalid choice. Try again.");
                }
            } while (choice != 4);
        }
    }

    private static void viewTasks() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            int taskNumber = 1;
            System.out.println("\nYour Tasks:");
            while ((line = br.readLine()) != null) {
                System.out.println(taskNumber++ + ". " + line);
            }
            if (taskNumber == 1) {
                System.out.println("No tasks found.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter task to add: ");
        String task = scanner.nextLine();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(task);
            bw.newLine();
            System.out.println("Task added.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    private static void deleteTask(Scanner scanner) {
        List<String> tasks = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                tasks.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
            return;
        }

        if (tasks.isEmpty()) {
            System.out.println("No tasks to delete.");
            return;
        }

        viewTasks();
        System.out.print("Enter task number to delete: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); // clear buffer

        if (taskNumber < 1 || taskNumber > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        tasks.remove(taskNumber - 1);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String task : tasks) {
                bw.write(task);
                bw.newLine();
            }
            System.out.println("Task deleted.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
}