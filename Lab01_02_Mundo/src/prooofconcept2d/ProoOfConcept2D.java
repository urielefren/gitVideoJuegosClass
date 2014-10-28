/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prooofconcept2d;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author servkey
 */
public class ProoOfConcept2D {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CanvasDib canvas = new CanvasDib();
        FrmGame fr = new FrmGame(canvas);
        fr.setSize(canvas.getStage().getWidth(), canvas.getStage().getHeight());
       
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
}
