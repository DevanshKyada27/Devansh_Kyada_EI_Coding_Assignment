package Exercise2_Mini_Project.Astronaut_Daily_Scheduler_Organizer_Application;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private final String description;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final String priority;
    private boolean completed;

    // Formatter for displaying time in a consistent HH:mm format.
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public Task(String description, LocalTime startTime, LocalTime endTime, String priority) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
        this.completed = false; // Tasks are not completed by default.
    }

    public String getDescription() {
        return description;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        this.completed = true;
    }

    public boolean conflictsWith(Task other) {
        return this.startTime.isBefore(other.endTime) && this.endTime.isAfter(other.startTime);
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s [%s] %s",
                startTime.format(TIME_FORMATTER),
                endTime.format(TIME_FORMATTER),
                description,
                priority,
                (completed ? "(Completed)" : ""));
    }
}
