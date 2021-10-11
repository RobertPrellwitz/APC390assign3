package Assignment3;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextTable {

	private String header;
	private static TableRow[] table = new TableRow[100] ;
	private static int counter = 0;

	/* This method reads the input file and puts the data into storage - 
	includes error capture for non conforming files to keep program from crashing */
	public void loadTableFromFile(String fileName) throws IOException  {
		
		Scanner loadFile = null; loadFile = new Scanner(new FileReader("data/" + fileName));
		String input ;
		try{
		header = loadFile.nextLine();
			while (loadFile.hasNext())
			{
				if ( counter < 100 ){
				input = loadFile.nextLine();
				boolean isEmpty = (input == null || input.trim().isEmpty());

				if(!isEmpty)
				{
					String[] array = input.split("\t", 3);
					table[counter] = new TableRow(array[0], array[1], array[2]);
					counter++;
				}
				}
				else{JOptionPane.showMessageDialog(null,"Data File has execeded the limit of the data Store");
				break;
			}
			}
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null,exp + "\nThe file does not conform to the required data stucture:");
		}
		loadFile.close();
	}

	// This method saves the data table in memory as edited by the user to a file
	public void saveTableToFile(String fileName) throws FileNotFoundException {
	
	PrintWriter fileOutput = new PrintWriter("output/" + fileName);

	String number, name, score;
	TableRow array ;
	fileOutput.println(header);

	for (int i =0; i < counter; i++)
	{
		 array = table[i];;
		 number = array.getData(0);
		 name = array.getData(1);
		score = array.getData(2);
		fileOutput.println( number + "\t"  + name + "\t"  + score );
	}

	fileOutput.close();
	}
	// adds another data element to the data store
	public void addRow(String int1, String nameToAddtoTable, String item3)
	{
		if (counter < 100){
		table[counter]= new TableRow(int1,nameToAddtoTable,item3);
			counter++;
		}
		else {
			JOptionPane.showMessageDialog(null,"The Data Store Is full - data can't be added");
		}
	}
	// this method looks up an elemet of the datastore by the number and deletes
	public void removeRow(int numberToRemoveFromTable)
	{
		TableRow array;
		int temp = -1;
		int range = counter;
		int number;
		for (int i = 0; i < range; i++){
			array = table[i];
			number = Integer.parseInt(array.getNumber());
			if (number == numberToRemoveFromTable){
				temp = i;
				break;
			}
		}
		if (temp != -1)
		{
		for (int j = temp; j < (range -1); j++ )
			{
			table[j] = table[j+1];
			}
		counter--;
		}
	}
	// this method searches fora data element by user name and outpts data to screen
	public String findRow(String findword)
	{
		findword.toLowerCase();
	    String row = "";
	    TableRow array;
    	for(int i = 1; i < counter; i++){
    		array = table[i];
    		String check =  array.getName();
    		if (check.toLowerCase().equals(findword)){
    			row = "Number: " + array.getNumber() + " Name: " + check + " Score: " + array.getScore();
    			break;
    		}
    		else{
    			row = "Name not found!   Sorry!\nPlease try again!";
    			continue;
    		}
    	}

	    return row;
    }
    // helper method for the delect function that displays the current data 
    static public String displayData(){
    	String display=String.format("\n%-30s%-30s%-30s","Number","Name","Data");
		TableRow array;
    	for(int i = 0; i < counter; i++){
    		array = table[i];
			display = display + (String.format("\n%-30s%-30s%-30s" , array.getNumber(), array.getName(), array.getScore()));
    	}
    	return display;
    }

}
