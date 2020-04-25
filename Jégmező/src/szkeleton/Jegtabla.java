package szkeleton;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A j�gt�bl�t megval�sit� oszt�ly.
 *
 */
public class Jegtabla {
	/**
	 * A Jegtabla oszt�ly adattagjai:
	 * kapacit�s: t�rolja, hogy maxim�lisan h�ny karakter �llhat rajta egy id�ben. Luk eset�n az �rt�ke 0, Stabil eset�n v�gtelen (k�zelitve), Instabil eset�n pedig v�ltoz�.
	 * ho_mennyiseg: a j�gt�bl�n tal�lhat� aktu�lis h�mennyis�get t�rolja. Ennek �rt�ke h�vihar k�vetkezt�ben n�velhet�, takarjt�s ut�n pedig cs�kken.
	 * van_iglu: ha igaz �rt�ket t�rol, a j�gt�bl�n van elhelyezve egy iglu.
	 * befagyva: ha igaz �rt�ket t�rol, a j�gt�bla a h�r�teg alatt m�g tartalmaz egy r�teg jeget, amelyben egy t�rgy lehet befagyva.
	 * poz: a j�gt�bla pozici�ja a j�gmez�n.
	 * T: a j�gt�bl�n tal�lhat� t�rgy; �rt�ke lehett null is.
	 * karakterek: a j�gt�bl�n �ll� karakterek nyilv�ntart�sa.
	 */
	private int kapacitas;
	private int ho_mennyiseg;
	private boolean befagyva;
	private int poz;
	private Targy T;
	protected Epitmeny E;
	
	
	ArrayList<Figura> figurak;
	ArrayList<Jegtabla> szomszedok;
	
	/**
	 * A Jegtabla oszt�ly konstrukt�ra, csak a konstruktorhiv�s kiir�s�nak c�lj�b�l lett implement�lva */
	public Jegtabla() {
		Szkeleton.printFunction("-------> Jegtabla() *konstruktor*", true, this);
		figurak = new  ArrayList<Figura>();
		szomszedok= new ArrayList<Jegtabla>();
		Szkeleton.printFunction("<------- Jegtabla() *konstruktor*", false, this);
	}

	public void addSzomszed(Jegtabla j) {
		szomszedok.add(j);
	}
	
	/**
	 * A j�gt�bl�n tal�lhat� karakterek lek�rdez�se. */
	public ArrayList<Figura> getFigurak(){
		Szkeleton.printFunction("-------> getKarakterek()", true, this);
		Szkeleton.printFunction("<--karakterek-- getKarakterek()", false, this);
		return figurak;
	}
	
	public ArrayList<Jegtabla> getSzomszedok(){
		Szkeleton.printFunction("-------> getKarakterek()", true, this);
		Szkeleton.printFunction("<--karakterek-- getKarakterek()", false, this);
		return szomszedok;
	}
	/**
	 * Amikor h�vihar �ri a j�gt�bl�t, megvizsg�lja ha van rajta iglu. 
	 * Amennyiben nincs, minden rajta �ll� karakter sebz�dik; minden karakterre meghivja a sebzodik f�ggv�ny�t.
	 * A  j�gt�bla ho_mennyiseg �rt�ke egy egys�ggel n�vekszik.*/
	public void hovihar_volt() {
		Szkeleton.printFunction("-------> hovihar_volt()", true, this);
		System.out.println("Van iglu?");
		Scanner in = new Scanner(System.in);
		int I = in.nextInt();
		
		if(I == 0) 
		{
			for(int i = 0; i < figurak.size(); ++i) {
				figurak.get(i).sebzodik();
			}
		}
		ho_mennyiseg++;
		Szkeleton.printFunction("<------- hovihar_volt()", false, this);
	}
	
	/**
	 * A j�gt�bl�n tal�lhat� karakterek sz�m�nak lek�rdez�se lek�rdez�se. */
	public int getFigurak_szama() {
		Szkeleton.printFunction("-------> getKarakterek_szama()", true, this);
		Szkeleton.printFunction("<--kar-- getKarakterek_szama()", false, this);
		return  figurak.size();
	}
	
	/**
	 * A j�gt�bl�ra l�pett karakter nyilv�ntart�sa ker�l.
	 * A karakter j�gt�bl�j�t is be�llitja az aktu�lisra. */
	public void ralepnek(Figura f) {
		Szkeleton.printFunction("------->  ralepnek(Karakter k)", true, this);
		figurak.add(f);
		f.setJegtabla(this);
		Szkeleton.printFunction("<------- ralepnek(Karakter k)", false, this);
	}
	
	/**
	 * Egy karakter j�gt�bla takarit�si munk�ja: a param�tertk�nt kapott intensity �rt�kkel cs�kken a j�gt�bla h�mennyis�ge.
	 * Az intensity �rt�ke 1 vagy 2, att�l f�gg, hogy a karakter lap�t n�lk�l vagy lap�ttal v�gzi a takarjt�sat. */
	public void takaritas_volt(int intensity) {
		Szkeleton.printFunction("------->  takaritas_volt(int intensity)", true, this);
		if(ho_mennyiseg - intensity >= 0) ho_mennyiseg -= intensity;
		Szkeleton.printFunction("<------- takaritas_volt(int intensity)", false, this);
	}
	
