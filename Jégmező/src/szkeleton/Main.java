package szkeleton;

import java.util.Scanner;

public class Main {
	 public static void main(String[] args)
	 {
		// System.out.println("Hello :) ");
		 Szkeleton.kiir_menu();
		 int I = 14;
		 Scanner in_main = new Scanner(System.in);
		
		while(I != 0) {
			System.out.println("A felhaszn�l� v�laszt�s�nak sorsz�ma: ");
			I = in_main.nextInt();
			Szkeleton.valasztas(I);	
		}
		
		in_main.close();
	 }

}
