package Controller;

import Objects.*;
import com.google.gson.stream.JsonReader;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.controlsfx.control.GridView;

import java.util.ArrayList;

public class HomeController {

    @FXML
    GridPane products;

    @FXML
    public void initialize(){
        ArrayList<Product> diocane = ProductSerializer.serialize(JSonReader.sendRequest("tutti")); // carica i prodotti

        int column = 0;
        int row = 0;

        for (int i = 0; i < diocane.size(); i++) {
            Product dioboia = diocane.get(i);
            Label laolao = new Label(dioboia.getNome());


            products.add(laolao, column, row);

            column++;
            if (column == 3) { // 3 colonne per riga
                column = 0;
                row++;
            }
        }
    }
}
