package a3;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class StadiumTable extends AbstractTable {

    //private String header;
    //private static final StadiumRow[] stadiums = new StadiumRow[100];
    //private static int counter = 0;

    public void loadTableFromFile(String fileName) throws IOException {
        Scanner loadFile = null;
        loadFile = new Scanner(new FileReader("src\\" + fileName));
        String input;
        try {
            int count = getCounter();
            setHeader(loadFile.nextLine());
            while (loadFile.hasNext()) {
                if (count < 100) {
                    input = loadFile.nextLine();
                    boolean isEmpty = (input == null || input.trim().isEmpty());

                    if (!isEmpty) {
                        String[] array = input.split("\\s*,\\s*", 4);
                       setRow(new StadiumRow(array[0], array[1], array[2], array[3]));
                        setCounter(count++);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Data File has execeded the limit of the data Store");
                    break;
                }
            }
        } catch (Exception exp) {
            JOptionPane.showMessageDialog(null, exp + "\nThe file does not conform to the required data stucture:");
        }
        loadFile.close();
    }

    public void saveTableToFile(String fileName) throws FileNotFoundException {
        PrintWriter fileOutput = new PrintWriter(fileName);
        String stadium, stadiumId, cityName, zipCode;
        StadiumRow array;
        fileOutput.println(getHeader());
        for (int i = 0; i < getCounter(); i++) {
            //array = stadiums[i];
            array = (StadiumRow) getRow(i);
            stadium = array.getStadiumName();
            stadiumId = array.getStadiumId();
            cityName = array.getTeam();
            zipCode = array.getZipCode();
            fileOutput.println(stadium + ", " + stadiumId + ", " + cityName + ", " + zipCode);
        }
        fileOutput.close();
    }

    public void addRow() {
        String stadium = JOptionPane.showInputDialog("Please enter the Stadium you want to add to the table");
        String stadiumId = JOptionPane.showInputDialog("Please enter the Id for " + stadium);
        String cityName = JOptionPane.showInputDialog("Please enter the name of the Team that uses the stadium.");
        String zipCode = JOptionPane.showInputDialog("Please enter the zip code the Stadium resides in:");
        StadiumRow newRow = new StadiumRow(stadium, stadiumId, cityName, zipCode);
        boolean duplicate = false;
        int count = 0; int currentTot= getCounter();
        while (!duplicate && count < currentTot) {
            AbstractRow check = getRow(count);
            duplicate = check.equal(newRow);
            count++;
        }
        if (duplicate) {
            JOptionPane.showMessageDialog(null, "This a duplicate item - data can't be added");
        } else if (count < 100) {
            setRow( newRow);
            currentTot++;
            setCounter(currentTot);
        } else {
            JOptionPane.showMessageDialog(null, "The Data Store Is full - data can't be added");
        }
    }

    public void removeRow() {
        int numberToRemoveFromTable = selection();
        StadiumRow array;
        int temp = -1;
        int range = getCounter();
        int number;
        for (int i = 0; i < range; i++) {
            array = (StadiumRow) getRow(i);
            number = Integer.parseInt(array.getStadiumId());
            if (number == numberToRemoveFromTable) {
                temp = i;
                break;
            }
        }
        if (temp != -1) {
            for (int j = temp; j < (range - 1); j++) {
                //rowObjects[j] = rowObjects[j + 1];
                setRow(getRow(j+1),j);
            }
            range--;
            setCounter(range);
        }
    }

    public String findRow(String stadium) {
        String stadiumName = stadium.toLowerCase();
        String row = "";
        StadiumRow array;
        int count = getCounter();
        for (int i = 0; i < count; i++) {
            array = (StadiumRow) getRow(i);
            String check = array.getStadiumName().toLowerCase();
            if (check.equals(stadiumName)) {
                row = "Stadium: " + array.getStadiumName() + "\nTeam: " + array.getTeam() + "\nZip Code: " + array.getZipCode() + "\nStadium Id: " + array.getStadiumId();
                break;
            } else {
                row = "Sorry " + stadium + " not found!   Sorry!\nPlease try again!";
                continue;
            }
        }
        return row;
    }

    public String displayData() {
        String display = String.format("\n%-30s%-50s%-50s", "Stadium Id", "Stadium Name", "Team Name");
        StadiumRow array;
        int count = getCounter();
        for (int i = 0; i < count; i++) {
            //array = stadiums[i];
            array = (StadiumRow) getRow(i);
            display = display + (String.format("\n%-30s%-50s%-50s", array.getStadiumId(), array.getStadiumName(), array.getTeam()));
        }
        return display;
    }

    public int selection() {
        int selection = 0;
        selection = Integer.parseInt(JOptionPane.showInputDialog(displayData()
                + "\nPlease enter the Stadium ID you would like to remove:"));
        return selection;
    }
}
