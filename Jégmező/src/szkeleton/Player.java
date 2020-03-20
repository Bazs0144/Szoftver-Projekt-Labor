/*------------ Gábor Balázs ------------*/

package szkeleton;

public class Player {
    private String nev;
    private int id;
    //private Karakter k;

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
