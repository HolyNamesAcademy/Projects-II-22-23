package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import java.util.TreeMap;
import java.util.ArrayList;
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
        hostName = env.getProperty("db.hostname");
        dbName = env.getProperty("db.db_name");
        user = env.getProperty("db.user");
        password = env.getProperty("db.password");

        connectionUrl = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
                + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
    }

    /*
     * Take created post information and add it into the database
     * @param line - takes Post object
     */ 
    public void uploadPost(Post post) {
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(connectionUrl);

            // creating the query
            String query1 = "INSERT INTO Post ([PlantID], [Age], [PlantName], [Species], [Status], [NameOfUser], [Caption], [PhotoURL])";
            query1 += " VALUES (" + getValues(post) + ");";

            // adding the post to the table
            Statement st = connect.createStatement();
            st.execute(query1, Statement.RETURN_GENERATED_KEYS);          
        } catch (Exception e) {
            System.err.println("Got an error in tags query! ");
            System.err.println(e.getMessage());
        }
    }

    /*
     * Retrieve all the posts from the database
     * @return - returns a TreeMap (key = postID, value = post)
     */ 
    public TreeMap<Integer, Post> viewPosts() {
        Connection connect = null;

        TreeMap<Integer, Post> posts = new TreeMap<>();

        try {
            connect = DriverManager.getConnection(connectionUrl);
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery("Select * from Post");
            
            while (rs.next()) {
                Integer postID = rs.getInt("PostID");
                Post post = new Post(postID, rs.getInt("PlantID"), 
                rs.getInt("Age"), rs.getString("PlantName"), 
                rs.getString("Species"), rs.getString("Status"), 
                rs.getString("NameOfUser"), rs.getString("Caption"), 
                rs.getString("PhotoURL"));

                posts.put(postID, post);
            }
        } catch (Exception e) {
            System.err.println("Got an error in tags query! ");
            System.err.println(e.getMessage());
        }
        return posts;
    }

     /*
     * Find the row with matching postID and delete it from the database
     * @param line - takes an int for postID
     */ 
    public void deletePosts(int postID) {
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(connectionUrl);

            String query1 = "DELETE FROM Post WHERE PostID=" + postID;

            Statement st = connect.createStatement();
            st.execute(query1, Statement.RETURN_GENERATED_KEYS);
        } catch (Exception e) {
            System.err.println("Got an error in tags query! ");
            System.err.println(e.getMessage());
        }
    }

    public void updatePosts() {
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(connectionUrl);

        } catch (Exception e) {
            System.err.println("Got an error in tags query! ");
            System.err.println(e.getMessage());
        }
    }

    private String getValues(Post post) {
        ArrayList<String> temp = new ArrayList<>();
        temp.add(Integer.toString(post.getPlantID()));
        temp.add(Integer.toString(post.getAge()));
        temp.add("N'" + post.getPlantName() + "'");
        temp.add("N'" + post.getSpecies() + "'");
        temp.add("N'" + post.getStatus() + "'"); 
        temp.add("N'" + post.getNameOfUser() + "'");
        temp.add("N'" + post.getCaption() + "'");
        temp.add("N'" + post.getPhotoUrl() + "'");

        String result = "";
        for (int i = 0; i < temp.size(); i++) {
            result += temp.get(i);
            if (i < temp.size() - 1) {
                result += ", ";
            }
        }
        return result;
    }
}