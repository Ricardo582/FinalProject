package finalprojectgit;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;

/**
 *
 * @author hgm
 */
public class ReadWrite {
    
    Level1 lvl1;
    int vidas;
    int score;
    
    ReadWrite(Level1 lvl1){
        this.lvl1 = lvl1;
    }
    
    public void Save(String strFileName){
        /*try{
            System.out.println("Saving...");
            PrintWriter writer = new PrintWriter(new FileWriter(strFileName));
            vidas = game.getLives();
            score = game.getScore();
            writer.println("" + vidas + "/" + score);
            writer.close();
        }
        catch(IOException ioe){
            System.out.println("File Not fund Call 911");
        }*/
    }
    
    public void Load(String strFileName){
        try{
            System.out.println("Loading...");
            FileReader file = new FileReader(strFileName);
            BufferedReader reader = new BufferedReader(file);
            String line;
            String datos[];
            line = reader.readLine();
            datos = line.split("/");
            //game.setLives(Integer.parseInt(datos[0]));
            //game.setScore(Integer.parseInt(datos[1]));
            //System.out.println("Se leyo vidas = " + vidas + " y score = " + score);
            reader.close();
        }
        catch(IOException e){
            System.out.println("File Not fund Call 911");
        }
    }
    
    public int[][] tileRead(String strFileName){
        int[][] mat;
        mat = new int[10][30];
        
        for(int x = 0; x < 10; x++){
            for(int y = 0; y < 30; y++){
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
                for(int j = 0; j < 30; j++){
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
