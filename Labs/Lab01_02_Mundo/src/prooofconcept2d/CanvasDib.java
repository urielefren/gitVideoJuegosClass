/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prooofconcept2d;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author servkey
 */
public class CanvasDib extends Canvas{
    
    private int x = 245;
    private int y = 80;
    
    private int xFiend = 190;
    private int yFiend = 260;
    private BufferedImage sample;
    private BufferedImage character;
    private BufferedImage fiend1;
    
    private boolean gameOver=false;
    
    
    public BufferedImage getStage(){
        return sample;
    }
    
    public BufferedImage getCharacter(){
        return character;
    }
    
    public BufferedImage getFiend(){
        return fiend1;
    }
    
    public CanvasDib(){
        if (sample == null) 
            sample = cargarImagen("./images/esc1.jpg");
        if (character == null) 
            character = cargarImagen("./images/yuna.png");
        if (fiend1 == null) 
            fiend1 = cargarImagen("./images/monster.png");
    }
    
    public BufferedImage cargarImagen(String file){
        BufferedImage img = null;
        try{
            URL image = getClass().getResource(file);
            img = ImageIO.read(image);
        }catch(Exception e){
        }
         return img;
    }
    
    @Override
    public void paint(Graphics g)
    {   
        g.drawImage(sample, 0, 0, this);
        //g.setColor(Color.BLUE);     //Activa el color azul
        //g.fillOval(getX(), getY(), 60, 60); //Dibuja un óvalo
        g.drawImage(character, getX(), getY(), this);
        g.drawImage(fiend1, getxFiend(), getyFiend(), this);
        if(gameOver){
            g.drawString("Game Over!, Retry?", 200, 200);
            g.setFont(new Font("TimesRoman", Font.BOLD, 45)); 
            g.setColor(Color.red);
        }
    }   

    @Override
    public void update(Graphics g)
    {
        super.update(g);
        paint(g);
    }
    
    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the xFiend
     */
    public int getxFiend() {
        return xFiend;
    }

    /**
     * @param xFiend the xFiend to set
     */
    public void setxFiend(int xFiend) {
        this.xFiend = xFiend;
    }

    /**
     * @return the yFiend
     */
    public int getyFiend() {
        return yFiend;
    }

    /**
     * @param yFiend the yFiend to set
     */
    public void setyFiend(int yFiend) {
        this.yFiend = yFiend;
    }

    /**
     * @return the gameOver
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * @param gameOver the gameOver to set
     */
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
    
        
}
