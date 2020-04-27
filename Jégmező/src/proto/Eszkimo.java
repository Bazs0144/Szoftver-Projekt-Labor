package proto;

import java.io.Serializable;

public class Eszkimo extends Karakter implements Serializable {
	/**
	 * Az eszkim� k�l�nleges k�pess�ge, amellyel iglut �p�thet�nk a tart�zkod�si hely�n.
	 * @return: Ha siker�lt az iglu �p�t�se igazzal t�r vissza, egy�bk�nt hamissal.
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