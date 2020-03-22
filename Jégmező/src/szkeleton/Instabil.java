package szkeleton;

import java.util.Scanner;

public class Instabil extends Jegtabla{
	private int karakterek_szama;
//	private int kapacitas;
	
	public Instabil() {
		System.out.println("-------> Instabil()  *konstruktor*");
		System.out.println("<------- Instabil()  *konstruktor*");
	}
	
	@Override
	public void ralepnek(Karakter k) {
		System.out.println("------->ralepnek(Karakter k)");
		System.out.print("karakter.");
		k.setJegtabla(this);
		System.out.println("Tobb karakter van mint amennyi a kapacitas?");
		Scanner in = new Scanner(System.in);
		int I = in.nextInt();
		
		if(I == 1) {
			System.out.print("this jegtabla.");
			felfordul(k);
		}
		System.out.println("<-------ralepnek(Karakter k)");
	}
	
	public void felfordul(Karakter k) {
		System.out.println("------->felfordul(Karakter k)");
		System.out.print("karakter.");
		k.vizbe_esik();
		System.out.println("<-------felfordul(Karakter k)");
	}
}
