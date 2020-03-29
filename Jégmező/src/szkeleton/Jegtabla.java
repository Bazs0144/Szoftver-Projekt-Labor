package szkeleton;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A jégtáblát megvalósitó osztály.
 *
 */
public class Jegtabla {
	/**
	 * A Jegtabla osztály adattagjai:
	 * kapacitás: tárolja, hogy maximálisan hány karakter állhat rajta egy idõben. Luk esetén az értéke 0, Stabil esetén végtelen (közelitve), Instabil esetén pedig változó.
	 * ho_mennyiseg: a jégtáblán található aktuális hómennyiséget tárolja. Ennek értéke hóvihar következtében növelhetõ, takarjtás után pedig csökken.
	 * van_iglu: ha igaz értéket tárol, a jégtáblán van elhelyezve egy iglu.
	 * befagyva: ha igaz értéket tárol, a jégtábla a hóréteg alatt még tartalmaz egy réteg jeget, amelyben egy tárgy lehet befagyva.
	 * poz: a jégtábla poziciója a jégmezõn.
	 * T: a jégtáblán található tárgy; értéke lehett null is.
	 * karakterek: a jégtáblán álló karakterek nyilvántartása.
	 */
	private int kapacitas;
	private int ho_mennyiseg;
	private boolean van_iglu;
	private boolean befagyva;
	private int poz;
	private Targy T;
	
	ArrayList<Karakter> karakterek;
	
	/**
	 * A Jegtabla osztály konstruktóra, csak a konstruktorhivás kiirásának céljából lett implementálva */
	public Jegtabla() {
		Szkeleton.printFunction("-------> Jegtabla() *konstruktor*", true, this);
		karakterek = new  ArrayList<Karakter>();
		Szkeleton.printFunction("<------- Jegtabla() *konstruktor*", false, this);
	}
	
	/**
	 * A jégtáblán található karakterek lekérdezése. */
	public ArrayList<Karakter> getKarakterek(){
		Szkeleton.printFunction("-------> getKarakterek()", true, this);
		Szkeleton.printFunction("<--karakterek-- getKarakterek()", false, this);
		return karakterek;
	}
	
	/**
	 * Amikor hóvihar éri a jégtáblát, megvizsgálja ha van rajta iglu. 
	 * Amennyiben nincs, minden rajta álló karakter sebzõdik; minden karakterre meghivja a sebzodik függvényét.
	 * A  jégtábla ho_mennyiseg értéke egy egységgel növekszik.*/
	public void hovihar_volt() {
		Szkeleton.printFunction("-------> hovihar_volt()", true, false);
		System.out.println("Van iglu?");
		Scanner in = new Scanner(System.in);
		int I = in.nextInt();
		
		if(I == 0) 
		{
			for(int i = 0; i < karakterek.size(); ++i) {
				karakterek.get(i).sebzodik();  
			}
		}
		ho_mennyiseg++;
		Szkeleton.printFunction("<------- hovihar_volt()", false, this);
	}
	
	/**
	 * A jégtáblán található karakterek számának lekérdezése lekérdezése. */
	public int getKarakterek_szama() {
		Szkeleton.printFunction("-------> getKarakterek_szama()", true, this);
		Szkeleton.printFunction("<--kar-- getKarakterek_szama()", false, this);
		return  karakterek.size();
	}
	
	/**
	 * A jégtáblára lépett karakter nyilvántartása kerül.
	 * A karakter jégtábláját is beállitja az aktuálisra. */
	public void ralepnek(Karakter k) {
		Szkeleton.printFunction("------->  ralepnek(Karakter k)", true, this);
		karakterek.add(k);
		k.setJegtabla(this);
		Szkeleton.printFunction("<------- ralepnek(Karakter k)", false, this);
	}
	
	/**
	 * Egy karakter jégtábla takaritási munkája: a paramétertként kapott intensity értékkel csökken a jégtábla hómennyisége.
	 * Az intensity értéke 1 vagy 2, attól függ, hogy a karakter lapát nélkül vagy lapáttal végzi a takarjtásat. */
	public void takaritas_volt(int intensity) {
		Szkeleton.printFunction("------->  takaritas_volt(int intensity)", true, this);
		Szkeleton.printFunction("<------- takaritas_volt(int intensity)", false, this);
	}
	
	/**
	 * A jégtábla kapacitásának lekérdezése. */
	public int getKapacitas() {
		Szkeleton.printFunction("-------> getKapacitas()", true, this);
		Szkeleton.printFunction("<--kapacitas-- getKapacitas()", false, this);
		return kapacitas;
	}
	
