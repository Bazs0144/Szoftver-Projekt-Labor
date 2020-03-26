package szkeleton;

public class Player {
    private String nev;
    private int id;
    private Karakter k;

    Player(Karakter kr) {
        Szkeleton.printTabs(true);
        System.out.println("-------> Player(Karakter kr) *konstruktor*");
        k=kr;
        Szkeleton.printTabs(false);
        System.out.println("<------- Player(Karakter kr) *konstruktor*");
    }

    public Karakter getKarakter() {
        Szkeleton.printTabs(true);
        System.out.println("-------> getKarakter()");
        Szkeleton.printTabs(false);
        System.out.println("<---k---- getKarakter()");
        return k;
    }

    //----------- Interfész ---
    public void kor_kezdes() {
        Szkeleton.printTabs(true);
        System.out.println("-------> kor_kezdes()");
        Szkeleton.printTabs(false);
        System.out.println("<------- kor_kezdes()");
    }

    public void kor_vegzes() {
        Szkeleton.printTabs(true);
        System.out.println("---p---> kor_vegzes()");
        Szkeleton.printTabs(false);
        System.out.println("<---p--- kor_vegzes()");
    }
    //-----------
}
