package service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.simple.JSONObject;
public class plantAPi {
    public static void api(){
       try {
           HttpRequest request = HttpRequest.newBuilder()
                   .uri(URI.create("https://house-plants2.p.rapidapi.com/"))
                   .header("X-RapidAPI-Key", "e3a6efcf20msh357c2c0f26d706dp1bb9fbjsn3c9ffec76d95")
                   .header("X-RapidAPI-Host", "house-plants2.p.rapidapi.com")
                   .method("GET", HttpRequest.BodyPublishers.noBody())
                   .build();
           HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
           //System.out.println(response.body());
           System.out.println("API connected");
       }
       catch (Exception e) {
           System.out.println("API failed");
       }
    }
    public static JSONObject getAll() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://house-plants2.p.rapidapi.com/all"))
                .header("X-RapidAPI-Key", "5ff00148a3msh2916b092724ce69p12c27djsn654991e583df")
                .header("X-RapidAPI-Host", "house-plants2.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    return (JSONObject) response;
    }

}
