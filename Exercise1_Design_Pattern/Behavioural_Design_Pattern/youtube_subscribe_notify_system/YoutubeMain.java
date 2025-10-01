package Exercise1_Design_Pattern.Behavioural_Design_Pattern.youtube_subscribe_notify_system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YoutubeMain {
    public static void main(String[] args) throws NumberFormatException, IOException {
        YoutubeChannel channel = new YoutubeChannel();

        Observer devansh = new Subscriber("Devansh");
        // Observer shayam = new Subscriber("Shayam");

        channel.subscribe(devansh);  //subscribed channel
        // channel.subscribe(shayam);

        // channel.notifyChanges("Behavioural Design Pattern - YouTube System");  //subscriber should get the notified changes from the channel
        // channel.notifyChanges("A video title");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            System.out.println("<--------------Welcome to the YouTube Notification System Application-------------->");
            System.out.println("Press 1 to upload a new video to the channel");
            System.out.println("Press 2 to create new subscriber");
            System.out.println("Press 3 to Unsubscribe a Subscriber");
            System.out.println("Press 4 to Exit");

            int choice = Integer.parseInt(br.readLine());  //choice
            if(choice == 1) {
                //new video upload to the channel
                System.out.println("Enter the title of the video");
                String videoTitle = br.readLine();
                channel.notifyChanges(videoTitle);  
            } else if(choice == 2) {
                //create new subscriber
                System.out.println("Enter name of subscriber");
                String subsName = br.readLine();
                Observer subscriber3 = new Subscriber(subsName); 
                channel.subscribe(subscriber3);
            } else if(choice == 3) {
                if(channel.getSubscribers().isEmpty()) {
                    System.out.println("No subscribers yet!");
                    continue;
                }
                //display the list of current subscribers
                channel.listSubscribers();

                //unsubscribe a subscriber from the channel
                System.out.println("Enter the name of the subscriber to unsubscriber the channel: ");
                String nameToRemove = br.readLine();

                //find the subscriber with the name
                Observer toRemove = null;
                for(Observer ob : channel.subscribers) {
                    if(ob instanceof Subscriber) {
                        Subscriber s = (Subscriber) ob;
                        if(s.getName().equalsIgnoreCase(nameToRemove)) {
                            toRemove = ob;
                            break;
                        }
                    }
                }

                if(toRemove != null) {
                    channel.unsubscribe(toRemove);
                } else {
                    System.out.println("Sorry! Subscriber not found :(");
                }
            } else  if(choice == 4) {
                //exit 
                System.out.println("Thank You for using the App!");
                break;
            } else {
                //exit wrong input
                System.out.println("Wrong Input, Please Try Again!");
            }
        }
    }
}
