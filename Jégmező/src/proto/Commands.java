package proto;

import java.io.*;
import java.util.ArrayList;

public class Commands {

    static protected Jatektabla jt;
    static protected BufferedReader reader;
    static protected FileReader fr;

    protected static void help(){ //Ez jo
        System.out.println("Reszletes leiras a parancsokra a 7. reszletes tervek dokumentacioban talalhato.\n");

        System.out.println("exit: Leallitja a program futasat.");
        System.out.println("loadMap <filename>: Betolti a tesztesetet a fajlbol.");
        System.out.println("saveTest <filename>: a teszt kimenetet a megadott fajlba menti.");
        System.out.println("start: elinditja a betoltott tesztesetet.");
        System.out.println("saveMap <filename>: Elmenti a jegmezo allapotat egy fajlba");
        System.out.println("generateMap <width><height><rand>: General egy jegmezot " +
                "a megadott szelesseggel es magassaggal, " +
                "és rand opciotol fuggoen hogy kitolti-e objektumokkal a jegmezot. ");
        System.out.println("changeJegtabla <pozX><pozY><Type>: Atalakitja az egyik mar letezo " +
                "jegtablat masik tipussa az adott pozicioban.");
        System.out.println("addTargy <pozX><pozY><Type> Beallitja az adott pzicioban levo " +
                "jegtablan levo targyat az adott tipussal");
        System.out.println("addPlayer <name><pozX><pozY><karakter>: hozzaad eg jatekost az adott jegtablahoz.");
        System.out.println("playerLep <name><pozX><pozY><karakter>: A karakter lep egyet az adott indexu jegtablara");
        System.out.println("iglutEpit <name>: Eszkimo karakter epit egy iglut.");
        System.out.println("kutatoVizsgal<name><PozX><PozY>: kutato hasznalja a kepesseget.");
        System.out.println("targyatHasznal<name><index><pozX><pozY>: A jatekos karaktere hasznalja az adott targyat");
        System.out.println("targyFelvetel <name><pozX><pozY>: A jatekos felvesz egy targyat az adott jegtablarol");
        System.out.println("targyHozzaadasa <Name><type>: Egy targyat adunk az adott jatekosnak.");
        System.out.println("addMedve <pozX><pozY>: Hozzaad egy jegesmedvet az adott jegtablara.");
        System.out.println("medveLep <index>: A medve lep egyet az adott indexu jegtabalara.");
        System.out.println("egyHovihar <pozX><pozY>: Hovihart general az adott jegtablan.");
        System.out.println("hoviharRand: Hovihart general veletlenszeruen kivalasztott jegtablakon.");
        System.out.println("listKarakterTargyak <name>: Kilistazza a karakternel levo targyakat.");
        System.out.println("listJegtablaAttrib <pozX><pozY>: Kiírja a jegtabla attributumait.");
        System.out.println("listJegmezo: kiirja mindegyik jégtablan mely " +
                "karakterek allnak, mennyi rajtuk a homennyiseg," +
                " es a rajtuk levo targy micsoda.");
        System.out.println("printPlayersLife <name>: Kiirja az adott jatekos eletet.");
        System.out.println("digSnow <name><pozX><pozY>: A Jatekos asast vegez az adott jegtablan.");
        System.out.println("setSnow <pozX><pozY><size>: Beallitja a jegtablan levo ho mennyiseget.");
        System.out.println("listKarAttrib <name>: Kiirja a kimenetre a karakter attributumait.");
        System.out.println("listKarTarg <name>: kiirja a karakternel levo targyakat indexeikkel.");
        System.out.println("addJegtabla <pozX><pozY><type><targy><epitm>: Hozzaad egy jegtablat.");
        System.out.println("listJegtablaSzomszed<pozX1><pozY1><pozX2><pozY2>: Szomszedda teszi a ket jegtablat");
        System.out.println("setIstabilKap <pozX><pozY><size>: Beallitja a jegtabla kapacitasat.");
        System.out.println("JatekosKorVege <name>: Befejezi a jatekos koret.");
        System.out.println("startGame: Elkezdi a jetekot.");
    }

    protected static void saveMap(String[] cmd) { //Remelhetoleg jo
        try {
            if (cmd.length > 1) {
                File f = new File(cmd[1]);
                if (!f.exists())
                    f.createNewFile();
                if (f.exists()) {
                    FileOutputStream fs = new FileOutputStream(f);
                    ObjectOutputStream out = new ObjectOutputStream(fs);
                    out.writeObject(jt);
                    out.close();
                    System.out.println("saveMap sikerult");
                }
            }
        }
        catch (Exception e) {
            System.out.println("saveMap nem sikerult");
        }
    }

