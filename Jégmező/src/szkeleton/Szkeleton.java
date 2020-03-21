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
		System.out.println("0.  Kilépés a menübõl");
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
			  Player p3=new Player(new Karakter());
			  p3.getKarakter().setJegtabla(new Jegtabla());
			  Lapat l= new Lapat();
			  p3.getKarakter().hasznal(l, p3.getKarakter().getJegtabla());
			 break;
		  case 4:
			  Player p4=new Player(new Karakter());
			  Targy t=new Targy();
			  p4.getKarakter().setJegtabla(new Jegtabla());
			  p4.getKarakter().getJegtabla().setTargy(t);
			  boolean sikerult=p4.getKarakter().targy_felvetele();
			  if(sikerult) System.out.println("Tárgy felvéve");
			  else System.out.println("Tárgy felvétel nem sikerült");
			  break;
		  case 5:
			  Player p5=new Player(new Karakter());
			  p5.getKarakter().setJegtabla(new Jegtabla());
			  Jegtabla j2=new Jegtabla();
			  boolean siker=p5.getKarakter().lep(j2);
			  if(siker) System.out.println("Lépés sikerült");
			  else System.out.println("Lépés nem sikerült");
			  break;
		  case 6:
			  Player p6=new Player(new Karakter());
			  p6.getKarakter().setJegtabla(new Jegtabla());
			  Instabil ins = new Instabil();
			  boolean hat=p6.getKarakter().lep(ins);
			  if(hat) System.out.println("Lépés sikerült");
			  else System.out.println("Lépés nem sikerült");
			  break;
		  case 7:
			  Player p7=new Player(new Karakter());
			  p7.getKarakter().setJegtabla(new Jegtabla());
			  Luk luk= new Luk();
			  boolean het=p7.getKarakter().lep(luk);
			  if(het) System.out.println("Lépés sikerült");
			  else System.out.println("Lépés nem sikerült");
			   break;
		  case 8:

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
