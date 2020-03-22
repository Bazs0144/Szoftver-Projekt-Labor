package szkeleton;

public class Alkatresz extends Targy {
	private int id;

	public Alkatresz(int i) {
		System.out.println("-------> Alkatresz(int i) *konstruktor*");
		id = i;
		System.out.println("<------- Alkatresz(int i ) *konstruktor*");
	}
}
