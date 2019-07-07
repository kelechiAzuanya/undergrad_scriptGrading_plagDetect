/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartGrader.scriptGrading;

//import icepdf.ae;
import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import org.icepdf.core.exceptions.PDFException;
import org.icepdf.core.exceptions.PDFSecurityException;
import org.icepdf.core.pobjects.Document;
import org.icepdf.core.pobjects.Page;
import org.icepdf.core.util.GraphicsRenderingHints;
import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;
import static sun.net.www.http.HttpClient.New;

/**
 *
 * @author LabaPc
 */
public class ViewPDF {

    SwingController controller;
    SwingViewBuilder factory;
    //  ActionEvent ae;
    //  String command=ae.getActionCommand();
    // String filePath;

    public ViewPDF() {
        controller = new SwingController();
        // Build a SwingViewFactory configured with the controller
        factory = new SwingViewBuilder(controller);

        // Use the factory to build a JPanel that is pre-configured
// with a complete, active Viewer UI.
        //     controller.actionPerformed(new ActionEvent(ae,0,command){});
    }

    public void displayPDF(JPanel viewerComponentPanel, String filePath) {

        // build a controller
        SwingController controller = new SwingController();
        // Build a SwingViewFactory configured with the controller
        SwingViewBuilder factory = new SwingViewBuilder(controller);
        // Use the factory to build a JPanel that is pre-configured
// with a complete, active Viewer UI.
        viewerComponentPanel.removeAll();
        viewerComponentPanel.revalidate();
        viewerComponentPanel.add(factory.buildViewerPanel());

// Open a PDF document to view
        controller.openDocument(filePath);
        controller.havePermissionToModifyDocument();
        viewerComponentPanel.revalidate();
        
    }

    public void closeDocument() {
        this.controller.closeDocument();
        this.controller.dispose();
    }

    public void convertToImage(String filePath, JTextPane displayPDF) {
        try {
            displayPDF.removeAll();
            displayPDF.revalidate();
        //    displayPDF= new JTextPane();
            Document document = new Document();
            document.setFile(filePath);
            float scale = 1.0f;
            float rotation = 0f;
            // Paint each pages content to an image and
            for (int i = 0; i < document.getNumberOfPages(); i++) {
                BufferedImage image = (BufferedImage) document.getPageImage(
                        i, GraphicsRenderingHints.PRINT, Page.BOUNDARY_CROPBOX, rotation, scale);
                RenderedImage rendImage = image;
                ImageIcon imag = new ImageIcon(image);
                displayPDF.insertIcon(imag);
//                JLabel label = new JLabel("", imag, JLabel.CENTER);
                // clean up resources
                document.dispose();
//                displayPDF.add(label,BorderLayout.CENTER);
                displayPDF.revalidate();
            }
            
            // clean up resources
            document.dispose();
        } catch (PDFException ex) {
            Logger.getLogger(ViewPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PDFSecurityException ex) {
            Logger.getLogger(ViewPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ViewPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ViewPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
