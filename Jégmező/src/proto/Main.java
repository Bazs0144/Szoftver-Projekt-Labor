package proto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SyncFailedException;

public class Main extends Commands{
	static boolean isOver = false;

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		System.out.println("Udvozlom a prototipusban\n" +
				" A lehetseges parancsok listajahoz irja be a help parancsot.\n");
		while (!isOver) {
			System.out.print("command: ");
			line = reader.readLine();
			String[] cmd = line.split(" ");
			if (cmd[0].equals("exit")) isOver = true;
			else if (cmd[0].equals("help")) help();
			else if (cmd[0].equals("loadMap")) loadMap();
			else if (cmd[0].equals("loadTest")) loadTest();
			else if (cmd[0].equals("saveTest")) saveTest();
			else if (cmd[0].equals("start")) start();
			else if (cmd[0].equals("saveMap")) saveMap();
			else if (cmd[0].equals("generateMap")) generateMap();
			else if (cmd[0].equals("changeJegtabla")) changeJegtabla();
			else if (cmd[0].equals("addTargy")) addTargy();
			else if (cmd[0].equals("addPlayer")) addPlayer();
			else if (cmd[0].equals("playerLep")) playerLep();
			else if (cmd[0].equals("iglutEpit")) iglutEpit();
			else if (cmd[0].equals("kutatoVizsgal")) kutatoVizsgal();
			else if (cmd[0].equals("targyatHasznal")) targyatHasznal();
			else if (cmd[0].equals("targyFelvetel")) targyFelvetel();
			else if (cmd[0].equals("targyHozzaadasa")) targyHozzadasa();
			else if (cmd[0].equals("addMedve")) addMedve();
			else if (cmd[0].equals("medveLep")) medveLep();
			else if (cmd[0].equals("egyHovihar")) egyHovihar();
			else if (cmd[0].equals("hoviharRand")) hoviharRand();
			else if (cmd[0].equals("listKarakterTargyak")) listKarakterTargyak();
			else if (cmd[0].equals("listJegtablaAttrib")) listJegtablaAttrib();
			else if (cmd[0].equals("listJegmezo")) listJegmezo();
			else if (cmd[0].equals("printPlayersLife")) printPlayersLife();
			else if (cmd[0].equals("digSnow")) digSnow();
			else if (cmd[0].equals("setSnow")) setSnow();
			else if (cmd[0].equals("listKarAttrib")) listKarAttrib();
			else if (cmd[0].equals("listKarTargy")) listKarTargy();
			else if (cmd[0].equals("addJegtabla")) addJegtabla();
			else if (cmd[0].equals("listJegtablaSzomszed")) listJegtablaSzomszed();
			else if (cmd[0].equals("addJegtablaSzomszed")) addJegtablaSzomszed();
			else if (cmd[0].equals("setInstabilKap")) setInstabilKap();
			else if (cmd[0].equals("jatekosKorVege")) jatekosKorVege();
			else if (cmd[0].equals("startGame")) startGame();


			else System.out.println("Ilyen parancs nem letezik :(");
		}
	}
}
