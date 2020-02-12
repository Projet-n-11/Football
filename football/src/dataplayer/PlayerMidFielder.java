package dataplayer;

public class PlayerMidFielder extends AbstractDataPlayerType {
	private ReadPlay readPlay;
	private Precision precision;
	
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
}
