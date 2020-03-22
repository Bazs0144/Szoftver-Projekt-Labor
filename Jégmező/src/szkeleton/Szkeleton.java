package szkeleton;

import java.util.ArrayList;

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
		System.out.println("14: Játék menete");
		System.out.println("15: Hóvihar végigsöpör a jégmezõn");
		System.out.println("0.  Kilépés a menübõl");
	}
	
	public static void valasztas(int I) {
		
		
		switch(I) {
		  case 1:
			  Player p1=new Player(new Karakter());
			  Etel e= new Etel();
			  Jegtabla j1 = new Jegtabla();
			  p1.getKarakter().setJegtabla(j1);
			  p1.getKarakter().hasznal(e, p1.getKarakter().getJegtabla());
		    break;
		  case 2:
			  Player p2=new Player(new Karakter());
			  Jegtabla j2 = new Jegtabla();
			  p2.getKarakter().setJegtabla(j2);
			  int erosseg=1;
			  p2.getKarakter().takarit(erosseg);
		    break;
		  case 3:
			  Player p3=new Player(new Karakter());
			  Jegtabla j3 = new Jegtabla();
			  p3.getKarakter().setJegtabla(j3);
			  Lapat l= new Lapat();
			  p3.getKarakter().hasznal(l, p3.getKarakter().getJegtabla());
			 break;
		  case 4:
			  Player p4=new Player(new Karakter());
			  Targy t=new Targy();
			  Jegtabla j4 = new Jegtabla();
			  p4.getKarakter().setJegtabla(j4);
			  p4.getKarakter().getJegtabla().setTargy(t);
			  boolean sikerult=p4.getKarakter().targy_felvetele();
			  if(sikerult) System.out.println("Tárgy felvéve");
			  else System.out.println("Tárgy felvétel nem sikerült");
			  break;
		  case 5:
			  Player p5=new Player(new Karakter());
			  p5.getKarakter().setJegtabla(new Jegtabla());
			  Jegtabla j5=new Jegtabla();
			  boolean siker=p5.getKarakter().lep(j5);
			  if(siker) System.out.println("Lépés sikerült");
			  else System.out.println("Lépés nem sikerült");
			  break;
		  case 6:
			  Player p6=new Player(new Karakter());
			  Jegtabla j6 = new Jegtabla();
			  p6.getKarakter().setJegtabla(j6);
			  Instabil ins = new Instabil();
			  boolean hat=p6.getKarakter().lep(ins);
			  if(hat) System.out.println("Lépés sikerült");
			  else System.out.println("Lépés nem sikerült");
			  break;
		  case 7:
			  Player p7=new Player(new Karakter());
			  Jegtabla j7 = new Jegtabla();
			  p7.getKarakter().setJegtabla(j7);
			  Luk luk= new Luk();
			  boolean het=p7.getKarakter().lep(luk);
			  if(het) System.out.println("Lépés sikerült");
			  else System.out.println("Lépés nem sikerült");
			   break;
		  case 8:
			  /*
			  Player lukban=new Player(new Karakter());
			  Luk l8 = new Luk();
			  lukban.getKarakter().setJegtabla(l8);
			  Player mento=new Player(new Karakter());
			  Stabil s8 = new Stabil();
			  mento.getKarakter().setJegtabla(s8);
			  mento.getKarakter().menekit(lukban.getKarakter());*/
			  Karakter lukban= new Karakter();
			  Luk luk1= new Luk();
			  luk1.ralepnek(lukban);
			  Karakter mento= new Karakter();
			  Stabil stabil =new Stabil();
			  stabil.ralepnek(mento);
			  mento.hasznal(new Kotel(), luk1);
			  break;
		  case 9:
			  Eszkimo eszk = new Eszkimo();
			  Jegtabla j9 = new Jegtabla();
			  eszk.setJegtabla(j9);
			  if(eszk.iglut_epit())
				  System.out.println("Iglu építés sikerült");
			  else System.out.println("Iglu építés nem sikerült");
			  break;
		  case 10:
			  Jegtabla j10 = new Jegtabla();
			  Jegtabla kutatott = new Jegtabla();
			  Sarkkutato sk = new Sarkkutato();
			  sk.setJegtabla(j10);
			  sk.megnez(kutatott);
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
			  Jegtabla j13 = new Jegtabla();
			  Eszkimo es = new Eszkimo();
			  es.setJegtabla(j13);
			  es.iglut_epit();
			  es.getJegtabla().hovihar_volt();
			  break;	
		  case 14:
			  ArrayList<Player> p_array = new ArrayList<Player>();
			  p_array.add(new Player(new Karakter()));
			  p_array.add(new Player(new Karakter()));
			  p_array.add(new Player(new Karakter()));
			  Jatektabla jatek = new Jatektabla(5, p_array);
		  	  break;
		  case 15:
		  	  Jegmezo jm = new Jegmezo(10);
		  	  jm.hovihar_indul();
		  	  break;
		  default:
		    // code block
		}
	}
	
}