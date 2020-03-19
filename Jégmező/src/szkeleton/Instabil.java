package szkeleton;

import java.util.Scanner;

public class Instabil extends Jegtabla{
	private int karakterek_szama;
//	private int kapacitas;
	
	@Override
	public void ralepnek(Karakter k) {
		System.out.println("------->ralepnek(Karakter k)");
		k.setJegtabla(this);
		System.out.println("Tobb karakter van mint amennyi a kapacitas?");
		Scanner in = new Scanner(System.in);
		int I = in.nextInt();
		
		if(I == 1) felfordul(k);
		
		in.close();
		System.out.println("<-------ralepnek(Karakter k)");
	}
	
	public void felfordul(Karakter k) {
		System.out.println("------->felfordul(Karakter k)");
		k.vizbe_esik();
		System.out.println("<-------felfordul(Karakter k)");
	}
}
