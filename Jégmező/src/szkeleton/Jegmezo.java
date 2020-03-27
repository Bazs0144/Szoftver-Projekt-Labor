package szkeleton;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

public class Jegmezo {
    private ArrayList<Jegtabla> JegT;

    //Konstruktor egy megadott méret alapján legenerál jégtáblákat.
    public Jegmezo(int size) {
        Szkeleton.printFunction("-------> Jegmezo(size: int) *konstruktor*", true, this);
        this.JegT = new ArrayList<>();
        for(int i=0; i<size; i++) {
            Jegtabla j=new Jegtabla();
            JegT.add(j);
        }
        for(int i=0; i<size; i++) {
            if(i+1<size) JegT.get(i).addSzomszed(JegT.get(i+1));
            if(i-1>=0) JegT.get(i).addSzomszed(JegT.get(i-1));

        }

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
