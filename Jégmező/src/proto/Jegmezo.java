package proto;

import java.util.ArrayList;
//import java.util.ListIterator;
//import java.util.Random;
import java.util.Scanner;

public class Jegmezo {
    private ArrayList<Jegtabla> JegT;

    /**
     * Konstruktor: Létrehozza a jágtáblákat, és megadja az adott jágtábla szomszédait
     * @param width height A Jégmezőt alkotó jégtáblák száma.
     */
    public Jegmezo(int width, int height) {
        Szkeleton.printFunction("-------> Jegmezo(size: int) *konstruktor*", true, this);
        this.JegT = new ArrayList<>();
        for(int i=0; i<height; i++)
            for(int j=0; j<width; j++) {
            Jegtabla jeg=new Stabil(new Poz(j, i));
            JegT.add(jeg);
          //  Szkeleton.objects.put(JegT.get(i), "Jegt["+i+"]");
        }
        for(int i=0; i<height; i++)
            for(int j=0; j<width; j++) {
                if(i-1>=0) JegT.get(i).addSzomszed(JegT.get(i-1));
                if(i+1<height) JegT.get(i).addSzomszed(JegT.get(i+1));
                if(j-1>=0) JegT.get(i).addSzomszed(JegT.get(j-1));
                if(j+1<width) JegT.get(i).addSzomszed(JegT.get(j+1));
            }

        Szkeleton.printFunction("<------- Jegmezo(size: int) *konstruktor*", false, this);
    }

    public void addJegtabla(Jegtabla jeg) {
        JegT.add(jeg);
    }

    public void szomszedokkaTesz(Jegtabla egy, Jegtabla ketto) {
        egy.addSzomszed(ketto);
        ketto.addSzomszed(egy);
    }

    public void addTargy(Poz p, Targy t) {
        for(Jegtabla jt: JegT) {
            if(jt.getPoz().equals(p)) jt.setTargy(t);
        }
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
