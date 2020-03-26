package szkeleton;

public class Stabil extends Jegtabla {
	
	public Stabil() {
		Szkeleton.printTabs(true);
		System.out.println("-------> Stabil()  *konstruktor*");
		Szkeleton.printTabs(false);
		System.out.println("<------- Stabil()  *konstruktor*");
	}
	
	@Override
	public void ralepnek(Karakter k) {
		Szkeleton.printTabs(true);
		System.out.println("------->ralepnek(Karakter k)");
		System.out.print("karakter.");
		karakterek.add(k);
		k.setJegtabla(this);
		Szkeleton.printTabs(false);
		System.out.println("<-------ralepnek(Karakter k)");
	}
}
