package service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class plantAPi {
    public void api() throws IOException, InterruptedException {
       HttpRequest request = HttpRequest.newBuilder()
               .uri(URI.create("https://house-plants.p.rapidapi.com/common/coralberry"))
               .header("X-RapidAPI-Key", "e3a6efcf20msh357c2c0f26d706dp1bb9fbjsn3c9ffec76d95")
               .header("X-RapidAPI-Host", "house-plants.p.rapidapi.com")
               .method("GET", HttpRequest.BodyPublishers.noBody())
               .build();
       HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
       System.out.println(response.body());
   }
}
