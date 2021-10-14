package Assignment3;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class StadiumTable extends AbstractTable {

    private String header;
    private static StadiumRow[] stadiums = new StadiumRow[100];
    private static int counter = 0;

    public void loadTableFromFile(String fileName) throws IOException {
        Scanner loadFile = null;
        loadFile = new Scanner(new FileReader(fileName));
        String input;
        try {
            header = loadFile.nextLine();
            while (loadFile.hasNext()) {
                if (counter < 100) {
                    input = loadFile.nextLine();
                    boolean isEmpty = (input == null || input.trim().isEmpty());

                    if (!isEmpty) {
                        String[] array = input.split("\\s*,\\s*", 4);
                        stadiums[counter] = new StadiumRow(array[0], array[1], array[2], array[3]);
                        counter++;
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
        fileOutput.println(header);
        for (int i = 0; i < counter; i++) {
            array = stadiums[i];
            stadium = array.getStadiumName();
            stadiumId = array.getStadiumId();
            cityName = array.getTeam();
            zipCode = array.getZipCode();
            fileOutput.println(stadium + "\\s*,\\s*" + stadiumId + "\\s*,\\s*" + cityName + "\\s*,\\s*" + zipCode);
        }
        fileOutput.close();
        ;
    }

    public void addRow() {
        String stadium = JOptionPane.showInputDialog("Please enter the Stadium you want to add to the table");
        String stadiumId = JOptionPane.showInputDialog("Please enter the Id for " + stadium);
        String cityName = JOptionPane.showInputDialog("Please enter the name of the city where the stadium is located");
        String zipCode = JOptionPane.showInputDialog("Please enter the zip code the Stadium residse in:");
        if (counter < 100) {
            stadiums[counter] = new StadiumRow(stadium, stadiumId, cityName, zipCode);
            counter++;
        } else {
            JOptionPane.showMessageDialog(null, "The Data Store Is full - data can't be added");
        }
    }

    ;

    public void removeRow() {
        int numberToRemoveFromTable = selection();
        StadiumRow array;
        int temp =- 1;
        int range = counter;
        int number;
        for (int i = 0; i < range; i++){
            array = stadiums[i];
            number = Integer.parseInt(array.getStadiumId());
            if (number == numberToRemoveFromTable){
                temp = i;
                break;
            }
        }
        if (temp != -1)
        {
            for (int j = temp; j < (range -1); j++ )
            {
                stadiums[j] = stadiums[j+1];
            }
            counter--;
        }
    };

    public String findRow(String stadium) {
        stadium.toLowerCase();
        String row = "";
        StadiumRow array;
        for (int i = 1; i < counter; i++) {
            array = stadiums[i];
            String check = array.getStadiumName();
            if (check.toLowerCase().equals(stadium)) {
                row = "Stadium: " + array.getStadiumName() + "\nTeam: " + array.getTeam() + "\nZip Code: " + array.getZipCode() + "\nStadium Id: " + array.getStadiumId();
                break;
            } else {
                row = "Sorry " + stadium + " not found!   Sorry!\nPlease try again!";
                continue;
            }
        }
        return row;
    }

     public String displayData(){
        String display=String.format("\n%-30s%-50s%-50s","Stadium Id","Stadium Name","Team Name");
        StadiumRow array;
        for(int i = 0; i < counter; i++){
            array = stadiums[i];
            display = display + (String.format("\n%-30s%-50s%-50s" , array.getStadiumId(), array.getStadiumName(), array.getTeam()));
        }
        return display;
    }
    public int selection(){
        int selection = 0;
        selection = Integer.parseInt(JOptionPane.showInputDialog(displayData()
                + "\nPlease enter the Stadium ID you would like to remove:"));
        return selection;
    }
}
