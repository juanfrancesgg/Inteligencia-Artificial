/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maquina;

import componentes.Celda;
import componentes.Tablero;
import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public class Maquina {

    private static Tablero tablero = Tablero.getInstance();
    private static ArrayList<Integer> puntuacionesJugada;
    private static ArrayList<Celda> celdas;
    private static int puntuacionParcialJugada, puntuacionTotalJugada, puntuacionMejorJugada, mejorJugada;

    public static void ejecutarMovimiento() {

        System.out.println("me toca!");
        celdas = tablero.celdas;
        puntuacionesJugada = new ArrayList();
        puntuacionMejorJugada = -11;
        mejorJugada = -1;
        /*
        for (int x = 0; x < 10; x++) {

            puntuacionesJugada.add(new Integer(0));
        }
        
        for (Celda c : celdas) {

            if (c.ocupadaPor() == 0) {

                c.setOcupada(1);

                for (int x = 0; x < 10; x++) {

                    puntuacionesJugada.set(x, 0);
                }

                for (Celda s1 : celdas) {

                    puntuacionParcialJugada = s1.ocupadaPor();

                }

                c.setOcupada(0);
            }
        }
        */
        boolean ok = false;
        for (Celda c : celdas) {
            if (c.ocupadaPor() == 0 && ok == false) {
                c.setOcupada(1);
                c.dibujar();
                ok = true;
            }
        }

    }
}
