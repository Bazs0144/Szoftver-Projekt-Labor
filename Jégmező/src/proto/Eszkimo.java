package proto;

public class Eszkimo extends Karakter {

	/**
	 * Az eszkimó osztály konstruktora, mely kiírás miatt lett implementálva.
	 */
	public Eszkimo() {
		Szkeleton.printFunction("-------> Eszkimo() *konstruktor*", true, this);
		Szkeleton.printFunction("<------- Eszkimo() *konstruktor*", false, this);
	}

	/**
	 * Az eszkimó különleges képessége, amellyel iglut építhetünk a tartózkodási helyén.
	 * @return: Ha sikerült az iglu építése igazzal tér vissza, egyébként hamissal.
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