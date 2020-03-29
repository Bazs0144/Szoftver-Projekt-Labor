package szkeleton;

public class Player {
    private String nev;
    private int id;
    private Karakter k;

    /**
     * Egyszerű konstruktor.
     * @param kr A Játékos választott karaktere.
     */
    Player(Karakter kr) {
        Szkeleton.printFunction("-------> Player(Karakter kr) *konstruktor*", true, this);
        k=kr;
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
        Szkeleton.printFunction("<------- kor_kezdes()", false, this);
    }

    /**
     * A játékos ezzel a függvénnyel vethet véget a körének.
     */
    public void kor_vegzes() {
        Szkeleton.printFunction("-------> kor_vegzes()", true, this);
        Szkeleton.printFunction("<---p--- kor_vegzes()", false, this);
    }
    //-----------
}
