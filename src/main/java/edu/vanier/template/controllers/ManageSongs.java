/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.vanier.template.controllers;

import SongObject.AddSong;
import SongObject.Song;
import edu.vanier.template.ui.MainApp;
import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author theli
 */
public class ManageSongs {
    private final static Logger logger = LoggerFactory.getLogger(ManagePlaylists.class);

    @FXML
    Button btnSwitchScene;

    @FXML
    Button btnPlayPause;
    
    @FXML
    ListView<Song> lvSongs;
    
    @FXML
    ImageView ivSong;
    
    @FXML
    Label lbName, lbArtist;
    
    int index = 0;//index of the currently selected song in the list of songs
    
    String PlayPause = "paused";
    
    @FXML
    public void initialize() {
        initializeListView();
        buttons();
        btnPlayPause.setVisible(false);
    }
    
    public void buttons(){
        btnSwitchScene.setOnAction((event)->{            
            loadPrimaryScene(event);
        });
        
        btnPlayPause.setOnAction((event)->{
            
          if(PlayPause.equals("paused")){//when the animation is currently paused
            // ivPlayPause.setImage(new Image("/Images/pause.png"));
             PlayPause = "playing";//now the animation is playing
             
              AddSong.players.get(index).play();
          }
          else if(PlayPause.equals("playing")){//when the animation is currently playing
            // ivPlayPause.setImage(new Image("/Images/play.png"));
             PlayPause = "paused";//now the animation is paused
             
             AddSong.players.get(index).pause();
          }
            
        });
    }
    public void initializeListView(){   
       ObservableList<Song> observableSongs = FXCollections.observableArrayList(AddSong.songs);
       lvSongs.setItems(observableSongs);
        
       lvSongs.setCellFactory(param -> new ListCell<Song>() {
       @Override
       protected void updateItem(Song song, boolean empty) {
        super.updateItem(song, empty);

        if (empty || song == null) {
            setText(null);
        } else {
            setText(song.toString());
            index = song.getIndex();
            setStyle("-fx-font-size: 18px; -fx-padding: 12px;");
            
            setOnMouseClicked((event)->{
               btnPlayPause.setVisible(true);
               ivSong.setImage(new Image(song.getImagePath()));
               lbName.setText(song.getName());
               lbArtist.setText(song.getArtist());
            });
            
            
        }
     }
    });
    }

    private void loadPrimaryScene(Event e) {
        MainApp.switchScene(MainApp.MAINAPP_SCENE);
    }
    
}
