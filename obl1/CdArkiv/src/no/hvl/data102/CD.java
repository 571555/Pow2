package no.hvl.data102;
public class CD {

	private int nr;
	private String artist;
	private String tittel;
	private int år;
	private  Sjanger sjanger;
	private String plateselskap;

	public CD() {

		nr = 0;
		artist = " ";
		tittel = " ";
		år = 0;
		sjanger = null;
		plateselskap = " ";

	}

	public CD(int nr, String artist, String tittel, int år, Sjanger sjanger, String plateselskap) {

		this.nr = nr;
		this.artist = artist;
		this.tittel = tittel;
		this.år = år;
		this.sjanger = sjanger;
		this.plateselskap = plateselskap;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public void setÅr(int år) {
		this.år = år;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	public void setPlateselskap(String plateselskap) {
		this.plateselskap = plateselskap;
	}

	public int getNr() {
		return nr;
	}

	public String getArtist() {
		return artist;
	}

	public String getTittel() {
		return tittel;
	}

	public int getÅr() {
		return år;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public String getPlateselskap() {
		return plateselskap;
	}
	
	@Override
	public String toString() {
		return nr + "#" + artist + "#" + tittel + "#" + år + "#"  + sjanger + "#"  + plateselskap;
	}

}
