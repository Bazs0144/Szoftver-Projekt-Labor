package proto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A jégtáblát megvalósitó osztály.
 *
 */
public class Jegtabla implements Serializable {
	/**
	 * A Jegtabla osztály adattagjai:
	 * @param kapacitas: tárolja, hogy maximálisan hány karakter állhat rajta egy idõben. Luk esetén az értéke 0, Stabil esetén végtelen (közelitve), Instabil esetén pedig változó.
	 * @param ho_mennyiseg: a jégtáblán található aktuális hómennyiséget tárolja. Ennek értéke hóvihar következtében növelhetõ, takarjtás után pedig csökken.
	 * @param befagyva: ha igaz értéket tárol, a jégtábla a hóréteg alatt még tartalmaz egy réteg jeget, amelyben egy tárgy lehet befagyva.
	 * @param poz: a jégtábla poziciója a jégmezõn.
	 * @param T: a jégtáblán található tárgy; értéke lehett null is.
	 * @param E: a jégtáblán található épitmény; értéke lehett null is.
	 * @param figurak: a jégtáblán álló figurák nyilvántartása.
	 * @param szomszedok: a jégtábla szomszédságában található jégtáblák nyilvántartása.
	 * @param medveitt: áll-e medve ezen a jégtáblán.
	 */
	private int kapacitas;
	private int ho_mennyiseg;
	private boolean befagyva;
	private Poz poz;
	private Targy T;
	protected Epitmeny E;
	private boolean medveitt;
	public String type = "Jegtabla";
	
	ArrayList<Figura> figurak;
	ArrayList<Jegtabla> szomszedok;
	
	/** A Jegtabla osztály konstruktora. A paraméterként kapott pozició lesz a jégtábla poziciója a jégmezõn */
	public Jegtabla(Poz p) {
		figurak = new  ArrayList<Figura>();
		szomszedok= new ArrayList<Jegtabla>();
		poz=new Poz(p);
	}
	
	/** Jégtábla poziciójának lekérdezése.*/
	public Poz getPoz() {
		return poz;
	}

	public void setPoz(Poz poz) {
		this.poz = poz;
	}

	/** Szomszédos jégtábla hozzáadása a jégtábla nyilvántartásába.*/
	public void addSzomszed(Jegtabla j) {
		szomszedok.add(j);
	}
	
	public void deleteSzomszed(Jegtabla j) {
		for(int i = 0; i < szomszedok.size(); i++)
			if(szomszedok.get(i).equals(j))
				szomszedok.remove(i);
	}
	
	/** A jégtáblán található figurák lekérdezése. */
	public ArrayList<Figura> getFigurak(){
		return figurak;
	}
	
	
	/** A jégtábla szomszédainak lekérdezése. */
	public ArrayList<Jegtabla> getSzomszedok(){
		return szomszedok;
	}
	
	/**
	 * Amikor hóvihar éri a jégtáblát, megvizsgálja ha van rajta epitmény. 
	 * Amennyiben nincs, minden rajta álló karakter sebzõdik; minden karakterre meghivja a sebzodik függvényét.
	 * A  jégtábla ho_mennyiseg értéke egy egységgel növekszik.*/
	public void hovihar_volt() {
		
		if(E == null) 
		{
			for(int i = 0; i < figurak.size(); ++i) { /////!!!!!
				figurak.get(i).sebzodik();
			}
		}
		ho_mennyiseg++;
	}
	
	/** A jégtáblán található figurák számának lekérdezése. */
	public int getFigurak_szama() {
		return  figurak.size();
	}
	/**
	 * A jégtáblára lépett figura nyilvántartása kerül.
	 * A figura jégtábláját is beállitja az aktuálisra. */
	public void ralepnek(Figura f) throws Exception {
		figurak.add(f);
		f.setJegtabla(this);
	}
	
	/**
	 * Egy karakter jégtábla takaritási munkája: a paramétertként kapott intensity értékkel csökken a jégtábla hómennyisége.
	 * Az intensity értéke 1 vagy 2, attól függ, hogy a karakter tárgy nélkül vagy lapáttal/ásóval végzi a takarjtásat.
	 * Ha már nincs hó, de még be van fagyva a jégtábla, ezt a jégréteget is el lehet távolitani
	 * Ha már sem hó, sem jégréteg nincs a jégtáblán, akkor nem történik semmi változás a jégtáblán */
	public void takaritas_volt(int intensity) {
		if(ho_mennyiseg == 0) befagyva = false;
		if(ho_mennyiseg - intensity >= 0) ho_mennyiseg -= intensity;
	}
	
