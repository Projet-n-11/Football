package datafield;
import java.util.HashMap;

public class DataSoccerField {
	private final int INITIALPOINT = 25;
	private HashMap<Integer,Square> hmField;
	private final SpecialPosition SPECIALPOS;
	
	public DataSoccerField(){
		this.SPECIALPOS = new SpecialPosition();
		hmField = new HashMap<Integer, Square>();
	}

	public String toString() {
		return "WIDTH=" + WIDTH + ", HEIGHT=" + HEIGHT + ", INITIALPOINT=" + INITIALPOINT
				+ ", hmField=" + hmField + ", SPECIALPOS=" + SPECIALPOS;
	}
}
