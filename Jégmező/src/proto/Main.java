package proto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SyncFailedException;
import java.util.ArrayList;

public class Main extends Commands{
	static boolean isOver = false;

	public static void main(String[] args) throws IOException {
		commandBuffer = new ArrayList<String>();
		reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		System.out.println("Udvozlom a prototipusban\n" +
				" A lehetseges parancsok listajahoz irja be a help parancsot.\n");
		while (!isOver) {
			if(!isTest)System.out.print("command: ");
			siker = true;
			line = reader.readLine();
			if(line == null && isTest) {
				isTest = false;
				reader.close();
				reader = new BufferedReader(new InputStreamReader(System.in));
				line = "";

			}
			if(line.compareTo("") != 0 && !line.contains("saveTest")) commandBuffer.add(line);
			String[] cmd = line.split(" ");
			try {
				if (cmd[0].equals("exit")) isOver = true;
				else if (cmd[0].equals("help")) help();
				else if (cmd[0].equals("loadMap")) loadMap(cmd);
				else if (cmd[0].equals("loadTest")) loadTest(cmd);
				else if (cmd[0].equals("saveTest")) saveTest(cmd);
				else if (cmd[0].equals("start")) start();
				else if (cmd[0].equals("saveMap")) saveMap(cmd);
				else if (cmd[0].equals("generateMap")) generateMap(cmd);
				else if (cmd[0].equals("changeJegtabla")) changeJegtabla(cmd);
				else if (cmd[0].equals("addTargy")) addTargy(cmd);
				else if (cmd[0].equals("addPlayer")) addPlayer(cmd);
				else if (cmd[0].equals("playerLep")) playerLep(cmd);
				else if (cmd[0].equals("iglutEpit")) iglutEpit(cmd);
				else if (cmd[0].equals("kutatoVizsgal")) kutatoVizsgal(cmd);
				else if (cmd[0].equals("targyatHasznal")) targyatHasznal(cmd);
				else if (cmd[0].equals("targyFelvetel")) targyFelvetel(cmd);
				else if (cmd[0].equals("targyHozzaadasa")) targyHozzadasa(cmd);
				else if (cmd[0].equals("addMedve")) addMedve(cmd);
				else if (cmd[0].equals("medveLep")) medveLep(cmd);
				else if (cmd[0].equals("egyHovihar")) egyHovihar(cmd);
				else if (cmd[0].equals("hoviharRand")) hoviharRand();
				else if (cmd[0].equals("listJegtablaAttrib")) listJegtablaAttrib(cmd);
				else if (cmd[0].equals("listJegmezo")) listJegmezo();
				else if (cmd[0].equals("printPlayersLife")) printPlayersLife(cmd);
				else if (cmd[0].equals("digSnow")) digSnow(cmd);
				else if (cmd[0].equals("setSnow")) setSnow(cmd);
				else if (cmd[0].equals("listKarAttrib")) listKarAttrib(cmd);
				else if (cmd[0].equals("listKarTargy")) listKarTargy(cmd);
				else if (cmd[0].equals("addJegtabla")) addJegtabla(cmd);
				else if (cmd[0].equals("listJegtablaSzomszed")) listJegtablaSzomszed(cmd);
				else if (cmd[0].equals("addJegtablaSzomszed")) addJegtablaSzomszed(cmd);
				else if (cmd[0].equals("setInstabilKap")) setInstabilKap(cmd);
				else if (cmd[0].equals("jatekosKorVege")) jatekosKorVege(cmd);
				else if (cmd[0].equals("jatekosKorVege")) jatekosKorVege(cmd);
				else if (cmd[0].equals("")) siker = false;
				else {System.out.println("Ilyen parancs nem letezik :("); siker=false;}
				if(siker) System.out.println(cmd[0] + " sikeresen lefutott");
			} catch(Exception e) {
				System.out.println(cmd[0] + " nem sikerult");
			}


		}
	}
}