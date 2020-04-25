package szkeleton;

public class Sator extends Targy implements Epitmeny {

	private boolean all;
	private int hasznalhato;
	private int hasznalatban;
	
    @Override
    public boolean megvedHovihartol() {
        return true;
    }

    @Override
    public boolean megvedMedvetol() {
        return false;
    }
    
    public void hasznaljak(Karakter k, Jegtabla j) {
    	if(k.vizben_van) return;
    	j.epitmenyKeszul(this);
    }
    
    public void hasznalodik() {
    	hasznalatban++;
    }
}
