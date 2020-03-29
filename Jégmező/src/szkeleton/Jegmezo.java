package szkeleton;

import java.util.ArrayList;
//import java.util.ListIterator;
//import java.util.Random;
import java.util.Scanner;

public class Jegmezo {
    private ArrayList<Jegtabla> JegT;

    /**
     * Konstruktor: Létrehozza a jágtáblákat, és megadja az adott jágtábla szomszédait
     * @param size A Jégmezőt alkotó jégtáblák száma.
     */
    public Jegmezo(int size) {
        Szkeleton.printFunction("-------> Jegmezo(size: int) *konstruktor*", true, this);
        this.JegT = new ArrayList<>();
        for(int i=0; i<size; i++) {
            Jegtabla j=new Jegtabla();
            JegT.add(j);
            Szkeleton.objects.put(JegT.get(i), "Jegt["+i+"]");
        }
        for(int i=0; i<size; i++) {
            if(i+1<size) JegT.get(i).addSzomszed(JegT.get(i+1));
            if(i-1>=0) JegT.get(i).addSzomszed(JegT.get(i-1));

        }

        Szkeleton.printFunction("<------- Jegmezo(size: int) *konstruktor*", false, this);
    }

    /**
     * Hóvihar esetén végigmegy az összes jégtáblán, és bizonyos logika alapján, egyes jégtáblákon hóvihart gerjeszt.
     */
    public void hovihar_indul() {
        Szkeleton.printFunction("-------> hovihar_indul()", true, this);
        //Random rand = new Random();
        for(Jegtabla item: this.JegT) {
            Scanner in = new Scanner(System.in);
            System.out.println("Legyen hovihar a jegtablan? 1: igen");
            int I = in.nextInt();
            //int r = rand.nextInt(100);
            //if(r < 10) {
            if(I == 1)
                item.hovihar_volt();

            //}
        }
        Szkeleton.printFunction("<------- hovihar_indul()", false, this);
    }
}
