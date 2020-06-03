package ViralDay.Manager;

import ViralDay.States.GameState;
import ViralDay.Entity.Enemy;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.util.LinkedList;

/**
 *
 * Clase ReadWrite
 * Manejador de lectura/escritura de archivos
 * 
 * @author PalaunuGames
 */
public class ReadWrite {
    
    GameState lvl;
    private int vidas, score, level;
    private int enemyX, enemyY, enemyColor;
    private int tmX, tmY;
    private int virusX, virusY;
    
    /**
     * 
     * ReadWrite
     * 
     * Constructor de la clase
     * 
     * @param lvl -> nivel actual (GameState)
     */
    public ReadWrite(GameState lvl){
        this.lvl = lvl;
    }
    
    /**
     * 
     * Save
     * 
     * Guarda los datos relevantes de la partida en un archivo
     * 
     * @param strFileName -> nombre del archivo de guardado (str)
     */
    public void Save(String strFileName){
        try{
            System.out.println("Saving...");
            PrintWriter writer = new PrintWriter(new FileWriter(strFileName));
            
            //vidas = lvl.getLives();
            //score = lvl.getScore();
            level = lvl.getTileMap().getCurrLvlState();
            tmX = lvl.getTileMap().getX();
            tmY = lvl.getTileMap().getX();
            writer.println(level);
            writer.println(vidas + "/" + score);
            writer.println(tmX + "/" + tmY);
            
            LinkedList<Enemy> enemies = lvl.getTileMap().getEnemies();
            for(int i=0; i<enemies.size(); i++){
                enemyX = enemies.get(i).getX();
                enemyY = enemies.get(i).getY();
                enemyColor = enemies.get(i).getColor();
                writer.println(enemyX + "/" + enemyY + "/" + enemyColor);
            }
            writer.println("eof");
            /*
            LinkedList<Virus> viruses = lvl.getTileMap().getViruses();
            for(int i=0; i<viruses.size(); i++){
                virusX = viruses.get(i).getX();
                virusY = viruses.get(i).getY();
                writer.println("" + virusX + "/" + virusY);
            }
            writer.println("eof");*/
            writer.close();
        }
        catch(IOException ioe){
            System.out.println("File Not fund Call 911");
        }
    }
    
    /**
     * 
     * Load
     * 
     * Carga los datos relevantes de la partida de un archivo
     * 
     * @param strFileName -> nombre del archivo de guardado (str)
     */
    public void Load(String strFileName){
        try{
            System.out.println("Loading...");
            BufferedReader reader = new BufferedReader(new FileReader(strFileName));
            String line;
            String datos[];
            line = reader.readLine(); 
            lvl.getGSM().setState(Integer.parseInt(line));
            lvl = lvl.Load();
            
            line = reader.readLine();
            //datos = line.split("/");
            //game.setLives(Integer.parseInt(datos[0]));
            //game.setScore(Integer.parseInt(datos[1]));
            line = reader.readLine();
            datos = line.split("/");
            lvl.getTileMap().setX(Integer.parseInt(datos[0]));
            //lvl.getTileMap().setY(Integer.parseInt(datos[1]));
            
            LinkedList<Enemy> enemies = lvl.getTileMap().getEnemies();
            for(int i=0; i<enemies.size(); i++){
                line = reader.readLine();
                datos = line.split("/");
                enemies.get(i).setX(Integer.parseInt(datos[0]));
                enemies.get(i).setY(Integer.parseInt(datos[1]));
                enemies.get(i).setColor(Integer.parseInt(datos[2]));
            }
            reader.close();
        }
        catch(IOException e){
            System.out.println("File Not fund Call 911");
        }
    }
    
    /**
     * 
     * tileRead
     * 
     * genera una matriz representando el mapa para generar todos los objetos por nivel
     * 
     * @param strFileName -> nombre del archivo de nivel (str)
     * @return mat -> matriz de enteros representando el mapa de genracion de Tilemap (int [][])
     */
    public int[][] tileRead(String strFileName){
        int[][] mat;
        mat = new int[10][128];
        
        for(int x = 0; x < 10; x++){
            for(int y = 0; y < 128; y++){
                mat[x][y] = 0;
            }
        }
        
        try{
            System.out.println("Loading TileMap...");
            FileReader file = new FileReader(strFileName);
            BufferedReader reader = new BufferedReader(file);
            String line;
            String datos[];
            for(int i = 0; i < 10; i++){
                line = reader.readLine();
                datos = line.split("/");
                for(int j = 0; j < 128; j++){
                    mat[i][j] = Integer.parseInt(datos[j]);
                    System.out.print(mat[i][j]);
                }
                System.out.println("");
            }
            reader.close();
        }
        catch(IOException e){
            System.out.println("File Not fund Call 911");
        }
        
        return mat;
    }
    
    /**
     * tick
     * 
     * tickeo del objeto
     * 
     * @param Null
     * @return Null
     */
    public void tick(){
        /*
        if(game.getKeyManager().g){
            Save("saves.txt");
        }
        if(game.getKeyManager().c){
            Load("saves.txt");
        }
        */
    }
}
