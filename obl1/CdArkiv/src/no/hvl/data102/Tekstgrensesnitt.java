import java.util.*;


public class Tekstgrensesnitt {

	
	// lese opplysningene om en CD fra tastatur
	public CD lesCD() {
	
		Scanner in = new Scanner(System.in);

		CD ny = new CD();
		
		try {
		System.out.println("Nummer: ");
		ny.setNr(in.nextInt());
		
		System.out.println("Artist: ");
		ny.setArtist(in.next());
		
		System.out.println("Tittel: ");
		ny.setTittel(in.next());
		
		System.out.println("År: ");
		ny.setÅr(in.nextInt());
		
		System.out.println("Sjanger: ");
		ny.setSjanger(Sjanger.valueOf(in.next().toUpperCase()));
		
		System.out.println("Plateselskap: ");
		ny.setPlateselskap(in.next());
		
		
		
		} catch (Exception e) {
			System.out.println("Feil!");
		}

		return ny;
		
	
	}

	// vise en CD med alle opplysninger på skjerm 
	public void visCD(CD cd) {

		try {
			
			String[] ny = cd.toString().split("#");
			
			System.out.println("Artist: " + ny[1]);
			System.out.println("Plateselskap: " + ny[5]);
			System.out.println("Nr: " + ny[0]);
			System.out.println("Tittel: " + ny[2]);
			System.out.println("Sjanger: " + ny[4]);
			System.out.println("År: " + ny[3]);
			System.out.println("============================");
			
		} catch (Exception e) {
			System.out.println("Fannt ikke CD'en");
		}
		
	}

	// Skrive ut alle CD-er med en spesiell delstreng i tittelen
	public void skrivUtCdDelstrengITittel(CDarkivADT cda, String delstreng) {

		CD[] cd = cda.sokTittel(delstreng);

		for (CD i : cd) {
			visCD(i);
		}

		
	}

	// Skriver ut alle CD-er av en artist / en gruppe
	public void skrivUtCdArtist(CDarkivADT cda, String delstreng) {

		CD[] ny = cda.sokArtist(delstreng);

		for (CD i : ny) {
			visCD(i);
		}
		
	}

	// Skrive ut en enkel statistikk som inneholder antall CD-er totalt
	// og hvor mange det er i hver sjanger
	public void skrivUtStatistikk(CDarkivADT cda) {
		
		Sjanger[] sjanger = Sjanger.values();

		for (int i = 0; i < sjanger.length; i++) {
			System.out.println(sjanger[i] + ": " + cda.hentAntall(sjanger[i]));
		}
		
		
	}
	
	public void skrivAlle(CDarkivADT cda) {
		for(CD cd : cda.hentCdTabell()) {
			visCD(cd);
		}
	}

}
