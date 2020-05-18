package proto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;

public class Jatektabla extends JFrame implements Serializable {
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
    protected ArrayList<Player> p=new ArrayList<Player>();
    protected ArrayList<Alkatresz> a;
    private Jegesmedve jm;
    boolean game_over;
    int act_index;


    /**
     * A játéktábla konstruktora, mely legenerál egy jégmezőt, és az alkatrészeket, valamint megkapja a jétékosokat.
     * @param width: A jégmező szélessége
     * @param height  a jégmező hossza
     * @param p : a játékosok, akik játszani fognak.
     */
    public Jatektabla(int width,int height, ArrayList<Player> p) throws Exception {
        kor=1;
        boolean b=true;
        j =new Jegmezo(width, height,b);
        for(Player pl: p) j.getJegtabla(0,0).ralepnek(pl.getKarakter());
        this.p = p;
        a = new ArrayList<>();
        for(int i=0; i<3; i++) a.add(new Alkatresz(this));
        ArrayList<Jegtabla> notLuk=j.getNotLuk();
        for( Alkatresz alk: a) {
            boolean lerakva=false;
            while(!lerakva) {
                Random rand=new Random();
                int index=rand.nextInt(notLuk.size());
                Jegtabla jeg=notLuk.get(index);
                if(jeg.getTargy()==null)  {
                    jeg.setTargy(alk);
                    lerakva=true;
                }
            }
        }

        for(Jegtabla jeg: notLuk) {
            if(jeg.getTargy()==null) {
                Random rand = new Random();
                int szam = rand.nextInt(6)+1;
                if(szam%6==0) jeg.setTargy(new Sator(0));
                else if(szam%5==0) jeg.setTargy(new Aso());
                else if(szam%4==0) jeg.setTargy(new Etel());
                else if(szam%3==0) jeg.setTargy(new Lapat());
                else if(szam%2==0) jeg.setTargy(new Kotel());
                else jeg.setTargy(new Buvarruha());
            }
        }

        Random rand=new Random();
        int index=rand.nextInt(notLuk.size()-1)+1;
       jm=new Jegesmedve();
       notLuk.get(index).ralepnek(jm);

    }



    /**
     * @return Visszadja a a jatekosok listaja
     */
    public ArrayList<Player> getPlayers() {
        return p;
    }

    /**
     * visszadja a jatektabla jegesmedvejet
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
     *Visszaadja a játéktáblán lévő alkatrészek listáját.
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
     * Ellenőrzi, hogy a játék véget ért-e, vagy sem.
     * @return igaz ha véget ért, hamis ha nem.
     */
    public boolean check_game_over() {
     for(Player pl: p) if(pl.getKarakter().getHo()==0) return true;
     return false;
    }

    /**
     * Átadja a játék kezelését a következő játékosnak.
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
     * @param alk ezt adja hozza
     */
    public void addAlkatresz(Alkatresz alk) {
        this.a.add(alk);
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
    
    /** Visszaadja az első játékost. */
    public Player getFirstPlayer() {
    	if(p != null)
    		return p.get(0);
    	else return null;
    }
    
    public Player setNextPlayer(Player curr) throws Exception {
    	int x = 0;
    	
    	for(int i = 0; i<p.size(); i++) {
    		if(p.get(i).equals(curr))
    			x = i;
    	}
    	
    	curr.kor_vegzes();
    	
    	if(x+1 == p.size()) {
    		x = 0;
    		kor++;
    		medveLep();
    	}
    	else {
    		x++;
    	
    	p.get(x).kor_kezdes();
    	return p.get(x);
    }
    
    public void medveLep() throws Exception {
        Random rand = new Random();
        Jegtabla itt = jm.getJegtabla();
        Jegtabla ide = null;
        boolean found = false;
        while(found != true) {
        	int x = rand.nextInt(4);
        	int y = rand.nextInt(4);
        	ide = j.getJegtabla(100+x*120, 20+y*120);
        	if(itt.szomszed_e(ide))
        		found = true;
        }
        
        jm.lep(ide);
    }
}

