package szkeleton;

import java.util.ArrayList;
import java.util.Scanner;

public class Jatektabla {
    private Jegmezo j;
    private ArrayList<Player> p;
    private ArrayList<Alkatresz> a;

    /**
     * A játéktábla konstruktora, mely legenerál egy jégmezőt, és az alkatrészeket, valamint megkapja a jétékosokat.
     * @param size: A jégmező mérete.
     * @param p : a játékosok, akik játszani fognak.
     */
    public Jatektabla(int size, ArrayList<Player> p) {
        Szkeleton.printFunction("-------> Jatektabla(size: int, p: Player[]) *konstruktor*", true, this);
        j = new Jegmezo(size);
        this.p = p;
        a = new ArrayList<>(); //Ez csak egyszerűsítés, bele kell rakni ebbe majd alkatrészeket, és elosztani a jégtáblák között.
        a.add(new Alkatresz(this));
        Szkeleton.printFunction("<------- Jatektabla(size: int, p: Player[]) *konstruktor*", false, this);
    }

    /**
     *Visszaadja a játéktáblán lévő alkatrészek listáját.
     */
    public ArrayList<Alkatresz> getAlkatresz() {
        return a;
    }

    /**
     * Befejezi a játékot.
     */
    public void game_over() {
        Szkeleton.printFunction("-------> game_over()", true, this);
        Szkeleton.printFunction("<------- game_over()", false, this);
    }

    /**
     * Ellenőrzi, hogy a játék véget ért-e, vagy sem.
     * @return igaz ha véget ért, hamis ha nem.
     */
    private boolean check_game_over() {
        Szkeleton.printFunction("------->  check_game_over()", true, this);
        System.out.println("Jatek vege? 1: igen");
        Scanner in = new Scanner(System.in);
        int I = in.nextInt();
        if(I == 1) {
            Szkeleton.printFunction("<---true--- check_game_over()", false, this);
            return true;
        }
        else {
            Szkeleton.printFunction("<---false--- check_game_over()", false, this);
            return false;
        }
    }

    /**
     * Átadja a játék kezelését a következő játékosnak.
     * @param p Az adott játékos következik.
     */
    private void next_player(Player p) {
        Szkeleton.printFunction("-------> next_player(p: Player)", true, this);
        p.kor_kezdes();
        p.kor_vegzes();
        Szkeleton.printFunction("<---p--- next_player(p: Player)", false, this);

    }

    /**
     * Kezeli a játék menetét addig, amíg nincsen vége a játéknak.
     */
    public void init() {
        Szkeleton.printFunction("-------> init()", true, this);
        boolean game_over = false;
        int act_index = 0;
        //itt is lesznek még dolgok(játékosok elhelyezése táblákba...stb).
        while(!game_over) {
            act_index = act_index % p.size();
            next_player(p.get(act_index));
            game_over = check_game_over();
            act_index++;
            //+
        }
        game_over();
        Szkeleton.printFunction("<------- init()", false, this);
    }
}
