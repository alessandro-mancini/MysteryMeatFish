package Controller;

import Utils.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ProductInfoController {

    @FXML
    private Label nome;
    @FXML
    private Label tipo;
    @FXML
    private Label prezzo;
    @FXML
    private Label prezzoSconto;
    @FXML
    private ImageView immagine;

    public void setData(Product product){

        nome.setText(product.getNome());
        tipo.setText(product.getTipo());
        prezzo.setText(String.valueOf(product.getPrezzo()));
        prezzo.getStylesheets().add("text-primary");
        if (product.getPrezzoSconto() != 0) {
            // prezzo.setStyle("-fx-strikethrough: true;");
            prezzoSconto.setText("€".concat(String.valueOf(product.getPrezzoSconto())));
            prezzoSconto.getStylesheets().add("text-warning");
        }
        immagine.setImage(product.getImmagine());
    }

    public void addToCart(){

    }

}
