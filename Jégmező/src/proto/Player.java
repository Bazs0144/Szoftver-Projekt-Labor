package proto;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private int id;
    private Karakter k;
    boolean aktiv;

    /**
     * Egyszerű konstruktor.
     * @param kr A Játékos választott karaktere.
     */
    Player(Karakter kr, String name) {
        k=kr;
        this.name = name;
    }

    /**
     * Visszadja a Játékos karakterét.
     * @return a karakter objektuma.
     */
    public Karakter getKarakter() {
        return k;
    }

    /**
     * Ha meghívódik a függvény a játékos elkezdhet tevékenykedni, mert az ő köre van.
     */
    public void kor_kezdes() {
        aktiv=true;
        k.munkak_szama=4;
        while(aktiv&&k.munkak_szama>0) {
            //proto.nextCommand();//???
        }
        kor_vegzes();
    }

    /**
     * A játékos ezzel a függvénnyel vethet véget a körének.
     */
    public void kor_vegzes() {
        aktiv=false;
    }

    public String getName(){
        return name;
    }
}
