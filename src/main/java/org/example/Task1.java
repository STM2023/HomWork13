package org.example;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.net.URISyntaxException;

public class Task1 {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        String uri="https://jsonplaceholder.typicode.com/users";
        String uriName="https://jsonplaceholder.typicode.com/users?username=";
        int id=1;
        String userName="Elwyn.Skiles";

        String jsonUser = "{ \"name\": \"Iren\",\n" +
                "    \"username\": \"Alekseenko\",\n" +
                "    \"email\": \"IrenAl@ukr.net\",\n" +
                "    \"address\": {\n" +
                "      \"street\": \"Sich\",\n" +
                "      \"suite\": \"Apt. 55\",\n" +
                "      \"city\": \"Dnepr\",\n" +
                "      \"zipcode\": \"92998-3874\",\n" +
                "      \"geo\": {\n" +
                "        \"lat\": \"37.3159\",\n" +
                "        \"lng\": \"81.1496\"\n" +
                "      }\n" +
                "    }, \n" +
                "  \"phone\": \"3-888-736-8031 x56442\",\n" +
                "  \"website\": \"hildegard.org\",\n" +
                "\"company\": {\n" +
                "\"name\": \"OOO AAA\",\n" +
                "\"catchPhrase\": \"Multi-layered client-server neural-net\",\n" +
                "\"bs\": \"harness real-time e-markets\"\n" +
                "      }\n" +
                "    } \n" ;

////task1_1 -создание нового объекта
        HttpRequest httpRequestCREATE=HttpRequest.newBuilder(new URI(uri))
                .POST(HttpRequest.BodyPublishers.ofString(jsonUser))
                .header("Content-type","application/json")
                .build();

        HttpClient httpClientCREATE = HttpClient.newHttpClient();
        HttpResponse<String> responseCREATE= httpClientCREATE.send(httpRequestCREATE, HttpResponse.BodyHandlers.ofString());
        printTask1(responseCREATE,"task1_1   створення нового об'єкта");

////task1_2 -обновление объекта  //baseUriId))
        HttpRequest httpRequestNew=HttpRequest.newBuilder(new URI(String.format("%s/%d",uri,id)) )
                .PUT(HttpRequest.BodyPublishers.ofString(jsonUser))
                .header("Content-type","application/json")
                .build();

        HttpClient httpClientNew = HttpClient.newHttpClient();
        HttpResponse<String> responseNew= httpClientNew.send(httpRequestNew, HttpResponse.BodyHandlers.ofString());
        printTask1(responseNew,"task1_2   оновлення об'єкту  id=1");

////task1_3 -удаление объекта  //baseUriId))
        HttpRequest deleteRequest = HttpRequest.newBuilder(new URI(String.format("%s/%d",uri,id)) )
                .DELETE()
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> send = httpClient.send(deleteRequest, HttpResponse.BodyHandlers.ofString());
        printTask1(send,"task1_3  видалення об'єкта id=1");

////task1_4 - получение информации обо всех пользователях
        HttpRequest httpRequest=HttpRequest.newBuilder(new URI(uri))
                .GET()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpClient httpClient1 = HttpClient.newHttpClient();
        HttpResponse<String> response= httpClient1.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        printTask1(response,"task1_4  отримання інформації про всіх користувачів");

        //task1_5 - получение информации о пользователе с определенным id
        HttpRequest httpRequestId=HttpRequest.newBuilder(new URI(String.format("%s/%d",uri,id)))
                .GET()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpClient httpClientId = HttpClient.newHttpClient();
        HttpResponse<String> responseId= httpClientId.send(httpRequestId, HttpResponse.BodyHandlers.ofString());
        printTask1(responseId,"task1_5   отримання інформації про користувача за id=1");

        //task1_6 - получение информации о пользователе с опредленным userName
        HttpRequest httpRequestUsername=HttpRequest.newBuilder(new URI(uriName+userName))
                .GET()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpClient httpClientUsername = HttpClient.newHttpClient();
        HttpResponse<String> responsetUsername= httpClientUsername.send( httpRequestUsername, HttpResponse.BodyHandlers.ofString());
        printTask1(responsetUsername,"task1_6  отримання інформації про користувача за username=\"Elwyn.Skiles\"");

    }
    private static void printTask1(HttpResponse<String> response,String nameTask) {
        System.out.println(nameTask);
        System.out.println("response.statusCode() = "+response.statusCode());
        System.out.println("response.body()  = "+response.body());
        System.out.println("**********************************************************\n");
    }
}
