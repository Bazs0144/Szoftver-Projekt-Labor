package proto;

import java.io.Serializable;

/**
 * Az s�tor implement�l�s��rt felel�s oszt�ly a Sator, a T�rgy lesz�rmazottja.
 *
 */
public class Sator extends Targy implements Epitmeny, Serializable {
	
	/**
	 * A S�tor oszt�ly adattagjai:
	 * @param all: igaz �rt�ket t�rol, ha a s�tor haszn�latban van.
	 * @param hasznalhato: a j�t�kosok sz�ma, ennyi j�t�kos k�r�vel egyenl� a j�t�kk�r. Ez tov�bbra egyenl� a s�tor haszn�lhat�s�g�nak idej�vel.
	 * @param hasznalatban:a s�tor fel�ll�t�s�t�l eltelt id� (eltelt j�t�kos k�r�k sz�ma).A s�tor fel�ll�t�sakor az �rt�ke 0, a haszn�l�dik f�ggv�ny pedig minden
						alkalommal eggyel n�veli az �rt�ket, amikor a next_player f�ggv�ny megh�v�dik (amikor egy m�sik j�t�kos elkezdi a k�r�t). Az �rt�k a hasznalhato attrib�tum
						�ltal t�rolt �rt�kig n�vekszik, ezut�n a s�tor m�r nem tud karaktert megv�deni a h�vihart�l.
	 */
	private boolean all;
	private int hasznalhato;
	private int hasznalatban;
	
	public Sator(int kor) {
		all = false;
		Name = "Sator";
		hasznalhato = kor;
		hasznalatban = 0;
	}
	
	/** A s�tor v�d a h�vihar ellen, ha �ppen �ll .*/
    @Override
    public boolean megvedHovihartol() {
    	if(all)
        return true;
    	else return false;
    }

    /** A s�tor nem v�d a h�vihar ellen.*/
    @Override
    public boolean megvedMedvetol() {
        return false;
    }

    @Override
	public String getName(){
    	return "Sator";
	}
    
    /** A s�tor fel�llitasa a param�terk�nt kapott j�gt�bl�ra, a param�terk�nt kapott karakter �lltal.
     * Ha a karakter vizben van vagy a s�tor m�r nem haszn�lhat�, a s�tor fel�llit�sa nem val�sithat� meg.*/
    public void hasznaljak(Karakter k, Jegtabla j) {
    	if(k.get_vizben_van()) return;
    	if(hasznalatban < hasznalhato) {
    	j.epitmenyKeszul(this);
    	all = true;
    	k.targy_elhasznalasa(this);
    	k.set_munkak_szama(k.get_munkakszama()-1);
    	}
    }
    
    /** Minden k�r eset�n a s�tor haszn�l�dik.*/
    public void hasznalodik() {
		hasznalatban++;
		if (hasznalatban > hasznalhato) all = false;
	}
}
