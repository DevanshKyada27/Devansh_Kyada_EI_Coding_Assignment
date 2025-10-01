package Exercise2_Mini_Project.Astronaut_Daily_Scheduler_Organizer_Application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public class ScheduleManager {
    private static ScheduleManager instance;
    private final List<Task> tasks;
    private final List<Observer> observers;
    private static final Logger logger = Logger.getLogger(ScheduleManager.class.getName());

    // Private constructor to prevent instantiation from outside.
    private ScheduleManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static synchronized ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    // --- Observer Pattern Methods ---

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    // --- Task Management Methods ---

    /**
     * Adds a task to the schedule after checking for conflicts.
     *
     * @param newTask The task to be added.
     * @return A string message indicating the result of the operation.
     */
    public String addTask(Task newTask) {
        for (Task existingTask : tasks) {
            if (newTask.conflictsWith(existingTask)) {
                String conflictMessage = "Error: Task conflicts with existing task \"" + existingTask.getDescription() + "\".";
                logger.warning("Task conflict detected: " + newTask.getDescription() + " with " + existingTask.getDescription());
                notifyObservers(conflictMessage);
                return conflictMessage;
            }
        }
        tasks.add(newTask);
        // Keep the list sorted by start time whenever a new task is added.
        tasks.sort(Comparator.comparing(Task::getStartTime));
        logger.info("Task added successfully: " + newTask.getDescription());
        return "Task added successfully. No conflicts.";
    }

    /**
     * Removes a task from the schedule by its description.
     *
     * @param description The description of the task to remove.
     * @return A string message indicating the result of the operation.
     */
    public String removeTask(String description) {
        boolean removed = tasks.removeIf(task -> task.getDescription().equalsIgnoreCase(description));
        if (removed) {
            logger.info("Task removed successfully: " + description);
            return "Task removed successfully.";
        } else {
            logger.warning("Attempted to remove non-existent task: " + description);
            return "Error: Task not found.";
        }
    }

    /**
     * Retrieves all tasks, sorted by their start time.
     *
     * @return A list of all tasks.
     */
    public List<Task> getTasks() {
        return Collections.unmodifiableList(tasks); // Return a read-only view
    }
}
