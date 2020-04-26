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
        Szkeleton.printFunction("-------> Player(Karakter kr) *konstruktor*", true, this);
        k=kr;
        proto=p;
        Szkeleton.printFunction("<------- Player(Karakter kr) *konstruktor*",false, this);
    }

    /**
     * Visszadja a Játékos karakterét.
     * @return a karakter objektuma.
     */
    public Karakter getKarakter() {
        Szkeleton.printFunction("-------> getKarakter()", true, this);
        Szkeleton.printFunction("<---k---- getKarakter()", false, this);
        return k;
    }

    /**
     * Ha meghívódik a függvény a játékos elkezdhet tevékenykedni, mert az ő köre van.
     */
    public void kor_kezdes() {
        Szkeleton.printFunction("-------> kor_kezdes()", true, this);
        aktiv=true;
        k.munkak_szama=4;
        while(aktiv&&k.munkak_szama>0) {
            proto.nextCommand();
        }
        Szkeleton.printFunction("<------- kor_kezdes()", false, this);
    }

    /**
     * A játékos ezzel a függvénnyel vethet véget a körének.
     */
    public void kor_vegzes() {
        Szkeleton.printFunction("-------> kor_vegzes()", true, this);
        aktiv=false;
        Szkeleton.printFunction("<---p--- kor_vegzes()", false, this);
    }
    //-----------
}
