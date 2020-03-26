package szkeleton;

public class Eszkimo extends Karakter {

	public Eszkimo() {
		Szkeleton.printTabs(true);
		System.out.println("-------> Eszkimo() *konstruktor*");
		Szkeleton.printTabs(false);
		System.out.println("<------- Eszkimo() *konstruktor*");
	}

	public boolean iglut_epit() {
		Szkeleton.printTabs(true);
		System.out.println("------->  iglut_epit()");
		
		if(!jegtabla.getVanIglu()) {
			if(jegtabla.getHoMennyiseg() == 0)
				if(jegtabla.getTargy() == null)
				{
					jegtabla.igluEpitese();
					Szkeleton.printTabs(false);
					System.out.println("<---true---- iglut_epit()");
					return true;
				}
		}
		else
			Szkeleton.printTabs(false);
			System.out.println("<---false---- iglut_epit()");
		return false;
	}
	
}