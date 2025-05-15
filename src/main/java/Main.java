import Utils.DBEditor;
import Utils.SceneManager;
import javafx.application.Application;

import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage stage){
        try {

            stage.setMaximized(true);
            SceneManager manager = new SceneManager("Home - MysteryMeatFish","home.fxml",stage);
            manager.loadScene();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}


