package szkeleton;

import java.util.Scanner;


/**
 * Az instabil jégtábla implementálásáért felelõs osztály az Instabil, a Jegtabla leszármazottja.
 *
 */
public class Instabil extends Jegtabla{
	/**
	 * Az Instabil osztály karakterek_szama adattagja tárolja az aktuálisan a jégtáblán álló karakterek számát.
	 */
	private int karakterek_szama;

	/**
	 * Az Instabil osztály konstruktóra, csak a konstruktorhivás kiirásának céljából lett implementálva */
	public Instabil() {
		Szkeleton.printFunction("-------> Instabil()  *konstruktor*", true, this);
		Szkeleton.printFunction("<------- Instabil()  *konstruktor*", false, this);
	}

	/**
	 * A Jegtabla osztályból öröklött ralepnek függvény felülirása:
	 * Az aktiv karakter, amely egy szomszédos jégtábláról lép a jelenlegire, felkerül a jégtáblára (ennek nyilvántartásába).
	 * A karakternek is beállitjuk az aktuális jégtábláját.
	 * Ezután megviszgálja ha az instabil jégtáblán álló karakterek száma meghaladja-e a kapacitását. 
	 * Ha igen, az insatbil jégtábla meghivja a felfordul függvényét.*/
	@Override
	public void ralepnek(Karakter k) {
		Szkeleton.printFunction("------->ralepnek(Karakter k)", true, this);
		k.setJegtabla(this);
		karakterek.add(k);
		System.out.println("Tobb karakter van mint amennyi a kapacitas?");
		Scanner in = new Scanner(System.in);
		int I = in.nextInt();
		
		if(I == 1) {
			felfordul(k);
		}
		Szkeleton.printFunction("<-------ralepnek(Karakter k)", false, this);
	}
	

	/**
	 * Amikor az instabil jégtábla felfordul, a rajta álló karakter(ek) a vizbe esnek. A karakter vizbe_esik függvénye hivódik meg. */
	public void felfordul(Karakter k) {
		Szkeleton.printFunction("------->felfordul(Karakter k)", true, this);
		k.vizbe_esik();
		Szkeleton.printFunction("<-------felfordul(Karakter k)", false, this);
	}
}

