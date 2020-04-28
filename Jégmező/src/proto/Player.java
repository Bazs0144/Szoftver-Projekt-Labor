package proto;

import java.io.Serializable;

public class Player implements Serializable {
    /**
     * name - a jatekos neve
     * k - a jatekos karaktere
     * aktiv - eppen a jatekos kore van-e a jatekban
     */
    private String name;
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
     //   while(aktiv&&k.munkak_szama>0) {
            //proto.nextCommand();//???
       // }
       // kor_vegzes();
    }

    /**
     * A játékos ezzel a függvénnyel vethet véget a körének.
     */
    public void kor_vegzes() {
        aktiv=false;
    }

    /**
     * @return Visszaadja a jatekos nevet
     */
    public String getName(){
        return name;
    }
}
