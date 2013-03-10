/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author 66786575
 */
public class Celda extends JPanel implements MouseListener{
    
    private int ocupada;
    public int fila;
    public int columna;
    
    public Celda(int num){
        
        fila = num/4;
        columna = num%4;
        ocupada = 0;
        setBackground(Color.white);
        setBorder(BorderFactory.createBevelBorder(0, Color.BLACK, Color.BLACK));
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
    public void setOcupada(int ocupada) {
        
        if(ocupada==0){
            this.ocupada = ocupada;
        }
        else{
            System.out.println("intento ocupar casilla ya ocupada");
        }
    }

    @Override
    public void mouseClicked(MouseEvent me){
            
        if(ocupada==0){
            ocupada=1;
            System.out.println("Ocupo la casilla: " + fila + " " +columna);
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
