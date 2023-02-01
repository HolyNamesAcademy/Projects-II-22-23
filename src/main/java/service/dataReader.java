package service;
import java.io.*;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class dataReader {
    public static speciesInfo jsonReaderSinglePlant(JSONObject apiInfo) throws ParseException {
        JSONParser reader = new JSONParser();
        JSONObject apiData = (JSONObject)reader.parse(String.valueOf(apiInfo));
        speciesInfo speciesData = new speciesInfo();
        speciesData.setCommonName((String)apiData.get("Common name(fr.)"));
        speciesData.setLatinName((String)apiData.get("Latin name"));
        speciesData.setFamily((String)apiData.get("Family"));
        speciesData.setOrigin((String)apiData.get("Origin"));
        speciesData.setClimate((String)apiData.get("Climat"));
        speciesData.setTempMax((double [])apiData.get("Temperature Max"));
        speciesData.setTempMin((double [])apiData.get("Temperature Min"));

        //fyi 'climat' is not a typo -- this is what the api has listed as the key

        speciesData.setIdealLight((String)apiData.get("Light ideal"));
        speciesData.setToleratedLight((String)apiData.get("Light tolered"));

        //again not a typo on our end -- how the api has the key written

        speciesData.setWatering((String)apiData.get("Watering"));
        speciesData.setPests((String)apiData.get("Insects"));
        speciesData.setDiseases((String)apiData.get("Disease"));
        speciesData.setImgUrl((String)apiData.get("img"));
        speciesData.setDescription((String)apiData.get("Description"));
        return speciesData;
    }
    public static ArrayList<speciesInfo> jsonReaderGetAll(JSONObject apiOutput) throws ParseException {
        JSONParser reader = new JSONParser();
        JSONObject apiData = (JSONObject)reader.parse(String.valueOf(apiOutput));
        int size = apiData.size();
        speciesInfo plant = new speciesInfo();
        ArrayList <speciesInfo> plantData = new ArrayList<>();
        for(int i = 0; i < size; i++){
           plant = jsonReaderSinglePlant((JSONObject) apiData.get(i));
           plantData.add(plant);
        }
        return plantData;
    }
}
