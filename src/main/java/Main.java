import Controller.SceneManager;
import Objects.JSonReader;
import Objects.ProductSerializer;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;


public class Main extends Application {

    @Override
    public void start(Stage stage){
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/".concat("home.fxml")));
            Scene scene = new Scene(loader.load());
            scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
            stage.setScene(scene);

            System.out.println(stage.isMaximized());
            stage.setMaximized(true);
            stage.setResizable(false);
            stage.setTitle("porcodio");

            System.out.println(ProductSerializer.serialize(JSonReader.sendRequest("Carne")));

            stage.show();
            // SceneManager.loadScene("Home - MysteryMeatFish","home.fxml",primaryStage);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}


