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
 */

public class Map {
	private Position[][] map = new Position[ConstantPosition.WIDTH+10][ConstantPosition.HEIGHT+10];
	
	public static Map carte = new Map();
	
	//The following constructor will initialize each box from the "position" array by inserting grass
	public Map(){
	}
	
	//This hook method will set an element into the array
	public void setElement(Position element) {
		this.map[element.getPositionX()][element.getPositionY()] = element;
	}
	
	//This hook method will get an element from the array
	public Position getElement(int posX, int posY) {
		return map[posX][posY];
	}
	
	public void removeElement(int x, int y) {
		this.map[x][y] = null;
	}
	
	public static Map getInstance() {
		return carte;
	}
}
