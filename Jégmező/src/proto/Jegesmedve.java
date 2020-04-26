package proto;

import java.util.ArrayList;

public class Jegesmedve extends Figura {

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
     * A Jegesmedve át akar lépni egy másik jégtáblára, előbb megkérdezi, a jégtáblától amin áll, hogy szomszédja-e a jégtábla amire lépni akar, ha igen átlép, ha nem akkor nem
     * és megeszi a rajtalévő játékosokat
     * @param jt : erre a jégtáblára akar átlépni
     * @return ha át tudott lépni igazzal tér vissza, ha nem akkor hamissal
     */
    public boolean lep(Jegtabla jt) {
        Szkeleton.printFunction("------->  lep(Jegmezo jm)", true, this);
        if(jegtabla.szomszed_e(jt)) {
            jegtabla.lelepnek(this);
            jt.ralepnek(this);
            megesz();
            Szkeleton.printFunction("<---true---- lep(Jegmezo jm)", false, this);
            return true;
        } else {
            Szkeleton.printFunction("<---false---- lep(Jegmezo jm)", false, this);
            return false; }
    }

    public void megesz() {
        ArrayList<Figura> figurak=new ArrayList<Figura>(jegtabla.getFigurak());
        figurak.remove(this);
        for(Figura f: figurak) f.setHo(0);
    }
}
