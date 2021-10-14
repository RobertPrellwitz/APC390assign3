package Assignment3;
import javax.swing.JOptionPane;
import java.io.IOException;

/**
 * <p> Title: APC 390 Assignment #1 </p>
 * <p> Description: Interactive Table builder. Assign1Main
 *     - read a text file containing a table of data </p>
 * <p> Copyright: Copyright (c) 2021 </p>
 * <p> Company: UWEX APC </p>
 *
 * @author Robert Prellwitz
 * @author Anthony Varghese
 * @version 1.1
 */

public class Assignment3Main {
    static final int LOAD = 1, SAVE = 2, ADD_ROW = 3, REMOVE_ROW = 4, FIND_ROW = 5, DISPLAY_TABLE = 6,QUIT = 7;
    static final int STADIUM = 1, CITY = 2, END = 3;

    static final String welcomeMessage = "This program implements an interactive table builder.\n"
            + "You can add new rows or remove rows from tables.\n"
            + "You can also load a table from a file or save a current\n"
            + "table to a file.\n";

    static final String developerMessage = "Program enhanced and improved by:\n"
            + "Robert Prellwitz\n"
            + "APC 390 Fall 21 Semester\n"
            + "September 12, 2021";

    static final String promptMessage = "What would you like to do?\n"
            + "Please enter the number corresponding to the action you would like:\n"
            + "   " + LOAD + ": Load a table from a file\n"
            + "   " + SAVE + ": Save current table to a file\n"
            + "   " + ADD_ROW + ": Add a row to the current table\n"
            + "   " + REMOVE_ROW + ": Remove a row from the current table\n"
            + "   " + FIND_ROW + ": Find a row\n"
            + "   " + DISPLAY_TABLE + ": Display current Table.\n"
            + "   " + QUIT + ": Quit\n";

    static final String tableChoice = "There are the two table types available:\n"
            + "City Data & Stadium data.\n"
            + "Please select what you want to work on:\n"
            + "   " + STADIUM +":  Stadium Data\n"
            + "   " + CITY +":  City Data\n"
            + "   " + END + ":  End Program";

    public static void main(String[] args) throws IOException {
        JOptionPane.showMessageDialog(null,developerMessage);
        JOptionPane.showMessageDialog(null, welcomeMessage);
        TextTable mytexttable = new TextTable();
        AbstractTable myStadium = new StadiumTable();
        AbstractTable myCity = new CityTable();

        int tableSelection =0;

        while (tableSelection!= END) {
            tableSelection = Integer.parseInt(JOptionPane.showInputDialog(tableChoice));
            AbstractTable myTable = tableSet(tableSelection);
            int userSelection = 0;
            while ((userSelection != QUIT) && (tableSelection != END)) {
                userSelection = Integer.parseInt(JOptionPane.showInputDialog(promptMessage));
                processSelection(myTable, userSelection);
            }
        }
    }

    private static AbstractTable tableSet(int tableChoice)throws IOException{
        AbstractTable userTable = new CityTable();

        switch (tableChoice){
            case STADIUM:
                userTable = new StadiumTable();
                break;
            case CITY:
                userTable = new CityTable();
                break;
            case END:
                JOptionPane.showMessageDialog(null, "Thank you for using our program."
                + "\nREP Computing Services. \n\n DON'T PANIC\n\n");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid Input");
                break;
        }
        return userTable;
    }

    private static void processSelection(AbstractTable mytable, int userSelection) throws IOException {
        switch (userSelection) {
            case LOAD:
                // Remember that you can have text files in your Eclipse Project
                // If this file is in src/a1, you could read the input.txt file in your a1
                // package
                // using the "fileName" src/a1/input.txt
                String fileName = JOptionPane.showInputDialog("Please enter the name of the text file to load");
                System.out.println("Opening the file '" + fileName + "'.");
                try {
                mytable.loadTableFromFile(fileName);}
                catch(IOException exp){
                    JOptionPane.showMessageDialog(null,"Error loading file: "+exp);
                }
                break;
            case SAVE:
                fileName = JOptionPane.showInputDialog("Please enter the name of the text file to which to save");
                mytable.saveTableToFile(fileName);
                break;
            case ADD_ROW:
                // String number = JOptionPane.showInputDialog("Please enter the number you want to add to the table");
                // String name = JOptionPane.showInputDialog("Please enter the name for " + number);
                // String value = JOptionPane.showInputDialog("Please enter the value for " + number);
                mytable.addRow();
                break;
            case REMOVE_ROW:
//                String Table = mytable.displayData();
//                int num = Integer.parseInt( JOptionPane
//                        .showInputDialog("Please enter the number in the row you want to remove from the table\n\n" )); //+ Table
                mytable.removeRow();
                break;
            case FIND_ROW:
                String name = JOptionPane.showInputDialog("Please enter the name in the row you want to find.");
                JOptionPane.showMessageDialog(null, mytable.findRow(name));
                break;
            case DISPLAY_TABLE:
                JOptionPane.showMessageDialog(null,mytable.displayData());
            case QUIT:
                JOptionPane.showMessageDialog(null, "Have a nice day");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid Input");
        }
    }
}
