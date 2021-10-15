package Assignment3;

public class CityRow extends AbstractRow{
    private String cityName;
    private String cityId;
    private String population;

    private String [] cityRow = new String [3];

    CityRow(String City, String cityId, String cityPop ){
        cityRow[0] = City;
        cityRow[1] = cityId;
        cityRow[2] = cityPop;

    }

    protected String getCityName(){
        cityName = cityRow[0];
        return cityName;
    }

    protected String getCityID(){
         cityId = cityRow[1];
        return cityId;
    }

    protected String getCityPop(){
        population = cityRow[2];
        return population;
    }
    /* This function checks to see if the city being entered already exists in the data table by
    * comparing the City Name and City Id (duplicate City names can exist but not duplicate name and ID*/
    public boolean equal(CityRow row){
        boolean check = false;
        if (this.getCityName().equals(row.getCityName()) &&
                Integer.parseInt(this.getCityID())==Integer.parseInt(row.getCityID())){
                check = true;
        }
        return check;
    }

}
