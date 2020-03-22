package szkeleton;

import java.util.ArrayList;
import java.util.Random;

public class Jegmezo {
    private ArrayList<Jegtabla> JegT;

    //Konstruktor egy megadott méret alapján legenerál jégtáblákat.
    public Jegmezo(int size) {
        System.out.println("-------> Jegmezo(size: int) *konstruktor*");
        this.JegT = new ArrayList<Jegtabla>();
        for(int i = 0; i < size; i++){
            this.JegT.add(new Jegtabla());
        }
        System.out.println("<------- Jegmezo(size: int) *konstruktor*");
    }

    //----------- Interfész ---
    //hovihar_indul végig iterál az összes jétáblán, és 10% eséllyel hóvihart gerjeszt rajtuk.
    public void hovihar_indul() {
        System.out.println("-------> hovihar_indul()");
        System.out.println("--for each Jegtabla-- begin");
        Random rand = new Random();
        for(Jegtabla item: this.JegT) {
            int r = rand.nextInt(100);
            if(r < 10) {
                item.hovihar_volt();
            }
        }
        System.out.println("--for each Jegtabla-- end");
        System.out.println("<------- hovihar_indul()");
    }
    //-----------
}
