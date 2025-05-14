package Controller;

import Utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class HeaderController {


    public void goToHome(ActionEvent e){
        Stage stage = (Stage) (((Node)e.getSource()).getScene().getWindow());
        SceneManager manager = new SceneManager("Home - MysteryMeatFish","home.fxml",stage);
        manager.loadScene();
    }
    public void goToRegister(ActionEvent e){
        Stage stage = (Stage) (((Node)e.getSource()).getScene().getWindow());
        SceneManager manager = new SceneManager("Registrati - MysteryMeatFish","register.fxml",stage);
        manager.loadScene();

    }
    public void goToLogin(ActionEvent e){
        Stage stage = (Stage) (((Node)e.getSource()).getScene().getWindow());
        SceneManager manager = new SceneManager("Accedi - MysteryMeatFish","login.fxml",stage);
        manager.loadScene();

    }
    public void goToCart(ActionEvent e){
        Stage stage = (Stage) (((Node)e.getSource()).getScene().getWindow());
        SceneManager manager = new SceneManager("Carrello - MysteryMeatFish","cart.fxml",stage);
        manager.loadScene();
    }
}
