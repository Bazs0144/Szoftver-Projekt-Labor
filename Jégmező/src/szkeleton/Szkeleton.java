package szkeleton;

import java.util.HashMap;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public final class Szkeleton {
	private static int numberOfTabs = -1;
	private static PrintStream printStreamOriginal = System.out;
	public static HashMap<Object, String> objects = new HashMap<Object, String>();;

	public static void printFunction(String message, boolean in, Object o) {
		printTabs(in);
		System.out.println(message + ": " + objects.get(o));
	}

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
		enableOutput(false);
		//variables for simulation------------------
		Karakter k = new Karakter();
		objects.put(k, "k");
		Player p=new Player(k);
		objects.put(p, "p");
		Player p2=new Player(k);
		objects.put(p2, "p2");
		Player p3=new Player(k);
		objects.put(p3, "p3");
		Etel e= new Etel();
		objects.put(e, "e");
		Jegtabla j = new Jegtabla();
		objects.put(j, "j");
		Lapat l= new Lapat();
		objects.put(l, "l");
		Targy t=new Targy();
		objects.put(t, "t");
		Instabil ins = new Instabil();
		objects.put(ins, "ins");
		Luk luk= new Luk();
		objects.put(luk, "luk");
		Karakter lukban= new Karakter();
		objects.put(lukban, "lukban");
		Karakter mento= new Karakter();
		objects.put(mento, "mento");
		Stabil stabil =new Stabil();
		objects.put(stabil, "stabil");
		Eszkimo eszk = new Eszkimo();
		objects.put(eszk, "eszk");
		Jegtabla kutatott = new Jegtabla();
		objects.put(kutatott, "kutatott");
		Sarkkutato sk = new Sarkkutato();
		objects.put(sk, "sk");
			//help for Jatektabla----------------------
			ArrayList<Player> p_array = new ArrayList<Player>();
			p_array.add(p);
			p_array.add(p2);
			p_array.add(p3);
			//------------------------------------------
		Jatektabla jatek = new Jatektabla(null, p_array);
		objects.put(jatek, "jatek");
			//help for Jatektabla----------------------
			Jegtabla jegt1 = new Jegtabla();
			Jegtabla jegt2 = new Jegtabla();
			Jegtabla jegt3 = new Jegtabla();
			ArrayList<Jegtabla> i_array = new ArrayList<Jegtabla>();
			i_array.add(jegt1);
			i_array.add(jegt2);
			i_array.add(jegt2);
			//------------------------------------------
		Jegmezo jm = new Jegmezo(i_array);
		objects.put(jm, "jm");
		//------------------------------------------
		enableOutput(true);
		
		switch(I) {
		  case 1:
		  	  enableOutput(false);
			  j.ralepnek(k);
			  enableOutput(true);
			  //----------
			  k.hasznal(e, j);
		    break;
		  case 2:
		  	  enableOutput(false);
			  j.ralepnek(k);
			  int erosseg=1;
			  enableOutput(true);
			  //----------
			  k.takarit(erosseg);
		    break;
		  case 3:
		  	  enableOutput(false);
			  j.ralepnek(k);
			  enableOutput(true);
			  //----------
			  k.hasznal(l, j);
			 break;
		  case 4:
			  enableOutput(false);
			  j.ralepnek(k);
			  j.setTargy(t);
			  enableOutput(true);
			  //----------
			  boolean sikerult = k.targy_felvetele();
			  if(sikerult) System.out.println("Tárgy felvéve");
			  else System.out.println("Tárgy felvétel nem sikerült");
			  break;
		  case 5:
			  //----------
			  enableOutput(false);
			  j.ralepnek(k);
			  enableOutput(true);
			  boolean siker = k.lep(j);
			  if(siker) System.out.println("Lépés sikerült");
			  else System.out.println("Lépés nem sikerült");
			  break;
		  case 6:
		  	  enableOutput(false);
			  j.ralepnek(k);
			  enableOutput(true);
			  //----------
			  boolean hat = k.lep(ins);
			  if(hat) System.out.println("Lépés sikerült");
			  else System.out.println("Lépés nem sikerült");
			  break;
		  case 7:
		  	  enableOutput(false);
			  j.ralepnek(k);
			  enableOutput(true);
			  //----------
			  boolean het=k.lep(luk);
			  if(het) System.out.println("Lépés sikerült");
			  else System.out.println("Lépés nem sikerült");
			  break;
		  case 8:
			  enableOutput(false);
			  luk.ralepnek(lukban);
			  stabil.ralepnek(mento);
			  enableOutput(true);
			  //----------
			  mento.hasznal(new Kotel(), luk);
			  break;
		  case 9:
		  	  enableOutput(false);
			  j.ralepnek(eszk);
			  enableOutput(true);
			  //----------
			  if(eszk.iglut_epit())
				  System.out.println("Iglu építés sikerült");
			  else System.out.println("Iglu építés nem sikerült");
			  break;
		  case 10:
		  	  enableOutput(false);
			  j.ralepnek(sk);
			  enableOutput(true);
			  //----------
			  sk.megnez(kutatott);
			  break;
		  case 11:
			  break;
		  case 12:
			  //----------
			  j.ralepnek(k);
			  j.hovihar_volt();
			  break;	
		  case 13: //ez fura
		  	  enableOutput(false);
			  j.ralepnek(eszk);
			  enableOutput(true);
			  //----------
			  eszk.iglut_epit();
			  j.hovihar_volt();
			  break;	
		  case 14:

			  //----------
			  jatek.init();
		  	  break;
		  case 15:
			  //----------
		  	  jm.hovihar_indul();
		  	  break;
		  default:
		    // code block
		}
		numberOfTabs = -1;
	}
	
}