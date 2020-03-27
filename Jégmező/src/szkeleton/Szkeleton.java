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
			  if(sikerult) System.out.println("T�rgy felv�ve");
			  else System.out.println("T�rgy felv�tel nem siker�lt");
			  break;
		  case 5:
			  //----------
			  enableOutput(false);
			  j.ralepnek(k);
			  enableOutput(true);
			  boolean siker = k.lep(j);
			  if(siker) System.out.println("L�p�s siker�lt");
			  else System.out.println("L�p�s nem siker�lt");
			  break;
		  case 6:
		  	  enableOutput(false);
			  j.ralepnek(k);
			  enableOutput(true);
			  //----------
			  boolean hat = k.lep(ins);
			  if(hat) System.out.println("L�p�s siker�lt");
			  else System.out.println("L�p�s nem siker�lt");
			  break;
		  case 7:
		  	  enableOutput(false);
			  j.ralepnek(k);
			  enableOutput(true);
			  //----------
			  boolean het=k.lep(luk);
			  if(het) System.out.println("L�p�s siker�lt");
			  else System.out.println("L�p�s nem siker�lt");
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
				  System.out.println("Iglu �p�t�s siker�lt");
			  else System.out.println("Iglu �p�t�s nem siker�lt");
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