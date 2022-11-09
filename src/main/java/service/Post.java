package service;
public class Post {
    private int PostId, PlantId, Age;
    private String PlantName, Species, Status, NameOfUser, Caption, PhotoUrl;
    public Post(int PostId, int PlantId, int Age, String PlantName, String Species, String Status, String NameOfUser, String Caption, String PhotoUrl) {
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
        PostId = 0;
        PlantId = 0;
        Age = 0;
        PlantName = "";
        Species = "";
        Status = "";
        NameOfUser = "";
        Caption = "";
        PhotoUrl = "";
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
    public void getPostID(int PostId) {
        this.PostId = PostId;
    }
    public void getPlantID(int PlantId) {
        this.PlantId = PlantId;
    }
    public void getAge(int age) {
        this.Age = Age;
    }
    public void getPlantName(String PlantName) {
        this.PlantName = PlantName;
    }
    public void getSpecies(String Species) {
        this.Species = Species;
    }
    public void getStatus(String Status) {
        this.Status = Status;
    }
    public void getNameOfUser(String NameOfUser) {
        this.NameOfUser = NameOfUser;
    }
    public void getCaption(String Caption) {
        this.Caption = Caption;
    }
    public void getPhotoUrl(String PhotoUrl) {
        this.PhotoUrl = PhotoUrl;
    }
}


