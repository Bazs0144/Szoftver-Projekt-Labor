package szkeleton;

import java.util.ArrayList;
import java.util.Scanner;

public class Jatektabla {
    private Jegmezo j;
    private ArrayList<Player> p;
    private ArrayList<Alkatresz> a;


    public Jatektabla(ArrayList<Jegtabla> jt, ArrayList<Player> p) {
        Szkeleton.printFunction("-------> Jatektabla(size: int, p: Player[]) *konstruktor*", true, this);
        j = new Jegmezo(jt);
        this.p = p;
        a = new ArrayList<>(); //Ez csak egyszerűsítés, bele kell rakni ebbe majd alkatrészeket, és elosztani a jégtáblák között.
        Szkeleton.printFunction("<------- Jatektabla(size: int, p: Player[]) *konstruktor*", false, this);
    }

    private void game_over() {
        Szkeleton.printFunction("-------> game_over()", true, this);
        Szkeleton.printFunction("<------- game_over()", false, this);
    }

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

    private void next_player(Player p) {
        Szkeleton.printFunction("---p---> next_player(p: Player)", true, this);
        p.kor_kezdes();
        p.kor_vegzes();
        Szkeleton.printFunction("<---p--- next_player(p: Player)", false, this);

    }

    //Ez ????
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

    //----------- Interfész ---
    //-----------
}
