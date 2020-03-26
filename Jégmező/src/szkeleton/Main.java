package szkeleton;

import java.util.Scanner;

public class Main {
	 public static void main(String[] args)
	 {
	     Szkeleton.kiir_menu();
		 int I = 14;
		 Scanner in_main = new Scanner(System.in);
		
		while(I != 0) {
			System.out.println("A felhasználó választásának sorszáma: ");
			I = in_main.nextInt();
			System.out.println("------------A szimuláció elkezdõdött------------");
			Szkeleton.valasztas(I);
			System.out.println("------------A szimulációnak vége----------------");
		}
		
		in_main.close();
	 }

}
