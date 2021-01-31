package prj.pedrowindisch.empregospcd.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import okhttp3.*;

import java.io.IOException;

public class EmpregosUtil {
    private static final OkHttpClient httpClient = new OkHttpClient();

    public static JsonArray fetchJobsList(String location) throws IOException {
        String baseApiUrl = System.getProperty("API_BASE_URL");
        String apiKey = System.getProperty("API_KEY");

        JsonObject requestBodyJson = new JsonObject();
        requestBodyJson.addProperty("keywords", "pcd");
        requestBodyJson.addProperty("location", location);

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(requestBodyJson.toString(), JSON);

        Request request = new Request.Builder()
                // api url = https://br.jooble.org/api/<API KEY>
                .url(baseApiUrl + apiKey)
                .addHeader("Content-Type", "application/json")
                .post(body)
                .build();

        try(Response response = httpClient.newCall(request).execute()) {
            if(!response.isSuccessful()) throw new IOException("API request has failed: " + response);

            String responseAsString = response.body().string();
            JsonObject jsonResponse = new Gson().fromJson(responseAsString, JsonObject.class);

            return jsonResponse.getAsJsonArray("jobs");
        }
    }
}
