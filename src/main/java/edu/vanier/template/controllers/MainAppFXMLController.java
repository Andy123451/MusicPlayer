package edu.vanier.template.controllers;

import SongObject.AddSong;
import edu.vanier.template.ui.MainApp;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.kordamp.ikonli.fontawesome5.FontAwesomeRegular;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FXML controller class for the primary stage scene.
 *
 * @author frostybee
 */
public class MainAppFXMLController {

    private final static Logger logger = LoggerFactory.getLogger(MainAppFXMLController.class);

    @FXML
    Button btnSongs;
    @FXML
    Button btnPlaylists;

    @FXML
    public void initialize() {
        AddSong.addSongs();
        logger.info("Initializing MainAppController...");
        btnSongs.setOnAction(this::Songs);
        btnPlaylists.setOnAction(this::Playlists);
        addFontIcons();
    }

    private void Songs(Event e) {
        MainApp.switchScene(MainApp.ManageSongs);
    }

    private void Playlists(Event e) {
        MainApp.switchScene(MainApp.ManagePlaylists);
    }

    
    private void addFontIcons() {
        /*// @see: https://kordamp.org/ikonli/cheat-sheet-fontawesome5.html
        FontIcon playIcon = new FontIcon(FontAwesomeRegular.SHARE_SQUARE);
        // Alternatively, Material Design icon set can be used as follows.
        // @see: https://kordamp.org/ikonli/#_materialdesign2_latest
        // @see: https://kordamp.org/ikonli/cheat-sheet-medicons.html
        //FontIcon searchIcon = new FontIcon(MaterialDesignA.ATOM);
        btnPlay.setGraphic(playIcon);
        btnPlay.setStyle("-fx-font-size: 16px;");
        FontIcon switchIcon = new FontIcon(MaterialDesignA.ATOM);
        btnSwitchScene.setGraphic(switchIcon);
        btnSwitchScene.setStyle("-fx-font-size: 16px;");*/
    }
}
