/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import maquina.Maquina;

/**
 *
 * @author 66786575
 */
public class Tablero extends JFrame {

    private static Tablero tablero;
    public ArrayList<Celda> celdas;

    private Tablero() {

        celdas = new ArrayList();
        
        GridLayout grid = new GridLayout(4,4);
        setLayout(grid);
        
        for (int x = 0; x <16; x++){
            
            celdas.add(new Celda(x));
            celdas.get(x).addMouseListener(celdas.get(x));
            add(celdas.get(x));
        }
        
        setLocation(480, 180);
        setSize(400,400);
        setTitle("4EnRalla");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static Tablero getInstance() {
        if (tablero == null) {
            tablero = new Tablero();
        }
        return tablero;
    }
}
