package Controller;

import Utils.DBEditor;
import Utils.Product;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ProductInfoController {

    private int id;

    @FXML private Label nome;
    @FXML private Label tipo;
    @FXML private Label prezzo;
    @FXML private Label prezzoSconto;
    @FXML private ImageView immagine;
    @FXML private Label descrizione;
    @FXML private Label quantity;

    public void setData(Product product) {
        id = product.getId();

        nome.setText(product.getNome());
        tipo.setText(product.getTipo());
        prezzo.setText(String.format("€ %.2f", product.getPrezzo()));

        // Rimuovo getStylesheets, uso setStyle per stile inline
        prezzo.setStyle("-fx-text-fill: blue;");

        if (product.getPrezzoSconto() != 0) {
            prezzoSconto.setText(String.format("€ %.2f", product.getPrezzoSconto()));
            prezzoSconto.setStyle("-fx-text-fill: orange; -fx-font-weight: bold;");
        } else {
            prezzoSconto.setText("");
        }

        immagine.setImage(product.getImmagine());
        descrizione.setText(product.getDescrizione());
    }

    @FXML
    public void remove() {
        boolean success = DBEditor.removeProduct(id);
        Platform.runLater(() -> {
            Alert alert = new Alert(success ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR);
            alert.setTitle(success ? "Successo" : "Errore");
            alert.setHeaderText(null);
            alert.setContentText(success ? "Prodotto rimosso con successo." : "Errore nella rimozione del prodotto.");
            alert.showAndWait();

            if (success) {
                // Qui potresti aggiungere logica per aggiornare la UI o tornare indietro
                // ad esempio disabilitare il pannello o ricaricare la lista prodotti
                nome.setText("");
                tipo.setText("");
                prezzo.setText("");
                prezzoSconto.setText("");
                descrizione.setText("");
                immagine.setImage(null);
            }
        });
    }
}
