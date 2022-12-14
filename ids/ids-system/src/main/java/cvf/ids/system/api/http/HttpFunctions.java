package cvf.ids.system.api.http;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

import static cvf.core.api.message.MessageSerializer.serialize;

/**
 * Utility methods for HTTP requests.
 */
public class HttpFunctions {

    public static Response postJson(String url, Object message) {
        var requestBody = RequestBody.create(serialize(message), MediaType.get("application/json"));
        var httpRequest = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        var httpClient = new OkHttpClient.Builder().build();
        try {
            var response = httpClient.newCall(httpRequest).execute();
            if (404 == response.code()) {
                throw new RuntimeException("Unexpected callback received: " + url);
            } else if (!response.isSuccessful()) {
                throw new RuntimeException("Unexpected response code: " + response.code());
            }
            return response;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private HttpFunctions() {
    }
}
