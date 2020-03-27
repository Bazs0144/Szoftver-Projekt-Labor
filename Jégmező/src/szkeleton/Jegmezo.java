package szkeleton;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jegmezo {
    private ArrayList<Jegtabla> JegT;

    //Konstruktor egy megadott méret alapján legenerál jégtáblákat.
    public Jegmezo(ArrayList<Jegtabla> j) {
        Szkeleton.printFunction("-------> Jegmezo(size: int) *konstruktor*", true, this);
        this.JegT = j;
        Szkeleton.printFunction("<------- Jegmezo(size: int) *konstruktor*", false, this);
    }

    //----------- Interfész ---
    //hovihar_indul végig iterál az összes jétáblán,
    public void hovihar_indul() {
        Szkeleton.printFunction("-------> hovihar_indul()", true, this);
        Random rand = new Random();
        for(Jegtabla item: this.JegT) {
            Scanner in = new Scanner(System.in);
            System.out.println("Legyen hovihar a jegtablan?");
            int I = in.nextInt();
            //int r = rand.nextInt(100);
            //if(r < 10) {
            if(I == 1)
                item.hovihar_volt();

            //}
        }
        Szkeleton.printFunction("<------- hovihar_indul()", false, this);
    }
    //-----------
}
