package szkeleton;


public final class Szkeleton {
		
	public static void kiir_menu() {
		System.out.println("Men�: ");
		System.out.println("1.  J�t�kos �telt haszn�l");
		System.out.println("2.  J�t�kos takarit");
		System.out.println("3.  J�t�kos lap�ttal takarit");
		System.out.println("4.  J�t�kos targyat felvesz");
		System.out.println("5.  J�t�kos j�gt�bl�ra l�p");
		System.out.println("6.  J�t�kos j�gt�bl�ra l�p, �tfordul");
		System.out.println("7.  J�t�kos lukra l�p");
		System.out.println("8.  J�t�kos kiment egy t�rs�t");
		System.out.println("9.  Eszkim� iglut �pit");
		System.out.println("10. Sarkkutat� j�gt�bl�t vizsg�l");
		System.out.println("11. Rak�ta els�t�se");
		System.out.println("12. H�vihar elkap egy karaktert");
		System.out.println("13. H�vihar, de iglu megv�d");
		System.out.println("0.  Kil�p�s a men�b�l");
	}
	
	public static void valasztas(int I) {
		
		
		switch(I) {
		  case 1:
			  Player p1=new Player(new Karakter());
			  Etel e= new Etel();
			  p1.getKarakter().hasznal(e, p1.getKarakter().getJegtabla());
		    break;
		  case 2:
			  Player p2=new Player(new Karakter());
			  p2.getKarakter().setJegtabla(new Jegtabla());
			  int erosseg=1;
			  p2.getKarakter().takarit(erosseg);
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
			  Eszkimo eszk = new Eszkimo();
			  eszk.setJegtabla(new Jegtabla());
			  eszk.iglut_epit();
				  
			  break;
		  case 10:
			  Sarkkutato sk = new Sarkkutato();
			  sk.megnez(new Jegtabla());
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
