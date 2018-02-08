import java.io.FileNotFoundException;
import java.util.Scanner;

public class Meny {
	
	
	private Tekstgrensesnitt tekstgr;
	private CDarkivADT cda;
	private Scanner in = new Scanner(System.in);
	private int valg = -1;

	public Meny(CDarkivADT cda) {
		tekstgr = new Tekstgrensesnitt();
		this.cda = cda;
	}

	public boolean nytArkivEllerLes() {
		
		boolean lest = false;
		System.out.println("============================ \n 1: Les inn CD arkiv \n 2: Oprette et nytt CD arkiv \n============================");

		while (valg != 1 && valg != 2) {
			try {
				valg = Integer.parseInt(in.nextLine());
			} catch (Exception e) {
				System.out.println("Velg enten 1 eller 2");
				valg = -1;
			}
		}
		int stop = 0;
		if (valg == 1) {
			while (lest != true && stop < 5) {
				System.out.println("Filnavn: ");
				String fil = in.next();

				try {

					cda = Fil.lesFraFil(fil);
					lest = true;

				} catch (FileNotFoundException e) {
					System.out.println("Fant ingen fil");
					stop++;
				}
			}
		}

		else if (valg == 2) {
			this.cda = new CDarkiv2();
			lest = true;
		}
		return lest;
	}

	public void start() {

		boolean start = false;
		start = nytArkivEllerLes();
		
		try {

		if (start == false) {
			System.out.println("Avsluttet");
		} else {

			do {
				System.out.println("============================\n" + "1: Legg CD til arkiv \n" + "2: Søk en CD \n" + "3: Søk artist \n"
						+ "4: Skriv ut Statistikk \n" + "5: Lagre CD arkiv på fil \n" + "6: Slette CD \n"+ "7: Vis hele arkiv \n"
						+ "0: Avslutt \n============================");

				valg = in.nextInt();
				switch (valg) {
				case 1: {
					cda.leggTilCd(tekstgr.lesCD());
					break;
				}
				case 2: {
					System.out.println("CD tittel: ");
					String cd = in.next();
					tekstgr.skrivUtCdDelstrengITittel(cda, cd);
					break;
				}
				case 3: {
					System.out.println("Artist: ");
					String cd = in.next();
					tekstgr.skrivUtCdArtist(cda, cd);
					break;
				}
				case 4: {
					tekstgr.skrivUtStatistikk(cda);
					break;
				}
				case 5: {
					String filnavn;
					System.out.println("Navn på fil: ");
					filnavn = in.next() + ".txt";
					try {
						Fil.skrivTilFil(cda, filnavn);
					} catch (FileNotFoundException e) {
						System.out.println("Feil ved skriving");
					}
					break;
				}
				case 6: {
					try {
						System.out.println("CD nummer til CD der skal slettes: ");
						int cdSlett = Integer.parseInt(in.next());
						boolean slettet = cda.slettCd(cdSlett);
						if (slettet) {
							System.out.println("CD "+ cdSlett + " ble slettet.");
							}
						else {
							System.out.println("CD " + cdSlett + " ikke slettet.");
						}
					} catch (Exception e) {
						System.out.println("Feil");
					}
					break;
				}
				case 7: {
					tekstgr.skrivAlle(cda);
					break;
				}
				}
			} while (valg != 0);
		}
		} catch(Exception e) {
			System.out.println("Opppgi riktig datatype");
		}

	}


}
