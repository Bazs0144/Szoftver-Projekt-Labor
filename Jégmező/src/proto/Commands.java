package proto;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * A prototipus tesztelésére használt parancsok osztálya.
 * */
public class Commands {

	/**
	 * jt : a játéktábla amelyen az éppen tesztelt játék fut. A további objektumok ehhez a jégtáblához tartoznak.
	 * inGame: igaz értéket vesz fel, ha éppen el van inditva a játék.
	 * allCases: ha igaz értéket vesz fel, akkor minden tesztesetet kell futtatni és eredményüket megjeleiteni.
	 * siker: ha igaz, a kiadott parancs futtatása sikeres volt.
	 * isTest: a teszteset sikeresen be lett töltve.
	 */
    static protected Jatektabla jt;
    static protected boolean inGame = false;
    static protected boolean allCases = false;
    static protected BufferedReader reader;
    static protected FileReader fr;
    static protected FileWriter fw;
    static protected PrintWriter writer;
    static protected  String actTest;
    static protected  int actAllTest = 0;
    static protected boolean siker;
    static boolean isTest = false;
    static ArrayList<String> commandBuffer;

    /**
     * Kilistázza az összes lehetséges parancsot, a helyes megadási szintaktikáját is feltüntetve*/
    protected static void help(){ 
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
        System.out.println("setInstabilKap <pozX><pozY><size>: Beallitja a jegtabla kapacitasat.");
        System.out.println("JatekosKorVege <name>: Befejezi a jatekos koret.");
        System.out.println("startGame: Elkezdi a jatekot.");
        System.out.println("testAllCases: Az osszes dokumentumban levo tesztesetet teszteli.");
    }


    /** az aktuális pálya elmentése egy fájlba*/
    protected static void saveMap(String[] cmd) throws IOException { 
        if (cmd.length > 1) {
            File f = new File(cmd[1] + ".dat");
            if (!f.exists())
                f.createNewFile();
            if (f.exists()) {
                FileOutputStream fs = new FileOutputStream(f);
                ObjectOutputStream out = new ObjectOutputStream(fs);
                out.writeObject(jt);
                out.close();
            }
        }
    }

    /** Egy létező pálya betöltése a megadott fájlból*/
    protected static void loadMap(String[] cmd) throws IOException, ClassNotFoundException { 

        String wd = System.getProperty("user.dir");
        File f = new File(wd, cmd[1] + ".dat");
        if (cmd.length > 1) {
            if (f.exists()) {

                FileInputStream fs = new FileInputStream(f);
                ObjectInputStream in = new ObjectInputStream(fs);
                jt = (Jatektabla) in.readObject();
                in.close();

            } else {doublePrintln("loadMap nem sikerult"); siker = false;};
        } else {doublePrintln("loadMap nem sikerult"); siker = false;};
    }

    /** A paraméterként megadott sorszámú teszteset betöltése. Betöltés után futtatható a teszt, az elvégzett parancsok a 
     * megadott fájlban található parancsok lesznek.
     * Ha nem létezik a megadott sorszámú teszteset, a siker attribútum értéke hamis lesz,
     * majd hibaüzenetben jelezzük a felhasználónak, hogy nem sikerült a teszt betöltése.
     * */
    protected  static void loadTest(String[] cmd) throws FileNotFoundException {
        File f = new File(".\\src\\proto\\testcases\\" + cmd[1] + ".txt");
        actTest = cmd[1];
        if (!f.exists()) {
            doublePrintln("loadTest nem sikerult");
            siker = false;
            return;
        }
        fr = new FileReader(f);
    }


    /**Egy aktuális teszteset elmentése, a parancs bufferben található parancsokat sorba elhelyezi egy fájlban, igy egy tesztesetet generálva
     * A teszteset azonositóval kezdődik minden teszt fájl tartalma.
     * */
    protected static void saveTest(String[] cmd) throws IOException {
        FileWriter fw = new FileWriter(".\\src\\proto\\testcases\\" + cmd[1] + ".txt");
        PrintWriter pw = new PrintWriter(fw);
        pw.println("90kjk12");
        for(String command: commandBuffer){
            pw.println(command);
        }
        pw.close();
    }

