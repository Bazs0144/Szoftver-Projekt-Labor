package proto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Jatektabla implements Serializable {
    /**
     * kor - ennél a körnél tart a jatek
     * j - a jegmezo a jatektablan
     * p - a jatekosok listaja
     * a - az alkatreszek listaja
     * jm - a jegesmedve ami a jegmezon van
     * game_over - ha igaz vege a jateknak, ha nem, folyamatban van
     * int act_index - a jatekoso kozul ennel az indexu jatekosnal tart a kör
     */
    int kor;
    private Jegmezo j;
    private ArrayList<Player> p;
    private ArrayList<Alkatresz> a;
    private Jegesmedve jm;
    boolean game_over;
    int act_index;

    /**
     * A játéktábla konstruktora, mely legenerál egy jégmezõt, és az alkatrészeket, valamint megkapja a jétékosokat.
     * @param width: A jégmezõ szélessége
     * @param height  a jégmezõ hossza
     * @param p : a játékosok, akik játszani fognak.
     */
    public Jatektabla(int width,int height, ArrayList<Player> p) {
        kor=1;
        j = new Jegmezo(width, height);
        this.p = p;
        a = new ArrayList<>(); //Ez csak egyszerûsítés, bele kell rakni ebbe majd alkatrészeket, és elosztani a jégtáblák között.
    }

    /**
     * @return Visszadja a a jatekosok listaja
     */
    public ArrayList<Player> getPlayers() {
        return p;
    }

    /**
     * visszadja a jatektabla jegesmedvejet
     * @return
     */
    public Jegesmedve getJegesmedve(){
        return jm;
    }

    /**
     * beallitja a jegesmedvet
     * @param jgm erre allitja be
     */
    public void setJegesmedve(Jegesmedve jgm){
        jm = jgm;
    }

    /**
     *Visszaadja a játéktáblán lévõ alkatrészek listáját.
     */
    public ArrayList<Alkatresz> getAlkatresz() {
        return a;
    }

    /**
     * Befejezi a játékot.
     */
    public void game_over() {
        game_over=true;
    }

    /**
     * Ellenõrzi, hogy a játék véget ért-e, vagy sem.
     * @return igaz ha véget ért, hamis ha nem.
     */
    public boolean check_game_over() {
     for(Player pl: p) if(pl.getKarakter().getHo()==0) return true;
     return false;
    }

    /**
     * Átadja a játék kezelését a következõ játékosnak.
     * pl: az  adott játékos következik.
     */
    void next_player(Player pl) {
        pl.kor_kezdes();
    }

    /**
     * Kezeli a játék menetét addig, amíg nincsen vége a játéknak.
     */
    public void init() throws Exception {
        boolean game_over = false;
        int act_index = 0;
        while(!game_over) {
            act_index = act_index % p.size();

            next_player(p.get(act_index));
            game_over = check_game_over();
            if(act_index==p.size()-1) {
            	act_index=0;
            	kor++;
            	while(jm.lep(j.getJegtabla(new Random().nextInt(j.getJegtablak().size()), new Random().nextInt(j.getJegtablak().size())))) {
            	;
            	}
            }
            else act_index++;
        }
        game_over();
    }

    /**
     * @return Visszadja a jegmezot
     */
    public Jegmezo getJegMezo() {
        return  j;
    }

    /**
     * Beallitja a jegmezot
     * @param JM erre allitja be
     */
    public void setJegMezo(Jegmezo JM) {
        j = JM;
    }

    /**
     * hozzadegy alkatresz az alkatresz listahoz
     * @param a ezt adja hozza
     */
    public void addAlkatresz(Alkatresz a) {
        this.a.add(a);
    }

    /**
     * Hoozad egy jatekost a jatekosok listajahoz
     * @param pl ezt adja hozza
     */
    public void addPlayer(Player pl) {
        p.add(pl);
    }

    /**
     * Visszadja a parameterkent kapott nevu jatekost
     */
    public Player getPlayer(String Name){
        for (Player pl: p) {
            if(pl.getName().compareTo(Name) == 0) return pl;
        }
        return null;
    }
    
    /** Visszaadja az elsõ játékost. */
    public Player getFirstPlayer() {
    	if(p != null)
    		return p.get(0);
    	else return null;
    }
}

