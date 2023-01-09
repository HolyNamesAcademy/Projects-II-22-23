package service;
import java.io.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class dataReader {
    public static speciesInfo jsonReader(JSONObject apiInfo) throws ParseException {
        JSONParser reader = new JSONParser();
        JSONObject apiData = (JSONObject)reader.parse(String.valueOf(apiInfo));
        speciesInfo speciesData = new speciesInfo();
        speciesData.setCommonName((String)apiData.get("categories"));
        speciesData.setLatinName((String)apiData.get("Latin name"));
        speciesData.setFamily((String)apiData.get("Family"));
        speciesData.setOrigin((String)apiData.get("Origin"));
        speciesData.setClimate((String)apiData.get("Climat"));

        //fyi 'climat' is not a typo -- this is what the api has listed as the key

        //make these two int arrays bc there are two values given
        String tempMax;
        String tempMin;
        //
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
    
}
