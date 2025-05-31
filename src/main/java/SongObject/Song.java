/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SongObject;

/**
 *
 * @author theli
 */
public class Song {
    
    String name;
    String artist;
    String songPath;
    String imagePath;
    int length;
    String duration;
    int min = 0;
    int index;//the index of the song in the list of all songs added
    
    public Song(String name, String artist, String songPath, String imagePath, int length, int index){
      this.name = name;
      this.artist = artist;
      this.songPath = songPath;
      this.imagePath = imagePath;
      this.length = length;
      this.index = index;
    }

    private void time(){
      
      while(length>=60){
         length = length - 60;
         min++;
      }
      
      if(length>=10)duration = min + ":" + length;
      else{duration = min + ":0" + length;}
    }
    
    @Override
    public String toString() {
        time();
      return name + "  -  " + artist + " " + duration;
    }
    
    public int getIndex(){
        return index;
    }
    
    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getSongPath() {
        return songPath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public double getLength() {
        return length;
    }
}
