package Assignment3;

public class StadiumRow extends AbstractRow {
    private String stadiumName;
    private int id;
    private String city;
    private int zip;

    private String [] stadiumRow = new String [4];

    StadiumRow(String stadium, int stadiumId, String cityName, int zipCode){
        this.stadiumName = stadium;
        this.id = stadiumId;
        this.city = cityName;
        this.zip = zipCode;
    }

    StadiumRow(String Stadium, String StadiumId, String cityName, String zipCode){
        stadiumRow[0] = Stadium;
        stadiumRow[1] = StadiumId;
        stadiumRow[2] = cityName;
        stadiumRow[3] = zipCode;
    }

    protected String getStadiumName(){
        String stadiumName = stadiumRow[0];
        return stadiumName;
    }

    protected String getStadiumId(){
      String stadiumId = stadiumRow[1];
      return stadiumId;
    }

    protected String getCity(){
        String city = stadiumRow[2];
        return city;
    }

    protected String getZipCode(){
        String zipCode = stadiumRow[3];
        return zipCode;
    }

    public void equal(StadiumRow row){

    }
}
