package Utils;
import com.google.gson.annotations.SerializedName;

import javafx.scene.image.Image;

public class Product {
    @SerializedName("tipo")
    private String tipo;
    @SerializedName("nome")
    private String nome;
    @SerializedName("prezzo")
    private String prezzo;
    @SerializedName("prezzo_sconto")
    private String prezzoSconto;
    @SerializedName("immagine")
    private String immagine;
    @SerializedName("descrizione")
    private String descrizione;


    // Getter e Setter
    public String getTipo() {
        return tipo;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrezzo() {
        return Double.parseDouble(prezzo);
    }

    public String getDescrizione(){
        return descrizione;
    }



    public double getPrezzoSconto() {
        if(prezzoSconto != null){
            return Double.parseDouble(prezzoSconto);
        }
        return 0;
    }


    public Image getImmagine() {
        return new Image("https://mysterymeatfish.altervista.org/img/food/".concat(immagine));
    }
}
