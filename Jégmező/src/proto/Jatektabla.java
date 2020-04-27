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

    public Jegesmedve getJegesmedve(){
        return jm;
    }
    
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
    }

    /**
     * Ellenõrzi, hogy a játék véget ért-e, vagy sem.
     * @return igaz ha véget ért, hamis ha nem.
     */
    private boolean check_game_over() {
     for(Player pl: p) if(pl.getKarakter().getHo()==0) return true;
     return false;
    }

    /**
     * Átadja a játék kezelését a következõ játékosnak.
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
        while(!game_over) {
            act_index = act_index % p.size();
            System.out.println(kor+". kör, következõ játékos: " + p.get(act_index));
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
    
    /** Visszaadja az elsõ játékost. */
    public Player getFirstPlayer() {
    	if(p != null)
    		return p.get(0);
    	else return null;
    }
}

