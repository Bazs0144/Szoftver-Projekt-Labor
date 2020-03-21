package szkeleton;

import java.util.ArrayList;
import java.util.Scanner;

public class Jegtabla {
	private int kapacitas;
	private int ho_mennyiseg;
	private boolean van_iglu;
	private boolean befagyva;
	private int poz;
	private Targy T;
	
	ArrayList<Karakter> karakterek = new  ArrayList<Karakter>();
	
	public void hovihar_volt() {
		System.out.println("-------> hovihar_volt()");
		System.out.println("Van iglu?");
		Scanner in = new Scanner(System.in);
		int I = in.nextInt();
		
		if(I == 0) 
		{
			for(int i = 0; i < karakterek.size(); ++i) {
				karakterek.get(i).sebzodik();
			}
		}
		// in.close();
		 System.out.println("<------- hovihar_volt()");
	}
	
	public int getKarakterek_szama() {
		System.out.println("-------> getKarakterek_szama()");
		System.out.println("<------- kar ------- getKarakterek_szama()");
		return  karakterek.size();
	}
	
	public void ralepnek(Karakter k) {
		System.out.println("------->  ralepnek(Karakter k)");
		karakterek.add(k);
		System.out.println("<------- ralepnek(Karakter k)");
	}
	
	public void takaritas_volt(int intensity) {
		System.out.println("------->  takaritas_volt(int intensity)");
		System.out.println("<------- takaritas_volt(int intensity)");
	}
	
	public int getKapacitas() {
		System.out.println("-------> getKapacitas()");
		System.out.println("<------- kapacitas ------- getKapacitas()");
		return kapacitas;
	}
	
	public Targy getTargy() {
		System.out.println("------->getTargy()");
		System.out.println("<------- T ------- getTargy()");
		return T;
	}
	
	public void setTargy(Targy t) {
		System.out.println("------->setTargy(Targy t)");
		System.out.println("<-------setTargy(Targy t)");
		this.T = t;
	}
	
	public int getHoMennyiseg() {
		System.out.println("------->getHoMennyiseg()");
		System.out.println("<------- ho_mennyiseg ----- getHoMennyiseg()");
		return ho_mennyiseg;
	}
	
	public void igluEpitese() {
		System.out.println("------->igluEpitese()");
		System.out.println("<-------igluEpitese()");
	}
	
	public boolean getVanIglu() {
		System.out.println("------->getVanIglu()");
		System.out.println("<------- van_iglu ----- getVanIglu()");
		return van_iglu;
	}
	
	public boolean szomszed_e(Jegtabla j) {
		System.out.println("------>szomszed_e(Jegtabla j)");
		System.out.println("Szomszédok a jégtáblák?");
		Scanner in = new Scanner(System.in);
		int I = in.nextInt();
		if(I == 1){
			System.out.println("<------true ---- szomszed_e(Jegtabla j)");
			return true;
		}
		else{
			System.out.println("<------false ---- szomszed_e(Jegtabla j)");
			 return false;
		}
	}
	
	public void lelepnek(Karakter k) {
		System.out.println("------>lelepnek(Karakter k)");
		//remove karakter
		System.out.println("<------lelepnek(Karakter k)");
	}
	
	public boolean elvesz(Karakter k, Targy t) {
		System.out.println("------>elvesz(Karakter k, Targy t)");
		System.out.println("Homennyiseg a jegtablan?");
		Scanner in = new Scanner(System.in);
		int I = in.nextInt();
		System.out.println("Be van fagyva?");
		int I2 = in.nextInt();
		
		if(I ==0  && I2 ==0) {
			k.targy_hozzaadasa(t);
			System.out.println("<---true---elvesz(Karakter k, Targy t)");
			return true;
		}
		else {
			System.out.println("<---false---elvesz(Karakter k, Targy t)");
			return false;
		}
	}
	
	
	public void kiment(Karakter kit, Jegtabla j) {
		System.out.println("------>kiment(Karakter kit, Jegtabla j) ");
		kit.setJegtabla(j);
		System.out.println("<------kiment(Karakter kit, Jegtabla j) ");
	}
}
