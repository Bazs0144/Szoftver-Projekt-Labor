package proto;

public class Commands {

    protected static void help(){
        System.out.println("Reszletes leiras a parancsokra a 7. reszletes tervek dokumentacioban talalhato.\n");

        System.out.println("exit: Leallitja a program futasat.");
        System.out.println("loadMap <filename>: Betolti a tesztesetet a fajlbol.");
        System.out.println("saveTest <filename>: a teszt kimenetet a megadott fajlba menti.");
        System.out.println("start: elinditja a betoltott tesztesetet.");
        System.out.println("saveMap <filename>: Elmenti a jegmezo allapotat egy fajlba");
        System.out.println("generateMap <width><height><rand>: General egy jegmezot a megadott szelesseggel es magassaggal, " +
                "és rand opciotol fuggoen hogy kitolti-e objektumokkal a jegmezot. ");
        System.out.println("changeJegtabla <pozX><pozY><Type>: Atalakitja az egyik mar letezo jegtablat masik tipussa az adott pozicioban.");
        System.out.println("addTargy <pozX><pozY><Type> Beallitja az adott pzicioban levo jegtablan levo targyat az adott tipussal");
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
        System.out.println("listJegmezo: kiirja mindegyik jégtablan mely karakterek allnak, mennyi rajtuk a homennyiseg," +
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

    protected static void saveMap() {

    }

    protected static void loadMap() {

    }

    protected  static void loadTest() {

    }

    protected static void saveTest() {

    }

    protected static  void start() {

    }

    protected static void generateMap() {

    }

    protected static void changeJegtabla() {

    }
    protected static void addTargy() {

    }

    protected static void addPlayer() {

    }

    protected static void playerLep() {

    }

    protected static void iglutEpit() {

    }
    protected static void kutatoVizsgal() {

    }

    protected static void targyatHasznal() {

    }

    protected static void targyFelvetel() {

    }

    protected static void targyHozzadasa() {

    }

    protected static void addMedve() {

    }

    protected static void medveLep() {

    }

    protected static void egyHovihar() {

    }

    protected static void hoviharRand() {

    }

    protected static void listKarakterTargyak() {

    }

    protected static void listJegtablaAttrib() {

    }

    protected static void listJegmezo() {

    }

    protected static void printPlayersLife() {

    }

    protected static void digSnow() {

    }

    protected static void setSnow() {

    }

    protected static void listKarAttrib() {

    }

    protected static void listKarTargy() {

    }

    protected static void addJegtabla() {

    }

    protected static void listJegtablaSzomszed() {

    }

    protected static void addJegtablaSzomszed() {

    }

    protected static void setInstabilKap() {

    }

    protected static void jatekosKorVege() {

    }

    protected static void startGame() {

    }
}
