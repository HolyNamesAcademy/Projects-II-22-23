package service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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

}
