package proto;

import java.io.Serializable;
import java.util.ArrayList;

public class Alkatresz extends Targy implements Serializable {
	private Jatektabla jt;

	/**
	 *Létrehozza az alkatrészt, kiírja a meghívását és beállítja a játéktáblát amin van
	 */
	public Alkatresz(Jatektabla j) {
		jt=j;
		Name = "Alkatresz";
	}

	/**
	 * Lekéri a játéktáblát hogy hol van a többi alkatrész, ezeket összegyűjti egy jégtábla tömbbe, és ha ezek mind megegyeznek azzal amin őt használták akkor sikerült összerakni
	 * és szól a játéktáblának hogy vége a játéknak
	 * @param k: ez a Karakter használja
	 * @param hol : ezen a Jégtáblán használják
	 */
	public void hasznaljak(Karakter k, Jegtabla hol) {
		if(k.vizben_van) return;
		k.munkak_szama--;
		ArrayList<Alkatresz> alk = new ArrayList<>(jt.getAlkatresz());
		ArrayList<Jegtabla> jegt=new ArrayList<>();
		for(Alkatresz j : alk) {
			jegt.add(j.getKarakter().getJegtabla());
		}
		boolean siker=true;
		for(Jegtabla jeg: jegt) {
			if (!jeg.equals(hol)) {
				siker = false;
				break;
			}
		}
		if(siker) {
			for(Player pl: jt.getPlayers())
			pl.getKarakter().setHo(0);
		}
	}
	
	public Poz getPoz() {
		return k.jegtabla.getPoz();
	}
}
