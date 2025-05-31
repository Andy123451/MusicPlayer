/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SongObject;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author theli
 */
public class AddSong {
    
    public static ArrayList <Song> songs = new ArrayList<>();
    public static ArrayList <MediaPlayer> players = new ArrayList<>();

    

    public static void addSongs(){
    
        Song s1 = new Song("Invincible", "Onerepublic", "src\\main\\resources\\Songs\\Invincible.mp3", "/Images/Invincible.jpeg", 184, 0);
        songs.add(s1);
        
        Media m1 = new Media(new File(s1.getSongPath()).toURI().toString());
        MediaPlayer mp1 = new MediaPlayer(m1);
        mp1.setVolume(1);
        players.add(mp1);
    }
}
