package proto;

import java.io.Serializable;
import java.util.ArrayList;
//import java.util.ListIterator;
//import java.util.Random;
import java.util.Scanner;

public class Jegmezo implements Serializable {
    private ArrayList<Jegtabla> JegT;
    private int width;

    /**
     * Konstruktor: Létrehozza a jágtáblákat, és megadja az adott jágtábla szomszédait
     * @param width height A Jégmezőt alkotó jégtáblák száma.
     */
    public Jegmezo(int width, int height) {
        this.width = width;
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
    }

    public void addJegtabla(Jegtabla jeg) {
        JegT.add(jeg);
    }

    public Jegtabla getJegtabla(int x, int y) {
        return JegT.get(x*width + y);
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
    }
}
