package szkeleton;

import java.util.ArrayList;
import java.util.Scanner;

public class Jatektabla {
    private Jegmezo j;
    private ArrayList<Player> p;
    private ArrayList<Alkatresz> a;


    public Jatektabla(int size, ArrayList<Player> p) {
        Szkeleton.printTabs(true);
        System.out.println("-------> Jatektabla(size: int, p: Player[]) *konstruktor*");
        j = new Jegmezo(size);
        this.p = p;
        a = new ArrayList<>(); //Ez csak egyszerűsítés, bele kell rakni ebbe majd alkatrészeket, és elosztani a jégtáblák között.
        Szkeleton.printTabs(false);
        System.out.println("<------- Jatektabla(size: int, p: Player[]) *konstruktor*");
    }

    private void game_over() {
        Szkeleton.printTabs(true);
        System.out.println("-------> game_over()");
        Szkeleton.printTabs(false);
        System.out.println("<------- game_over()");
    }

    private boolean check_game_over() {
        Szkeleton.printTabs(true);
        System.out.println("------->  check_game_over()");
        System.out.println("Jatek vege? 1: igen");
        Scanner in = new Scanner(System.in);
        int I = in.nextInt();
        if(I == 1) {
            Szkeleton.printTabs(false);
            System.out.println("<---true--- check_game_over()");
            return true;
        }
        else {
            Szkeleton.printTabs(false);
            System.out.println("<---false--- check_game_over()");
            return false;
        }
    }

    private void next_player(Player p) {
        Szkeleton.printTabs(true);
        System.out.println("---p---> next_player(p: Player)");
        p.kor_kezdes();
        p.kor_vegzes();
        Szkeleton.printTabs(false);
        System.out.println("<---p--- next_player(p: Player)");

    }

    //Ez ????
    public void init() {
        Szkeleton.printTabs(true);
        System.out.println("-------> init()");
        boolean game_over = false;
        int act_index = 0;
        //itt is lesznek még dolgok(játékosok elhelyezése táblákba...stb).
        while(!game_over) {
            next_player(p.get(act_index));
            game_over = check_game_over();
            //+
        }
        game_over();
        Szkeleton.printTabs(false);
        System.out.println("<------- init()");
    }

    //----------- Interfész ---
    //-----------
}
