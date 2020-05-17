package proto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A j�gt�bl�t megval�sit� oszt�ly.
 *
 */
public class Jegtabla implements Serializable {
	/**
	 * A Jegtabla oszt�ly adattagjai:
	 * @param kapacitas: t�rolja, hogy maxim�lisan h�ny karakter �llhat rajta egy id�ben. Luk eset�n az �rt�ke 0, Stabil eset�n v�gtelen (k�zelitve), Instabil eset�n pedig v�ltoz�.
	 * @param ho_mennyiseg: a j�gt�bl�n tal�lhat� aktu�lis h�mennyis�get t�rolja. Ennek �rt�ke h�vihar k�vetkezt�ben n�velhet�, takarjt�s ut�n pedig cs�kken.
	 * @param befagyva: ha igaz �rt�ket t�rol, a j�gt�bla a h�r�teg alatt m�g tartalmaz egy r�teg jeget, amelyben egy t�rgy lehet befagyva.
	 * @param poz: a j�gt�bla pozici�ja a j�gmez�n.
	 * @param T: a j�gt�bl�n tal�lhat� t�rgy; �rt�ke lehett null is.
	 * @param E: a j�gt�bl�n tal�lhat� �pitm�ny; �rt�ke lehett null is.
	 * @param figurak: a j�gt�bl�n �ll� figur�k nyilv�ntart�sa.
	 * @param szomszedok: a j�gt�bla szomsz�ds�g�ban tal�lhat� j�gt�bl�k nyilv�ntart�sa.
	 * @param medveitt: �ll-e medve ezen a j�gt�bl�n.
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
	
	/** A Jegtabla oszt�ly konstruktora. A param�terk�nt kapott pozici� lesz a j�gt�bla pozici�ja a j�gmez�n */
	public Jegtabla(Poz p) {
		figurak = new  ArrayList<Figura>();
		szomszedok= new ArrayList<Jegtabla>();
		poz=new Poz(p);
	}
	
	/** J�gt�bla pozici�j�nak lek�rdez�se.*/
	public Poz getPoz() {
		return poz;
	}

	public void setPoz(Poz poz) {
		this.poz = poz;
	}

	/** Szomsz�dos j�gt�bla hozz�ad�sa a j�gt�bla nyilv�ntart�s�ba.*/
	public void addSzomszed(Jegtabla j) {
		szomszedok.add(j);
	}
	
	public void deleteSzomszed(Jegtabla j) {
		for(int i = 0; i < szomszedok.size(); i++)
			if(szomszedok.get(i).equals(j))
				szomszedok.remove(i);
	}
	
	/** A j�gt�bl�n tal�lhat� figur�k lek�rdez�se. */
	public ArrayList<Figura> getFigurak(){
		return figurak;
	}
	
	
	/** A j�gt�bla szomsz�dainak lek�rdez�se. */
	public ArrayList<Jegtabla> getSzomszedok(){
		return szomszedok;
	}
	
	/**
	 * Amikor h�vihar �ri a j�gt�bl�t, megvizsg�lja ha van rajta epitm�ny. 
	 * Amennyiben nincs, minden rajta �ll� karakter sebz�dik; minden karakterre meghivja a sebzodik f�ggv�ny�t.
	 * A  j�gt�bla ho_mennyiseg �rt�ke egy egys�ggel n�vekszik.*/
	public void hovihar_volt() {
		
		if(E == null) 
		{
			for(int i = 0; i < figurak.size(); ++i) { /////!!!!!
				figurak.get(i).sebzodik();
			}
		}
		ho_mennyiseg++;
	}
	
	/** A j�gt�bl�n tal�lhat� figur�k sz�m�nak lek�rdez�se. */
	public int getFigurak_szama() {
		return  figurak.size();
	}
	/**
	 * A j�gt�bl�ra l�pett figura nyilv�ntart�sa ker�l.
	 * A figura j�gt�bl�j�t is be�llitja az aktu�lisra. */
	public void ralepnek(Figura f) throws Exception {
		figurak.add(f);
		f.setJegtabla(this);
	}
	
