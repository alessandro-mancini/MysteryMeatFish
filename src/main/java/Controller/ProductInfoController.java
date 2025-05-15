package Controller;

import Utils.Product;
import javafx.event.ActionEvent;
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
    @FXML
    private Label descrizione;

    @FXML
    private Label quantity;

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
        descrizione.setText(product.getDescrizione());

    }

    public void addToCart(){

    }

    public void increase(ActionEvent e){
        int quantita = Integer.parseInt(quantity.getText());
        if(quantita < 50){
            quantity.setText(String.valueOf(quantita + 1));
        }
    }

    public void decrease(ActionEvent e){
        int quantita = Integer.parseInt(quantity.getText());
        if(quantita > 1){
            quantity.setText(String.valueOf(quantita - 1));
        }
    }

}
