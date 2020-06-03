package ViralDay.Manager;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * Clase Display
 * Genera la ventana para el juego
 * 
 * @author PalaunuGames
 */
public class Display {

    private JFrame jframe;  // this is the app class
    private Canvas canvas;  // to display images

    private String title;   // title of the window
    private int width;      // width of the window
    private int height;     // height of the window

    /**
     * Display
     * 
     * inicializa los valores para la applicacion juego
     *
     * @param title para seleccionar el titulo de la ventana
     * @param width la anchura de la ventana
     * @param height la altura de la ventana
     */
    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        createDisplay();
    }

    /**
     * 
     * createDisplay
     * 
     * genera la ventana y el canvas
     * 
     * @param Null
     * @return Null
     */
    public void createDisplay() {
        // create the app window
        jframe = new JFrame(title);

        // set the size of the window
        jframe.setSize(width, height);

        // setting not resizable, visible and possible to close
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);

        // creating the canvas to paint and setting size
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setFocusable(false);

        // adding the canvas to the app window and packing to
        // get the right dimensions
        jframe.add(canvas);
        jframe.pack();
    }

    /**
     * 
     * getJframe
     * 
     * retorna el objeto Jframe de la ventana
     *
     * @param Null
     * @return jframe -> objeto Jframe de la ventana (JFrame)
     */
    public JFrame getJframe() {
        return jframe;
    }

    /**
     * 
     * getCanvas
     * 
     * retorna el canvas de la ventana
     *
     * @param Null
     * @return canvas -> objeto Canvas de la ventana (Canvas)
     */
    public Canvas getCanvas() {
        return canvas;
    }
}