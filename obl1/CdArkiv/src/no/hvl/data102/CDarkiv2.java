
public class CDarkiv2 implements CDarkivADT{

	private int antall = 0;
	private LinearNode<CD> start;
	private final String TOM = "CD arkivet er helt tomt";
	
	
	
	public CDarkiv2() {
		
		start = null;
		antall= 0;
	}
	
	@Override
	public CD[] hentCdTabell() {
		
		CD[] tab = new CD[antall];
		int i = 0;
		LinearNode<CD> denne = start;

		if (start == null) {
			System.out.println(TOM);
		} else {
			while (i < antall && denne != null) {
				tab[i] = denne.getElement();
				denne = denne.getNeste();
				i++;
			}
		}
		return tab;
		
	
	}

	@Override
	public void leggTilCd(CD nyCd) {
		
		LinearNode<CD> newNode = new LinearNode<CD>(nyCd);
		newNode.setNeste(start); // Setter noden til start
		start = newNode; // Nå er start den nye noden
		antall++;
		
	}

	@Override
	public boolean slettCd(int cdNr) {
		
		boolean delete = false;
		LinearNode<CD> tempNode = start;
		LinearNode<CD> neste = tempNode.getNeste();

		
		// sjekker om det finnes noen elementer
		if (start == null) { 
			return delete;
		}
		
		// hvis det er første element der skal slettes
		if (start.getElement().getNr() == cdNr) { 
			start = start.getNeste();
			antall--;
			return true;
		}

		while (tempNode != null && delete != true) {

			if (tempNode.getElement().getNr() == cdNr && neste == null) {// Hvis det er sidste elemente der skal
																				// slettes.
				tempNode = null;
				antall--;
			}
			if (neste.getElement().getNr() == cdNr) {// sletter noder midt i tabellen
				tempNode.setNeste(neste.getNeste()); // hopper over noden som har cdnummeret
				delete = true;
				antall--;

			} else {
				tempNode = tempNode.getNeste();
			}
		}
		return delete;
	}

	
	
	private CD[] trimTab(CD[] tab, int n) {
		int i = 0;
		CD[] cdtab2 = new CD[n];
		while (i < n) {
		         cdtab2[i] = tab[i];
		         i++;
		   }
		return cdtab2; 
	}
	
	@Override
	public CD[] sokTittel(String delstreng) {
		
		CD[] tab = new CD[antall];
		int i = 0;
		LinearNode<CD> denne = start;

		if (antall == 0) {
			System.out.println(TOM);
		} else {
			while (denne != null) {
				if (denne.getElement().getTittel().contains(delstreng)) {
					tab[i] = denne.getElement();
					i++;
					denne = denne.getNeste();
				} else {
					denne = denne.getNeste();
				}
			}
		}
		tab = trimTab(tab, i);
		return tab;
	}

	@Override
	public CD[] sokArtist(String delstreng) {
		
		CD[] tab = new CD[antall];
		int i = 0;
		LinearNode<CD> denne = start;

		if (antall == 0) {
			System.out.println(TOM);
		} else {
			while (denne != null) {
				if (denne.getElement().getArtist().contains(delstreng)) {
					tab[i] = denne.getElement();
					i++;
					denne = denne.getNeste();
				} else {
					denne = denne.getNeste();
				}
			}
			tab = trimTab(tab, i);
		}

		return tab;
	}

	@Override
	public int hentAntall() {
		
		return antall;
	}
	

	@Override
	public int hentAntall(Sjanger sjanger) {
		
		LinearNode<CD> denne = start;
		int nr = 0;

		while (denne != null) {
			if (denne.getElement().getSjanger() == sjanger) {
				nr++;
				denne = denne.getNeste();
			} else {
				denne = denne.getNeste();
			}
		}
		return nr;
	}

}
