package dataplayer;

public class Knowledge {
	private int valueKnowledge;

	public Knowledge(int valueKnowledge) {
		this.valueKnowledge = valueKnowledge;
	}
	
	public int getValueKnowledge() {
		return valueKnowledge;
	}

	public void setValueKnowledge(int valueKnowledge) {
		this.valueKnowledge = valueKnowledge;
	}
	
	public String toString() {
		return "Knowledge is : " + valueKnowledge;
	}
}
