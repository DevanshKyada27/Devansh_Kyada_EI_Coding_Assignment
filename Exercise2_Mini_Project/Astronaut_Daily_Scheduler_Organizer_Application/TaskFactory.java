package Exercise2_Mini_Project.Astronaut_Daily_Scheduler_Organizer_Application;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class TaskFactory {
    public static Task createTask(String description, String startTimeStr, String endTimeStr, String priority)
            throws DateTimeParseException, IllegalArgumentException {
        
        LocalTime startTime = LocalTime.parse(startTimeStr);
        LocalTime endTime = LocalTime.parse(endTimeStr);

        if (!endTime.isAfter(startTime)) {
            throw new IllegalArgumentException("Error: End time must be after start time.");
        }

        return new Task(description, startTime, endTime, priority);
    }
}
