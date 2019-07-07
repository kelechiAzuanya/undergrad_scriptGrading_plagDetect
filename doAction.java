/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartGrader.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

/**
 *
 * @author LabaPc
 */
public class doAction implements ActionListener {

    JProgressBar progressBar;

    public doAction(JProgressBar progressBar) {
        this.progressBar = progressBar;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        progressBar.setValue(0);
        progressBar.setStringPainted(false);
    }
}
