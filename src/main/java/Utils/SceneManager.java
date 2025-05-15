package Utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

public class SceneManager {

    private FXMLLoader loader;
    private String pageName;
    private String fxmlPath;
    private Stage stage;


    public SceneManager(String pageName, String fxmlPath, Stage stage){
        this.pageName = pageName;
        this.fxmlPath = fxmlPath;
        this.stage = stage;
        loader = new FXMLLoader(SceneManager.class.getResource("/".concat(fxmlPath)));
    }

    public void loadScene(){

        double height;
        double width;

        stage.getIcons().add(new Image(getClass().getResource("/img/logo.png").toString()));

        if(!stage.isMaximized()){
            width = stage.getWidth();
            height = stage.getHeight();
        }else{
            width = Screen.getPrimary().getBounds().getWidth();
            height = Screen.getPrimary().getBounds().getHeight();
        }


        try {
            Scene scene = new Scene(loader.load(), width, height);
            scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
            stage.setScene(scene);

            stage.setResizable(false);
            stage.setTitle(pageName);

            stage.show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public Object getController() {
        return loader.getController();
    }

    public FXMLLoader getLoader(){
        return loader;
    }
}
