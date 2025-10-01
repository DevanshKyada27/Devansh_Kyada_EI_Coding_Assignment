package Exercise1_Design_Pattern.Behavioural_Design_Pattern.song_playlist_management_system;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PlaylistManagement playlist = new PlaylistManagement();

        // playlist.addSong(new Song("Shape of You", "Ed Sheeran", 4.24));
        // playlist.addSong(new Song("Blinding Lights", "The Weeknd", 3.22));
        // playlist.addSong(new Song("Believer", "Imagine Dragons", 3.37));
        // playlist.addSong(new Song("Levitating", "Dua Lipa", 3.23));

        

        // MyIterator iterator = playlist.getIterator();

        // System.out.println("Playlist Songs:");
        // while(iterator.hasNext()) {
        //     Song song = (Song) iterator.next();
        //     System.out.println(song.getSongName() + " by " + song.getArtist() + " (" + song.getDuration() + " min)");
        // }

        Scanner sc = new Scanner(System.in);

        System.out.println("<-------------- Welcome to Playlist Manager System Application-------------->");

        while(true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a Song");
            System.out.println("2. View Playlist");
            System.out.println("3. Remove a Song");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            if(choice == 1) {
                // Add a new song
                System.out.print("Enter Song Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Artist Name: ");
                String artist = sc.nextLine();
                System.out.print("Enter Duration (in minutes): ");
                double duration = sc.nextDouble();
                sc.nextLine(); 

                playlist.addSong(new Song(name, artist, duration));
                System.out.println("Song added to playlist! :)");

            } else if(choice == 2) {
                // View playlist using iterator
                MyIterator iterator = playlist.getIterator();
                System.out.println("\n--- Playlist ---");
                if(!iterator.hasNext()) {
                    System.out.println("Playlist is empty :(");
                }
                while(iterator.hasNext()) {
                    Song song = (Song) iterator.next();
                    System.out.println(song.getSongName() + " by " + song.getArtist() + " (" + song.getDuration() + " min)");
                }

            } else if(choice == 3) {
                System.out.print("Enter index of song to remove (starting from 0): ");
                int index = sc.nextInt();
                sc.nextLine();
                playlist.removeSong(index);

            } else if(choice == 4) {
                // Exit program
                System.out.println("Exiting Console Playlist Manager. Thank You for using the application!");
                break;

            } else {
                System.out.println("Invalid choice! Please enter 1, 2, 3 or 4.");
            }
        }
    }
}
