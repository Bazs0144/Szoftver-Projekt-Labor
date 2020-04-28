package proto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Jatektabla implements Serializable {
    /**
     * kor - enn�l a k�rn�l tart a jatek
     * j - a jegmezo a jatektablan
     * p - a jatekosok listaja
     * a - az alkatreszek listaja
     * jm - a jegesmedve ami a jegmezon van
     * game_over - ha igaz vege a jateknak, ha nem, folyamatban van
     * int act_index - a jatekoso kozul ennel az indexu jatekosnal tart a k�r
     */
    int kor;
    private Jegmezo j;
    private ArrayList<Player> p;
    private ArrayList<Alkatresz> a;
    private Jegesmedve jm;
    boolean game_over;
    int act_index;

    /**
     * A j�t�kt�bla konstruktora, mely legener�l egy j�gmez�t, �s az alkatr�szeket, valamint megkapja a j�t�kosokat.
     * @param width: A j�gmez� sz�less�ge
     * @param height  a j�gmez� hossza
     * @param p : a j�t�kosok, akik j�tszani fognak.
     */
    public Jatektabla(int width,int height, ArrayList<Player> p) {
        kor=1;
        j = new Jegmezo(width, height);
        this.p = p;
        a = new ArrayList<>(); //Ez csak egyszer�s�t�s, bele kell rakni ebbe majd alkatr�szeket, �s elosztani a j�gt�bl�k k�z�tt.
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
     *Visszaadja a j�t�kt�bl�n l�v� alkatr�szek list�j�t.
     */
    public ArrayList<Alkatresz> getAlkatresz() {
        return a;
    }

    /**
     * Befejezi a j�t�kot.
     */
    public void game_over() {
        game_over=true;
    }

    /**
     * Ellen�rzi, hogy a j�t�k v�get �rt-e, vagy sem.
     * @return igaz ha v�get �rt, hamis ha nem.
     */
    public boolean check_game_over() {
     for(Player pl: p) if(pl.getKarakter().getHo()==0) return true;
     return false;
    }

    /**
     * �tadja a j�t�k kezel�s�t a k�vetkez� j�t�kosnak.
     * pl: az  adott j�t�kos k�vetkezik.
     */
    void next_player(Player pl) {
        pl.kor_kezdes();
    }

    /**
     * Kezeli a j�t�k menet�t addig, am�g nincsen v�ge a j�t�knak.
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
    
    /** Visszaadja az els� j�t�kost. */
    public Player getFirstPlayer() {
    	if(p != null)
    		return p.get(0);
    	else return null;
    }
}

