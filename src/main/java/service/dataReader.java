package service;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;


public class dataReader {
    public static speciesInfo jsonReaderSinglePlant(JSONObject apiData){
        JSONObject dataValue;
        //System.out.print(apiData);
        speciesInfo speciesData = new speciesInfo();
        if((apiData.get("Common name").getClass() == JSONArray.class)&&(apiData.get("Origin").getClass() == JSONArray.class)) {
            speciesData.setCommonName(String.valueOf((apiData.getJSONArray("Common name")).get(0)));
            speciesData.setLatinName((String.valueOf(apiData.get("Latin name"))).replaceAll("\'", ""));
            speciesData.setFamily(String.valueOf(apiData.get("Family")));
            speciesData.setOrigin(String.valueOf((apiData.getJSONArray("Origin")).get(0)));
            speciesData.setClimate(String.valueOf(apiData.get("Climat")));
            speciesData.setImgUrl(String.valueOf(apiData.get("Img")));
            speciesData.setDescription(String.valueOf(apiData.get("Description")));
            return speciesData;
        }
        else
            return null;
    }
    public static ArrayList<speciesInfo> jsonReaderGetAll(JSONArray apiData){
        Iterator<Object> plants = apiData.iterator();
        int length = apiData.length() - 1;
        ArrayList<String> commonNames;
        speciesInfo plant = new speciesInfo();
        JSONObject testPlant = new JSONObject();
        ArrayList <speciesInfo> plantData = new ArrayList<>();
        for(int i = 0; i < length; i++){
            //worst case put the while has next function back in
                testPlant = (JSONObject) plants.next();
                plant = jsonReaderSinglePlant(testPlant);
                if (plant != null)
                    plantData.add(plant);

        }
        System.out.println("Finished executing GetAll()");
        return plantData;
    }
}
