package dataplayer;

public class PlayerMidFielder extends AbstractDataPlayerType {
	private ReadPlay readPlay;
	private Precision precision;
	
	public PlayerMidFielder(ReadPlay readPlay, Precision precision) {
		this.readPlay = readPlay;
		this.precision = precision;
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
		return readPlay.toString() + "," + precision.toString();
	}
}
