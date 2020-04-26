package proto;

public class Sarkkutato extends Karakter {
	
	/**
	 * Sarkkutato oszt�ly konstruktora, mely ki�r�s miatt lett implement�lva.
	 */
	public Sarkkutato() {
		Szkeleton.printFunction("-------> Sarkkutato() *konstruktor*", true, this);
		Szkeleton.printFunction("<------- Sarkkutato() *konstruktor*", false, this);
	}
	
	
	/**
	 * A sarkkutat� k�pess�ge, amellyel meg lehet tudni egy szomsz�dos mez�r�l, hogy h�ny embert b�r el.
	 * @param j: A j�gt�bla, amelynek szeretn�nk megtudni a kapacit�s�t.
	 * @return kap: A j�gt�bla kapacit�sa, ha -1-el t�r vissza, akkor nem szomsz�dos mez�t pr�b�lt megvizsg�lni a karakter.
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
