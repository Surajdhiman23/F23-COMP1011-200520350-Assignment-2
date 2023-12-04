package com.example.advancejavaassignment2;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;


public class GetApiResponse {
    private static String api="gwdkuMUAQR7DjUpL1n3eVg==oJy1GhIoBIKmUW3t";

//    public static ArrayList<Animal> getResponse(String name) throws IOException {
//        URL url = new URL("https://api.api-ninjas.com/v1/animals?name=" + name);
//        HttpURLConnection connection = null;
//        List<Animal> animalList = new ArrayList<>();
//        try {
//            connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestProperty("accept", "application/json");
//            connection.setRequestMethod("GET");
//            connection.setRequestProperty("accept", "application/json");
//            connection.setRequestProperty("X-Api-Key", api);
//
//            InputStream responseStream = connection.getInputStream();
//
//            byte[] responseBytes = responseStream.readAllBytes();
//            String response = new String(responseBytes);
//
//            JSONArray jsonArray = new JSONArray(response);
//            ArrayList<JSONObject> lst=new ArrayList<>();
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONObject jsonObject = jsonArray.getJSONObject(i);
//                lst.add(jsonObject);
//            }
//
//            connection.disconnect();
//            return lst;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//    }

    public static ArrayList<Animal> getResponse(String name) throws IOException {
        URL url = new URL("https://api.api-ninjas.com/v1/animals?name=" + name);
        HttpURLConnection connection = null;
        ArrayList<Animal> animalList = new ArrayList<>();
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            connection.setRequestMethod("GET");
            connection.setRequestProperty("accept", "application/json");
            connection.setRequestProperty("X-Api-Key", api);

            InputStream responseStream = connection.getInputStream();

            byte[] responseBytes = responseStream.readAllBytes();
            String response = new String(responseBytes);

            JSONArray jsonArray = new JSONArray(response);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Animal animal = new Animal(jsonObject);
                animalList.add(animal);
            }

            connection.disconnect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return animalList;
    }
}
