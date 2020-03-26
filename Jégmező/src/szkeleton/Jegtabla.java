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
	
	ArrayList<Karakter> karakterek;
	
	public Jegtabla() {
        Szkeleton.printTabs(true);
		System.out.println("-------> Jegtabla() *konstruktor*");
		karakterek = new  ArrayList<Karakter>();
        Szkeleton.printTabs(false);
		System.out.println("<------- Jegtabla() *konstruktor*");
	}
	
	public ArrayList<Karakter> getKarakterek(){
		return karakterek;
	}
	
	public void hovihar_volt() {
        Szkeleton.printTabs(true);
		System.out.println("-------> hovihar_volt()");
		System.out.println("Van iglu?");
		Scanner in = new Scanner(System.in);
		int I = in.nextInt();
		
		if(I == 0) 
		{
			for(int i = 0; i < karakterek.size(); ++i) {
				System.out.print("karakter.");
				karakterek.get(i).sebzodik();  
			}
		}
		// in.close();
		ho_mennyiseg++;
        Szkeleton.printTabs(false);
		 System.out.println("<------- hovihar_volt()");
	}
	
	public int getKarakterek_szama() {
        Szkeleton.printTabs(true);
		System.out.println("-------> getKarakterek_szama()");
        Szkeleton.printTabs(false);
		System.out.println("<------- kar ------- getKarakterek_szama()");
		return  karakterek.size();
	}
	
	public void ralepnek(Karakter k) {
        Szkeleton.printTabs(true);
		System.out.println("------->  ralepnek(Karakter k)");
		karakterek.add(k);
		k.setJegtabla(this);
        Szkeleton.printTabs(false);
		System.out.println("<------- ralepnek(Karakter k)");
	}
	
	public void takaritas_volt(int intensity) {
        Szkeleton.printTabs(true);
		System.out.println("------->  takaritas_volt(int intensity)");
        Szkeleton.printTabs(false);
		System.out.println("<------- takaritas_volt(int intensity)");
	}
	
	public int getKapacitas() {
        Szkeleton.printTabs(true);
		System.out.println("-------> getKapacitas()");
        Szkeleton.printTabs(false);
		System.out.println("<------- kapacitas ------- getKapacitas()");
		return kapacitas;
	}
	
	public Targy getTargy() {
        Szkeleton.printTabs(true);
		System.out.println("------->getTargy()");
        Szkeleton.printTabs(false);
		System.out.println("<------- T ------- getTargy()");
		return T;
	}
	
	public void setTargy(Targy t) {
        Szkeleton.printTabs(true);
		System.out.println("-------> setTargy(Targy t)");
        Szkeleton.printTabs(false);
		System.out.println("<------- setTargy(Targy t)");
		this.T = t;
	}
	
	public int getHoMennyiseg() {
        Szkeleton.printTabs(true);
		System.out.println("------->getHoMennyiseg()");
		System.out.println("Mennyi ho van ezen a jegtablan?");
		Scanner in = new Scanner(System.in);
		int I = in.nextInt();
        Szkeleton.printTabs(false);
		System.out.println("<------- ho_mennyiseg ----- getHoMennyiseg()");
		return I;
	}
	
	public void igluEpitese() {
        Szkeleton.printTabs(true);
		System.out.println("------->igluEpitese()");
        Szkeleton.printTabs(false);
		System.out.println("<-------igluEpitese()");
	}
	
	public boolean getVanIglu() {
        Szkeleton.printTabs(true);
		System.out.println("-------> getVanIglu()");
		System.out.println("van iglu?");
		Scanner in = new Scanner(System.in);
		int I = in.nextInt();
        Szkeleton.printTabs(false);
		System.out.println("<------- van_iglu ----- getVanIglu()");
		if(I == 0) {
			return true;
		}
		else return false;
	}
	
	public boolean szomszed_e(Jegtabla j) {
        Szkeleton.printTabs(true);
		System.out.println("------>szomszed_e(Jegtabla j)");
		System.out.println("Szomszédok a jégtáblák?");
		Scanner in = new Scanner(System.in);
		int I = in.nextInt();
		if(I == 1){
            Szkeleton.printTabs(false);
			System.out.println("<------true ---- szomszed_e(Jegtabla j)");
			return true;
		}
		else{
            Szkeleton.printTabs(false);
			System.out.println("<------false ---- szomszed_e(Jegtabla j)");
			 return false;
		}
	}
	
	public void lelepnek(Karakter k) {
        Szkeleton.printTabs(true);
		System.out.println("------>lelepnek(Karakter k)");
		karakterek.remove(k);
        Szkeleton.printTabs(false);
		System.out.println("<------lelepnek(Karakter k)");
	}
	
	public boolean elvesz(Karakter k, Targy t) {
        Szkeleton.printTabs(true);
		System.out.println("------>elvesz(Karakter k, Targy t)");
		System.out.println("Homennyiseg a jegtablan?");
		Scanner in = new Scanner(System.in);
		int I = in.nextInt();
		System.out.println("Be van fagyva?");
		int I2 = in.nextInt();
		
		if(I ==0  && I2 ==0) {
			k.targy_hozzaadasa(t);  System.out.print("k");
            Szkeleton.printTabs(false);
			System.out.println("<---true---elvesz(Karakter k, Targy t)");
			return true;
		}
		else {
            Szkeleton.printTabs(false);
			System.out.println("<---false---elvesz(Karakter k, Targy t)");
			return false;
		}
	}
	
	
	public void kiment(Karakter kit, Jegtabla j) {
        Szkeleton.printTabs(true);
		System.out.println("------>kiment(Karakter kit, Jegtabla j) ");
		System.out.print("this jegtabla.");
		this.lelepnek(kit);	 
		System.out.print("karakter.");
		j.ralepnek(kit);
		//kit.setJegtabla(j);
        Szkeleton.printTabs(false);
		System.out.println("<------kiment(Karakter kit, Jegtabla j) ");
	}
}
