/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author 66786575
 */
public class Tablero extends JFrame {

    private static Tablero tablero;
    public ArrayList<Celda> celdas;
    public ArrayList<Boton> botones;

    private Tablero() {

        celdas = new ArrayList();
        
        GridLayout grid = new GridLayout(7,7);
        setLayout(grid);
        
        for(int x= 0; x < 7; x++){
            
            botones.add(new Boton(x));
            add(botones.get(x));
        }
        
        for (int x = 0; x <42; x++){
            
            celdas.add(new Celda(x));
            add(celdas.get(x));
        }
        
        setLocation(480, 180);
        setSize(400,400);
        setTitle("4EnRaya");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static Tablero getInstance() {
        if (tablero == null) {
            tablero = new Tablero();
        }
        return tablero;
    }
}
