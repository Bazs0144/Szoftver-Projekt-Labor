package proto;

import java.io.Serializable;

public class Iglu implements Epitmeny, Serializable {

    @Override
    public boolean megvedHovihartol() {
        return true;
    }

    @Override
    public boolean megvedMedvetol() {
        return true;
    }

    @Override
    public String getName() {
        return "iglu";
    }
}
