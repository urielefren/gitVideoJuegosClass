/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prooofconcept2d;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author servkey
 * @modified by UrielEfren
 */
public class FrmGame extends JFrame implements KeyListener{
    private Thread t=null;
    private CanvasDib c=null;
    private boolean bandera=true;
    public FrmGame(CanvasDib c){
        this.c = c;
        add(c);
        addKeyListener(this);
        //Iniciar hilo
        t = new Thread(){
              public void run(){
                  updating();
              }
        };
        t.start();
    }
    
    public void updating(){
        while (true){
            try {
                Thread.sleep(100);
                moveFiend(bandera);
                checkCollision();
                c.repaint();
            } catch (InterruptedException ex) {
                Logger.getLogger(FrmGame.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("pressed:"+e.getKeyCode());
        System.out.println(c.getX()+" -- "+c.getY());
        int keypressed = e.getKeyCode();
        String command = "";
        if(keypressed==37){//izquierda
            command = "izquierda";
        }
        else if(keypressed==38){//arriba
            command = "arriba";
        }
        else if(keypressed==39){//derecha
            command = "derecha";
        }
        else if(keypressed==40){//abajo
            command = "abajo";
        }
        if(!command.equals("")){
            moveAvatar(command);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void moveFiend(boolean b){
        if(b){
            if(c.getxFiend()<390)
                c.setxFiend(c.getxFiend()+3);
            else
                bandera=false;
        }else{
            if(c.getxFiend()>130)
                c.setxFiend(c.getxFiend()-3);
            else
                bandera = true;
        }
    }
    
    
    //metodo para mover avatar
    public void moveAvatar(String command) {
        if(!c.isGameOver()){
            switch (command) {
                case "izquierda":
                    //izquierda
                    if(c.getX()>190){
                        c.setX(c.getX()-5);
                    }else{
                        c.setX(190);
                    }   break;
                case "arriba":
                    //arriba
                    if(c.getY()>80){
                        c.setY(c.getY()-5);
                    }else{
                        c.setY(80);
                    }   break;
                case "derecha":
                    //derecha
                    if(c.getX()<325){
                        c.setX(c.getX()+5);
                    }else{
                        c.setX(325);
                    }   break;
                case "abajo":
                    //abajo
                    if(c.getY()<460){
                        c.setY(c.getY()+5);
                    }else{
                        c.setY(460);
                    }   break;
            }
            c.repaint();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void checkCollision(){
        //System.out.println(c.getX()+" "+c.getxFiend() +" "+ c.getY()+" "+c.getyFiend());
        int charX2=c.getX()+c.getCharacter().getWidth();
        
        int charY1=c.getY();
        int charY2=c.getY()+c.getCharacter().getHeight();
        
        int fiendX1=c.getxFiend();
        
        int fiendY1=c.getyFiend();
        
        if(charY1>200 && charY1<400){
            if(charX2-10< fiendX1 && charY2 != fiendY1){
                //System.out.println("character pass");
                //conectar el socket
            }else{
                //System.out.println("character coll");
                c.setGameOver(true);
            }
        }
    }
}
