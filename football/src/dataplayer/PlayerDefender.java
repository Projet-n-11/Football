package dataplayer;

public class PlayerDefender extends AbstractDataPlayerType {
	private Knowledge knowledge;
	private Strength strength;
	
	public PlayerDefender(Knowledge knowledge, Strength strength) {
		this.knowledge = knowledge;
		this.strength = strength;
	}
	
	public Knowledge getKnowledge() {
		return knowledge;
	}
	public void setKnowledge(Knowledge knowledge) {
		this.knowledge = knowledge;
	}
	public Strength getStrength() {
		return strength;
	}
	public void setStrength(Strength strength) {
		this.strength = strength;
	}
	
	public String toString() {
		return "Defender,KNOWLEDGE," + knowledge.toString() + ",STRENGTH," + strength.toString();
	}
}
