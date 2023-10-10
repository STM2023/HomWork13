package org.example;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.*;
import java.util.List;

public class Task2 {
  //  private static final String GET_POST_URI = "https://jsonplaceholder.typicode.com/posts/10/comments";
     private static final int X=1;

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        //int X = 1; //  де Х - id користувача,
        String uriIdPost ="https://jsonplaceholder.typicode.com/users/"+X+"/posts";
        int Y = 1;  // Y -  номер посту.( пост з найбільшим id.)

        final List<Post> posts = HttpUtil.sendGetWithListOfResults2(URI.create(uriIdPost));
        for (Post o: posts ) {
            if (o.getId() > Y) {
                Y=o.getId();
                //System.out.println(o );
            }
        }

        String uriPost = "https://jsonplaceholder.typicode.com/posts/"+Y+"/comments";
       // Файл повинен називатись user-X-post-Y-comments.json, де Х - id користувача, Y - номер посту.
        String postPath = "user-" + X + "-post-" + Y + "-comments.json";

        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(uriPost))
                .GET()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpClient httpClient1 = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient1.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println("task2");
        System.out.println("response.statusCode() = " + response.statusCode() );
        System.out.println("response.uri()  = "+response.uri());
        //   System.out.println("response.body()  = "+response.body());

        try (PrintWriter out = new PrintWriter(new FileWriter(postPath))) {
            out.write(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}







