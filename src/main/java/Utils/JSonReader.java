package Utils;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class JSonReader {

    public static String sendRequest(String param){

        OkHttpClient client = new OkHttpClient();

        HttpUrl url;


        url = new HttpUrl.Builder()
            .scheme("https")
            .host("mysterymeatfish.altervista.org")
            .addPathSegment("java")
            .addPathSegment("prodotti.php")
            .addQueryParameter("tipo", param)
            .build();

        System.out.println(url);

        // Costruisce la richiesta HTTP GET
        Request request = new Request.Builder()
                .url(url)
                .build();


        try {
            Response response = client.newCall(request).execute();
            assert response.body() != null;
            return response.body().string();
        } catch (Exception e) {
            return null;
        }

    }


}


