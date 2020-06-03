package ViralDay.Manager;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.FloatControl;

/**
 *
 * Clase SoundClip
 * Contiene funcione para la importacion y uso de efectos de sonido
 * 
 * @author PalaunuGames
 */
public class SoundClip {

    private AudioInputStream sample;
    private Clip clip;
    private boolean looping = false;
    private int repeat = 0;
    private String filename = "";

    /**
     * SoundClip
     * 
     * Constructor default de la clase
     * 
     * @return Null
     */
    public SoundClip() {
        try {

            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {

            System.out.println("Error en " + e.toString());
        }
    }

    /**
     * SoundClip
     * 
     * Constructor con parametro de la clase, carga el archivo que se le pase
     * 
     * @param filename -> path del archivo de sonido a importar (str)
     */
    public SoundClip(String filename) {
        this();
        load(filename);
    }

    /**
     * SetLooping
     * 
     * Pone en loop la pista que lo invoca
     * 
     * @param looping -> representa el estado que se colocara la opcion de loop (boolean)
     */
    public void setLooping(boolean looping) {
        this.looping = looping;
    }

    /**
     * SetRepeat
     * 
     * Repite la pista que lo invoca
     * 
     * @param repeat -> representa el estado que se colocara la opcion de repeat (boolean)
     */
    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    /**
     * SetFileName
     * 
     * Modifica el path del archivo de audio
     * 
     * @param filename -> path del archivo de sonido a importar (str)
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }
//Los métodos de acceso son usados para obtener los valores del objeto SoundClip.

    /**
     * getClip
     * 
     * Retorna el clip asociado al objeto
     * 
     * @return clip -> objeto clip (Clip)
     */
    public Clip getClip() {
        return clip;
    }

    /**
     * getLooping
     * 
     * Retorna si el audio que lo invoca esta en loop
     * 
     * @return looping -> representa el estado en el que esta la opcion de loop (boolean)
     */
    public boolean getLooping() {
        return looping;
    }

    /**
     * getRepeat
     * 
     * Retorna si el audio que lo invoca se repite
     * 
     * @return repeat -> representa el estado en el que esta la opcion de repeat (boolean)
     */
    public int getRepeat() {
        return repeat;
    }

    /**
     * getFilename
     * 
     * retorna el path del archivo de audio
     * 
     * @return filename -> path del archivo de audio (str)
     */
    public String getFilename() {
        return filename;
    }

    /**
     * getURL
     * 
     * genera el path del archivo de audio en formato del objeto URL
     * 
     * @param filename -> path del archivo de audio (str)
     * @return url -> objeto URL que representa un path (URL)
     */
    private URL getURL(String filename) {
        URL url = null;
        try {

            url = this.getClass().getResource(filename);
        } catch (Exception e) {

            System.out.println("Error en " + e.toString());
        }
        return url;
    }

    /**
     * isLoaded
     * 
     * Retorna true si es que el archivo de audio esta cargado
     * 
     * @return true -> si el archivo de audio esta cargado (boolean)
     */
    public boolean isLoaded() {
        return (boolean) (sample != null);
    }

    /**
     * load
     * 
     * Carga el archivo de audio
     * 
     * @param audiofile -> path del archivo de audio (str)
     * @return true -> si se pudo cargar el archivo de audio (boolean)
     */
    public boolean load(String audiofile) {
        try {

            setFilename(audiofile);
            sample = AudioSystem.getAudioInputStream(getURL(filename));
            clip.open(sample);
            return true;
        } catch (IOException e) {

            System.out.println("Error en " + e.toString());
            return false;
        } catch (UnsupportedAudioFileException e) {

            System.out.println("Error en " + e.toString());
            return false;
        } catch (LineUnavailableException e) {

            System.out.println("Error en " + e.toString());
            return false;
        }
    }

    /**
     * play
     * 
     * reproduce el audio del objeto que lo incova
     * 
     * @return Null
     */
    public void play() {
        if (!isLoaded()) {
            return;
        }
        clip.setFramePosition(0);

        if (looping) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } else {
            clip.loop(repeat);
        }
    }

    /**
     * stop
     * 
     * detiene el audio del objeto que lo invoca
     * 
     * @return Null
     */
    public void stop() {
        clip.stop();
    }

    /**
     * setVolume
     * 
     * Modifica el volumen del audio que lo invoca
     * 
     * @param vol -> representa el volumen al que se colocara el sonido (double)
     */
    public void setVolume(double vol) {
        FloatControl gain = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        float dB = (float) (Math.log(vol) / Math.log(10) * 20);
        gain.setValue(dB);
    }
}
