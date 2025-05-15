package Utils;

import okhttp3.*;
import org.json.JSONObject;
import java.util.Objects;

public class DBEditor {
    private static final String BASE_URL = "https://mysterymeatfish.altervista.org/java/edit.php";
    private static final OkHttpClient client = new OkHttpClient();
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static boolean addProduct(String nome, String descrizione, double prezzo) {
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("action", "add");
        jsonBody.put("nome", nome);
        jsonBody.put("descrizione", descrizione);
        jsonBody.put("prezzo", prezzo);

        return executeRequest(jsonBody);
    }

    public static boolean removeProduct(int id) {
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("action", "remove");
        jsonBody.put("id", id);  // Cambiato da "remove" a "id"

        return executeRequest(jsonBody);
    }


    private static boolean executeRequest(JSONObject jsonBody) {
        RequestBody body = RequestBody.create(jsonBody.toString(), JSON);

        Request request = new Request.Builder()
                .url(BASE_URL)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                System.err.println("HTTP error code: ".concat(response.code());
                return false;
            }

            String responseBody = Objects.requireNonNull(response.body()).string();
            System.out.println(responseBody);
            System.out.println("Response from server: ".concat(responseBody)); // DEBUG

            JSONObject jsonResponse = new JSONObject(responseBody);

            boolean success = jsonResponse.optBoolean("success", false);
            String message = jsonResponse.optString("message", "Nessun messaggio");

            if (!success) {
                System.err.println("Errore dal server: ".concat(message));
            }

            return success;

        } catch (Exception e) {
            System.err.println("Eccezione durante la richiesta:");
            e.printStackTrace();
            return false;
        }
    }
}
