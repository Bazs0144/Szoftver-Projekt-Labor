package proto;

import java.io.Serializable;

public class Eszkimo extends Karakter implements Serializable {

	/**
	 * Eszkimo konstruktora, az eszkimonak alapból 5 a homerseklete
	 */
	public Eszkimo() {
		Name = "Eskimo";
		ho = 5;
	}

	/**
	 * Az eszkimó különleges képessége, amellyel iglut építhetünk a tartózkodási helyén.
	 * @return: Ha sikerült az iglu építése igazzal tér vissza, egyébként hamissal.
	 */
	public boolean iglut_epit() {
		if(jegtabla.getEpitmeny() == null) { //??? Itt miert volt !=
			if(jegtabla.getHoMennyiseg() == 0)
				if(jegtabla.getTargy() == null)
				{
					Iglu I = new Iglu();
					jegtabla.epitmenyKeszul(I);
					this.munkak_szama--;
					return true;
				}
		}

		return false;

	}
	
	public Poz getPoz() {
		return jegtabla.getPoz();
		}
	
}
