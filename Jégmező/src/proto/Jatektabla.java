package proto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Jatektabla implements Serializable {
    int kor;
    private Jegmezo j;
    private ArrayList<Player> p;
    private ArrayList<Alkatresz> a;
    private Jegesmedve jm;

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

    public Jegesmedve getJegesmedve(){
        return jm;
    }
    
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
    }

    /**
     * Ellen�rzi, hogy a j�t�k v�get �rt-e, vagy sem.
     * @return igaz ha v�get �rt, hamis ha nem.
     */
    private boolean check_game_over() {
     for(Player pl: p) if(pl.getKarakter().getHo()==0) return true;
     return false;
    }

    /**
     * �tadja a j�t�k kezel�s�t a k�vetkez� j�t�kosnak.
     * pl: az  adott j�t�kos k�vetkezik.
     */
    private void next_player(Player pl) {
        pl.kor_kezdes();
    }

    /**
     * Kezeli a j�t�k menet�t addig, am�g nincsen v�ge a j�t�knak.
     */
    public void init() {
        boolean game_over = false;
        int act_index = 0;
        while(!game_over) {
            act_index = act_index % p.size();
            System.out.println(kor+". k�r, k�vetkez� j�t�kos: " + p.get(act_index));
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

    public Jegmezo getJegMezo() {
        return  j;
    }

    public void setJegMezo(Jegmezo JM) {
        j = JM;
    }

    public void addAlkatresz(Alkatresz a) {
        this.a.add(a);
    }

    public void addPlayer(Player pl) {
        p.add(pl);
    }

    public  Player getPlayer(String Name){
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

