package dataplayer;

public class PlayerGoalie extends AbstractDataPlayerType {
	private Reflex reflex;
	private Dive dive;
	
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
}
