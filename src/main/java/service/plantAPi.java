package service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONArray;
import org.json.JSONObject;
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
    public static JSONArray getAll() throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://house-plants2.p.rapidapi.com/all-lite"))
                .header("X-RapidAPI-Key", "71a3a60ddemshbbd559ac60334e5p1913bbjsnbea55ca40435")
                .header("X-RapidAPI-Host", "house-plants2.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println(response.body());
        JSONArray jsonObj = new JSONArray(String.valueOf(response.body()));
        return jsonObj;
    }

}
