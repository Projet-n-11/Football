package dataplayer;

public class PlayerMidFielder extends AbstractDataPlayerType {
	private ReadPlay readPlay;
	private Precision precision;
	
	public PlayerMidFielder(ReadPlay readPlay, Precision precision, int titularPlayer) {
		this.readPlay = readPlay;
		this.precision = precision;
		this.setTitularPlayer(titularPlayer);
		this.setPlayerTypeName("Midfielder");

	}
	public ReadPlay getReadPlay() {
		return readPlay;
	}
	public void setReadPlay(ReadPlay readPlay) {
		this.readPlay = readPlay;
	}
	public Precision getPrecision() {
		return precision;
	}
	public void setPrecision(Precision precision) {
		this.precision = precision;
	}
	
	public String toString() {
		return "MidFielder," + readPlay.toString() + "," + precision.toString();
	}
}
