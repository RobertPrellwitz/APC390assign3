package Assignment3;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class AbstractTable {

    private String header;
    private AbstractRow [] rowObjects = new AbstractRow[100];
    private int counter;

    public void loadTableFromFile (String fileName) throws IOException {};
    public void saveTableToFile (String fileName)throws FileNotFoundException {};
    public String findRow(String input){
        String row="blank" ;
        return row;
    };
   public void addRow(){};
   public void removeRow(){};
   public String displayData(){String data = ""; return data;};
   //public int selection () {int select = 0; return select;}
}
