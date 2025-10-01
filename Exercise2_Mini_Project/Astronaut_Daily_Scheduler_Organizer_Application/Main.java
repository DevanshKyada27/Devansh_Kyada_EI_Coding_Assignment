package Exercise2_Mini_Project.Astronaut_Daily_Scheduler_Organizer_Application;

import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Get the single instance of ScheduleManager
        ScheduleManager scheduleManager = ScheduleManager.getInstance();
        
        // Setup the Observer
        ConflictNotifier notifier = new ConflictNotifier();
        scheduleManager.addObserver(notifier);

        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("<------------ Welcome TO Astronaut Daily Schedule Organizer Application ------------>");
        printHelp();

        while (true) {
            System.out.print("\nEnter command: ");
            command = scanner.nextLine().trim();
            String[] parts = command.split(",");

            try {
                switch (parts[0].toLowerCase()) {
                    case "add":
                        // Expected format: add,Description,HH:mm,HH:mm,Priority
                        if (parts.length < 5) {
                            System.out.println("Error: Invalid arguments for 'add'. Use format: add,Description,StartTime,EndTime,Priority");
                            break;
                        }
                        String description = parts[1].trim();
                        String startTime = parts[2].trim();
                        String endTime = parts[3].trim();
                        String priority = parts[4].trim();
                        
                        Task newTask = TaskFactory.createTask(description, startTime, endTime, priority);
                        String result = scheduleManager.addTask(newTask);
                        System.out.println(result);
                        break;

                    case "remove":
                        // Expected format: remove,Description
                        if (parts.length < 2) {
                            System.out.println("Error: Invalid arguments for 'remove'. Use format: remove,Description");
                            break;
                        }
                        String descToRemove = parts[1].trim();
                        System.out.println(scheduleManager.removeTask(descToRemove));
                        break;

                    case "view":
                        // Expected format: view
                        List<Task> tasks = scheduleManager.getTasks();
                        if (tasks.isEmpty()) {
                            System.out.println("No tasks scheduled for the day.");
                        } else {
                            System.out.println("\n--- Daily Schedule ---");
                            for (Task task : tasks) {
                                System.out.println(task);
                            }
                            System.out.println("--------------------");
                        }
                        break;
                    
                    case "help":
                        printHelp();
                        break;

                    case "exit":
                        System.out.println("Exiting application.... Thank You for Using the Appplication! :)");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Error: Unknown command. Type 'help' to see available commands.");
                        break;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Error: Invalid time format. Please use HH:mm.");
            } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    private static void printHelp() {
        System.out.println("\nAvailable Commands:");
        System.out.println("  add, <description>, <start_time HH:mm>, <end_time HH:mm>, <priority>");
        System.out.println("  remove, <description>");
        System.out.println("  view");
        System.out.println("  help");
        System.out.println("  exit");
        System.out.println("\nExample: add, Morning Exercise, 07:00, 08:00, High");
    }
}
