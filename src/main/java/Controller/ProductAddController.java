package Controller;

import Utils.DBEditor;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

public class ProductAddController {

    @FXML
    private TextField nomeField;

    @FXML
    private ComboBox<String> tipoComboBox;

    @FXML
    private TextField prezzoField;

    @FXML
    private TextField prezzoScontoField;

    @FXML
    private TextArea descrizioneArea;

    @FXML
    private void handleAddProduct() {
        String nome = nomeField.getText().trim();
        String tipo = tipoComboBox.getValue();
        String prezzoText = prezzoField.getText().trim();
        String prezzoScontoText = prezzoScontoField.getText().trim();
        String descrizione = descrizioneArea.getText().trim();

        // Validazioni
        if (nome.isEmpty() || tipo == null || prezzoText.isEmpty() || descrizione.isEmpty()) {
            showAlert(AlertType.ERROR, "Errore", "Tutti i campi obbligatori devono essere compilati.");
            return;
        }

        double prezzo;
        double prezzoSconto = 0;

        try {
            prezzo = Double.parseDouble(prezzoText);
            if (!prezzoScontoText.isEmpty()) {
                prezzoSconto = Double.parseDouble(prezzoScontoText);
            }
        } catch (NumberFormatException e) {
            showAlert(AlertType.ERROR, "Errore", "Prezzo e prezzo scontato devono essere numeri validi.");
            return;
        }

        boolean success = DBEditor.addProduct(nome, tipo, descrizione, prezzo, prezzoSconto);

        if (success) {
            showAlert(AlertType.INFORMATION, "Successo", "Prodotto aggiunto con successo.");
            clearFields();
        } else {
            showAlert(AlertType.ERROR, "Errore", "Errore durante l'aggiunta del prodotto.");
        }
    }

    private void showAlert(AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        nomeField.clear();
        tipoComboBox.getSelectionModel().clearSelection();
        prezzoField.clear();
        prezzoScontoField.clear();
        descrizioneArea.clear();
    }
}

