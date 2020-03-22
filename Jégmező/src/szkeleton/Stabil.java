package szkeleton;

public class Stabil extends Jegtabla {
	
	public Stabil() {
		System.out.println("-------> Stabil()  *konstruktor*");
		System.out.println("<------- Stabil()  *konstruktor*");
	}
	
	@Override
	public void ralepnek(Karakter k) {
		System.out.println("------->ralepnek(Karakter k)");
		k.setJegtabla(this);
		System.out.println("<-------ralepnek(Karakter k)");
	}
}
