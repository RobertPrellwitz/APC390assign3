package a3;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class AbstractTable {

    private String header;
    protected AbstractRow[] rowObjects = new AbstractRow[100];
    private AbstractRow[] testRows = new AbstractRow[100];
    private int counter = 0;

    public void loadTableFromFile(String fileName) throws IOException {
    }

    public void saveTableToFile(String fileName) throws FileNotFoundException {
    }

    public String findRow(String input) {
        String row = "blank";
        return row;
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
        String data = "";
        return data;
    }

    //public int selection () {int select = 0; return select;}
}
