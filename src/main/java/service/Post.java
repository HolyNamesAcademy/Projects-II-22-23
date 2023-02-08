package service;

public class Post {
    private Integer PostId;
    private int PlantId, Age;
    private String PlantName, Species, Status, NameOfUser, Caption, PhotoUrl;

    public Post(Integer PostId, int PlantId, int Age, String PlantName, String Species, String Status, String NameOfUser, String Caption, String PhotoUrl) {
        this.PostId = PostId;
        this.PlantId = PlantId;
        this.Age = Age;
        this.PlantName = PlantName;
        this.Species = Species;
        this.Status = Status;
        this.NameOfUser = NameOfUser;
        this.Caption = Caption;
        this.PhotoUrl = PhotoUrl;
    }

   public Post(){
        PostId = null;
        PlantId = 0; 
        Age = 0;
        PlantName = "";
        Species = "";
        Status = "";
        NameOfUser = "";
        Caption = "";
        PhotoUrl = "";
    }   

    public Post(int PlantId, int Age, String PlantName, String Species, String Status, String NameOfUser, String Caption, String PhotoUrl) {
        PostId = null; // "created" when post is added to the database
        this.PlantId = PlantId;
        this.Age = Age;
        this.PlantName = PlantName;
        this.Species = Species;
        this.Status = Status;
        this.NameOfUser = NameOfUser;
        this.Caption = Caption;
        this.PhotoUrl = PhotoUrl;
    }

    // all the get methods
    public int getPostID() {
        return PostId;
    }
    public int getPlantID() {
        return PlantId;
    }
    public int getAge() {
        return Age;
    }
    public String getPlantName() {
        return PlantName;
    }
    public String getSpecies() {
        return Species;
    }
    public String getStatus() {
        return Status;
    }
    public String getNameOfUser() {
        return NameOfUser;
    }
    public String getCaption() {
        return Caption;
    }
    public String getPhotoUrl() {
        return PhotoUrl;
    }

    // all the set methods
    public void setPostID(int PostId) {
        this.PostId = PostId;
    }
    public void setPlantID(int PlantId) {
        this.PlantId = PlantId;
    }
    public void setAge(int Age) {
        this.Age = Age;
    }
    public void setPlantName(String PlantName) {
        this.PlantName = PlantName;
    }
    public void setSpecies(String Species) {
        this.Species = Species;
    }
    public void setStatus(String Status) {
        this.Status = Status;
    }
    public void setNameOfUser(String NameOfUser) {
        this.NameOfUser = NameOfUser;
    }
    public void setCaption(String Caption) {
        this.Caption = Caption;
    }
    public void setPhotoUrl(String PhotoUrl) {
        this.PhotoUrl = PhotoUrl;
    }

    @Override
    public String toString(){
        return "Post [ Photo URL=" + PhotoUrl + ", Plant Type=" + Species + ", Age=" + Age + ", Caption=" + Caption + ", Life Status=" + Status + "]";
    }
}