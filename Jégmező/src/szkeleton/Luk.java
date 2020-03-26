package szkeleton;

public class Luk extends Jegtabla{

	public Luk() {
		Szkeleton.printTabs(true);
		System.out.println("-------> Luk()  *konstruktor*");
		Szkeleton.printTabs(false);
		System.out.println("<------- Luk()  *konstruktor*");
	}
	
	@Override
	public void ralepnek(Karakter k) {
		Szkeleton.printTabs(true);
		System.out.println("------->ralepnek(Karakter k)");
		System.out.print("karakter.");
		karakterek.add(k);
		k.setJegtabla(this);
		System.out.print("karakter.");
		k.vizbe_esik();
		Szkeleton.printTabs(false);
		System.out.println("<-------ralepnek(Karakter k)");
	}
}
