package szkeleton;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public final class Szkeleton {
	private static int numberOfTabs = -1;
	private static PrintStream printStreamOriginal = System.out;

	public static void enableOutput(boolean b) {
		if(!b) {
			System.setOut(new PrintStream(new OutputStream(){
				public void write(int b) {
				}
			}));
		}
		else System.setOut(printStreamOriginal);
	}

	public static void printTabs(boolean in) {
		if (in) numberOfTabs++;
		for (int i = 0; i < numberOfTabs; i++)
			System.out.print('\t');
		if (!in) numberOfTabs--;
	}
		
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
		System.out.println("14: J�t�k menete");
		System.out.println("15: H�vihar v�gigs�p�r a j�gmez�n");
		System.out.println("0.  Kil�p�s a men�b�l");
	}
	
	public static void valasztas(int I) {
		
		
		switch(I) {
		  case 1:
		  	  enableOutput(false);
			  Player p1=new Player(new Karakter());
			  Etel e= new Etel();
			  Jegtabla j1 = new Jegtabla();
			  p1.getKarakter().setJegtabla(j1);
			  enableOutput(true);
			  //----------
			  p1.getKarakter().hasznal(e, p1.getKarakter().getJegtabla());
		    break;
		  case 2:
		  	  enableOutput(false);
			  Player p2=new Player(new Karakter());
			  Jegtabla j2 = new Jegtabla();
			  p2.getKarakter().setJegtabla(j2);
			  int erosseg=1;
			  enableOutput(true);
			  //----------
			  p2.getKarakter().takarit(erosseg);
		    break;
		  case 3:
		  	  enableOutput(false);
			  Player p3=new Player(new Karakter());
			  Jegtabla j3 = new Jegtabla();
			  p3.getKarakter().setJegtabla(j3);
			  Lapat l= new Lapat();
			  enableOutput(true);
			  //----------
			  p3.getKarakter().hasznal(l, p3.getKarakter().getJegtabla());
			 break;
		  case 4:
			  enableOutput(false);
			  Player p4=new Player(new Karakter());
			  Targy t=new Targy();
			  Jegtabla j4 = new Jegtabla();
			  p4.getKarakter().setJegtabla(j4);
			  p4.getKarakter().getJegtabla().setTargy(t);
			  enableOutput(true);
			  //----------
			  boolean sikerult=p4.getKarakter().targy_felvetele();
			  if(sikerult) System.out.println("T�rgy felv�ve");
			  else System.out.println("T�rgy felv�tel nem siker�lt");
			  break;
		  case 5:
			  enableOutput(false);
			  Player p5=new Player(new Karakter());
			  p5.getKarakter().setJegtabla(new Jegtabla());
			  Jegtabla j5=new Jegtabla();
			  enableOutput(true);
			  //----------
			  boolean siker=p5.getKarakter().lep(j5);
			  if(siker) System.out.println("L�p�s siker�lt");
			  else System.out.println("L�p�s nem siker�lt");
			  break;
		  case 6:
		  	  enableOutput(false);
			  Player p6=new Player(new Karakter());
			  Jegtabla j6 = new Jegtabla();
			  p6.getKarakter().setJegtabla(j6);
			  Instabil ins = new Instabil();
			  enableOutput(true);
			  //----------
			  boolean hat=p6.getKarakter().lep(ins);
			  if(hat) System.out.println("L�p�s siker�lt");
			  else System.out.println("L�p�s nem siker�lt");
			  break;
		  case 7:
		  	  enableOutput(false);
			  Player p7=new Player(new Karakter());
			  Jegtabla j7 = new Jegtabla();
			  p7.getKarakter().setJegtabla(j7);
			  Luk luk= new Luk();
			  enableOutput(true);
			  //----------
			  boolean het=p7.getKarakter().lep(luk);
			  if(het) System.out.println("L�p�s siker�lt");
			  else System.out.println("L�p�s nem siker�lt");
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
			  enableOutput(false);
			  Karakter lukban= new Karakter();
			  Luk luk1= new Luk();
			  luk1.ralepnek(lukban);
			  Karakter mento= new Karakter();
			  Stabil stabil =new Stabil();
			  stabil.ralepnek(mento);
			  enableOutput(true);
			  //----------
			  mento.hasznal(new Kotel(), luk1);
			  break;
		  case 9:
		  	  enableOutput(false);
			  Eszkimo eszk = new Eszkimo();
			  Jegtabla j9 = new Jegtabla();
			  eszk.setJegtabla(j9);
			  enableOutput(true);
			  //----------
			  if(eszk.iglut_epit())
				  System.out.println("Iglu �p�t�s siker�lt");
			  else System.out.println("Iglu �p�t�s nem siker�lt");
			  break;
		  case 10:
		  	  enableOutput(false);
			  Jegtabla j10 = new Jegtabla();
			  Jegtabla kutatott = new Jegtabla();
			  Sarkkutato sk = new Sarkkutato();
			  sk.setJegtabla(j10);
			  enableOutput(true);
			  //----------
			  sk.megnez(kutatott);
			  break;
		  case 11:
		  	  //???
			  break;
		  case 12:
		  	  enableOutput(false);
			  Jegtabla Jt = new Jegtabla();
			  Karakter K = new Karakter();
			  enableOutput(true);
			  //----------
			  Jt.ralepnek(K);
			  Jt.hovihar_volt();
			  break;	
		  case 13:
		  	  enableOutput(false);
			  Jegtabla j13 = new Jegtabla();
			  Eszkimo es = new Eszkimo();
			  es.setJegtabla(j13);
			  enableOutput(true);
			  //----------
			  es.iglut_epit();
			  es.getJegtabla().hovihar_volt();
			  break;	
		  case 14:
		  	  enableOutput(false);
			  ArrayList<Player> p_array = new ArrayList<Player>();
			  p_array.add(new Player(new Karakter()));
			  p_array.add(new Player(new Karakter()));
			  p_array.add(new Player(new Karakter()));
			  enableOutput(true);
			  //----------
			  Jatektabla jatek = new Jatektabla(0, p_array);
		  	  break;
		  case 15:
		  	  enableOutput(false);
		  	  Jegmezo jm = new Jegmezo(10);
		  	  enableOutput(true);
			  //----------
		  	  jm.hovihar_indul();
		  	  break;
		  default:
		    // code block
		}
		numberOfTabs = -1;
	}
	
}