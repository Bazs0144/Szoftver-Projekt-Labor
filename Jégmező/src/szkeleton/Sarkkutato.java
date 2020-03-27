package szkeleton;

public class Sarkkutato extends Karakter {
	
	public Sarkkutato() {
		Szkeleton.printFunction("-------> Sarkkutato() *konstruktor*", true, this);
		Szkeleton.printFunction("<------- Sarkkutato() *konstruktor*", false, this);
	}
	
	public int megnez(Jegtabla j) {
		Szkeleton.printFunction("------->  megnez(Jegtabla j)", true, this);
		int kap;
		if(this.jegtabla.szomszed_e(j))
			kap = j.getKapacitas();
		else
			kap = -1;
		Szkeleton.printFunction("<------- megnez(Jegtabla j)", false, this);
		return kap;
	}
}