    /**
     * 
     * Egy betöltött teszteset futásának elinditására szolgáló parancs.
     * Csak akkor futtatható egy teszt, ha a betöltése sikeres volt.
     * Csak az aktuálisan betöltött, egy darab tesztesetet indit el.
     */
    protected static  void start() throws IOException {

        reader = new BufferedReader(fr);

        siker = false; //hogyne irja ki a tesztfajlba a startot
        File f = new File(".\\src\\proto\\testresult\\" + actTest + ".txt");
        f.createNewFile();
        fw = new FileWriter(f);
        writer = new PrintWriter(fw);
        if (reader.readLine().compareTo("90kjk12") != 0) {
            System.out.println("start nem sikerult");
            siker = false;
            return;
        }
        if(!allCases) System.out.println("----------------------------------------");
        isTest = true;
    }

    /** Egy új játéktábla generálása. Paraméterként a jégmező méreteit várja (szélessége és hosszúsága) Jégtábla egységekben.
     * Ha a méretek nem természetes egész számok, a akkor a parnacs hibaüzenettel jelez a felhasználónak.*/
    protected static void generateMap(String[] cmd) { //Ez jo
        if (Integer.parseInt(cmd[1]) < 0 || Integer.parseInt(cmd[2]) < 0) {
            doublePrintln("hihi?");
            siker = false;
            return;
        }
        jt = new Jatektabla(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]), new ArrayList<Player>());
    }

    /** Egy létező jégtábla átalakitása.
     * Első sorban elmenti a megváltoztatni kivánt jégtábla szomszédait, majd kitörli a jégtáblát.
     * Létrehoz egy új jégtáblát a kitörölt jégtábla helyére.
     * Az új jégtáblának tipusától függően beállitja ennek kapacitását,
     * majd beállitja a szomszédait is.
     * Ha nem létezik a megadott koordinátájú  vagy a megadott tipúsú jégtábla, akkor a parnacs hibaüzenettel jelez a felhasználónak.*/
 protected static void changeJegtabla(String[] cmd) throws Exception{
        Jegtabla j = jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
        if(j == null) throw new Exception();
        Poz poz=new Poz(Integer.parseInt(cmd[1]),Integer.parseInt(cmd[2]));
        ArrayList<Jegtabla> jegT = jt.getJegMezo().getJegtablak();
        ArrayList<Jegtabla> szomszedok = j.getSzomszedok();
        
        for(int i = 0; i < jegT.size(); i++) {
        	jegT.get(i).deleteSzomszed(j);
        }
        
        jegT.remove(jt.getJegMezo().getJegtabla(poz.x, poz.y));
        if(cmd[3].compareTo("luk") == 0 ) {
            Luk luk = new Luk(poz);
            jt.getJegMezo().addJegtabla(luk);
            j = jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
            j.setKapacitas(0); 
        }
        else  if(cmd[3].compareTo("instabil") == 0 ) {
            Instabil in = new Instabil(poz);
            jt.getJegMezo().addJegtabla(in);
            j = jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
            j.setKapacitas(2); 
        }
        else  if(cmd[3].compareTo("stabil") == 0 ) {
            Stabil st = new Stabil(poz);
            jt.getJegMezo().addJegtabla(st);
            j = jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
            j.setKapacitas(1000); 
        }
        else throw new Exception();
        
        for(int i = 0; i < szomszedok.size(); i++)
        	jt.getJegMezo().szomszedokkaTesz(szomszedok.get(i), jt.getJegMezo().getJegtabla(poz.x, poz.y));
    }

 	/** Hozzáad egy, a harmadik paraméterként megadott tipusú tárgyat, a paraméterként megadott jégtáblához.
 	 * A megadott tipusnak megfelelő tárgyat hoz létre és állitja be a jégtábla tárgy attribútumaként.
 	 * Ha nem létezik a megadott koordinátájú jégtábla, vagy a megadott tipúsú tárgy, akkor a parnacs hibaüzenettel jelez a felhasználónak.*/
    protected static void addTargy(String[] cmd)throws Exception {
        Jegtabla j = jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
        if(j == null) throw new Exception();
        if(cmd[3].compareTo("alkatresz") == 0){
            Alkatresz alk = new Alkatresz(jt);
            j.setTargy(alk);
            jt.addAlkatresz(alk);
        }
        else if(cmd[3].compareTo("aso") == 0 ) j.setTargy(new Aso());
        else if(cmd[3].compareTo( "buvarruha") == 0) j.setTargy(new Buvarruha());
        else if(cmd[3].compareTo("etel") == 0) j.setTargy(new Etel());
        else if(cmd[3].compareTo("kotel") == 0) j.setTargy(new Kotel());
        else if(cmd[3].compareTo("lapat") == 0) j.setTargy(new Lapat());
        else if(cmd[3].compareTo("sator") == 0) j.setTargy(new Sator(jt.getPlayers().size()));
        else throw new Exception();

    }

    /**
     * Hozzáad egy új játékost a jégtáblához. A játékos karakterének  beállitásra kerül a munkáinak száma.
     * Ha a játékost egy luk-ra helyezzük, akkor automatikusan vizbe esik a karaktere.
     * */
   protected static void addPlayer(String[] cmd)throws Exception { 
        Karakter k;
        if(cmd[4].compareTo("eszkimo") == 0) {k = new Eszkimo(); k.set_munkak_szama(4); }
        else if(cmd[4].compareTo("sarkkutato") == 0) { k = new Sarkkutato(); k.set_munkak_szama(4);}
        else throw new Exception();
        Player p = new Player(k, cmd[1]);
        Jegtabla j = jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[2]), Integer.parseInt(cmd[3]));
        if(j == null) throw new Exception();
        jt.addPlayer(p);
        j.addPlayer(p);
        p.getKarakter().setJegtabla(j);
        if(j.getKapacitas() == 0)  {
        	p.getKarakter().vizbe_esik();
        	doublePrintln("vizbeesett");
        	munkaVolt(p);
        	
        }

    }

   /**
    * A játékos átlép egy másik jégtáblára.
    * Az új jégtábla tipusa szerint ellenőrizni kell, ha biztonságban van, egyből vizbe esik vagy feldordul a jégtábla és az összes ott található karakter vizbe esik.
    * */
    protected static void playerLep(String[] cmd) throws Exception {
        Player p = jt.getPlayer(cmd[1]);
        ArrayList<Jegtabla> ja = p.getKarakter().getJegtabla().getSzomszedok();
        Jegtabla j2 = ja.get(Integer.parseInt(cmd[2]));
        p.getKarakter().lep(j2);
        if(j2.type.equals("Luk")) {
            doublePrintln(p.getName() + " vizbeesett");
            doublePrintln(p.getName() + " munkak szama: " + p.getKarakter().munkak_szama);
            p.getKarakter().vizbeKerultKor=jt.kor;
        }
        else if(j2.type.equals("Instabil")) {
            if(j2.getKapacitas()<j2.figurak.size()) {
                p.getKarakter().munkak_szama=0;
                for(Player pl: jt.getPlayers()) {
                    if(pl.getKarakter().getJegtabla().getPoz().equals(j2.getPoz())) {
                    doublePrintln(pl.getName() + " vizbeesett");
                    doublePrintln(pl.getName() + " munkak szama: " + pl.getKarakter().munkak_szama);
                    pl.getKarakter().vizbeKerultKor=jt.kor;
                    }
                }
            }else munkaVolt(p);
        }else munkaVolt(p);
      
    }

    /**
     *A játékos iglut épit. Csak a következő feltételek mellett sikeres az iglu épitése:
     *a játékos karaktere egy eszkimó, a jégtábla nincs befagyva és nincs már rajta hó, nem található tárgy a jégtáblán és nincs más épitmény sem ott.
     *Ha a karakter vizben van, egyértelműen akkor sem végezheti el a tevékenységet.
     *Sikeretelen iglu épités esetén, a parnacs hibaüzenettel jelez ezt a felhasználónak.
     * */
    protected static void iglutEpit(String[] cmd)throws Exception {
        Eszkimo k =(Eszkimo) jt.getPlayer(cmd[1]).getKarakter();
        if(k.get_vizben_van())throw new Exception(); 
        if(k.Name.compareTo("Eszkimo") == 0 && k.van_munkaja() && !k.jegtabla.get_befagyva() && k.jegtabla.getHoMennyiseg() == 0 && k.jegtabla.getEpitmeny()== null && k.jegtabla.getTargy() == null) {
            k.iglut_epit();
            munkaVolt(jt.getPlayer(cmd[1]));
        }
        else throw new Exception(); 

    }
    
    /**
     * A játékos jégtábla kapacitását vizsgálja meg.
     * Ha a játékos karaktere nem sarkkutató, akkor a munka nem megy végbe és a parnacs hibaüzenettel jelez a felhasználónak.
     * */
    protected static void kutatoVizsgal(String[] cmd)throws Exception { 
        Sarkkutato k =(Sarkkutato) jt.getPlayer(cmd[1]).getKarakter();
        if(k.Name.compareTo("Sarkkutato") == 0) {
        	if(k.get_vizben_van())throw new Exception(); 
            int kapacitas = k.megnez(jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[2]), Integer.parseInt(cmd[3])));
            doublePrintln("A vizsgalt jegtabla kapacitasa: " + kapacitas);
            munkaVolt(jt.getPlayer(cmd[1]));
        }
        else throw new Exception(); 
    }

    /**
     * Egy jatekos karaktere hasznal a targyai kozul egy adott indexut, adott pozicioju jegtablan
     * @param cmd a kapott parancs
     * @throws Exception kivetelt dob, ha nem letezik a jatekos, ha nem letezik a jegtabla, ha nem letezik az adott targy
     */
    protected static void targyatHasznal(String[] cmd)throws Exception {
        Player p = jt.getPlayer(cmd[1]);
        if(p == null) throw new Exception();
        Jegtabla j = jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[2]), Integer.parseInt(cmd[3]));
        if(j == null) throw new Exception();
        ArrayList<Targy> zseb = p.getKarakter().getTargyak();
        Targy T = zseb.get(Integer.parseInt(cmd[4]));
        if(T == null) throw new Exception();
        if(p.getKarakter().get_vizben_van()) throw new Exception();
        T.hasznaljak(p.getKarakter(), j);
        munkaVolt(p);
    }

    protected static void targyFelvetel(String[] cmd) throws Exception {//Szerintem jo
        Karakter k = jt.getPlayer(cmd[1]).getKarakter();
        Jegtabla j = jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[2]), Integer.parseInt(cmd[3]));
        if(j.elvesz(k, j.getTargy())==false){
            throw new Exception();
        }
    }

    protected static void targyHozzadasa(String[] cmd) throws Exception{//Szerintem jo
        Karakter k = jt.getPlayer(cmd[1]).getKarakter();
        if(cmd[2].compareTo("alkatresz") == 0){
            Alkatresz alk = new Alkatresz(jt);
            k.targy_hozzaadasa(alk);
            jt.addAlkatresz(alk);
        }
        else if(cmd[2].compareTo("aso") == 0 ) k.targy_hozzaadasa(new Aso());
        else if(cmd[2].compareTo("buvarruha") == 0) k.targy_hozzaadasa(new Buvarruha());
        else if(cmd[2].compareTo("etel") == 0) k.targy_hozzaadasa(new Etel());
        else if(cmd[2].compareTo("kotel") == 0) k.targy_hozzaadasa(new Kotel());
        else if(cmd[2].equals("lapat")) k.targy_hozzaadasa(new Lapat());
        else if(cmd[2].compareTo("sator") == 0) k.targy_hozzaadasa(new Sator(jt.getPlayers().size()));
        else throw new Exception();

    }

    protected static void addMedve(String[] cmd) { //Szerintem jo
        Jegtabla j = jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
        Jegesmedve jm = new Jegesmedve();
        j.addFigura(jm);
        jm.setJegtabla(j);
        jt.setJegesmedve(jm);
    }

    protected static void medveLep(String[] cmd) throws Exception {//Szerintem jo
        Jegesmedve jm = jt.getJegesmedve();
        Jegmezo jgm = jt.getJegMezo();
        ArrayList<Jegtabla> ja = jm.getJegtabla().getSzomszedok();
        Jegtabla j2 = ja.get(Integer.parseInt(cmd[1]));
        jm.lep(j2);
    }

    protected static void egyHovihar(String[] cmd) {//Jo?
        Jegtabla j = jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
        j.hovihar_volt();
    }

    protected static void hoviharRand() {//Eeeeelvileg jo, de egy jegtablan igy lehet tobb hovihar
        Random r = new Random();
        int mennyi = 1 + r.nextInt(3);
        Jegmezo jm = jt.getJegMezo();
        ArrayList<Jegtabla> ja = jm.getJegtablak();
        for(int i = 0; i<mennyi; i++){
            ja.get(r.nextInt(ja.size())).hovihar_volt();
        }
    }

    protected static void listJegtablaAttrib(String[] cmd) { //Ez jo
        Jegtabla j = jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
        doublePrintln("Pozicio: " + cmd[1] + " " + cmd[2]);
        doublePrintln("Tipus: " +  j.type);
        doublePrintln("Homennyiseg: " + j.getHoMennyiseg());
        doublePrint("Karakterek: ");
        ArrayList<Figura> k = j.getFigurak();
        if(k.size() == 0) doublePrint("null");
        else {
            for (Figura f : k) {
                doublePrint(f.Name + " ");
            }
        }
        doublePrintln("");
        doublePrint("Targy: ");
        if(j.getTargy() == null) doublePrintln("null");
        else System.out.println(j.getTargy().Name);
        doublePrint("Epitmeny: ");
        if(j.getEpitmeny() == null) doublePrintln("null");
        else doublePrintln(j.getEpitmeny().getName());
        if(j.type.compareTo("Instabil") == 0) {
            Instabil jr = (Instabil) jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
            doublePrintln("Kapacitas: " + jr.getKapacitas());
        }

    }

    protected static void listJegmezo() {
        for(Jegtabla j: jt.getJegMezo().getJegtablak()) {
            String[] cmd={"listJegtablaAttrib", String.valueOf(j.getPoz().x), String.valueOf(j.getPoz().y)};
            listJegtablaAttrib(cmd);
        }

    }

    protected static void printPlayersLife(String[] cmd) {
        doublePrintln("Homennyiseg: " + jt.getPlayer(cmd[1]).getKarakter().getHo());

    }

    protected static void digSnow(String[] cmd) throws Exception{ //Ez jó
        Karakter k = jt.getPlayer(cmd[1]).getKarakter();
        if(k.getJegtabla().getHoMennyiseg()!=0){
            k.takarit(1);
        }
        else{
            k.kias();
        }
        munkaVolt(jt.getPlayer(cmd[1]));
    }

    protected static void setSnow(String[] cmd) { //Ez jó
        jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2])).setHo(Integer.parseInt(cmd[3]));
    }

    protected static void listKarAttrib(String[] cmd) {
        Karakter k = jt.getPlayer(cmd[1]).getKarakter();
        Poz p=k.getJegtabla().getPoz();
        doublePrintln("Jatekos: " + cmd[1]);
        doublePrintln("Karakter: " + k.Name);
        doublePrintln("Ho: " + k.getHo());
        String viz= (k.get_vizben_van()) ? "igen" : "nem";
        doublePrintln("Vizben: " + viz);
        doublePrintln("Munkak: " + k.munkak_szama);
        doublePrintln("Jegtabla: " +p.x + " " +p.y );
    }

    protected static void listKarTargy(String[] cmd) {
        Karakter k = jt.getPlayer(cmd[1]).getKarakter();
        int i=0;
        for(Targy t: k.getTargyak()) {
            doublePrintln(i + ": " + t.Name);
            i++;
        }
    }

    protected static void addJegtabla(String[] cmd) {
        if(jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2])) != null)
            ;
        else {
            if(cmd[3].compareTo("stabil") == 0) jt.getJegMezo().addJegtabla(new Stabil(new Poz(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]))));
            if(cmd[3].compareTo("instabil") == 0) jt.getJegMezo().addJegtabla(new Instabil(new Poz(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]))));
            if(cmd[3].compareTo("luk") == 0) jt.getJegMezo().addJegtabla(new Luk(new Poz(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]))));

            Jegtabla jegt = jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));

            if(cmd[4].compareTo("etel") == 0) jegt.setTargy(new Etel());
            if(cmd[4].compareTo("buvarruha") == 0) jegt.setTargy(new Buvarruha());
            if(cmd[4].compareTo("kotel") == 0) jegt.setTargy(new Kotel());
            if(cmd[4].compareTo("sator") == 0) jegt.setTargy(new Sator(jt.getPlayers().size()));
            if(cmd[4].compareTo("lapat") == 0) jegt.setTargy(new Lapat());
            if(cmd[4].compareTo("aso") == 0) jegt.setTargy(new Aso());
            if(cmd[4].compareTo("raketa") == 0) jegt.setTargy(new Alkatresz(jt));

            if(cmd[5].compareTo("iglu") == 0) jegt.epitmenyKeszul(new Iglu());
            if(cmd[5].compareTo("sator") == 0) jegt.epitmenyKeszul(new Sator(jt.getPlayers().size()));
            if(cmd[5].compareTo("null") == 0) ;
        }
    }

    protected static void listJegtablaSzomszed(String[] cmd) {
        if(jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2])) != null) {
            doublePrintln("jegtabla: "+ Integer.parseInt(cmd[1])+ " "+Integer.parseInt(cmd[2]));
            ArrayList<Jegtabla> szom = jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2])).getSzomszedok();
            for(int i = 0; i < szom.size(); i++) {
                doublePrintln(i + ": " + szom.get(i).getPoz().getX() + " " + szom.get(i).getPoz().getY());
            }
        }
    }

    protected static void addJegtablaSzomszed(String[] cmd) {
        jt.getJegMezo().szomszedokkaTesz(jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2])), jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[3]), Integer.parseInt(cmd[4])));
    }

    protected static void setInstabilKap(String[] cmd) {
        jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2])).setKapacitas(Integer.parseInt(cmd[3]));

    }

    protected static void jatekosKorVege(String[] cmd) {
        jt.getPlayers().get(jt.act_index).getKarakter().munkak_szama=0;
    }

    protected static void startGame() {
        doublePrintln("Az elso jatekos neve: " + jt.getFirstPlayer().getName());
        initGame();
    }

    protected static void initGame() {
        jt.game_over = false;
        jt.act_index = 0;
        jt.kor=1;
        inGame=true;
        jt.next_player(jt.getPlayers().get(jt.act_index));
        doublePrintln(jt.kor + ". kor, jatekos: " + jt.getPlayers().get(jt.act_index).getName());
    }

    protected static void inGameRound() {
        jt.game_over=jt.check_game_over();
        if(jt.game_over) {
            inGame=false;
            doublePrintln("Jatek vege");
        }
        if(!jt.game_over) {
            Player current = jt.getPlayers().get(jt.act_index);
            if (!current.getKarakter().van_munkaja()) {
                if (jt.act_index == jt.getPlayers().size() - 1) {
                    jt.act_index = 0;
                    jt.kor++;
                } else jt.act_index++;
                current=jt.getPlayers().get(jt.act_index);
                jt.next_player(current);
                doublePrintln(jt.kor + ". kor, jatekos: " + jt.getPlayers().get(jt.act_index).getName());
                if(current.getKarakter().vizbeKerultKor!=jt.kor&&current.getKarakter().get_vizben_van()) {
                    jt.game_over=true;
                    inGame=false;
                    doublePrintln("Jatek vege");
                }
            }
        }
    }

    protected static void munkaVolt(Player p) {
        doublePrintln(p.getName()+  " munkak szama: " + p.getKarakter().munkak_szama);
    }

    protected static void testAllCases() throws IOException {
            loadTest(new String[]{"loadTest", String.valueOf(++actAllTest)});
            System.out.print(actAllTest + " teszteset: ");
            allCases = true;
            start();
    }

    //----------------------------------------------
    static void doublePrintln(String s) {
        if(!allCases)System.out.println(s);
        if(isTest)writer.println(s);
    }

    static void doublePrint(String s) {
        if(!allCases)System.out.print(s);
        if(isTest)writer.print(s);
    }

    static void calculateTestResult() throws IOException {
        File f = new File(".\\src\\proto\\expectedresults\\" + actTest + ".txt");
        File f2 = new File(".\\src\\proto\\testresult\\" + actTest + ".txt");
        if(!f.exists()){
            System.out.println("Nincsen teszt irva ehhet a tesztesethez");
            return;
        }
        FileReader r2 = new FileReader(f2);
        FileReader r = new FileReader(f);
        BufferedReader br = new BufferedReader(r);
        BufferedReader br2 = new BufferedReader(r2);
        String expectedLine = new String();
        String line = new String();
        int i = 0;
        int c = 0;
        while((expectedLine = br.readLine()) != null & (line = br2.readLine()) != null) {
            if(line.compareTo(expectedLine) == 0) c++;
            i++;
        }
        if(!allCases)System.out.println("----------------------------------------");
        System.out.println("A teszteset helyessege: " + 100*c/i + "%");
        br.close();
        br2.close();
    }
}
