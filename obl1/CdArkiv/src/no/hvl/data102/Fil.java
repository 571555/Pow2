
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Fil {
	
	final static String SKILLE = "#"; // Eventuelt ha som parameter i metodene.

	// Lese et CDarkiv fra tekstfil
	public static CDarkivADT lesFraFil(String filnavn) throws FileNotFoundException { 
		
		CDarkivADT cda = new CDarkiv2(); // Er det lovligt med en objektreferanse her????
		
		Scanner scanner = new Scanner(new File(filnavn));
		
		while(scanner.hasNext()) {
			String[] cd = scanner.nextLine().split(SKILLE);
			CD nyCd = new CD();
			
			nyCd.setNr(Integer.parseInt(cd[0]));
			nyCd.setArtist(cd[1]);
			nyCd.setTittel(cd[2]);
			nyCd.setÅr(Integer.parseInt(cd[3]));
			nyCd.setSjanger(Sjanger.valueOf(cd[4]));
			nyCd.setPlateselskap(cd[5]);
			
			cda.leggTilCd(nyCd);
			
			scanner.close();
		}
    
    return cda;
}

	// Lagre et CDarkiv til tekstfil
	public static void skrivTilFil(CDarkivADT cda, String filnavn) throws FileNotFoundException {
		
		File fil = new File(filnavn);
		PrintWriter writer = new PrintWriter(fil);
		int i = 0;
		CD[] cd = cda.hentCdTabell();
		
		while(i < cd.length) {
			writer.println(cd[i].toString());
			i++;
		}
		writer.close();
	}

}
