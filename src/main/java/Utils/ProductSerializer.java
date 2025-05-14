package Utils;

import com.google.gson.*;

import java.util.ArrayList;

public class ProductSerializer {

    public static ArrayList<Product> serialize(String jsonBody) {
        ArrayList<Product> prodotti = new ArrayList<>();
        try {
            // Parsiamo la stringa JSON come un array
            JsonArray jsonArray = JsonParser.parseString(jsonBody).getAsJsonArray();

            for (JsonElement element : jsonArray) {
                // Deserializziamo ogni oggetto JSON come un oggetto Product
                Product prodotto = new Gson().fromJson(element, Product.class);
                prodotti.add(prodotto);
            }

        } catch (Exception e) {
            throw new RuntimeException(e); // Con e.printStackTrace mi dava warning
        }

        return prodotti;
    }
}


