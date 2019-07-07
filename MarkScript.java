/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartGrader.scriptGrading;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author LabaPc
 */
public class MarkScript extends JTextPane{

 
    public void paintComponent(Graphics g,int x,int y) {
        super.paintComponent(g);
       // draw(jTextPaneGrader,jSpinnerSetMark,x,y);
    }

    public void draw(JTextPane jTextPaneGrader,JSpinner jSpinnerSetMark,int x,int y) {
        MarkScript ms = new MarkScript();
        String text =ms.getSpinnerValue(jSpinnerSetMark).toString();
        Graphics g22 = jTextPaneGrader.getGraphics();
        Graphics2D g2 = (Graphics2D) g22;
        g2.setStroke(new BasicStroke(30));
        g2.drawString(text, x, y);
    }

    
    public void paint(Graphics g, String text, float x, float y) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(30));
        g2.drawString(text, x, y);
    }

    public Double getSpinnerValue(JSpinner spinner) {
        Double v = ((Double) spinner.getValue()).doubleValue();
        return v;
    }
}
