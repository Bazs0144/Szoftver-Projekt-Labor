package proto;

import java.io.Serializable;
import java.util.ArrayList;
//import java.util.ListIterator;
//import java.util.Random;
import java.util.Scanner;


public class Jegmezo implements Serializable {
    private ArrayList<Jegtabla> JegT;


    /**
     * Konstruktor: Létrehozza a jágtáblákat, és megadja az adott jágtábla szomszédait
     * @param width height A Jégmezõt alkotó jégtáblák száma.
     */
    public Jegmezo(int width, int height) {

        this.JegT = new ArrayList<>();
        for(int y=0; y<height; y++)
            for(int x=0; x<width; x++) {
            Jegtabla jeg=new Stabil(new Poz(x, y));
            JegT.add(jeg);
          //  Szkeleton.objects.put(JegT.get(i), "Jegt["+i+"]");
        }
        Jegtabla jelen;
        for(int y=0; y<height; y++)
            for(int x=0; x<width; x++) {
                jelen=getJegtabla(x ,y);
                if(y-1>=0) jelen.addSzomszed(getJegtabla(x, y-1));
                if(y+1<height) jelen.addSzomszed(getJegtabla(x, y+1));
                if(x-1>=0) jelen.addSzomszed(getJegtabla(x-1, y));
                if(x+1<width) jelen.addSzomszed(getJegtabla(x+1, y));
            }
    }

    public void addJegtabla(Jegtabla jeg) {
        JegT.add(jeg);
    }

    public ArrayList<Jegtabla> getJegtablak() {
        return JegT;
    }

    public Jegtabla getJegtabla(int x, int y) {
    	for(int i = 0; i<JegT.size(); i++) {
    		if(JegT.get(i).getPoz().getX() == x && JegT.get(i).getPoz().getY() == y)
    			return JegT.get(i);
    	}
        return null;
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
            //System.out.println("Legyen hovihar a jegtablan? 1: igen");
            int I = in.nextInt();
            //int r = rand.nextInt(100);
            //if(r < 10) {
            if(I == 1)
                item.hovihar_volt();

            //}
        }
    }
}