package edu.vanier.template.ui;

import edu.vanier.template.controllers.MainAppFXMLController;
import edu.vanier.template.controllers.SceneController;
import edu.vanier.template.controllers.ManagePlaylists;
import edu.vanier.template.controllers.ManageSongs;
import edu.vanier.template.helpers.FxUIHelper;
import java.io.IOException;
import java.util.logging.Level;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is a JavaFX project template to be used for creating GUI applications.
 *
 * The JavaFX GUI framework (version: 22.0.2) is linked to this project in the
 * build.gradle file.
 * @link: https://openjfx.io/javadoc/22/
 * @see: /Build Scripts/build.gradle
 * @author frostybee.
 */
public class MainApp extends Application {

    // The FXML file name of the primary scene.
    public static final String MAINAPP_SCENE = "MainApp_layout";
    // The FXML file name of the secondary scene.
    public static final String ManagePlaylists = "ManagePlaylists";
    public static final String ManageSongs = "ManageSongs";
    private final static Logger logger = LoggerFactory.getLogger(MainApp.class);
    private static Scene scene;
    private static SceneController sceneController;

    @Override
    public void stop() {
        // TODO: 
        // Here, we need to perform teardown operations such as stopping running 
        // animation, etc.
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            logger.info("Bootstrapping the application...");
            // Load the scene of the primary stage.
            Parent root = FxUIHelper.loadFXML(MAINAPP_SCENE, new MainAppFXMLController());
            scene = new Scene(root);
            // Add the primary scene to the scene-switching controller.
            sceneController = new SceneController(scene);
            sceneController.addScene(MAINAPP_SCENE, root);
            primaryStage.setScene(scene);
            primaryStage.sizeToScene();
            primaryStage.setTitle("An FX Project Template!");
            // Request putting this appliation's main window on top of other 
            // already-opened windows upon launching t he app.
            primaryStage.setAlwaysOnTop(true);
            primaryStage.show();
            primaryStage.setAlwaysOnTop(false);
        } catch (IOException ex) {
            logger.error(ex.getMessage(), ex);
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public static void switchScene(String fxmlFileName) {
        try {
            if (fxmlFileName.equals(MAINAPP_SCENE)) {
                sceneController.activateScene(fxmlFileName);

            } else if (fxmlFileName.equals(ManagePlaylists)) {
                if (!sceneController.sceneExists(fxmlFileName)) {
                    ManagePlaylists controller = new ManagePlaylists();
                    Parent root = FxUIHelper.loadFXML(fxmlFileName, controller);
                    sceneController.addScene(ManagePlaylists, root);
                }
                sceneController.activateScene(fxmlFileName);
            } else if (fxmlFileName.equals(ManageSongs)) {
                if (!sceneController.sceneExists(fxmlFileName)) {
                    ManageSongs controller = new ManageSongs();
                    Parent root = FxUIHelper.loadFXML(fxmlFileName, controller);
                    sceneController.addScene(ManageSongs, root);
                }
                sceneController.activateScene(fxmlFileName);
            }
            //TODO: You can register or activate additional scenes here, 
            //      based on the logic used to add the secondary scene (as shown above).            
        } catch (IOException ex) {
            logger.error(ex.getMessage(), ex);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
