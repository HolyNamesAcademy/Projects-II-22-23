package service;
import java.io.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class dataReader {
    public static void jsonReader(JSONObject apiInfo) throws ParseException {
        JSONParser reader = new JSONParser();
        JSONObject apiData = (JSONObject)reader.parse(String.valueOf(apiInfo));
        String speciesName = (String)apiData.get("categories");
        String latinName = (String)apiData.get("Latin name");
        String family = (String)apiData.get("Family");
        String origin = (String)apiData.get("Origin");
        String climate = (String)apiData.get("Climat");
        //fyi 'climat' is not a typo -- this is what the api has listed as the key

        //make these two int arrays bc there are two values given
        String tempMax;
        String tempMin;
        //

        String idealLight = (String)apiData.get("Light ideal");
        String toleratedLight = (String)apiData.get("Light tolered");
        //again not a typo on our end -- how the api has the key written

        String watering = (String)apiData.get("Watering");
        String pests = (String)apiData.get("Insects");
        String diseases = (String)apiData.get("Disease");
        String imgUrl = (String)apiData.get("img");
        String description = (String)apiData.get("Description");
    }
    
}
