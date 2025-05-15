package Utils;

import okhttp3.*;

public class ProductReader {

    public static String sendRequest(String action, String param) {


        OkHttpClient client = new OkHttpClient();

        HttpUrl url;


        url = new HttpUrl.Builder()
                .scheme("https")
                .host("mysterymeatfish.altervista.org")
                .addPathSegment("java")
                .addPathSegment("prodotti.php")
                .addQueryParameter(action, param)
                .build();

        System.out.println(url);

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


