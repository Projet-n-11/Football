package datafield;

public class Square {
	private int nbPixels;
	private int number;
	
	public Square(int nbPixels, int number) {
		this.nbPixels = nbPixels;
		this.number = number;
	}
	public int getNbPixels() {
		return nbPixels;
	}
	public void setNbPixels(int nbPixels) {
		this.nbPixels = nbPixels;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public String toString() {
		return "The fixed number of pixels for one zone is: " + nbPixels + " and we have with this " + number + " of zones.";
	}
}
