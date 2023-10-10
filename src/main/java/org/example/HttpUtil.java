package org.example;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class HttpUtil {
    private static final HttpClient CLIENT= HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();

        public static List<Todos> sendGetWithListOfResults3(URI uri) throws IOException,InterruptedException{

            HttpRequest request= HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();
            HttpResponse<String> response=CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
            List<Todos> todos =GSON.fromJson(response.body(), new TypeToken<List<Todos>>(){}.getType());
        //    System.out.println("response.statusCode() = " + response.statusCode() );
            return   todos;

    }
    public static List<Post> sendGetWithListOfResults2(URI uri) throws IOException,InterruptedException{

        HttpRequest request= HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        HttpResponse<String> response=CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
        List<Post> posts =GSON.fromJson(response.body(), new TypeToken<List<Post>>(){}.getType());
        //    System.out.println("response.statusCode() = " + response.statusCode() );
        return  posts;

    }
}

