package Assignment3;

public class StadiumRow extends AbstractRow {
    private String stadiumName;
    private int id;
    private String city;
    private int zip;

    StadiumRow(String stadium, int stadiumId, String cityName, int zipCode){
        this.stadiumName = stadium;
        this.id = stadiumId;
        this.city = cityName;
        this.zip = zipCode;
    }

    public void equal(StadiumRow row){

    }
}
