package proto;

public class Player {
    Proto proto;
    private String nev;
    private int id;
    private Karakter k;
    boolean aktiv;

    /**
     * Egyszerű konstruktor.
     * @param kr A Játékos választott karaktere.
     */
    Player(Karakter kr, Proto p) {
        k=kr;
        proto=p;
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
            proto.nextCommand();
        }
    }

    /**
     * A játékos ezzel a függvénnyel vethet véget a körének.
     */
    public void kor_vegzes() {
        aktiv=false;
    }
}
