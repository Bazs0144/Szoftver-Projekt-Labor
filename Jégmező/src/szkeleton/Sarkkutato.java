package szkeleton;

public class Sarkkutato extends Karakter {
	
	public void megnez(Jegtabla j) {
		System.out.println("------->  megnez(Jegtabla j)");
		j.getKapacitas();
		System.out.println("<------- megnez(Jegtabla j)");
	}
}
