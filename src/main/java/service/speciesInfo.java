package service;

import java.util.ArrayList;

public class speciesInfo {
    //set methods
    public String commonName = "";
    public String latinName = "";
    public String family = "";
    public String origin = "";
    public String climate = "";
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
    public String getImgUrl(){
        return imgUrl;
    }
    public String getDescription(){
        return description;
    }

}
