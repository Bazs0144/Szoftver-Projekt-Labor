package szkeleton;

public class Sarkkutato extends Karakter {
	
	public int megnez(Jegtabla j) {
		System.out.println("------->  megnez(Jegtabla j)");
		int kap = j.getKapacitas();
		System.out.println("<------- megnez(Jegtabla j)");
		return kap;
	}
}
