package proto;

public interface Epitmeny {
    /**
     * Visszadja hogy az epitmeny megved-e a vihartol
     */
    public boolean megvedHovihartol();

    /**
     *Visszadja hogy az epitmeny megved-e a medvetol
     */
    public boolean megvedMedvetol();

    /**
     * Visszadja az epitmeny nevet
     */
    public String getName();
}
