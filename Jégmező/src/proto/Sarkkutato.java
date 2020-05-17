package proto;

import java.io.Serializable;

public class Sarkkutato extends Karakter implements Serializable {
	/**
	 * A Sarkkutato konstruktora, a homerseklete alapbol 4
	 */
	public Sarkkutato() {
		Name = "Polar explorer";
		ho = 4;
	}
	/**
	 * A sarkkutato kepess�ee, amellyel meg lehet tudni egy szomszedos mezorol, hogy hany embert bir el.
	 * @param j: A jegtabla, amelynek szeretnenk megtudni a kapacitasat.
	 * @return kap: A jegtabla kapacitasa, ha -1-el ter vissza, akkor nem szomszedos mezot probalt megvizsgalni a karakter.
	 */
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
	
	public Poz getPoz() {
		return jegtabla.getPoz();
		}
}
