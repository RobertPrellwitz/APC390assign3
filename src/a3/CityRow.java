/***************************
 * @author Robert Prellwitz
 * APC 390 Fall '21
 **************************/

package a3;

public class CityRow extends AbstractRow {

    // member variables
    private String cityName;
    private String cityId;
    private String population;

    private final String[] cityRow = new String[3];

    // Constructor
    CityRow(String City, String cityId, String cityPop) {
        cityRow[0] = City;
        cityRow[1] = cityId;
        cityRow[2] = cityPop;
    }

    protected String getCityName() {
        cityName = cityRow[0];
        return cityName;
    }

    protected String getCityID() {
        cityId = cityRow[1];
        return cityId;
    }

    protected String getCityPop() {
        population = cityRow[2];
        return population;
    }

    /* This function checks to see if the city being entered already exists in the data table by
     * comparing the City Id (duplicate City names can exist but not duplicate ID) */

    public boolean equal(CityRow row) {
        boolean check = false;
        if (Integer.parseInt(this.getCityID()) == Integer.parseInt(row.getCityID())) {
            check = true;
        }
        return check;
    }

}
