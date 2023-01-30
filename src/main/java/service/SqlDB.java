package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.sql.*;

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
           String query = "INSERT INTO SpeciesData (SPECIES NAME, LATIN NAME, FAMILY, ORIGIN, CLIMATE, TEMPMAX, TEMPMIN, IDEAL LIGHT, TOLERATED LIGHT, WATERING, PESTS, DISEASES, IMG URL, DESCRIPTION) VALUES (" + speciesInfo.getCommonName() + "," + speciesInfo.getLatinName() + "," + speciesInfo.getFamily() + "," + speciesInfo.getOrigin() + "," + speciesInfo.getClimate() + "," + speciesInfo.getTempMax() + "," + speciesInfo.getTempMin() + "," + speciesInfo.getIdealLight() + "," + speciesInfo.getToleratedLight() + "," + speciesInfo.getWatering() + "," + speciesInfo.getPests() + "," + speciesInfo.getDiseases() + "," + speciesInfo.getImgUrl() + "," + speciesInfo.getDescription() + ")";
           statement.executeUpdate(query);
           connection.close();
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }

   }
    // TODO: Add methods to talk to your DB here

}