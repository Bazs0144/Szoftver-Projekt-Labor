package szkeleton;


public final class Szkeleton {
		
	public static void kiir_menu() {
		System.out.println("Menü: ");
		System.out.println("1.  Játékos ételt használ");
		System.out.println("2.  Játékos takarit");
		System.out.println("3.  Játékos lapáttal takarit");
		System.out.println("4.  Játékos targyat felvesz");
		System.out.println("5.  Játékos jégtáblára lép");
		System.out.println("6.  Játékos jégtáblára lép, átfordul");
		System.out.println("7.  Játékos lukra lép");
		System.out.println("8.  Játékos kiment egy társát");
		System.out.println("9.  Eszkimó iglut épit");
		System.out.println("10. Sarkkutató jégtáblát vizsgál");
		System.out.println("11. Rakéta elsütése");
		System.out.println("12. Hóvihar elkap egy karaktert");
		System.out.println("13. Hóvihar, de iglu megvéd");
		System.out.println("0.  Kilépés a menûbõl");
	}
	
	public static void valasztas(int I) {
		
		
		switch(I) {
		  case 1:
			  
		    break;
		  case 2:
		    // code block
		    break;
		  case 3:
			  
			 break;
		  case 4:
			    // code block
			  break;
		  case 5:
				  
			  break;
		  case 6:
				    // code block
			  break;
		  case 7:
			  
			   break;
		  case 8:
			    // code block
			   break;
		  case 9:
				  
			  break;
		  case 10:
				    // code block
			  break;
		  case 11:
					  
			  break;
		  case 12:
			  Jegtabla Jt = new Jegtabla();
			  Karakter K = new Karakter();
			  Jt.ralepnek(K);
			  Jt.hovihar_volt();
			  
			  break;	
		  case 13:
			    // code block
			  break;	
		  default:
		    // code block
		}
	}
	
}
