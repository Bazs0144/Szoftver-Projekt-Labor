package szkeleton;

public class Alkatresz extends Targy {
	private int id;

	public Alkatresz(int i) {
		Szkeleton.printTabs(true);
		System.out.println("-------> Alkatresz(int i) *konstruktor*");
		id = i;
		Szkeleton.printTabs(false);
		System.out.println("<------- Alkatresz(int i ) *konstruktor*");
	}
}
