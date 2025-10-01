package Exercise1_Design_Pattern.Behavioural_Design_Pattern.song_playlist_management_system;

public class Song {
    private String songName;
    private String artist;
    private double duration; // in minutes
    
    public Song(String songName, String artist, double duration) {
        this.songName = songName;
        this.artist = artist;
        this.duration = duration;
    }

    public String getSongName() {
        return songName;
    }

    public String getArtist() {
        return artist;
    }

    public double getDuration() {
        return duration;
    }
}
