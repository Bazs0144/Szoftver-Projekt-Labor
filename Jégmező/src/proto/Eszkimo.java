package proto;

import java.io.Serializable;

public class Eszkimo extends Karakter implements Serializable {
	/**
	 * Az eszkimó különleges képessége, amellyel iglut építhetünk a tartózkodási helyén.
	 * @return: Ha sikerült az iglu építése igazzal tér vissza, egyébként hamissal.
	 */
	public Eszkimo() {
		Name = "Eszkimo";
	}

	public boolean iglut_epit() {
		if(jegtabla.getEpitmeny() != null) {
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
	
}