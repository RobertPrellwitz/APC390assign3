package Assignment3;

public class AbstractTable {

    private String header;
    private AbstractRow [] rowObjects = new AbstractRow[100];
    private int counter;

    public void loadTableFromFile(String fileName){};
    public void saveTable (String fileName){};
}
