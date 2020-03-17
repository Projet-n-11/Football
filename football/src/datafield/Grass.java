package datafield;


public class Grass extends Position{
	
	/*
	 * Color of the grass should be either green or white (following
	 * if there's a white line drawn on top of it)
	 * 
	 */
	private String color;
	
	//This is just a neutral element used when there's nothing
	//onto the field
	
	public Grass(int positionX, int positionY) {
		super(positionX, positionY);
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Grass";
	}
}
