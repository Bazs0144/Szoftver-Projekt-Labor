package szkeleton;

public class Eszkimo extends Karakter {

	public Eszkimo() {
		Szkeleton.printFunction("-------> Eszkimo() *konstruktor*", true, this);
		Szkeleton.printFunction("<------- Eszkimo() *konstruktor*", false, this);
	}

	public boolean iglut_epit() {
		Szkeleton.printFunction("------->  iglut_epit()", true, this);
		
		if(!jegtabla.getVanIglu()) {
			if(jegtabla.getHoMennyiseg() == 0)
				if(jegtabla.getTargy() == null)
				{
					jegtabla.igluEpitese();
					Szkeleton.printFunction("<--true-- iglut_epit()", false, this);
					return true;
				}
		}

		Szkeleton.printFunction("<--false-- iglut_epit()", false, this);
		return false;

	}
	
}