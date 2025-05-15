package Controller;

import Utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class HeaderController {

    @FXML
    Button home;

    @FXML
    Button login;

    @FXML
    Button cart;


    @FXML
    public void initialize(){
        home.setGraphic(createIcon("home.svg",70,50));
        login.setGraphic(createIcon("login.svg",70,50));
        cart.setGraphic(createIcon("cart.svg",70,50));
    }

    public void goToHome(ActionEvent e){
        Stage stage = (Stage) (((Node)e.getSource()).getScene().getWindow());
        SceneManager manager = new SceneManager("Home - MysteryMeatFish","home.fxml",stage);
        manager.loadScene();
    }

    public void goToLogin(ActionEvent e){
        Stage stage = (Stage) (((Node)e.getSource()).getScene().getWindow());
        SceneManager manager = new SceneManager("Aggiungi Prodotto - MysteryMeatFish", "aggiungi.fxml",stage);
        manager.loadScene();

    }
    public void goToCart(ActionEvent e){
        Stage stage = (Stage) (((Node)e.getSource()).getScene().getWindow());
        SceneManager manager = new SceneManager("Carrello - MysteryMeatFish","cart.fxml",stage);
        manager.loadScene();
    }

    private ImageView createIcon(String fileName, double width, double height) {
        ImageView view = new ImageView(loadImage(fileName));
        view.setFitWidth(width);
        view.setFitHeight(height);
        view.setPreserveRatio(true);
        return view;
    }

    private Image loadImage(String name){
        String resource = "/img/".concat(name);
        System.out.println(resource);
        return new Image(getClass().getResource(resource).toString());
    }
}
