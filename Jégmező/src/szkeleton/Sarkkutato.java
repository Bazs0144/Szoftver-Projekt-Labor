package szkeleton;

public class Sarkkutato extends Karakter {
	
	public int megnez(Jegtabla j) {
		System.out.println("------->  megnez(Jegtabla j)");
		int kap;
		if(this.jegtabla.szomszed_e(j))
			kap = j.getKapacitas();
		else
			kap = -1;
		System.out.println("<------- megnez(Jegtabla j)");
		return kap;
	}
}
