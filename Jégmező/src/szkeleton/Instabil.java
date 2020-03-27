package szkeleton;

import java.util.Scanner;

public class Instabil extends Jegtabla{
	private int karakterek_szama;
//	private int kapacitas;
	
	public Instabil() {
		Szkeleton.printFunction("-------> Instabil()  *konstruktor*", true, this);
		Szkeleton.printFunction("<------- Instabil()  *konstruktor*", false, this);
	}
	
	@Override
	public void ralepnek(Karakter k) {
		Szkeleton.printFunction("------->ralepnek(Karakter k)", true, this);
		k.setJegtabla(this);
		karakterek.add(k);
		System.out.println("Tobb karakter van mint amennyi a kapacitas?");
		Scanner in = new Scanner(System.in);
		int I = in.nextInt();
		
		if(I == 1) {
			felfordul(k);
		}
		Szkeleton.printFunction("<-------ralepnek(Karakter k)", false, this);
	}
	
	public void felfordul(Karakter k) {
		Szkeleton.printFunction("------->felfordul(Karakter k)", true, this);
		k.vizbe_esik();
		Szkeleton.printFunction("<-------felfordul(Karakter k)", false, this);
	}
}
