package szkeleton;

public class Eszkimo extends Karakter {
	
	public void iglut_epit() {
		
		System.out.println("------->  iglut_epit()");
		
		if(!jegtabla.getVanIglu()) {
			if(jegtabla.getHoMennyiseg() == 0)
				if(jegtabla.getTargy() == null)
					System.out.println("<---true---- iglut_epit()");
		}
		else
			System.out.println("<---false---- iglut_epit()");
	}
	
}
