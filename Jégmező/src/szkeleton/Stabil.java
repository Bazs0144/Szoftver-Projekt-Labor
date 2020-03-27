package szkeleton;

public class Stabil extends Jegtabla {
	
	public Stabil() {
		Szkeleton.printFunction("-------> Stabil()  *konstruktor*", true,  this);
		Szkeleton.printFunction("<------- Stabil()  *konstruktor*", false, this);
	}
	
	@Override
	public void ralepnek(Karakter k) {
		Szkeleton.printFunction("------->ralepnek(Karakter k)", true, this);
		karakterek.add(k);
		k.setJegtabla(this);
		Szkeleton.printFunction("<-------ralepnek(Karakter k)", false, this);
	}
}
