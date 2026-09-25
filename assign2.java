class Playlist {
    private String[] songs;
    private int songCount;

    // Constructor
    Playlist(int maximumSongs) {
        songs = new String[maximumSongs];
        songCount = 0;
    }

    // Add song
    void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        }
    }

    // Return a copy of songs
    String[] getSongs() {
        String[] copy = new String[songCount];

        for (int i = 0; i < songCount; i++) {
            copy[i] = songs[i];
        }

        return copy;
    }

    // Return number of songs
    int getSongCount() {
        return songCount;
    }
}

public class Main {
    public static void main(String[] args) {

        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        System.out.println("Songs:");
        for (int i = 0; i < copy.length; i++) {
            System.out.println(copy[i]);
        }

        // Modify the returned array
        copy[0] = "Hacked";

        System.out.println("\nAfter modifying copy:");
        String[] newCopy = p.getSongs();

        for (int i = 0; i < newCopy.length; i++) {
            System.out.println(newCopy[i]);
        }

        System.out.println("Song Count = " + p.getSongCount());
    }
}
