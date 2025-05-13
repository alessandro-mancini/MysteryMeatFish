package Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.awt.*;

public class SceneManager {

    public static void loadScene(String name, String fxmlPath, Stage stage){

        double width = Screen.getPrimary().getBounds().getWidth();
        double height = Screen.getPrimary().getBounds().getHeight();

        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/".concat(fxmlPath)));
            Scene scene = new Scene(loader.load(), width, height);
            scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
            stage.setScene(scene);

            System.out.println(stage.isMaximized());
            stage.setResizable(false);
            stage.setTitle(name);

            stage.show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public Object getController(String fxmlPath) {
        return (new FXMLLoader(getClass().getResource(fxmlPath))).getController();
    }
}
