///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package smartGrader.GUI;
//
///**
// *
// * @author LabaPc
// */
//import java.awt.Image;
//import javax.swing.ImageIcon;
//import javax.swing.JLabel;
//import javax.swing.JScrollPane;
//
//public class RenderPDF {
//
//    static Image image;
//
//    public RenderPDF(JScrollPane srollPane) {
//        JLabel label = new JLabel(new ImageIcon(image));
//
//        label.setVerticalAlignment(JLabel.TOP);
//
//        setContentPane( new JScrollPane(label));
//    }
//    public void renderImage(){
//  
//      RandomAccessFile raf = new RandomAccessFile (new File (args [0]), "r");
//      FileChannel fc = raf.getChannel ();
//      ByteBuffer buf = fc.map (FileChannel.MapMode.READ_ONLY, 0, fc.size ());
//      PDFFile pdfFile = new PDFFile (buf);
//
//      int numpages = pdfFile.getNumPages ();
//      System.out.println ("Number of pages = "+numpages);
//      if (pagenum > numpages)
//          pagenum = numpages;
//
//      PDFPage page = pdfFile.getPage (pagenum);
//              
//      Rectangle2D r2d = page.getBBox ();
//
//      double width = r2d.getWidth ();
//      double height = r2d.getHeight ();
//      width /= 72.0;
//      height /= 72.0;
//      int res = Toolkit.getDefaultToolkit ().getScreenResolution ();
//      width *= res;
//      height *= res;
//
//      image = page.getImage ((int) width, (int) height, r2d, null, true, true);
//
//      Runnable r = new Runnable ()
//                   {
//                       public void run ()
//                       {
//                          new PDFViewer ("PDF Viewer: "+args [0]);
//                       }
//                   };
//      EventQueue.invokeLater (r);
//   }
//    }
//}