	/**
	 * A jégtáblán található tárgy lekérdezése. */
	public Targy getTargy() {
		Szkeleton.printFunction("------->getTargy()", true, this);
        Szkeleton.printTabs(false);
		Szkeleton.printFunction("<---T--- getTargy()", false, this);
		return T;
	}
	
	/**
	 * A paraméterként megkapott tárgy beállitása. */
	public void setTargy(Targy t) {
		Szkeleton.printFunction("-------> setTargy(Targy t)", true, this);
		Szkeleton.printFunction("<------- setTargy(Targy t)", false, this);
		this.T = t;
	}
	
	/**
	 * A jégtáblán található hómennyiség lekérdezése. */
	public int getHoMennyiseg() {
		Szkeleton.printFunction("------->getHoMennyiseg()", true, this);
		System.out.println("Mennyi ho van ezen a jegtablan?");
		Scanner in = new Scanner(System.in);
		int I = in.nextInt();
		Szkeleton.printFunction("<--ho_mennyiseg-- getHoMennyiseg()", false, this);
		return I;
	}
	
	/**
	 *Amikor egy eszkimó iglut épit a jégtáblára, a jégtábla megjegyzi, hogy található rajta iglu. */
	public void igluEpitese() {
		Szkeleton.printFunction("------->igluEpitese()", true, this);
		Szkeleton.printFunction("<-------igluEpitese()", false, this);
		van_iglu = true;
	}
	
	/**
	 * Annak lekérdezése, ha a jégtáblán található-e iglu. */
	public boolean getVanIglu() {
		Szkeleton.printFunction("------->getVanIglu()", true, this);
		System.out.println("van iglu?");
		Scanner in = new Scanner(System.in);
		int I = in.nextInt();
		if(I == 0) {
			Szkeleton.printFunction("<--true-- getVanIglu()",false, this);
			return true;
		}
		else {
			Szkeleton.printFunction("<--false-- getVanIglu()", false, this);
			return false;
		}


	}
	
	/**
	 * Meghatározza, ha a paraméterként kapott jégtábla szomszédos-e a jelengivel. */
	public boolean szomszed_e(Jegtabla j) {
		Szkeleton.printFunction("------>szomszed_e(Jegtabla j)", true, this);
		System.out.println("Szomszédok a jégtáblák?");
		Scanner in = new Scanner(System.in);
		int I = in.nextInt();
		if(I == 1){
			Szkeleton.printFunction("<--true-- szomszed_e(Jegtabla j)", false, this);
			return true;
		}
		else{
			Szkeleton.printFunction("<--false-- szomszed_e(Jegtabla j)", false, this);
			 return false;
		}
	}
	
	/**
	 *Amikor egy karakter rálép egy szomszédos jégtáblára, a jelenlegirõl lelép, ilyenkor törlõdik ennek nyilvántartásából*/
	public void lelepnek(Karakter k) {
		Szkeleton.printFunction("------>lelepnek(Karakter k)", true, this);
		karakterek.remove(k);
		Szkeleton.printFunction("<------lelepnek(Karakter k)", false, this);
	}
	
	/**
	 *A paraméterként kapott karakter elveszi a jégtábláról a paraméterként megadott tárgyat.
	 *Ekkor a karakter targy_hozzaadasa függvényének meghivásával a tárgy a karakter tulajdonába kerül.
	 *Ugyanakkor a jégtábla tárgy adattagja null értékû lesz.*/
	public boolean elvesz(Karakter k, Targy t) {
		Szkeleton.printFunction("------>elvesz(Karakter k, Targy t)", true, this);
		System.out.println("Homennyiseg a jegtablan?");
		Scanner in = new Scanner(System.in);
		int I = in.nextInt();
		System.out.println("Be van fagyva?");
		int I2 = in.nextInt();
		
		if(I ==0  && I2 ==0) {
			k.targy_hozzaadasa(t);  System.out.print("k");
			Szkeleton.printFunction("<--true--elvesz(Karakter k, Targy t)", false, this);
			return true;
		}
		else {
			Szkeleton.printFunction("<--false--elvesz(Karakter k, Targy t)", false, this);
			return false;
		}
	}
	
	/**
	 *Amikor egy vizbe esett karaktert sikeresen kiment egy társa, a jelenlegi jégtábáról (luk vagy átfordult instabil jégtábla) lelép és rálép arra a szomszédos 
	 *jégtáblára, amelyen a megmentõje is áll. */
	public void kiment(Karakter kit, Jegtabla j) {
		Szkeleton.printFunction("------>kiment(Karakter kit, Jegtabla j) ", true, this);
		this.lelepnek(kit);
		j.ralepnek(kit);
		Szkeleton.printFunction("<------kiment(Karakter kit, Jegtabla j) ", false, this);
	}
}