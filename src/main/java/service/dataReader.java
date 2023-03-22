package service;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;


public class dataReader {
    public static speciesInfo jsonReaderSinglePlant(JSONObject apiData){
        System.out.print(apiData);
        speciesInfo speciesData = new speciesInfo();
        speciesData.setCommonName(String.valueOf(apiData.get("Common name")));
        speciesData.setLatinName(String.valueOf(apiData.get("Latin name")));
        speciesData.setFamily(String.valueOf(apiData.get("Family")));
        speciesData.setOrigin(String.valueOf(apiData.get("Origin")));
        speciesData.setClimate(String.valueOf(apiData.get("Climat")));
        //if(apiData.get("Temperature Max") != null){
           // speciesData.setTempMax((double [])apiData.get("Temperature Max"));
        //}
       // if(apiData.get("Temperature Min") != null) {
            //speciesData.setTempMin((double[]) apiData.get("Temperature Min"));
        //}
        //fyi 'climat' is not a typo -- this is what the api has listed as the key

        //speciesData.setIdealLight(String.valueOf(apiData.get("Light ideal")));
        //speciesData.setToleratedLight(String.valueOf(apiData.get("Light tolered")));

        //again not a typo on our end -- how the api has the key written

        //.setWatering(String.valueOf(apiData.get("Watering")));
        //speciesData.setPests(String.valueOf(apiData.get("Insects")));
        //speciesData.setDiseases(String.valueOf(apiData.get("Disease")));
        speciesData.setImgUrl(String.valueOf(apiData.get("Img")));
        speciesData.setDescription(String.valueOf(apiData.get("Description")));
        return speciesData;
    }
    public static ArrayList<speciesInfo> jsonReaderGetAll(JSONArray apiData){
        Iterator<Object> plants = apiData.iterator();
        speciesInfo plant = new speciesInfo();
        JSONObject testPlant = new JSONObject();
        ArrayList <speciesInfo> plantData = new ArrayList<>();
        while(plants.hasNext()){
            testPlant = (JSONObject)plants.next();
            plant = jsonReaderSinglePlant(testPlant);
            System.out.println(plant);
            plantData.add(plant);
        }
        return plantData;
    }
}
