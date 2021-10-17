package a3;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class AbstractTable {
    //Abstract class data members
    private String header;
    private final AbstractRow[] tableRows = new AbstractRow[100];
    private int counter = 0;

    // helper methods for private data members
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
        this.tableRows[counter]= row;

    }
    public void setRow(AbstractRow row, int spot){
        this.tableRows[spot]=row;
    }
    public AbstractRow getRow(int row){
        return tableRows[row];
    }

    //Abstract class methods to be overridden in Concrete Classes
    abstract void addRow() ;
    abstract void removeRow() ;
    abstract String displayData() ;
    abstract String findRow(String input);
    abstract void loadTableFromFile(String fileName) throws IOException;
    abstract void saveTableToFile(String fileName) throws FileNotFoundException;
}
