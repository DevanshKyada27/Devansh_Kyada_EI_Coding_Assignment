package Exercise1_Design_Pattern.Behavioural_Design_Pattern.youtube_subscribe_notify_system;

public class Subscriber implements Observer{

    String name;

    Subscriber(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    @Override
    public void notified(String title) {
        System.out.println("Hello " + this.name + "!" + " " + "New Video Uploded on the Youtube Channel : " + title);
    }
    
}
