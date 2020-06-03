package ViralDay.Manager;

/**
 *
 * Clase VideoGame
 * Genera la aplicacion del juego
 * 
 * @author PalaunuGames
 */
public class VideoGame {

    /**
     * main
     * 
     * main del que se empieza a generar todo el juego
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Game g = new Game("Juego", 1024, 600);
        g.start();
    }
    
}
