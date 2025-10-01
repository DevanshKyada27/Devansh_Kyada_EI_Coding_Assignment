package Exercise1_Design_Pattern.Behavioural_Design_Pattern.youtube_subscribe_notify_system;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel implements Subject{
    List<Observer> subscribers = new ArrayList<>();

    @Override
    public void subscribe(Observer ob) {
        this.subscribers.add(ob);  //if subscribed then add the subscriber to the list
        System.out.println("Subscriber Added! Thank You for Subscribing to the channel :)");
    }

    @Override
    public void unsubscribe(Observer ob) {
        this.subscribers.remove(ob);  //if unsubscribed then remove the subscriber from the list
        System.out.println("Subscriber Removed! Subscriber have unsubscribed the channel!");
    }

    @Override
    public void notifyChanges(String title) {
        for(Observer ob : this.subscribers) {
            ob.notified(title);   //notify the subscribers
        }
    } 

    public List<Observer> getSubscribers() {
        return subscribers;
    }

    //Display all subscribers
    public void listSubscribers() {
        if (subscribers.isEmpty()) {
            System.out.println("No subscribers yet!");
            return;
        }
        System.out.println("\nCurrent Subscribers:");
        int i = 1;
        for (Observer ob : subscribers) {
            if (ob instanceof Subscriber) {
                Subscriber s = (Subscriber) ob;
                System.out.println(i++ + ". " + s.getName());
            }
        }
    }
}
