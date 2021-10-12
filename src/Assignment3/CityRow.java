package Assignment3;

public class CityRow extends AbstractRow{
    private String City;
    private String id;
    private String population;

    private String [] cityRow = new String [3];

    CityRow(String City, String cityId, String cityPop ){
        cityRow[0] = City;
        cityRow[1] = cityId;
        cityRow[2] = cityPop;

    }

    protected String getCityName(){
        String cityName = cityRow[0];
        return cityName;
    }

    protected String getCityID(){
        String cityId = cityRow[1];
        return cityId;
    }

    protected String getCityPop(){
        String cityPop = cityRow[2];
        return cityPop;
    }

    public void equal(CityRow row){

    }

}
