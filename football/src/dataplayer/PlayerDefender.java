package dataplayer;

public class PlayerDefender extends AbstractDataPlayerType {
	private Knowledge knowledge;
	private Strength strength;
	
	public PlayerDefender(Knowledge knowledge, Strength strength, int titularPlayer) {
		this.knowledge = knowledge;
		this.strength = strength;
		this.setTitularPlayer(titularPlayer);
		this.setPlayerTypeName("Défenseur");
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
		return "Défenseur," + knowledge.toString() + "," + strength.toString();
	}
}
