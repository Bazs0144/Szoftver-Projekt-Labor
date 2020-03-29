package szkeleton;

public class Sarkkutato extends Karakter {
	
	/**
	 * Sarkkutato osztály konstruktora, mely kiírás miatt lett implementálva.
	 */
	public Sarkkutato() {
		Szkeleton.printFunction("-------> Sarkkutato() *konstruktor*", true, this);
		Szkeleton.printFunction("<------- Sarkkutato() *konstruktor*", false, this);
	}
	
	
	/**
	 * A sarkkutató képessége, amellyel meg lehet tudni egy szomszédos mezõrõl, hogy hány embert bír el.
	 * @param j: A jégtábla, amelynek szeretnénk megtudni a kapacitását.
	 * @return kap: A jégtábla kapacitása, ha -1-el tér vissza, akkor nem szomszédos mezõt próbált megvizsgálni a karakter.
	 */
	public int megnez(Jegtabla j) {
		Szkeleton.printFunction("------->  megnez(Jegtabla j)", true, this);
		int kap;
		if(this.jegtabla.szomszed_e(j)) {
			kap = j.getKapacitas();
			//this.munkak_szama--;
			}
		else
			kap = -1;
		Szkeleton.printFunction("<------- megnez(Jegtabla j)", false, this);
		return kap;
	}
}
