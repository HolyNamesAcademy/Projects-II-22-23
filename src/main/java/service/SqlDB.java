package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.json.simple.JSONObject;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

@Component
public class SqlDB {
    private String hostName;
    private final String dbName;
    private final String user;
    private final String password;
    private final String connectionUrl;

    @Autowired
    public SqlDB(Environment env) {
        hostName = env.getProperty("db.ostname");
        dbName = env.getProperty("db.db_name");
        user = env.getProperty("db.user");
        password = env.getProperty("db.password");

        connectionUrl = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
                + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
    }
   public void insertSpecies(speciesInfo speciesInfo){
       try {
           Connection connection = DriverManager.getConnection(connectionUrl);
           Statement statement = connection.createStatement();
           String query = "INSERT INTO SpeciesData (SPECIES NAME, LATIN NAME, FAMILY, ORIGIN, CLIMATE, TEMPMAX, TEMPMIN, IDEAL LIGHT, TOLERATED LIGHT, WATERING, PESTS, DISEASES, IMG URL, DESCRIPTION) VALUES (" + speciesInfo.getCommonName() + "," + speciesInfo.getLatinName() + "," + speciesInfo.getFamily() + "," + speciesInfo.getOrigin() + "," + speciesInfo.getClimate() + "," + Arrays.toString(speciesInfo.getTempMax()) + "," + Arrays.toString(speciesInfo.getTempMin()) + "," + speciesInfo.getIdealLight() + "," + speciesInfo.getToleratedLight() + "," + speciesInfo.getWatering() + "," + speciesInfo.getPests() + "," + speciesInfo.getDiseases() + "," + speciesInfo.getImgUrl() + "," + speciesInfo.getDescription() + ")";
           statement.executeUpdate(query);
           connection.close();
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }

   }
   public void insertMultipleSpecies(ArrayList<speciesInfo> plantsData){
            for(speciesInfo plant : plantsData){
                this.insertSpecies(plant);
            }
   }
   public speciesInfo selectSingleSpecies(String commonName){
        try{
            Connection connection = DriverManager.getConnection(connectionUrl);
            Statement statement = connection.createStatement();
            speciesInfo plant = new speciesInfo();
            String query = "SELECT * FROM SpeciesData WHERE SPECIES NAME = '" + commonName + "';"; //not sure what query to write here
           ResultSet data = statement.executeQuery(query);
           double [] tempMax;
           double [] tempMin;
           plant.setCommonName(data.getString("SPECIES NAME"));
           plant.setLatinName(data.getString("LATIN NAME"));
           plant.setFamily(data.getString("FAMILY"));
           plant.setOrigin(data.getString("ORIGIN"));
           plant.setClimate(data.getString("CLIMATE"));
           tempMax = (double[]) data.getObject("TEMPMAX");
           tempMin = (double[]) data.getObject("TEMPMIN");
            plant.setIdealLight(data.getString("IDEAL LIGHT"));
            plant.setToleratedLight(data.getString("TOLERATED LIGHT"));
            plant.setWatering(data.getString("WATERING"));
            plant.setPests(data.getString("PESTS"));
            plant.setDiseases(data.getString("DISEASES"));
            plant.setImgUrl(data.getString("IMAGE URL"));
            plant.setDescription(data.getString("Descriptions"));
            return plant;
        } catch(SQLException e){
            return null;
        }
   }
    // TODO: Add methods to talk to your DB here

}