package Exercise2_Mini_Project.Astronaut_Daily_Scheduler_Organizer_Application;

public class ConflictNotifier implements Observer {
    @Override
    public void update(String message) {
        System.out.println("NOTIFICATION: " + message);
    }
}
