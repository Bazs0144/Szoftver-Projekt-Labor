package proto;

import java.io.Serializable;
import java.util.ArrayList;

public class Jegesmedve extends Figura implements Serializable {

    public Jegesmedve(){
      Name = "Jegesmedve";
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
     * A Jegesmedve �t akar l�pni egy m�sik j�gt�bl�ra, el�bb megk�rdezi, a j�gt�bl�t�l amin �ll, hogy szomsz�dja-e a j�gt�bla amire l�pni akar, ha igen �tl�p, ha nem akkor nem
     * �s megeszi a rajtal�v� j�t�kosokat
     * @param jt : erre a j�gt�bl�ra akar �tl�pni
     * @return ha �t tudott l�pni igazzal t�r vissza, ha nem akkor hamissal
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
}
