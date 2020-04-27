package proto;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Commands {

    static protected Jatektabla jt;
    static protected BufferedReader reader;
    static protected FileReader fr;
    static protected boolean siker;
    static boolean isTest = false;
    static ArrayList<String> commandBuffer;

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
        System.out.println("setInstabilKap <pozX><pozY><size>: Beallitja a jegtabla kapacitasat.");
        System.out.println("JatekosKorVege <name>: Befejezi a jatekos koret.");
        System.out.println("startGame: Elkezdi a jetekot.");
    }


    protected static void saveMap(String[] cmd) throws IOException { //Remelhetoleg jó
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

    protected static void loadMap(String[] cmd) throws IOException, ClassNotFoundException { //Remelhetoleg jo

        String wd = System.getProperty("user.dir");
        File f = new File(wd, cmd[1] + ".dat");
        if (cmd.length > 1) {
            if (f.exists()) {

                FileInputStream fs = new FileInputStream(f);
                ObjectInputStream in = new ObjectInputStream(fs);
                jt = (Jatektabla) in.readObject();
                in.close();

            } else {System.out.println("loadMap nem sikerult"); siker = false;};
        } else {System.out.println("loadMap nem sikerult"); siker = false;};
    }

    protected  static void loadTest(String[] cmd) throws FileNotFoundException {
        File f = new File(".\\src\\proto\\testcases\\" + cmd[1] + ".txt");
        if (!f.exists()) {
            System.out.println("loadTest nem sikerult");
            siker = false;
            return;
        }
        fr = new FileReader(f);
    }


    protected static void saveTest(String[] cmd) throws IOException {
        FileWriter fw = new FileWriter(cmd[1] + ".txt");
        PrintWriter pw = new PrintWriter(fw);
        for(String command: commandBuffer){
            pw.println(command);
        }
        pw.close();
    }

    protected static  void start() throws IOException {

        reader = new BufferedReader(fr);
        isTest = true;
        if (reader.readLine().compareTo("90kjk12") != 0) {
            System.out.println("start nem sikerult");
            siker = false;
            return;
        }

    }

    protected static void generateMap(String[] cmd) { //Ez jo
        if (Integer.parseInt(cmd[1]) < 0 || Integer.parseInt(cmd[2]) < 0) {
            System.out.println("generateMap nem sikerult");
            siker = false;
            return;
        }
        jt = new Jatektabla(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]), new ArrayList<Player>());
    }

       protected static void changeJegtabla(String[] cmd) throws Exception{
        Jegtabla j = jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
        if(j == null) throw new Exception();
        ArrayList<Jegtabla> jegT = jt.getJegMezo().getJegtablak();
        jegT.remove(Integer.parseInt(cmd[1]) * jt.getJegMezo().getwidth()  + Integer.parseInt(cmd[2]));
        Poz poz =  new Poz(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
        if(cmd[3].compareTo("luk") == 0 ) {
        	Luk luk = new Luk(poz);
        	jt.getJegMezo().addJegtabla(luk);
        }
        else  if(cmd[3].compareTo("instabil") == 0 ) {
            Instabil in = new Instabil(poz);
            jt.getJegMezo().addJegtabla(in);
            }
        else  if(cmd[3].compareTo("stabil") == 0 ) {
            Stabil st = new Stabil(poz);
            jt.getJegMezo().addJegtabla(st);
            }
        else throw new Exception();
    }
    
    protected static void addTargy(String[] cmd)throws Exception {
        Jegtabla j = jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
        if(j == null) throw new Exception();
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
        else throw new Exception();
    	
    }

    protected static void addPlayer(String[] cmd)throws Exception { //Ez jo
        Karakter k;
        if(cmd[4].compareTo("eszkimo") == 0) k = new Eszkimo();
        else if(cmd[4].compareTo("sarkkutato") == 0) k = new Sarkkutato();
        else throw new Exception();
        Player p = new Player(k, cmd[1]);
        Jegtabla j = jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[2]), Integer.parseInt(cmd[3]));
        if(j == null) throw new Exception();
        jt.addPlayer(p);
        j.addPlayer(p);
        p.getKarakter().setJegtabla(j);

    }

    protected static void playerLep(String[] cmd) throws Exception {
            Player p = jt.getPlayer(cmd[1]);
            if(p == null) throw new Exception();
            Jegtabla j2 = jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[2]), Integer.parseInt(cmd[3]));
            if( j2 == null) throw new Exception();
            Jegtabla j = p.getKarakter().jegtabla;
            if(j.szomszed_e(j2))
            {
            	 p.getKarakter().lep(j2);
            }
            else throw new Exception();
    }

    protected static void iglutEpit(String[] cmd)throws Exception {
        Eszkimo k =(Eszkimo) jt.getPlayer(cmd[1]).getKarakter();
        if(k.Name.compareTo("Eszkimo") == 0) {
            k.iglut_epit();
        }
        else throw new Exception(); 

    }
    protected static void kutatoVizsgal(String[] cmd)throws Exception { 
        Sarkkutato k =(Sarkkutato) jt.getPlayer(cmd[1]).getKarakter();
        if(k.Name.compareTo("Sarkkutato") == 0) {
            int kapacitas = k.megnez(jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[2]), Integer.parseInt(cmd[3])));
            if(kapacitas < 0) throw new Exception(); 
            System.out.println("A vizsgált jégtábla kapacitása: " + kapacitas);
        }
        else throw new Exception(); 
    }

    protected static void targyatHasznal(String[] cmd)throws Exception {
    	Player p = jt.getPlayer(cmd[1]);
        if(p == null) throw new Exception();
        Jegtabla j = jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[2]), Integer.parseInt(cmd[3]));
        if(j == null) throw new Exception();
        ArrayList<Targy> zseb = p.getKarakter().getTargyak();
        Targy T = zseb.get(Integer.parseInt(cmd[4]));
        if(T == null) throw new Exception();
        T.hasznaljak(p.getKarakter(), j);
    }
    
    protected static void targyFelvetel(String[] cmd) throws Exception {//Szerintem jo
        Karakter k = jt.getPlayer(cmd[1]).getKarakter();
        Jegtabla j = jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[2]), Integer.parseInt(cmd[3]));
        if(j.elvesz(k, j.getTargy())==false){
            throw new Exception();
        }
    }

    protected static void targyHozzadasa(String[] cmd) {//Szerintem jo
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
        else if(cmd[2].compareTo("sator") == 0) k.targy_hozzaadasa(new Sator());

    }

    protected static void addMedve(String[] cmd) { //Szerintem jo
        Jegtabla j = jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
        Jegesmedve jm = new Jegesmedve();
        j.addFigura(jm);
        jt.setJegesmedve(jm);
    }

    protected static void medveLep(String[] cmd) {//Szerintem jo
        Jegesmedve jm = jt.getJegesmedve();
        Jegmezo jgm = jt.getJegMezo();
        ArrayList<Jegtabla> ja = jm.getJegtabla().getSzomszedok();
        Jegtabla j2 = ja.get(Integer.parseInt(cmd[2]));
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
    		if(cmd[4].compareTo("sator") == 0) jegt.setTargy(new Sator());
    		if(cmd[4].compareTo("lapat") == 0) jegt.setTargy(new Lapat());
    		if(cmd[4].compareTo("aso") == 0) jegt.setTargy(new Aso());
    		if(cmd[4].compareTo("raketa") == 0) jegt.setTargy(new Alkatresz(jt));
    		
    		if(cmd[5].compareTo("iglu") == 0) jegt.epitmenyKeszul(new Iglu());
    		if(cmd[5].compareTo("sator") == 0) jegt.epitmenyKeszul(new Sator());
    		if(cmd[5].compareTo("null") == 0) ;
    	}
    }

    protected static void listJegtablaSzomszed(String[] cmd) {
    	if(jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2])) != null) {
    		ArrayList<Jegtabla> szom = jt.getJegMezo().getJegtabla(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2])).getSzomszedok();
    		for(int i = 0; i < szom.size(); i++) {
    			System.out.println(i + ". szomszéd, koordináták: (" + szom.get(i).getPoz().getX() + "; " + szom.get(i).getPoz().getY() + ")");
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
    	if(jt.getPlayer(cmd[1]) != null)
    		jt.getPlayer(cmd[1]).kor_vegzes();
    }

    protected static void startGame(String[] cmd) {
    	System.out.println("Az elsõ játékos neve: " + jt.getFirstPlayer().getName());
    	jt.init();
    }

    //----------------------------------------------
}