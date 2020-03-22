/*------------ G�bor Bal�zs ------------*/

package szkeleton;

import java.util.ArrayList;
import java.util.Scanner;

public class Jatektabla {
    private Jegmezo j;
    private ArrayList<Player> p;
    private ArrayList<Alkatresz> a;


    public Jatektabla(int size, ArrayList<Player> p) {
        System.out.println("-------> Jatektabla(size: int, p: Player[]) *konstruktor*");
        j = new Jegmezo(size);
        this.p = p;
        a = new ArrayList<>(); //Ez csak egyszer�s�t�s, bele kell rakni ebbe majd alkatr�szeket, �s elosztani a j�gt�bl�k k�z�tt.
        init();
        System.out.println("<------- Jatektabla(size: int, p: Player[]) *konstruktor*");
    }

    private void game_over() {
        System.out.println("-------> game_over()");
        System.out.println("<------- game_over()");
    }

    private boolean check_game_over() {
        System.out.println("------->  check_game_over()");
        System.out.println("Jatek vege? 1: igen");
        Scanner in = new Scanner(System.in);
        int I = in.nextInt();
        if(I == 1) {
            System.out.println("<---true--- check_game_over()");
            return true;
        }
        else {
            System.out.println("<---false--- check_game_over()");
            return false;
        }
    }

    private void next_player(Player p) {
        System.out.println("---p---> next_player(p: Player)");
        p.kor_kezdes();
        p.kor_vegzes();
        System.out.println("<---p--- next_player(p: Player)");

    }

    private void init() {
        System.out.println("-------> init()");
        boolean game_over = false;
        int act_index = 0;
        //itt is lesznek m�g dolgok(j�t�kosok elhelyez�se t�bl�kba...stb).
        while(!game_over) {
            act_index = act_index % p.size(); //az�rt, hogy utols� embern�l �jrakezd�dj�n.
            next_player(p.get(act_index));
            game_over = check_game_over();
            act_index++;
            //ide kell majd m�g h�vihar.
        }
        game_over();
        System.out.println("<------- init()");
    }

    //----------- Interf�sz ---
    //-----------



}
