/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartGrader.Plagiarism;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LabaPc
 */
public class populateList {

    /**
     * path--A String that stores the name of the path to the folder to be read
     * extractedFile--A map that stores the extracted PDF files and its FileName
     *
     *
     */
    // String path;
    File dir;
   public static Map<String, String> extractedPDF = new HashMap<>();
    String ontransitText;

    public populateList(File dir) {

        this.dir = dir;
    }

    /**
     * extractTextFromPDF--is the method that does the actual PDF extraction,
 it reads a folder, gets the files and calls the PDFExtractor class
 that actually does the PDF extraction. The extracted File is storesd 
     * extractedPDF Map
     */
    public void extractTextFromPDF() {
        String FilePath;
        String FileName;
        File[] FileList = dir.listFiles();
        for (int i = 0; i < FileList.length; i++) {
            //if (dir.isFile()) {
            try {
                FilePath = FileList[i].getCanonicalPath();
                FileName = FileList[i].getName();
                PDFExtractor extract = new PDFExtractor();
                extract.setFilePath(FilePath);
                ontransitText = extract.ToText();
                extractedPDF.put(FileName, ontransitText);

            } catch (IOException ex) {
                Logger.getLogger(populateList.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
//        Set<Map.Entry<String, String>> hashSet = extractedPDF.entrySet();
//        for (Map.Entry<String, String> entry : hashSet) {
//            //System.out.println("Key=" + entry.getKey() + ", Value=" + entry.getValue());
//            System.out.println(entry);
//        }
       
    }
}
