package Utils;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Objects;

public class DBEditor {
    private static final String BASE_URL = "https://mysterymeatfish.altervista.org/java/";
    private static final OkHttpClient client = new OkHttpClient();
    private static final MediaType JSON = MediaType.parse("application/json");

    public static boolean addProduct(String tipo, String nome, String descrizione, double prezzo, double prezzoSconto, String immagine) {
        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("action", "add");
            jsonBody.put("tipo", tipo);
            jsonBody.put("nome", nome);
            jsonBody.put("descrizione", descrizione);
            jsonBody.put("prezzo", prezzo);
            jsonBody.put("prezzo_sconto", prezzoSconto != 0 ? prezzoSconto : JSONObject.NULL);
            jsonBody.put("immagine", immagine);

            JSONArray response = executeRequest(jsonBody, "edit.php");

            if (response == null) {
                System.err.println("Errore nella risposta del server");
                return false;
            }

            return response.getJSONObject(0).optBoolean("success", false);

        } catch (Exception e) {
            System.err.println("Errore nella creazione della richiesta addProduct");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean removeProduct(int id) {
        JSONObject jsonBody = new JSONObject();
        try {

            jsonBody.put("action", "remove");
            jsonBody.put("id_prodotto", id);

            JSONArray response = executeRequest(jsonBody,"edit.php");

            if(response == null){
                System.err.println("Errore nella risposta del server");
                return false;
            } else {
                return true;
            }

        } catch (Exception e) {
            System.err.println("Errore nella creazione della richiesta removeProduct");
            e.printStackTrace();
            return false;
        }
    }

    private static JSONArray executeRequest(JSONObject jsonBody, String file) {
        RequestBody body = RequestBody.create(jsonBody.toString(), JSON);

        Request request = new Request.Builder()
                .url(BASE_URL + file)
                .post(body)
                .addHeader("CONTENT_TYPE", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                System.err.println("HTTP error code: " + response.code());
                return null;
            }

            String responseBody = Objects.requireNonNull(response.body()).string();

            // Se la risposta è un array, la ritorniamo direttamente
            if (responseBody.trim().startsWith("[")) {
                return new JSONArray(responseBody);
            } else {
                // La risposta è un oggetto: lo analizziamo
                JSONObject jsonResponse = new JSONObject(responseBody);
                boolean success = jsonResponse.optBoolean("success", false);
                String message = jsonResponse.optString("message", "Nessun messaggio");

                if (!success) {
                    System.err.println("Errore dal server: " + message);
                }


                // Creiamo un array fittizio solo per compatibilità
                JSONArray jsonArray = new JSONArray();
                jsonArray.put(jsonResponse);
                return jsonArray;
            }

        } catch (Exception e) {
            System.err.println("Eccezione durante la richiesta:");
            e.printStackTrace();
            return null;
        }
    }


    public static JSONArray searchProduct(String nome, String tipo) {
        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("nome", nome);
            jsonBody.put("tipo", tipo);

            return executeRequest(jsonBody, "search.php");

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}