package proto;

public class Eszkimo extends Karakter {

	/**
	 * Az eszkim� oszt�ly konstruktora, mely ki�r�s miatt lett implement�lva.
	 */
	public Eszkimo() {
		Szkeleton.printFunction("-------> Eszkimo() *konstruktor*", true, this);
		Szkeleton.printFunction("<------- Eszkimo() *konstruktor*", false, this);
	}

	/**
	 * Az eszkim� k�l�nleges k�pess�ge, amellyel iglut �p�thet�nk a tart�zkod�si hely�n.
	 * @return: Ha siker�lt az iglu �p�t�se igazzal t�r vissza, egy�bk�nt hamissal.
	 */
	public boolean iglut_epit() {
		Szkeleton.printFunction("------->  iglut_epit()", true, this);
		
		if(jegtabla.getEpitmeny() != null) {
			if(jegtabla.getHoMennyiseg() == 0)
				if(jegtabla.getTargy() == null)
				{
					Iglu I = new Iglu();
					jegtabla.epitmenyKeszul(I);
					Szkeleton.printFunction("<--true-- iglut_epit()", false, this);
					//this.munkak_szama--;
					return true;
				}
		}

		Szkeleton.printFunction("<--false-- iglut_epit()", false, this);
		return false;

	}
	
}