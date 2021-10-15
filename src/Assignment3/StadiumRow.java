package Assignment3;

public class StadiumRow extends AbstractRow {
    private String stadiumName;
    private String stadiumId;
    private String teamName;
    private String zipCode;

    private String [] stadiumRow = new String [4];

//    StadiumRow(String stadium, int stadiumId, String teamName, int zipCode){
//        this.stadiumName = stadium;
//        this.id = stadiumId;
//        this.teamName = teamName;
//        this.zip = zipCode;
//    }

    StadiumRow(String Stadium, String StadiumId, String teamName, String zipCode){
        stadiumRow[0] = Stadium;
        stadiumRow[1] = StadiumId;
        stadiumRow[2] = teamName;
        stadiumRow[3] = zipCode;
    }

    protected String getStadiumName(){
         stadiumName = stadiumRow[0];
        return stadiumName;
    }

    protected String getStadiumId(){
       stadiumId = stadiumRow[1];
      return stadiumId;
    }

    protected String getTeam(){
         teamName = stadiumRow[2];
        return teamName;
    }

    protected String getZipCode(){
         zipCode = stadiumRow[3];
        return zipCode;
    }

    /// This checks to see if the Stadium being added is the same as another based on Team & StadiumId
    /// This allows for a stadium to exist with multiple Teams and have a multiple listings based on ID and Team
    public boolean equal(StadiumRow row) {
        boolean check = false;
        if (this.getTeam().equals(row.getTeam()) || Integer.parseInt(this.getStadiumId()) == Integer.parseInt(row.getStadiumId())) {
            check = true;
        }
        return check;
    }
}
