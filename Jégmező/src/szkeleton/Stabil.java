package szkeleton;

public class Stabil extends Jegtabla {
	
	@Override
	public void ralepnek(Karakter k) {
		System.out.println("------->ralepnek(Karakter k)");
		k.setJegtabla(this);
		System.out.println("<-------ralepnek(Karakter k)");
	}
}
