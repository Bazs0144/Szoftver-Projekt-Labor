package szkeleton;

public class Sarkkutato extends Karakter {
	
	public Sarkkutato() {
		Szkeleton.printTabs(true);
		System.out.println("-------> Sarkkutato() *konstruktor*");
		Szkeleton.printTabs(false);
		System.out.println("<------- Sarkkutato() *konstruktor*");
	}
	
	public int megnez(Jegtabla j) {
		Szkeleton.printTabs(false);
		System.out.println("------->  megnez(Jegtabla j)");
		int kap;
		if(this.jegtabla.szomszed_e(j))
			kap = j.getKapacitas();
		else
			kap = -1;
		Szkeleton.printTabs(false);
		System.out.println("<------- megnez(Jegtabla j)");
		return kap;
	}
}
