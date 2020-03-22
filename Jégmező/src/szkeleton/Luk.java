package szkeleton;

public class Luk extends Jegtabla{

	public Luk() {
		System.out.println("-------> Luk()  *konstruktor*");
		System.out.println("<------- Luk()  *konstruktor*");
	}
	
	@Override
	public void ralepnek(Karakter k) {
		System.out.println("------->ralepnek(Karakter k)");
		System.out.print("karakter.");
		karakterek.add(k);
		k.setJegtabla(this);
		System.out.print("karakter.");
		k.vizbe_esik();
		System.out.println("<-------ralepnek(Karakter k)");
	}
}
