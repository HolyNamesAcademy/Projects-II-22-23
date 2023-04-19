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
        hostName = env.getProperty("db.hostname");
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
           String query = "INSERT INTO PlantSpeciesData (SPECIES_NAME, LATIN_NAME, FAMILY, ORIGIN, CLIMATE, IMG_URL, DESCRIPTION) \n VALUES (\'" + speciesInfo.getCommonName() + "\', \'" + speciesInfo.getLatinName() + "\', \'" + speciesInfo.getFamily() + "\', \'" + speciesInfo.getOrigin() + "\', \'" + speciesInfo.getClimate() + "\', \'" + speciesInfo.getImgUrl() + "\', \'" + speciesInfo.getDescription() + "\')";
           System.out.println(query);
           statement.executeUpdate(query);
           connection.close();
           System.out.println("db updated");
       } catch (SQLException e) {
           System.out.println("error inserting into db");
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
            String query = "SELECT * FROM dbo.SpeciesData WHERE SPECIES NAME = '" + commonName + "';"; //not sure what query to write here
           ResultSet data = statement.executeQuery(query);
           plant.setCommonName(data.getString("SPECIES_NAME"));
           plant.setLatinName(data.getString("LATIN_NAME"));
           plant.setFamily(data.getString("FAMILY"));
           plant.setOrigin(data.getString("ORIGIN"));
           plant.setClimate(data.getString("CLIMATE"));
           plant.setImgUrl(data.getString("IMAGE_URL"));
           plant.setDescription(data.getString("DESCRIPTION"));
           return plant;
        } catch(SQLException e){
            return null;
        }
   }
    // TODO: Add methods to talk to your DB here

}