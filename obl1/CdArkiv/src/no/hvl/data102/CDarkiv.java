
/*
package no.hvl.data102;
public class CDarkiv implements CDarkivADT {

	private CD[] cdTabell;
	private int antall;



	public CDarkiv(int str) {
		cdTabell = new CD[str];
		antall = 0;
	}
	
	

	public CD[] hentCdTabell() {

		return cdTabell;
	}

	@Override
	public void leggTilCd(CD nyCd) {
		
		if(antall == cdTabell.length) {
			utvidKapasitet();
		}
		cdTabell[antall] = nyCd;
		antall++;
	}

	private void utvidKapasitet() {
		
		CD [] hjelpetabell = new CD[(int) Math.ceil(1.1 * cdTabell.length)];
		for(int i = 0; i < cdTabell.length; i++) {
			
			hjelpetabell[i] = cdTabell[i];
		}
		
		cdTabell = hjelpetabell;
		
	}
	
	@Override
	public int finnCD(int nr) {

		int p = 0;
		boolean funnet = false;

		while (!funnet && p < antall) {

			if (nr == cdTabell[p].getNr()) {
				funnet = true;
			} else {
				p++;
			}
		}

		if (funnet) {
			return p;
		} else {
			return -1;
		}
	}
	
	
	
	@Override
	public boolean slettCd(int cdNr) {
		int p = finnCD(cdNr);
		if (p >= 0) {
			antall--;
			cdTabell[p] = cdTabell[antall];
			cdTabell[antall] = null;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public CD[] sokTittel(String delstreng) {

		CD[] liste = new CD[100];
		int nummer = 0;

		for (int i = 0; i < antall; i++) {

			if (cdTabell[i].getTittel().toLowerCase().equals(delstreng.toLowerCase())) {
				liste[nummer] = cdTabell[i];
				nummer++;
			}

		}
		return liste;
	}


	@Override
	public CD[] sokArtist(String delstreng) {

		CD[] liste = new CD[100];
		int nummer = 0;

		for (int i = 0; i < antall; i++) {

			if (cdTabell[i].getArtist().toLowerCase().equals(delstreng.toLowerCase())) {
				liste[nummer] = cdTabell[i];
				nummer++;
			}

		}
		return liste;

	}

	@Override
	public int hentAntall() {

		return antall;
	}

	@Override
	public int hentAntall(Sjanger sjanger) {

		int total = 0;
		
		for(int i=0; i<antall; i++) {
			
			if(cdTabell[i].getSjanger() == sjanger) {
				total++;
			}
		}
		
		return total;

	}
}

*/
