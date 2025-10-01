package Exercise1_Design_Pattern.Behavioural_Design_Pattern.youtube_subscribe_notify_system;

interface Subject {
    void subscribe(Observer ob);  //registration

    void unsubscribe(Observer ob);  //deregistration

    void notifyChanges(String title);
}