    protected static void loadMap(String[] cmd) throws IOException { //Remelhetoleg jo
        try {
            String wd = System.getProperty("user.dir");
            File f = new File(wd, cmd[1]);
            if (cmd.length > 1) {
                if (f.exists()) {

                    FileInputStream fs = new FileInputStream(f);
                    ObjectInputStream in = new ObjectInputStream(fs);
                    jt = (Jatektabla) in.readObject();
                    in.close();
                    System.out.println("loadMap sikeresen lefutott");

                } else System.out.println("loadMap nem sikerult");
            } else System.out.println("loadMap nem sikerult");
        } catch (Exception e) {
            System.out.println("loadMap nem sikerult");
        }
    }

    protected  static void loadTest(String[] cmd) throws FileNotFoundException {
        try {
            File f = new File(cmd[2]);
            if (!f.exists()) {
                System.out.println("loadTest nem sikerult");
                return;
            }
            fr = new FileReader(f);
            System.out.println("loadTest sikerult");
        }
        catch (Exception e) {
            System.out.println("loadTest nem sikerult");
        }
    }

    protected static void saveTest() {

    }

    protected static  void start() {
        try {
            reader = new BufferedReader(fr);
            if (reader.readLine().compareTo("90kjk12") != 0) {
                System.out.println("start nem sikerult");
                return;
            }
        }
        catch (Exception e){
            System.out.println("start nem sikerult");
        }
    }

