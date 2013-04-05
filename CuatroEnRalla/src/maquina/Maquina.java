/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maquina;

import componentes.Boton;
import componentes.Celda;
import componentes.Tablero;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Juan
 */
public class Maquina {

    private static Tablero tablero = Tablero.getInstance();
    private static ArrayList<Integer> puntuacionesJugada;
    private static ArrayList<Celda> celdas;
    private static ArrayList<Boton> botones;
    private static int puntuacionParcialJugada, puntuacionTotalJugada, puntuacionMejorJugada, mejorJugada;

    public static void ejecutarMovimiento() {

        celdas = tablero.celdas;
        botones = tablero.botones;
        //puntuacionesJugada = new ArrayList();
        //puntuacionMejorJugada = -11;
        //mejorJugada = -1;

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
        
        //Generador de jugada en posición aleatoria
        int x = 0;
        Random randomGenerator = new Random();
        int maxLibre = -1;
        int ultimaCasilla = -1;
        int columnaRandom;
        ArrayList<Celda> celdas_columna = new ArrayList();

        do {
            columnaRandom = randomGenerator.nextInt(7);
        } while (!botones.get(columnaRandom).isEnabled());

        for (Celda c : celdas) {

            if (c.columna == columnaRandom) {
                celdas_columna.add(c);
            }
        }
        for (Celda c : celdas_columna) {

            if (c.ocupadaPor() == 0) {
                ultimaCasilla++;
                maxLibre = x;
            }
            x++;
        }
        if (maxLibre != -1) {
            celdas_columna.get(maxLibre).setOcupada(1);
            celdas_columna.get(maxLibre).dibujar();
        }
        if (ultimaCasilla == 0) {
            botones.get(columnaRandom).setEnabled(false);
        }
        /*for (Celda c : celdas) {
         if (c.ocupadaPor() == 0 && !ok) {
         c.setOcupada(1);
         c.dibujar();
         ok = true;
                
         if (x < 7) {
         //botones.get(x % (6 + 1)).setEnabled(false);
         }
         }
         x++;
         }*/

    }
}
