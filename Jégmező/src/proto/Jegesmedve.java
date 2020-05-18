package proto;

import java.io.Serializable;
import java.util.ArrayList;

public class Jegesmedve extends Figura implements Serializable {

    public Jegesmedve(){
      Name = "Jegesmedve";
      vizben_van=false;
    }

    /**
     * Jegesmedve nem sebzodhet, de kell a figura miatt
     */
    @Override
    public void sebzodik() {
        //semmi
    }

    /**
     * Jegesmedvenek nem allithato a testhoje, de kell a figura miatt
     */
    @Override
    public void setHo(int ho) {
        //semmi
    }

    /**
     * Jegesmedve nem esik vizbe, de kell a figura miatt
     */
    @Override
    public void vizbe_esik() {
        //semmi
    }

    /**
     * A Jegesmedve át akar lépni egy másik jégtáblára, előbb megkérdezi, a jégtáblától amin áll, hogy szomszédja-e a jégtábla amire lépni akar, ha igen átlép, ha nem akkor nem
     * és megeszi a rajtalévő játékosokat
     * @param jt : erre a jégtáblára akar átlépni
     * @return ha át tudott lépni igazzal tér vissza, ha nem akkor hamissal
     */
    public boolean lep(Jegtabla jt) throws Exception {
        if(jegtabla.szomszed_e(jt)) {
            jegtabla.lelepnek(this);
            jt.ralepnek(this);
            if(jt.getEpitmeny()==null) megesz();
            else if(!jt.getEpitmeny().megvedMedvetol())
            	megesz();
            return true;
        } else {
            return false; }
    }

    /**
     * Minden figuranak a homersekletet, 0-ra allitja (ebben o is benne van ,de nem tortenik olyankor semmi)
     */
    public void megesz() {
        ArrayList<Figura> figurak=new ArrayList<Figura>(jegtabla.getFigurak());
        for(Figura f: figurak) f.setHo(0);
    }
    
    public Poz getPoz() {
		return jegtabla.getPoz();
		}
}