	/**
	 * Egy karakter j�gt�bla takarit�si munk�ja: a param�tertk�nt kapott intensity �rt�kkel cs�kken a j�gt�bla h�mennyis�ge.
	 * Az intensity �rt�ke 1 vagy 2, att�l f�gg, hogy a karakter t�rgy n�lk�l vagy lap�ttal/�s�val v�gzi a takarjt�sat.
	 * Ha m�r nincs h�, de m�g be van fagyva a j�gt�bla, ezt a j�gr�teget is el lehet t�volitani
	 * Ha m�r sem h�, sem j�gr�teg nincs a j�gt�bl�n, akkor nem t�rt�nik semmi v�ltoz�s a j�gt�bl�n */
	public void takaritas_volt(int intensity) {
		if(ho_mennyiseg == 0) befagyva = false;
		if(ho_mennyiseg - intensity >= 0) ho_mennyiseg -= intensity;
	}
	
	/** A j�gt�bla kapacit�s�nak lek�rdez�se. */
	public int getKapacitas() {
		return kapacitas;
	}
	
	/** A j�gt�bla kapacit�s�nak be�ll�t�sa. */
	public void setKapacitas(int cap) {
		kapacitas = cap;
	}
	
	/** A j�gt�bl�n tal�lhat� t�rgy lek�rdez�se. */
	public Targy getTargy() {
		return T;
	}
	
	/** A j�gt�bl�n tal�lhat� �pitm�ny lek�rdez�se. */
	public Epitmeny getEpitmeny() {
		return E;
	}
	
	/** A param�terk�nt megkapott t�rgy be�llit�sa. */
	public void setTargy(Targy t) {
		this.T = t;
	}
	/** A j�gt�bl�n tal�lhat� h�mennyis�g lek�rdez�se. */
	public int getHoMennyiseg() {
		return ho_mennyiseg;
	}
	
	/**
	 * Meghat�rozza, ha a param�terk�nt kapott j�gt�bla szomsz�dos-e a jelengivel.
	 * A jelenlegi szomsz�djainak nyilv�ntart�s�ban v�gighalad �s megvizsg�lja, ha az egyes elemek egyenl�ek-e a param�terk�nt kapottal */
	public boolean szomszed_e(Jegtabla j) {
		
		for(int i = 0; i < szomszedok.size(); ++i) {
			if (szomszedok.get(i).equals(j)) return true;
		}
		 return false;
	}
	
	/** Amikor egy figura r�l�p egy szomsz�dos j�gt�bl�ra, a jelenlegir�l lel�p, ilyenkor t�rl�dik ennek nyilv�ntart�s�b�l*/
	public void lelepnek(Figura f) {
		figurak.remove(f);
	}
	/**
	 *A param�terk�nt kapott karakter elveszi a j�gt�bl�r�l a param�terk�nt megadott t�rgyat.
	 *Ekkor a karakter targy_hozzaadasa f�ggv�ny�nek meghiv�s�val a t�rgy a karakter tulajdon�ba ker�l.
	 *Ugyanakkor a j�gt�bla t�rgy adattagja null �rt�k� lesz.
	 *Ha a felv�tel sikeres volt, a met�dus igaz �rt�kkel t�r vissza, k�l�nben hamissal.*/
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
	 *Amikor egy vizbe esett karaktert sikeresen kiment egy t�rsa, a jelenlegi j�gt�b�r�l (luk vagy �tfordult instabil j�gt�bla) lel�p �s r�l�p arra a szomsz�dos 
	 *j�gt�bl�ra, amelyen a megment�je is �ll. */
	public void kiment(Karakter kit, Jegtabla j) throws Exception {
		this.lelepnek(kit);
		j.ralepnek(kit);
	}

	/** A j�gt�bl�t befagyottra �llitja. */
	public void setBefagyva(boolean be) {
		befagyva=be;
	}
	
	/** A j�gt�bla befagyott igazs�g�rt�k�t k�rdezi le. */	
	public boolean get_befagyva() {
		return befagyva;
	}
	
	/** A j�gt�bla medveitt igazs�g�rt�k�t k�rdezi le. */
	public boolean get_medveitt(){
		return medveitt;
	}
	
	/** A j�gt�bl�n tal�lhat� �pitm�ny �rt�ke null lesz. */
	public void epitmenyTorles() {
		E = null;
	}
	
	/** A j�gt�bl�n tal�lhat� �pitm�ny �rt�ke a param�terk�nt kapott �pitm�ny lesz. */	
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