package szkeleton;

public class Eszkimo extends Karakter {

	public Eszkimo() {
		System.out.println("-------> Eszkimo() *konstruktor*");
		System.out.println("<------- Eszkimo() *konstruktor*");
	}

	public boolean iglut_epit() {
		
		System.out.println("------->  iglut_epit()");
		
		if(!jegtabla.getVanIglu()) {
			if(jegtabla.getHoMennyiseg() == 0)
				if(jegtabla.getTargy() == null)
				{
					jegtabla.igluEpitese();
					System.out.println("<---true---- iglut_epit()");
					return true;
				}
		}
		else
			System.out.println("<---false---- iglut_epit()");
		return false;
	}
	
}