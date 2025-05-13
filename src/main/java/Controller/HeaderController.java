package Controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class HeaderController {


    public void goToHome(ActionEvent e){
        Stage stage = (Stage) (((Node)e.getSource()).getScene().getWindow());
        SceneManager.loadScene("Home - MysteryMeatFish","home.fxml",stage);
    }
    public void goToRegister(ActionEvent e){
        Stage stage = (Stage) (((Node)e.getSource()).getScene().getWindow());
        SceneManager.loadScene("Registrati - MysteryMeatFish","register.fxml",stage);

    }
    public void goToLogin(ActionEvent e){
        Stage stage = (Stage) (((Node)e.getSource()).getScene().getWindow());
        SceneManager.loadScene("Accedi - MysteryMeatFish","login.fxml",stage);

    }
    public void goToCart(ActionEvent e){
        Stage stage = (Stage) (((Node)e.getSource()).getScene().getWindow());
        SceneManager.loadScene("Carrello - MysteryMeatFish","cart.fxml",stage);
    }
}
