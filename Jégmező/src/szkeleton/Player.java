/*------------ Gábor Balázs ------------*/

package szkeleton;

public class Player {
    private String nev;
    private int id;
    private Karakter k;

    Player(Karakter kr) {
        System.out.println("-------> Player(Karakter kr) konstruktor");
        k=kr;
        System.out.println("<------- Player(Karakter kr) konstruktor");
    }

    public Karakter getKarakter() {
        System.out.println("-------> getKarakter()");
        System.out.println("<---k---- getKarakter()");
        return k;
    }

    //----------- Interfész ---
    public void kor_kezdes() {
        System.out.println("-------> kor_kezdes()");
        System.out.println("<------- kor_kezdes()");
    }

    public void kor_vegzes() {
        System.out.println("---p---> kor_vegzes()");
        System.out.println("<---p--- kor_vegzes()");
    }
    //-----------
}
