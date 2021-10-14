package Assignment3;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CityTable extends AbstractTable{

    private String header;
    private static CityRow [] cities = new CityRow[100];
    private static int counter = 0;

    public void loadTableFromFile (String fileName) throws IOException {
        Scanner loadFile = null; loadFile = new Scanner(new FileReader(fileName));
        String input ;
        try {
            header = loadFile.nextLine();
            while (loadFile.hasNext()) {
                if (counter < 100) {
                    input = loadFile.nextLine();
                    boolean isEmpty = (input == null || input.trim().isEmpty());

                    if (!isEmpty) {
                        String[] array = input.split("\\s*,\\s*", 3);
                        cities[counter] = new CityRow(array[0], array[1], array[2]);
                        counter++;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Data File has execeded the limit of the data Store");
                    break;
                }
            }
        }
        catch(Exception exp){
            JOptionPane.showMessageDialog(null,exp + "\nThe file does not conform to the required data stucture:");
        }
        loadFile.close();
    }

    public void saveTableToFile(String fileName) throws FileNotFoundException {
        PrintWriter fileOutput = new PrintWriter( fileName);

        String city, cityId, population;
        CityRow array ;
        fileOutput.println(header);

        for (int i = 0; i < counter; i++)
        {
            array = cities[i];
            city = array.getCityName();
            cityId = array.getCityID();
            population = array.getCityPop();
            fileOutput.println( city + "\\s*,\\s*"  + cityId + "\\s*,\\s*"  + population );
        }
        fileOutput.close();
    }
    public void addRow(){
        String city = JOptionPane.showInputDialog("Please enter the City you want to add to the table");
        String cityId = JOptionPane.showInputDialog("Please enter the Id for " + city);
         String population = JOptionPane.showInputDialog("Please enter the population for " + city);
        if (counter < 100){
            cities[counter]= new CityRow(city,cityId,population);
            counter++;
        }
        else {
            JOptionPane.showMessageDialog(null,"The Data Store Is full - data can't be added");
        }
    };

    public void removeRow(){};

    public String findRow(String name){
        name.toLowerCase();
        String row="";
        CityRow array;
        for (int i = 1; i < counter; i++){
            array = cities[i];
            String check = array.getCityName();
            if (check.toLowerCase().equals(name)){
                row = "City: " + array.getCityName() + " City Id: " + array.getCityID() + " Population: " + array.getCityPop();
            break;
            }
            else{
                row = "Name not found!   Sorry!\nPlease try again!";
                continue;
            }
        }
        return row;
    }

}
