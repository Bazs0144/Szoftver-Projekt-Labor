package szkeleton;

public class Player {
    private String nev;
    private int id;
    private Karakter k;

    Player(Karakter kr) {
        Szkeleton.printFunction("-------> Player(Karakter kr) *konstruktor*", true, this);
        k=kr;
        Szkeleton.printFunction("<------- Player(Karakter kr) *konstruktor*",false, this);
    }

    public Karakter getKarakter() {
        Szkeleton.printFunction("-------> getKarakter()", true, this);
        Szkeleton.printFunction("<---k---- getKarakter()", false, this);
        return k;
    }

    //----------- Interfész ---
    public void kor_kezdes() {
        Szkeleton.printFunction("-------> kor_kezdes()", true, this);
        Szkeleton.printFunction("<------- kor_kezdes()", false, this);
    }

    public void kor_vegzes() {
        Szkeleton.printFunction("---p---> kor_vegzes()", true, this);
        Szkeleton.printFunction("<---p--- kor_vegzes()", false, this);
    }
    //-----------
}
