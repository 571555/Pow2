package no.hvl.data102;


public interface CDarkivADT {

	
	/** Returnere tabell med CD'er
	 * @return Hele CD tabellen.
	 */
	CD[] hentCdTabell();

	
	
	
	/** Legger til en ny CD
	 * @param nyCd
	 */
	void leggTilCd(CD nyCd);

	
	
	
	/** Sletter en CD hvis den fins
	  * @param cdNr
	  * @return true hvis CD'en blev lakt til
	  */
	boolean slettCd(int cdNr);

	
	
	
	/**Søker etter cd'er med en gitt delstreng
	 * @param delstreng fra tittel
	 * @return tabel med alle CD'er med den tittel
	 */
	CD[] sokTittel(String delstreng);

	
	
	/**Søker og henter artister med en gitt delstreng   
	 * @param delstreng med artist
	 * @return CD tabell med alle CD'er fra den artisten
	 */
	CD[] sokArtist(String delstreng);

	
	
	/**Henter antall CD'er
	   * @return antall CD'er i samlingen
	   */
	int hentAntall();

	
	
	/**Henter antall CD'er fra en sjanger   
	 * @param sjanger
	 * @return antall CD'er i den sjanger.
	 */
	int hentAntall(Sjanger sjanger);

}
