/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import maquina.Maquina;

/**
 *
 * @author 66786575
 */
public class Celda extends JPanel implements MouseListener {

    private int ocupada;
    public int fila;
    public int columna;

    public Celda(int num) {

        fila = num / 4;
        columna = num % 4;
        ocupada = 0;
        setBackground(Color.white);
        setBorder(BorderFactory.createBevelBorder(0, Color.BLACK, Color.BLACK));
    }

    public void dibujar() {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Dimension d = getSize();
        g2d.setStroke(new BasicStroke(3));

        if (ocupada == -1) {

            g2d.setColor(Color.RED);
            g2d.drawLine((int) d.getWidth() / 10, (int) d.getHeight() / 10, ((int) d.getWidth() - (int) d.getWidth() / 10), ((int) d.getHeight() - (int) d.getHeight() / 10));
            g2d.drawLine((int) d.getWidth() / 10, ((int) d.getHeight() - (int) d.getHeight() / 10), ((int) d.getWidth() - (int) d.getWidth() / 10), (int) d.getHeight() / 10);
        }

        if (ocupada == 1) {

            g2d.setColor(Color.BLUE);
            g2d.drawOval((int) d.getWidth() / 20, (int) d.getHeight() / 20, ((int) d.getWidth() - (int) d.getWidth() / 10), ((int) d.getHeight() - (int) d.getHeight() / 10));
        }
        g2d.setStroke(new BasicStroke(1));
    }

    /**
     * @return the ocupada
     */
    public int ocupadaPor() {
        return ocupada;
    }

    /**
     * @param ocupada the ocupada to set
     */
    public void setOcupada(int _ocupada) {
        ocupada = _ocupada;
    }

    @Override
    public void mouseClicked(MouseEvent me) {

        if (ocupada == 0) {
            ocupada = -1;
            System.out.println("Ocupo la casilla: " + fila + " " + columna);
            dibujar();
            Maquina.ejecutarMovimiento();
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
}