	/** A jégtábla kapacitásának lekérdezése. */
	public int getKapacitas() {
		return kapacitas;
	}
	
	/** A jégtábla kapacitásának beállítása. */
	public void setKapacitas(int cap) {
		kapacitas = cap;
	}
	
	/** A jégtáblán található tárgy lekérdezése. */
	public Targy getTargy() {
		return T;
	}
	
	/** A jégtáblán található épitmény lekérdezése. */
	public Epitmeny getEpitmeny() {
		return E;
	}
	
	/** A paraméterként megkapott tárgy beállitása. */
	public void setTargy(Targy t) {
		this.T = t;
	}
	/** A jégtáblán található hómennyiség lekérdezése. */
	public int getHoMennyiseg() {
		return ho_mennyiseg;
	}
	
	/**
	 * Meghatározza, ha a paraméterként kapott jégtábla szomszédos-e a jelengivel.
	 * A jelenlegi szomszédjainak nyilvántartásában végighalad és megvizsgálja, ha az egyes elemek egyenlõek-e a paraméterként kapottal */
	public boolean szomszed_e(Jegtabla j) {
		
		for(int i = 0; i < szomszedok.size(); ++i) {
			if (szomszedok.get(i).equals(j)) return true;
		}
		 return false;
	}
	
	/** Amikor egy figura rálép egy szomszédos jégtáblára, a jelenlegirõl lelép, ilyenkor törlõdik ennek nyilvántartásából*/
	public void lelepnek(Figura f) {
		figurak.remove(f);
	}
	/**
	 *A paraméterként kapott karakter elveszi a jégtábláról a paraméterként megadott tárgyat.
	 *Ekkor a karakter targy_hozzaadasa függvényének meghivásával a tárgy a karakter tulajdonába kerül.
	 *Ugyanakkor a jégtábla tárgy adattagja null értékû lesz.
	 *Ha a felvétel sikeres volt, a metódus igaz értékkel tér vissza, különben hamissal.*/
	public boolean elvesz(Karakter k, Targy t) {
		
		if(!befagyva && ho_mennyiseg == 0) {
			k.targy_hozzaadasa(t); 
			T = null;
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 *Amikor egy vizbe esett karaktert sikeresen kiment egy társa, a jelenlegi jégtábáról (luk vagy átfordult instabil jégtábla) lelép és rálép arra a szomszédos 
	 *jégtáblára, amelyen a megmentõje is áll. */
	public void kiment(Karakter kit, Jegtabla j) throws Exception {
		this.lelepnek(kit);
		j.ralepnek(kit);
	}

	/** A jégtáblát befagyottra állitja. */
	public void setBefagyva(boolean be) {
		befagyva=be;
	}
	
	/** A jégtábla befagyott igazságértékét kérdezi le. */	
	public boolean get_befagyva() {
		return befagyva;
	}
	
	/** A jégtábla medveitt igazságértékét kérdezi le. */
	public boolean get_medveitt(){
		return medveitt;
	}
	
	/** A jégtáblán található épitmény értéke null lesz. */
	public void epitmenyTorles() {
		E = null;
	}
	
	/** A jégtáblán található épitmény értéke a paraméterként kapott épitmény lesz. */	
	public void epitmenyKeszul(Epitmeny e) {
		E = e; //
	}

	/**
	 * Hoozad egy jatekos karakteret a jegtablan allokhoz
	 * @param p ezt a jatekost adja hozza
	 */
	public void addPlayer(Player p) {
		figurak.add(p.getKarakter());
	}

	/**
	 * hozzaad egy figurat a jegtablan allokhoz
	 * @param f ezt a figurat adja hozza
	 */
	public void addFigura(Figura f) { figurak.add(f);}

	/**
	 * Beallitja a ho mennyiseget a jegtablan
	 * @param size erre a szamra allitja
	 */
	public void setHo(int size) {
		ho_mennyiseg = size;
	}
}