package szkeleton;

import java.util.Scanner;

public class Main {
	 public static void main(String[] args)
	 {
	     Szkeleton.kiir_menu();
		 int I = 14;
		 Scanner in_main = new Scanner(System.in);
		
		while(I != 0) {
			System.out.println("A felhaszn�l� v�laszt�s�nak sorsz�ma: ");
			I = in_main.nextInt();
			System.out.println("------------A szimul�ci� elkezd�d�tt------------");
			Szkeleton.valasztas(I);
			System.out.println("------------A szimul�ci�nak v�ge----------------");
		}
		
		in_main.close();
	 }

}
