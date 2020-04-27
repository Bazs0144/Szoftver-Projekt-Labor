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
     * Konstruktor: L�trehozza a j�gt�bl�kat, �s megadja az adott j�gt�bla szomsz�dait
     * @param width height A J�gmez�t alkot� j�gt�bl�k sz�ma.
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
        Jegtabla jelen;
        for(int i=0; i<height; i++)
            for(int j=0; j<width; j++) {
                jelen=getJegtabla(i ,j);
                if(i-1>=0) jelen.addSzomszed(getJegtabla(i-1, j));
                if(i+1<height) jelen.addSzomszed(getJegtabla(i+1, j));
                if(j-1>=0) jelen.addSzomszed(getJegtabla(i, j-1));
                if(j+1<width) jelen.addSzomszed(getJegtabla(i, j+1));
            }
    }
    
    public int getwidth() {
    	return width;
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
     * H�vihar eset�n v�gigmegy az �sszes j�gt�bl�n, �s bizonyos logika alapj�n, egyes j�gt�bl�kon h�vihart gerjeszt.
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