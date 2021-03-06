package proto;

import java.io.Serializable;
import java.util.ArrayList;
//import java.util.ListIterator;
//import java.util.Random;
import java.util.Random;
import java.util.Scanner;


public class Jegmezo implements Serializable {
    /**
     * A Jegmezoben levo jegtablak listaja
     */
    private ArrayList<Jegtabla> JegT;


    /**
     * Konstruktor: L�trehozza a j�gt�bl�kat, �s megadja az adott j�gt�bla szomsz�dait
     * @param width height A J�gmez�t alkot� j�gt�bl�k sz�ma.
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

    public Jegmezo(int width, int height, boolean b) {
        this.JegT = new ArrayList<>();
        for(int y=0; y<height; y++)
            for(int x=0; x<width; x++) {
                Random rand = new Random();
                Jegtabla jeg;
                if(y==0&&x==0)  {
                    jeg=new Stabil(new Poz(x, y));
                    jeg.setBefagyva(true);
                    jeg.setHo(rand.nextInt(5));
                }
                else {
                    int value = rand.nextInt(50);
                    if(value%2==0) {
                        jeg=new Instabil(new Poz(x,y));
                        jeg.setKapacitas(rand.nextInt(5)+1);
                        jeg.setBefagyva(true);
                        jeg.setHo(rand.nextInt(5));
                    }else if(value%3==0)  jeg=new Luk(new Poz(x,y));
                    else {
                        jeg=new Stabil(new Poz(x, y));
                        jeg.setBefagyva(true);
                        jeg.setHo(rand.nextInt(5));
                    }
                }
                JegT.add(jeg);
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

    /**
     * visszadja azokat a j�gt�bl�kat amikor stabilak/instabilak
     */
    public ArrayList<Jegtabla> getNotLuk() {
        ArrayList<Jegtabla> ez=new ArrayList<>();
        for(Jegtabla j: JegT) if(j.type.equals("Stabil")||j.type.equals("Instabil")) ez.add(j);
        return ez;
    }



    /**
     * Hoo�zzad egy jegtablat a listahoz
     * @param jeg ezt adja hozza
     */
    public void addJegtabla(Jegtabla jeg) {
        JegT.add(jeg);
    }

    /**
     * Visszaadja a jegtablak listajat
     */
    public ArrayList<Jegtabla> getJegtablak() {
        return JegT;
    }

    /**
     *Visszaadja a a jegtablat ami az adott x, y koordinataval rendelkezik
     * @param x az adott x koordinata
     * @param y az adott y koordinata
     */
    public Jegtabla getJegtabla(int x, int y) {
    	for(int i = 0; i<JegT.size(); i++) {
    		if(JegT.get(i).getPoz().getX() == x && JegT.get(i).getPoz().getY() == y)
    			return JegT.get(i);
    	}
        return null;
    }

    /**
     * Egymas szomszedaihoz hozzaad ket jegtablat
     * @param egy az egyik jegtabla
     * @param ketto a masik jegtabla
     */
    public void szomszedokkaTesz(Jegtabla egy, Jegtabla ketto) {
        egy.addSzomszed(ketto);
        ketto.addSzomszed(egy);
    }

    /**
     * Hozzaad egy targyat az adott pozicioju jegtablahoz
     * @param p a jegtabla pozicioja
     * @param t a targy
     */
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