    protected static void generateMap(String[] cmd) { //Ez jo
        try {
             if(Integer.parseInt(cmd[1]) < 0 || Integer.parseInt(cmd[2]) < 0) {
                 System.out.println("generateMap nem sikerult");
                 return;
             }
            jt = new Jatektabla(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]), new ArrayList<Player>());
            System.out.println("generateMap sikeresen lefutott");
        } catch (Exception e) {
            System.out.println("generateMap nem sikerult");
        }
    }

    protected static void changeJegtabla(String[] cmd) {
       // Jegtabla j = jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));

    }
    protected static void addTargy(String[] cmd) { //Ez jo
        Jegtabla j = jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
        if(cmd[3].compareTo("Alkatresz") == 0){
            Alkatresz alk = new Alkatresz(jt);
            j.setTargy(alk);
            jt.addAlkatresz(alk);
        }
        else if(cmd[3].compareTo("aso") == 0 ) j.setTargy(new Aso());
        else if(cmd[3].compareTo( "buvarruha") == 0) j.setTargy(new Buvarruha());
        else if(cmd[3].compareTo("etel") == 0) j.setTargy(new Etel());
        else if(cmd[3].compareTo("kotel") == 0) j.setTargy(new Kotel());
        else if(cmd[3].compareTo("lapat") == 0) j.setTargy(new Lapat());
        else if(cmd[3].compareTo("sator") == 0) j.setTargy(new Sator());
    }

    protected static void addPlayer(String[] cmd) { //Ez jo
        Karakter k;
        if(cmd[4].compareTo("eszkimo") == 0) k = new Eszkimo();
        else if(cmd[4].compareTo("sarkkutato") == 0) k = new Sarkkutato();
        else return;
        Player p = new Player(k, cmd[1]);
        Jegtabla j = jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[2]), Integer.parseInt(cmd[3]));
        jt.addPlayer(p);
        j.addPlayer(p);
        p.getKarakter().setJegtabla(j);

    }

    protected static void playerLep(String[] cmd) {// Nem tudom hogy jó-e
            Player p = jt.getPlayer(cmd[1]);
            ArrayList<Jegtabla> ja = p.getKarakter().jegtabla.getSzomszedok();
            Jegtabla j2 = ja.get(Integer.parseInt(cmd[2]));
            j2.addPlayer(p);
    }

    protected static void iglutEpit(String[] cmd) {//Ez mukodik, ha atirtam az iglut_epit fuggvenyt.(Nem ertettem)
        Eszkimo k =(Eszkimo) jt.getPlayer(cmd[1]).getKarakter();
        if(k.Name.compareTo("Eszkimo") == 0) {
            k.iglut_epit();
        }

    }
    protected static void kutatoVizsgal(String[] cmd) { //Ez meg nem jo
        Sarkkutato k =(Sarkkutato) jt.getPlayer(cmd[1]).getKarakter();
        if(k.Name.compareTo("Sarkkutato") == 0) {
            k.megnez(jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[2]), Integer.parseInt(cmd[3])));
        }

    }

    protected static void targyatHasznal(String[] cmd) {

    }

    protected static void targyFelvetel() {

    }

    protected static void targyHozzadasa(String[] cmd) {//Nem tudom hogy jo
        Karakter k = jt.getPlayer(cmd[1]).getKarakter();
        if(cmd[2].compareTo("Alkatresz") == 0){
            Alkatresz alk = new Alkatresz(jt);
            k.targy_hozzaadasa(alk);
            jt.addAlkatresz(alk);
        }
        else if(cmd[2].compareTo("aso") == 0 ) k.targy_hozzaadasa(new Aso());
        else if(cmd[2].compareTo( "buvarruha") == 0) k.targy_hozzaadasa(new Buvarruha());
        else if(cmd[2].compareTo("etel") == 0) k.targy_hozzaadasa(new Etel());
        else if(cmd[2].compareTo("kotel") == 0) k.targy_hozzaadasa(new Kotel());
        else if(cmd[2].equals("lapat")) k.targy_hozzaadasa(new Lapat());
        else if(cmd[2].compareTo("sator") == 0) k.targy_hozzaadasa(new Sator());

    }

    protected static void addMedve(String[] cmd) { //Ez jo
        Jegtabla j = jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
        j.addFigura(new Jegesmedve());
    }

    protected static void medveLep() {

    }

    protected static void egyHovihar() {

    }

    protected static void hoviharRand() {

    }

    //Ebből valamiért ketto van ne csináld meg, lejebb már megvan
    protected static void listKarakterTargyak() {

    }

    protected static void listJegtablaAttrib(String[] cmd) { //Ez jo
        Jegtabla j = jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
        System.out.println("Pozicio: " + cmd[1] + " " + cmd[2]);
        System.out.println("Tipus: " +  j.type);
        System.out.println("Homennyiseg: " + j.getHoMennyiseg());
        System.out.print("Karakterek: ");
        ArrayList<Figura> k = j.getFigurak();
        if(k.size() == 0) System.out.print("null");
        else {
            for (Figura f : k) {
                System.out.print(f.Name + " ");
            }
        }
        System.out.println();
        System.out.print("Targy: ");
        if(j.getTargy() == null) System.out.println("null");
        else System.out.println(j.getTargy().Name);
        System.out.print("Epitmeny: ");
        if(j.getEpitmeny() == null) System.out.println("null");
        else System.out.println(j.getEpitmeny().getName());
        if(j.type.compareTo("Instabil") == 0) {
            Instabil jr = (Instabil) jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
            System.out.println("Kapacitas: " + jr.getKapacitas());
        }

    }

    protected static void listJegmezo() {
        for(Jegtabla j: jt.getJegMezo().getJegtablak()) {
            String[] cmd={"listJegtablaAttrib", String.valueOf(j.getPoz().x), String.valueOf(j.getPoz().y)};
            listJegtablaAttrib(cmd);
        }

    }

    protected static void printPlayersLife(String[] cmd) {
            System.out.println("Homennyiseg: " + jt.getPlayer(cmd[1]).getKarakter().getHo());

    }

    protected static void digSnow(String[] cmd) { //Ez jó
        Karakter k = jt.getPlayer(cmd[1]).getKarakter();
        k.kias();
        // Ide minek PozX PozY
    }

    protected static void setSnow(String[] cmd) { //Ez jó
        jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2])).setHo(Integer.parseInt(cmd[3]));
    }

    protected static void listKarAttrib(String[] cmd) {
        Karakter k = jt.getPlayer(cmd[1]).getKarakter();
        Poz p=k.getJegtabla().getPoz();
        System.out.println("Jatekos: " + cmd[1]);
        System.out.println("Karakter: " + k.getClass().getName());
        System.out.println("Ho: " + k.getHo());
        String viz= (k.get_vizben_van()) ? "igen" : "nem";
        System.out.println("Vizben: " + viz);
        System.out.println("Munkak: " + k.munkak_szama);
        System.out.println("Jegtabla: " +p.x + " " +p.y );
    }

    protected static void listKarTargy(String[] cmd) {
        Karakter k = jt.getPlayer(cmd[1]).getKarakter();
        int i=0;
        for(Targy t: k.getTargyak()) {
            System.out.println(i + ": " + t.Name);
            i++;
        }
    }

    protected static void addJegtabla(String[] cmd) {

    }

    protected static void listJegtablaSzomszed(String[] cmd) {
        Jegtabla jeg = jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
        int i=0;
        for(Jegtabla j: jeg.getSzomszedok()) {
            Poz p=j.getPoz();
            System.out.println(i + ": " + p.x + " " + p.y);
            i++;
        }
    }

    protected static void addJegtablaSzomszed(String[] cmd) {

    }

    protected static void setInstabilKap(String[] cmd) {

    }

    protected static void jatekosKorVege(String[] cmd) {

    }

    protected static void startGame() {
        jt.init();
    }

    //----------------------------------------------
}
