package Controller;

import Utils.DBEditor;
import Utils.Product;
import Utils.ProductReader;
import Utils.ProductSerializer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class SearchController {

    public GridPane productsGrid;
    public Label noResultsLabel;
    @FXML
    private TextField searchField;

    @FXML
    private ComboBox typeFilter;


    @FXML

    public void handleSearch() {
        String tipo = (typeFilter.getValue() == null) ? null : typeFilter.getValue().toString();
        String nome = searchField.getText();

        ArrayList<Product> products = ProductSerializer.serialize(DBEditor.searchProduct(nome,tipo).toString());

        productsGrid.getChildren().clear();  // Pulisci la griglia prima di aggiungere nuovi elementi


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

                    if (column == 3) {
                        column = 0;
                        row++;
                    }

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }


    public void handleResetFilters() {

    }

}