	/**
	 * A j�gt�bla kapacit�s�nak lek�rdez�se. */
	public int getKapacitas() {
		Szkeleton.printFunction("-------> getKapacitas()", true, this);
		Szkeleton.printFunction("<--kapacitas-- getKapacitas()", false, this);
		return kapacitas;
	}
	
	/**
	 * A j�gt�bl�n tal�lhat� t�rgy lek�rdez�se. */
	public Targy getTargy() {
		Szkeleton.printFunction("------->getTargy()", true, this);
        Szkeleton.printTabs(false);
		Szkeleton.printFunction("<---T--- getTargy()", false, this);
		return T;
	}
	
	/**
	 * A param�terk�nt megkapott t�rgy be�llit�sa. */
	public void setTargy(Targy t) {
		Szkeleton.printFunction("-------> setTargy(Targy t)", true, this);
		Szkeleton.printFunction("<------- setTargy(Targy t)", false, this);
		this.T = t;
	}
	
	/**
	 * A j�gt�bl�n tal�lhat� h�mennyis�g lek�rdez�se. */
	public int getHoMennyiseg() {
		Szkeleton.printFunction("------->getHoMennyiseg()", true, this);
		Szkeleton.printFunction("<--ho_mennyiseg-- getHoMennyiseg()", false, this);
		return ho_mennyiseg;
	}
	


	
	/**
	 * Meghat�rozza, ha a param�terk�nt kapott j�gt�bla szomsz�dos-e a jelengivel. */
	public boolean szomszed_e(Jegtabla j) {
		Szkeleton.printFunction("------>szomszed_e(Jegtabla j)", true, this);
		
		for(int i = 0; i < szomszedok.size(); ++i) {
			if (szomszedok.get(i).equals(j)) return true;
		}
		 return false;
		
	/*	int I = 0;
		if(I == 1){
			Szkeleton.printFunction("<--true-- szomszed_e(Jegtabla j)", false, this);
			return true;
		}
		else{
			Szkeleton.printFunction("<--false-- szomszed_e(Jegtabla j)", false, this);
			 return false;
		}*/
	}
	
	/**
	 *Amikor egy karakter r�l�p egy szomsz�dos j�gt�bl�ra, a jelenlegir�l lel�p, ilyenkor t�rl�dik ennek nyilv�ntart�s�b�l*/
	public void lelepnek(Figura f) {
		Szkeleton.printFunction("------>lelepnek(Karakter k)", true, this);
		figurak.remove(f);
		Szkeleton.printFunction("<------lelepnek(Karakter k)", false, this);
	}
	
	/**
	 *A param�terk�nt kapott karakter elveszi a j�gt�bl�r�l a param�terk�nt megadott t�rgyat.
	 *Ekkor a karakter targy_hozzaadasa f�ggv�ny�nek meghiv�s�val a t�rgy a karakter tulajdon�ba ker�l.
	 *Ugyanakkor a j�gt�bla t�rgy adattagja null �rt�k� lesz.*/
	public boolean elvesz(Karakter k, Targy t) {
		Szkeleton.printFunction("------>elvesz(Karakter k, Targy t)", true, this);
		System.out.println("Homennyiseg a jegtablan?");
		Scanner in = new Scanner(System.in);
		int I = in.nextInt();
		System.out.println("Be van fagyva?");
		int I2 = in.nextInt();
		
		if(!befagyva && ho_mennyiseg ==0) {
			k.targy_hozzaadasa(t); 
			T = null;
			System.out.print("k");
			Szkeleton.printFunction("<--true--elvesz(Karakter k, Targy t)", false, this);
			return true;
		}
		else {
			Szkeleton.printFunction("<--false--elvesz(Karakter k, Targy t)", false, this);
			return false;
		}
	}
	
	/**
	 *Amikor egy vizbe esett karaktert sikeresen kiment egy t�rsa, a jelenlegi j�gt�b�r�l (luk vagy �tfordult instabil j�gt�bla) lel�p �s r�l�p arra a szomsz�dos 
	 *j�gt�bl�ra, amelyen a megment�je is �ll. */
	public void kiment(Karakter kit, Jegtabla j) {
		Szkeleton.printFunction("------>kiment(Karakter kit, Jegtabla j) ", true, this);
		this.lelepnek(kit);
		j.ralepnek(kit);
		Szkeleton.printFunction("<------kiment(Karakter kit, Jegtabla j) ", false, this);
	}

	public void setBefagyva(boolean be) {
		befagyva=be;
	}
	
	public boolean get_befagyva() {
		return befagyva;
	}
	/*medveitt
	 * 
	 */
	
	public void epitmenyTorles() {
		E = null;
	}
	
	public void epitmenyKeszul(Epitmeny e) {
		E = e; //
	}
}