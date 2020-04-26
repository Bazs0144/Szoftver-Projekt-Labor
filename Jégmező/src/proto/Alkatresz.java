package proto;

import java.util.ArrayList;

public class Alkatresz extends Targy {
	private Jatektabla jt;

	/**
	 *Létrehozza az alkatrészt, kiírja a meghívását és beállítja a játéktáblát amin van
	 */
	public Alkatresz(Jatektabla j) {
		Szkeleton.printFunction("-------> Alkatresz(Jatektabla j) *konstruktor*", true, this);
		jt=j;
		Szkeleton.printFunction("<------- Alkatresz(Jatektabla j) *konstruktor*", false,this);
	}

	/**
	 * Lekéri a játéktáblát hogy hol van a többi alkatrész, ezeket összegyűjti egy jégtábla tömbbe, és ha ezek mind megegyeznek azzal amin őt használták akkor sikerült összerakni
	 * és szól a játéktáblának hogy vége a játéknak
	 * @param k: ez a Karakter használja
	 * @param hol : ezen a Jégtáblán használják
	 */
	public void hasznaljak(Karakter k, Jegtabla hol) {
		Szkeleton.printFunction("-------> hasznaljak(Karakter k, Jegtabla hol)", true, this);
		if(k.vizben_van) return;
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
		if(siker) jt.game_over();
		else Szkeleton.printFunction("Alkatrész összerakás nem sikerült", true, this);
		Szkeleton.printFunction("<------- hasznaljak(Karakter k, Jegtabla hol)", true, this);
	}
}
