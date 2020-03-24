package process.management;

import datafield.Position;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import datafield.Grass;

/*
 * Class which will place every items into the field, by first initializing every box from the array
 * position with grass (neutral element) then by filling it with each players from each teams.
 * 
 * @author Aladdine Ben Romdhane
 * 
 */

public class Positioning {
	private Position[][] position = new Position[ConstantPosition.WIDTH+2][ConstantPosition.HEIGHT+2];
	
	//The following constructor will initialize each box from the "position" array by inserting grass
	public Positioning(){
		for(int x=0; x<ConstantPosition.WIDTH; x++) {
			for(int y=0; y<ConstantPosition.HEIGHT; y++) {
				Grass grass = new Grass(x, y);
				grass.setPositionX(x);
				grass.setPositionY(y);
				setElement(grass);
			}
		}
	}
	
	//This hook method will set an element into the array
	public void setElement(Position element) {
		this.position[element.getPositionX()][element.getPositionY()] = element;
	}
	
	//This hook method will get an element from the array
	public Position getElement(int posX, int posY) {
		return position[posX][posY];
	}
	
	//This method will print each box from the array into a file named "output.txt" (USELESS CHECKING METHOD)
	public void printAllElementsFromTable() throws FileNotFoundException {
		PrintStream o = new PrintStream(new File("output.txt")); 
		PrintStream console = System.out;
		System.setOut(o);
		for(int x=0; x<ConstantPosition.WIDTH; x++) {
			for(int y=0; y<ConstantPosition.HEIGHT; y++) {
				System.out.println(getElement(x, y));
			}
		}
		System.setOut(console);;
		System.out.println("Done");
	}
}
