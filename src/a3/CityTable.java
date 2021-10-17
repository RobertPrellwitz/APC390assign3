/***************************
 * @author Robert Prellwitz
 * APC 390 Fall '21
 **************************/
package a3;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CityTable extends AbstractTable {

    public CityTable(){

    }

    public void loadTableFromFile(String fileName) throws IOException {
        Scanner loadFile = new Scanner(new FileReader("src\\" + fileName));
        String input;
        try {
            int count = getCounter();
            //header = loadFile.nextLine();
            setHeader(loadFile.nextLine());
            while (loadFile.hasNext()) {
                if (count < 100) {
                    input = loadFile.nextLine();
                    boolean isEmpty = (input == null || input.trim().isEmpty());

                    if (!isEmpty) {
                        String[] array = input.split("\\s*,\\s*", 3);
                        setRow(new CityRow(array[0], array[1], array[2]));
                        //rowObjects[count] = new CityRow(array[0], array[1], array[2]);
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

        String city, cityId, population;
        CityRow array;
        fileOutput.println(getHeader());

        for (int i = 0; i < getCounter(); i++) {
            //array = (CityRow) rowObjects[i];
            array = (CityRow) getRow(i);
            city = array.getCityName();
            cityId = array.getCityID();
            population = array.getCityPop();
            fileOutput.println(city + ", " + cityId + ", " + population);
        }
        fileOutput.close();
    }

    public void addRow() {
        String city = JOptionPane.showInputDialog("Please enter the City you want to add to the table");
        String cityId = JOptionPane.showInputDialog("Please enter the Id for " + city);
        String population = JOptionPane.showInputDialog("Please enter the population in millions for " + city);
        CityRow newRow = new CityRow(city, cityId, population);
        boolean duplicate = false;
        int count = 0;
        int currentTot = getCounter();

        while (!duplicate && count < currentTot) {
            AbstractRow check = getRow(count);
            duplicate = check.equal(newRow);
            count++;
        }
        if (duplicate) {
            JOptionPane.showMessageDialog(null, newRow.getCityName() + " is a duplicate - data can't be added");
        }
        else if (count < 100) {
            setRow(newRow);
            currentTot++;
            setCounter(currentTot);
        } else {
            JOptionPane.showMessageDialog(null, "The Data Store Is full - data can't be added");
        }
    }

    public void removeRow() {
        int numberToRemoveFromTable = selection();
        CityRow array;
        int temp = -1;
        int range = getCounter();
        int number;
        for (int i = 0; i < range; i++) {
            //array = (CityRow) rowObjects[i];
            array = (CityRow) getRow(i);
            number = Integer.parseInt(array.getCityID());
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

    public String findRow(String name) {
        name = name.toLowerCase();
        String row = "";
        CityRow array;
        int count = getCounter();
        for (int i = 0; i < count; i++) {
            array = (CityRow) getRow(i);
            String check = array.getCityName().toLowerCase();
            if (check.toLowerCase().equals(name)) {
                row = "City: " + array.getCityName() + " City Id: " + array.getCityID() + " Population: " + array.getCityPop();
                break;
            } else {
                row = name + " not found!   Sorry!\nPlease try again!";
            }
        }
        return row;
    }

    public String displayData() {
        StringBuilder display = new StringBuilder(String.format("\n%-30s%-50s%-50s", "City Id", "City Name", "Population"));
        CityRow array;
        int count = getCounter();
        for (int i = 0; i < count; i++) {
            //array = (CityRow) rowObjects[i];
            array = (CityRow) getRow(i);
            display.append(String.format("\n%-30s%-50s%-50s", array.getCityID(), array.getCityName(), array.getCityPop()));
        }
        return display.toString();
    }


    public int selection() {
        return Integer.parseInt(JOptionPane.showInputDialog(displayData()
                + "\nPlease enter the City ID you would like to remove:"));
    }

}
