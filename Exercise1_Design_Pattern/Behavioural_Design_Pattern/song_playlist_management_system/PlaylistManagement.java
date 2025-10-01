package Exercise1_Design_Pattern.Behavioural_Design_Pattern.song_playlist_management_system;

import java.util.ArrayList;

public class PlaylistManagement {
    private ArrayList<Song> playlist = new ArrayList<>();  // list to store songs

    public void addSong(Song song) {
        playlist.add(song);
    }

    public Song getSong(int index) {
        return playlist.get(index);
    }

    public void removeSong(int index) {
        if(index >= 0 && index < playlist.size()) {
            playlist.remove(index);
            System.out.println("Song removed from playlist!");
        } else {
            System.out.println("Invalid index!");
        }
    }

    public MyIterator getIterator() {
        //helps in to iterate the obejcts of the class
        return new MyIteratorImpl(playlist);  //implementaiton class
    }
}
