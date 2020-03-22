package szkeleton;

public class Luk extends Jegtabla{

	public Luk() {
		System.out.println("-------> Luk()  *konstruktor*");
		System.out.println("<------- Luk()  *konstruktor*");
	}
	
	@Override
	public void ralepnek(Karakter k) {
		System.out.println("------->ralepnek(Karakter k)");
		k.setJegtabla(this);
		k.vizbe_esik();
		System.out.println("<-------ralepnek(Karakter k)");
	}
}
