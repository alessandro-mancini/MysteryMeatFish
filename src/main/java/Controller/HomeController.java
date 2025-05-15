package Controller;

import Utils.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;

public class HomeController {

    @FXML
    GridPane productsGrid;
    @FXML
    Button mysterybox;
    @FXML
    Button carne;
    @FXML
    Button pesce;
    @FXML
    Button salumi;
    @FXML
    Label labelProdotti;

    @FXML
    public void initialize(){
        int column = 0;
        int row = 0;

        mysterybox.setGraphic(createIcon("mysterybox.png",200,100));
        carne.setGraphic(createIcon("carne.png",200,100));
        pesce.setGraphic(createIcon("pesce.png",200,100));
        salumi.setGraphic(createIcon("salumi.png",200,100));
        labelProdotti.setVisible(false);

    }


    private ImageView createIcon(String fileName, double width, double height) {
        ImageView view = new ImageView(loadImage(fileName));
        view.setFitWidth(width);
        view.setFitHeight(height);
        view.setPreserveRatio(true);
        return view;
    }

    private Image loadImage(String name){
        return new Image(getClass().getResource("/img/".concat(name)).toString());
    }

    public void switchCategory(ActionEvent e){
        Button pressed = (Button) e.getSource();
        String category = pressed.getId();

        productsGrid.getChildren().clear();
        new Thread(() ->{
            mostraProdotti(ProductSerializer.serialize(ProductReader.sendRequest("tipo",category)));
            if(!labelProdotti.isVisible()){
                labelProdotti.setVisible(true);
            }
        }).start();

    }

    @FXML
    public void mostraProdotti(ArrayList<Product> products) {




        Platform.runLater(() -> {
            int column = 0;
            int row = 0;
            for (Product product : products) {

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/product-info.fxml"));

                VBox productCard = loader.load();
                ProductInfoController controller = loader.getController();
                controller.setData(product);

                productsGrid.add(productCard, column, row);

                column++;

                if (column == 3) { // 3 elementi per riga
                    column = 0;
                    row++;
                }

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        });
    }
}
