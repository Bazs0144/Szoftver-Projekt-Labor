/*------------ Gábor Balázs ------------*/

package szkeleton;

public class Jatektabla {
    private Jegmezo j;
    private Player p;
    // private Alkatresz a;  ---  még nincs implementálva

    //----------- Interfész ---
    public void game_over() {
        System.out.println("-------> game_over()");
        System.out.println("<------- game_over()");
    }

    public boolean check_game_over() {
        System.out.println("------->  check_game_over()");
        if(true) {
            System.out.println("<---true--- check_game_over()");
            return true;
        }
        else {
            System.out.println("<---false--- check_game_over()");
            return false;
        }
    }

    public Player next_player() {
        System.out.println("---p---> next_player()");
        System.out.println("<---p--- next_player()");
        return null;

    }

    public void init() {
        System.out.println("-------> init()");
        System.out.println("<------- init()");
    }
    //-----------



}
