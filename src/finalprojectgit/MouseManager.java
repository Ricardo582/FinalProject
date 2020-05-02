
package finalprojectgit;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author hgm
 */
public class MouseManager implements MouseListener, MouseMotionListener{
    
    private Point punto;
    public boolean pressed;
    public boolean dxdyHelper;
    public int x;
    public int y;
    
    public MouseManager(){
        pressed = false;
        dxdyHelper = false;
        punto = new Point(0, 0);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //importante
        if(e.getButton() == MouseEvent.BUTTON1){
            //System.out.println("press()");
            punto = e.getPoint();
            pressed = true;
            dxdyHelper = true;
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //importante
        if(e.getButton() == MouseEvent.BUTTON1){
            //System.out.println("Release()");
            pressed = false;
            dxdyHelper = false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //importante
        //Mac debe de usar BUTTON1 como boton derecho
        //Windows de usar BUTTON0 como boton derecho
        if(e.getButton() == MouseEvent.BUTTON1){
            //System.out.println("draggin()");
            punto = e.getPoint();
            pressed = true;
            dxdyHelper = false;
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //importante
        //Mac debe de usar BUTTON1 como boton derecho
        //Windows de usar BUTTON0 como boton derecho
    }
    
    public Point getPunto(){
        return punto;
    }
    
    public void tick() {
        x = punto.x;
        y = punto.y;
    }
    
}