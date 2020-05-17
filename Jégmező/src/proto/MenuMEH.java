package proto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Scanner;

public class MenuMEH implements MouseListener{

	public static class OkButtonActionListener1 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
		/*	JFrame settings = new JFrame();
			settings.setVisible(true);
			settings.setTitle("New Game Settings");
			settings.setSize(800, 800); */
		MainFrame.Instance.changeState(State.NewGameS);

		}
	}

	public static class OkButtonActionListener2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Jatektabla JT = new Jatektabla();
			Scanner scanner;
			try{
				scanner = new Scanner(new File("IceFiled.txt"));

			} catch (Exception exception) {
				exception.printStackTrace();
				System.out.println("Hiba!! Nem talalja a file-t ");
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) { //onClick függvény
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	


}
