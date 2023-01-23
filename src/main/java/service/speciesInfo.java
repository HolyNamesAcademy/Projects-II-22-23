package service;

import java.util.ArrayList;

public class speciesInfo {
    //set methods
    public String commonName = "";
    public String latinName = "";
    public String family = "";
    public String origin = "";
    public String climate = "";
    public double [] tempMax;
    public double [] tempMin;
    public String idealLight = "";
    public String toleratedLight = "";
    public String watering = "";
    public String pests = "";
    public String diseases;
    public String imgUrl = "";
    public String description = "";

    public void setCommonName(String name){
        commonName = name;
    }
    public void setLatinName(String name){
        latinName = name;
    }
    public void setFamily(String info){
        family = info;
    }
    public void setOrigin(String info){
        origin = info;
    }
    public void setClimate(String info){
        climate = info;
    }
    public void setTempMax(double [] temp){
        tempMax = temp;
    }
    public void setTempMin(double [] temp){
        tempMin = temp;
    }
    public void setIdealLight(String light){
        idealLight = light;
    }
    public void setToleratedLight(String light){
        toleratedLight = light;
    }
    public void setWatering(String info){
        watering = info;
    }
    public void setPests(String info){
        pests = info;
    }
    public void setDiseases(String info){
        diseases = info;
    }
    public void setImgUrl(String info){
        imgUrl = info;
    }
    public void setDescription(String info){
        description = info;
    }
    //get methods
    public String getCommonName(){
        return commonName;
    }
    public String getLatinName(){
        return latinName;
    }
    public String getFamily(){
        return family;
    }
    public String getOrigin(){
        return origin;
    }
    public String getClimate(){
        return climate;
    }
    public String getToleratedLight(){
        return toleratedLight;
    }
    public String getIdealLight(){
        return idealLight;
    }
    public String getWatering(){
        return watering;
    }
    public String getPests(){
        return pests;
    }
    public String getDiseases(){
        return diseases;
    }
    public String getImgUrl(){
        return imgUrl;
    }
    public String getDescription(){
        return description;
    }
    public double [] getTempMax(){
        return tempMax;
    }
    public double [] getTempMin(){
        return tempMin;
    }

}
