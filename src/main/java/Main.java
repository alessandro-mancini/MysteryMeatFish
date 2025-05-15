import Utils.LoginChecker;
import Utils.SceneManager;
import javafx.application.Application;

import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage stage){
        try {
            /*FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/".concat("home.fxml")));
            Scene scene = new Scene(loader.load());
            scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.setResizable(false);
            stage.setTitle("porcodio");


            stage.show();*/

            boolean diofiga = LoginChecker.check("alessandro","Password33");

            System.out.println(diofiga);
            stage.setMaximized(true);
            SceneManager manager = new SceneManager("Home - MysteryMeatFish","home.fxml",stage);
            manager.loadScene();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}


