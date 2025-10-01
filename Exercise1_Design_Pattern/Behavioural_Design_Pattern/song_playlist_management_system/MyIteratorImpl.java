package Exercise1_Design_Pattern.Behavioural_Design_Pattern.song_playlist_management_system;

import java.util.Iterator;
import java.util.List;

public class MyIteratorImpl implements MyIterator{
    private List<Song> list;
    private int length;

    private int position = 0;  //current position

    public MyIteratorImpl(List<Song> list) {
        this.list = list;
        this.length = list.size();
    }

    @Override
    public boolean hasNext() {
        if(position >= length) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        Song user = list.get(position);
        position += 1;
        return user;
    }
}
