/***************************
 * @author Robert Prellwitz
 * APC 390 Fall '21
 **************************/
package a3;

public class TableRow {

    private final String[] tableRow = new String[3];

    //class constructor that creates the data array
    TableRow(String number, String name, String score) {
        tableRow[0] = number;
        tableRow[1] = name;
        tableRow[2] = score;
    }

    // accessor to provide the number element of a table row oject
    protected String getNumber() {
        String number = tableRow[0];
        return number;
    }

    // accessor to provide the name element of a table row oject
    protected String getName() {
        String name = tableRow[1];
        return name;
    }

    // accessor to provide the data element of a table row oject
    protected String getScore() {
        String score = tableRow[2];
        return score;
    }

    // generic accessor to provide the specified element of a table row oject
    protected String getData(int i) {
        String element = tableRow[i];
        return element;
    }
}
