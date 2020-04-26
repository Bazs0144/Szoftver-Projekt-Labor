package proto;

import java.util.ArrayList;

public class Jatektabla {
    int kor;
    private Jegmezo j;
    private ArrayList<Player> p;
    private ArrayList<Alkatresz> a;

    /**
     * A játéktábla konstruktora, mely legenerál egy jégmezőt, és az alkatrészeket, valamint megkapja a jétékosokat.
     * @param width: A jégmező szélessége
     * @param height  a jégmező hossza
     * @param p : a játékosok, akik játszani fognak.
     */
    public Jatektabla(int width,int height, ArrayList<Player> p) {
        kor=1;
        j = new Jegmezo(width, height);
        this.p = p;
        a = new ArrayList<>(); //Ez csak egyszerűsítés, bele kell rakni ebbe majd alkatrészeket, és elosztani a jégtáblák között.
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
    }

    /**
     * Ellenőrzi, hogy a játék véget ért-e, vagy sem.
     * @return igaz ha véget ért, hamis ha nem.
     */
    private boolean check_game_over() {
     for(Player pl: p) if(pl.getKarakter().getHo()==0) return true;
     return false;
    }

    /**
     * Átadja a játék kezelését a következő játékosnak.
     * pl: az  adott játékos következik.
     */
    private void next_player(Player pl) {
        pl.kor_kezdes();
    }

    /**
     * Kezeli a játék menetét addig, amíg nincsen vége a játéknak.
     */
    public void init() {
        boolean game_over = false;
        int act_index = 0;
        //itt is lesznek még dolgok(játékosok elhelyezése táblákba...stb).
        while(!game_over) {
            act_index = act_index % p.size();
            System.out.println(kor+". kör, következö játékos: " + p.get(act_index));
            next_player(p.get(act_index));
            game_over = check_game_over();
            if(act_index==p.size()-1) {act_index=0; kor++;}
            else act_index++;
            //+
        }
        game_over();
    }
}
