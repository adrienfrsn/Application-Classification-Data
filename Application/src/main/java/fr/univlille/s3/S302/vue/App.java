package fr.univlille.s3.S302.vue;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import atlantafx.base.theme.Dracula;
import atlantafx.base.theme.PrimerLight;


/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    static Parent loadFXML(String fxml) throws IOException {
        Application.setUserAgentStylesheet(new Dracula().getUserAgentStylesheet());
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("UI"), 1280, 960);
        stage.setScene(scene);
        stage.show();
    }

}
