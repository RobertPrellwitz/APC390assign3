package a3;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class AbstractTable {

    private String header;
    private final AbstractRow[] testRows = new AbstractRow[100];
    private int counter = 0;

    public void loadTableFromFile(String fileName) throws IOException {
    }

    public void saveTableToFile(String fileName) throws FileNotFoundException {
    }

    public String findRow(String input) {
        return "blank";
    }
    public String getHeader(){
        return header;
    }

    public void setHeader(String header){
        this.header = header;
    }
    public void setCounter(int count){
        this.counter = count;
    }
    public int getCounter(){
        return counter;
    }
    public void setRow(AbstractRow row){
        this.testRows[counter]= row;

    }
    public void setRow(AbstractRow row, int spot){
        this.testRows[spot]=row;
    }
    public AbstractRow getRow(int row){
        return testRows[row];
    }

    public void addRow() {
    }
    public void removeRow(){}

    public String displayData() {
        return "";
    }

    //public int selection () {int select = 0; return select;}
}
