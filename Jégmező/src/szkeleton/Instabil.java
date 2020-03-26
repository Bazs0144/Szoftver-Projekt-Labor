package szkeleton;

import java.util.Scanner;

public class Instabil extends Jegtabla{
	private int karakterek_szama;
//	private int kapacitas;
	
	public Instabil() {
        Szkeleton.printTabs(true);
		System.out.println("-------> Instabil()  *konstruktor*");
        Szkeleton.printTabs(false);
		System.out.println("<------- Instabil()  *konstruktor*");
	}
	
	@Override
	public void ralepnek(Karakter k) {
        Szkeleton.printTabs(true);
		System.out.println("------->ralepnek(Karakter k)");
		System.out.print("karakter.");
		k.setJegtabla(this);
		karakterek.add(k);
		System.out.println("Tobb karakter van mint amennyi a kapacitas?");
		Scanner in = new Scanner(System.in);
		int I = in.nextInt();
		
		if(I == 1) {
			System.out.print("this jegtabla.");
			felfordul(k);
		}
        Szkeleton.printTabs(false);
		System.out.println("<-------ralepnek(Karakter k)");
	}
	
	public void felfordul(Karakter k) {
        Szkeleton.printTabs(true);
		System.out.println("------->felfordul(Karakter k)");
		System.out.print("karakter.");
		k.vizbe_esik();
        Szkeleton.printTabs(false);
		System.out.println("<-------felfordul(Karakter k)");
	}
}
