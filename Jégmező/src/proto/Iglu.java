package proto;

import java.io.Serializable;

public class Iglu implements Epitmeny, Serializable {

    /**
     * @return Visszaadja hogy az iglu megved a vihartol
     */
    @Override
    public boolean megvedHovihartol() {
        return true;
    }

    /**
     * @return visszaadja, hogy az iglu megved a medvetol
     */
    @Override
    public boolean megvedMedvetol() {
        return true;
    }

    /**
     * @return Visszaadja hogy Iglu a neve
     */
    @Override
    public String getName() {
        return "iglu";
    }
}
