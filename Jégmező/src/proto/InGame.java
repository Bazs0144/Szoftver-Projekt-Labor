package proto;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class InGame extends JPanel {
    ArrayList<JPanel> fields = new ArrayList<>(); //Ezek tartalmazzák a jégmezőket

    public InGame() {
        this.setPreferredSize(new Dimension(730, 700));
        this.setBackground(new Color(189, 216, 235));
        this.setLayout(new BorderLayout());

        Statusbar p = new Statusbar();// a harom adat es a ket gomb
        this.add(p, BorderLayout.NORTH);

        for(int i = 0; i < fields.size(); i++){
            fields.get(i).add(new JPanel());// itt iniciakizálódnak
        }

        gameView();
    }

    void gameView() {//tartalmazza a jegmezoket
        JPanel p2 = new JPanel();
        p2.setLayout(new BorderLayout());
        p2.setBackground(new Color(189, 216, 235));

        JPanel area1 = new JPanel();//helytolto
        area1.setPreferredSize(new Dimension(80, 570));
        area1.setBackground(new Color(189, 216, 235));
        p2.add(area1, BorderLayout.WEST);

        JPanel area2 = new JPanel();//helytolto
        area2.setPreferredSize(new Dimension(100, 570));
        area2.setBackground(new Color(189, 216, 235));
        p2.add(area2, BorderLayout.EAST);

        JPanel gameArea = new JPanel();//igazittas, ebben vannak a jegmezok
        gameArea.setLayout(new BoxLayout(gameArea, BoxLayout.Y_AXIS));
        gameArea.setBackground(new Color(189, 216, 235));
        p2.add(gameArea, BorderLayout.CENTER);



        JPanel first = new JPanel();//1.sor
        first.setBackground(new Color(189, 216, 235));
        first.setLayout(new GridLayout());
        gameArea.add(first);

        JPanel second = new JPanel();//2.sor
        second.setLayout(new GridLayout());
        second.setBackground(new Color(189, 216, 235));
        gameArea.add(second);

        JPanel third = new JPanel();//3.sor
        third.setLayout(new GridLayout());
        third.setBackground(new Color(189, 216, 235));
        gameArea.add(third);

        JPanel fourth = new JPanel();//4.sor
        fourth.setLayout(new GridLayout());
        fourth.setBackground(new Color(189, 216, 235));
        gameArea.add(fourth);

        ArrayList<JPanel> fieldcontainers = new ArrayList<>();//4 eleme az 1. sornak, azonban ez meg nem kocka alakú
        for (int i = 0; i < 4; i++) {
            JPanel j = new JPanel();
            j.setBackground(new Color(189, 216, 235));
            fieldcontainers.add(j);
            first.add(j);
        }

        for (int i = 0; i < 4; i++) { //4 eleme az 2. sornak, azonban ez meg nem kocka alakú
            JPanel j = new JPanel();
            j.setBackground(new Color(189, 216, 235));
            fieldcontainers.add(j);
            second.add(j);
        }

        for (int i = 0; i < 4; i++) { //4 eleme az 3. sornak, azonban ez meg nem kocka alakú
            JPanel j = new JPanel();
            j.setBackground(new Color(189, 216, 235));
            fieldcontainers.add(j);
            third.add(j);
        }

        for (int i = 0; i < 4; i++) { //4 eleme az 4. sornak, azonban ez meg nem kocka alakú
            JPanel j = new JPanel();
            j.setBackground(new Color(189, 216, 235));
            fieldcontainers.add(j);
            fourth.add(j);
        }


        for(int i = 0; i < fieldcontainers.size(); i++) {// na ez már kocka, ezeknek kell tartalmaznia a jégtáblákat
                JPanel j = new JPanel();
                j.setPreferredSize(new Dimension(110, 110));
                fieldcontainers.get(i).setLayout(new GridBagLayout());
                j.setBackground(Color.blue);
                fields.add(j);
                fieldcontainers.get(i).add(j, new GridBagConstraints());
        }

        this.add(p2, BorderLayout.CENTER);
    }
}


