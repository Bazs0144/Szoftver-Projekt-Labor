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
		Szkeleton.printFunction("-------> Jegtabla() *konstruktor*", true, this);
		karakterek = new  ArrayList<Karakter>();
		Szkeleton.printFunction("<------- Jegtabla() *konstruktor*", false, this);
	}
	
	public ArrayList<Karakter> getKarakterek(){
		return karakterek;
	}
	
	public void hovihar_volt() {
		Szkeleton.printFunction("-------> hovihar_volt()", true, false);
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
		ho_mennyiseg++;
		Szkeleton.printFunction("<------- hovihar_volt()", false, this);
	}
	
	public int getKarakterek_szama() {
		Szkeleton.printFunction("-------> getKarakterek_szama()", true, this);
		Szkeleton.printFunction("<--kar-- getKarakterek_szama()", false, this);
		return  karakterek.size();
	}
	
	public void ralepnek(Karakter k) {
		Szkeleton.printFunction("------->  ralepnek(Karakter k)", true, this);
		karakterek.add(k);
		k.setJegtabla(this);
		Szkeleton.printFunction("<------- ralepnek(Karakter k)", false, this);
	}
	
	public void takaritas_volt(int intensity) {
		Szkeleton.printFunction("------->  takaritas_volt(int intensity)", true, this);
		Szkeleton.printFunction("<------- takaritas_volt(int intensity)", false, this);
	}
	
	public int getKapacitas() {
		Szkeleton.printFunction("-------> getKapacitas()", true, this);
		Szkeleton.printFunction("<--kapacitas-- getKapacitas()", false, this);
		return kapacitas;
	}
	
	public Targy getTargy() {
		Szkeleton.printFunction("------->getTargy()", true, this);
        Szkeleton.printTabs(false);
		Szkeleton.printFunction("<---T--- getTargy()", false, this);
		return T;
	}
	
	public void setTargy(Targy t) {
		Szkeleton.printFunction("-------> setTargy(Targy t)", true, this);
		Szkeleton.printFunction("<------- setTargy(Targy t)", false, this);
		this.T = t;
	}
	
	public int getHoMennyiseg() {
		Szkeleton.printFunction("------->getHoMennyiseg()", true, this);
		System.out.println("Mennyi ho van ezen a jegtablan?");
		Scanner in = new Scanner(System.in);
		int I = in.nextInt();
		Szkeleton.printFunction("<--ho_mennyiseg-- getHoMennyiseg()", false, this);
		return I;
	}
	
	public void igluEpitese() {
		Szkeleton.printFunction("------->igluEpitese()", true, this);
		Szkeleton.printFunction("<-------igluEpitese()", false, this);
	}
	
	public boolean getVanIglu() {
		Szkeleton.printFunction("------->getVanIglu()", true, this);
		System.out.println("van iglu?");
		Scanner in = new Scanner(System.in);
		int I = in.nextInt();
		if(I == 0) {
			Szkeleton.printFunction("<--true-- getVanIglu()",false, this);
			return true;
		}
		else {
			Szkeleton.printFunction("<--false-- getVanIglu()", false, this);
			return false;
		}


	}
	
	public boolean szomszed_e(Jegtabla j) {
		Szkeleton.printFunction("------>szomszed_e(Jegtabla j)", true, this);
		System.out.println("Szomszédok a jégtáblák?");
		Scanner in = new Scanner(System.in);
		int I = in.nextInt();
		if(I == 1){
			Szkeleton.printFunction("<--true-- szomszed_e(Jegtabla j)", false, this);
			return true;
		}
		else{
			Szkeleton.printFunction("<--false-- szomszed_e(Jegtabla j)", false, this);
			 return false;
		}
	}
	
	public void lelepnek(Karakter k) {
		Szkeleton.printFunction("------>lelepnek(Karakter k)", true, this);
		karakterek.remove(k);
		Szkeleton.printFunction("<------lelepnek(Karakter k)", false, this);
	}
	
	public boolean elvesz(Karakter k, Targy t) {
		Szkeleton.printFunction("------>elvesz(Karakter k, Targy t)", true, this);
		System.out.println("Homennyiseg a jegtablan?");
		Scanner in = new Scanner(System.in);
		int I = in.nextInt();
		System.out.println("Be van fagyva?");
		int I2 = in.nextInt();
		
		if(I ==0  && I2 ==0) {
			k.targy_hozzaadasa(t);  System.out.print("k");
			Szkeleton.printFunction("<--true--elvesz(Karakter k, Targy t)", false, this);
			return true;
		}
		else {
			Szkeleton.printFunction("<--false--elvesz(Karakter k, Targy t)", false, this);
			return false;
		}
	}
	
	
	public void kiment(Karakter kit, Jegtabla j) {
		Szkeleton.printFunction("------>kiment(Karakter kit, Jegtabla j) ", true, this);
		this.lelepnek(kit);
		j.ralepnek(kit);
		//kit.setJegtabla(j);
		Szkeleton.printFunction("<------kiment(Karakter kit, Jegtabla j) ", false, this);
	}
}
