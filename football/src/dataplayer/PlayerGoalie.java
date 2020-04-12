package dataplayer;

public class PlayerGoalie extends AbstractDataPlayerType {
	private Reflex reflex;
	private Dive dive;
	
	public PlayerGoalie(Reflex reflex, Dive dive, int titularPlayer) {
		this.reflex = reflex;
		this.dive = dive;
		this.setTitularPlayer(titularPlayer);
		this.setPlayerTypeName("Goalie");

	}
	
	public Reflex getReflex() {
		return reflex;
	}
	public void setReflex(Reflex reflex) {
		this.reflex = reflex;
	}
	public Dive getDive() {
		return dive;
	}
	public void setDive(Dive dive) {
		this.dive = dive;
	}
	
	public String toString() {
		return  "Goalie | Reflex: " + reflex.toString() + "% ; Dive: " + dive.toString() + "%"; 
	}
}
