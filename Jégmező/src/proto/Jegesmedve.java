package proto;

import java.io.Serializable;
import java.util.ArrayList;

public class Jegesmedve extends Figura implements Serializable {

    public Jegesmedve(){
      Name = "Jegesmedve";
    }

    @Override
    public void sebzodik() {
        //semmi
    }

    @Override
    public void setHo(int ho) {
        //semmi
    }

    @Override
    public void vizbe_esik() {
        //semmi
    }

    /**
     * A Jegesmedve át akar lépni egy másik jégtáblára, elõbb megkérdezi, a jégtáblától amin áll, hogy szomszédja-e a jégtábla amire lépni akar, ha igen átlép, ha nem akkor nem
     * és megeszi a rajtalévõ játékosokat
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

    public void megesz() {
        ArrayList<Figura> figurak=new ArrayList<Figura>(jegtabla.getFigurak());
        figurak.remove(this);
        for(Figura f: figurak) f.setHo(0);
    }
}
