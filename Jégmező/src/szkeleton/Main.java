package szkeleton;

import java.util.Scanner;

public class Main {
	 public static void main(String[] args)
	 {
		// System.out.println("Hello :) ");
		 Szkeleton.kiir_menu();
		 int i = 14;
		 Scanner in_main = new Scanner(System.in);
		
		while(i != 0) {
			System.out.println("A felhasznalo valasztasanak sorszama: ");
			i = in_main.nextInt();
			Szkeleton.valasztas(i);
		}
		
		in_main.close();
	 }

}
