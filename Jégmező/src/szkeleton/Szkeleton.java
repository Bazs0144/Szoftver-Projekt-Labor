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
			  if(sikerult) System.out.println("T�rgy felv�ve");
			  else System.out.println("T�rgy felv�tel nem siker�lt");
			  break;
		  case 5:
			  Player p5=new Player(new Karakter());
			  p5.getKarakter().setJegtabla(new Jegtabla());
			  Jegtabla j2=new Jegtabla();
			  boolean siker=p5.getKarakter().lep(j2);
			  if(siker) System.out.println("L�p�s siker�lt");
			  else System.out.println("L�p�s nem siker�lt");
			  break;
		  case 6:
			  Player p6=new Player(new Karakter());
			  p6.getKarakter().setJegtabla(new Jegtabla());
			  Instabil ins = new Instabil();
			  boolean hat=p6.getKarakter().lep(ins);
			  if(hat) System.out.println("L�p�s siker�lt");
			  else System.out.println("L�p�s nem siker�lt");
			  break;
		  case 7:
			  Player p7=new Player(new Karakter());
			  p7.getKarakter().setJegtabla(new Jegtabla());
			  Luk luk= new Luk();
			  boolean het=p7.getKarakter().lep(luk);
			  if(het) System.out.println("L�p�s siker�lt");
			  else System.out.println("L�p�s nem siker�lt");
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
