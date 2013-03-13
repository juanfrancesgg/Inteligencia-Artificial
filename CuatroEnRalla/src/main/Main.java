/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import componentes.Tablero;
import javax.swing.SwingUtilities;

/**
 *
 * @author 66786575
 */
public class Main {

    private static Tablero tablero;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                tablero = Tablero.getInstance();
                tablero.setVisible(true);
            }
        });
    }
}

