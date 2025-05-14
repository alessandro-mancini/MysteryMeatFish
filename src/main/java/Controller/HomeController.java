package Controller;

import Utils.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.ArrayList;

public class HomeController {

    @FXML
    GridPane productsGrid;

    @FXML
    public void initialize(){
        ArrayList<Product> diocane = ProductSerializer.serialize(JSonReader.sendRequest("tutti")); // carica i prodotti

        int column = 0;
        int row = 0;

        mostraProdotti(diocane);

    }


    public void switchCategory(ActionEvent e){
        Button pressed = (Button) e.getSource();
        String category = pressed.getText();

        mostraProdotti(ProductSerializer.serialize(JSonReader.sendRequest(category)));
    }

    @FXML
    public void mostraProdotti(ArrayList<Product> products) {

        productsGrid.getChildren().clear();

        int column = 0;
        int row = 0;

        for (Product product : products) {


            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/product-info.fxml"));

                HBox productCard = (HBox) loader.load();
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
    }
}
