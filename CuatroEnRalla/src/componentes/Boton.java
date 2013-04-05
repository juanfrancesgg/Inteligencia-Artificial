/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import maquina.Maquina;

/**
 *
 * @author 66786575
 */
public class Boton extends JButton implements ActionListener {

    private int columna;
    private ArrayList<Celda> celdas_columna;
    public File fich;
    public BufferedImage imagen;
    private ImageIcon icono;

    public Boton(int _columna, ArrayList<Celda> celdas) {

        columna = _columna;
        System.out.println("" + columna);
        celdas_columna = new ArrayList();
        fich = new File("src/componentes/icons/flecha.jpg");

        for (Celda c : celdas) {

            if (c.columna == columna) {
                celdas_columna.add(c);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Ya se que es una chapuza que esto este aqui
        //Estaba intentando que la imagen se reescalara
        //Al modificar el tamaño de la ventana pero no lo consigo
        try {

            imagen = ImageIO.read(fich);
            icono = new ImageIcon(imagen);


        } catch (IOException ex) {
            System.out.println(ex + " Error al cargar imagen");
        }
        setIcon(icono);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int x = 0;
        int maxLibre = -1;
        int ultimaCasilla = -1;
        for (Celda c : celdas_columna) {

            if (c.ocupadaPor() == 0) {
                ultimaCasilla++;
                maxLibre = x;
            }
            x++;
        }
        celdas_columna.get(maxLibre).setOcupada(-1);
        celdas_columna.get(maxLibre).dibujar();

        if (ultimaCasilla == 0) {
            setEnabled(false);
        }
        Maquina.ejecutarMovimiento();
    }
}
