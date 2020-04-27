package proto;

import java.io.Serializable;

public class Sarkkutato extends Karakter implements Serializable {
	/**
	 * A sarkkutat� k�pess�ge, amellyel meg lehet tudni egy szomsz�dos mez�r�l, hogy h�ny embert b�r el.
	 * @param j: A j�gt�bla, amelynek szeretn�nk megtudni a kapacit�s�t.
	 * @return kap: A j�gt�bla kapacit�sa, ha -1-el t�r vissza, akkor nem szomsz�dos mez�t pr�b�lt megvizsg�lni a karakter.
	 */
	public Sarkkutato() {
		Name = "Sarkkutato";
		ho = 4;
	}

	public int megnez(Jegtabla j) {
		int kap;
		if(this.jegtabla.szomszed_e(j)) {
			kap = j.getKapacitas();
			munkak_szama--;
			}
		else
			kap = -1;
		return kap;
	}
}
