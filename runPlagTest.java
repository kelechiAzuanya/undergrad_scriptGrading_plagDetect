
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartGrader.Plagiarism;

import java.io.File;
import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import smartGrader.GUI.eGrader_Worker;

/**
 *
 * @author LabaPc
 */
public class runPlagTest {

    /**
     * getFiles method reads the folder extracts the PDF and presents it for
     * normalising before plagiarism check is run
     *
     * @param backContainer
     */
    public Map<String, String> normalizedText;

    public void getFiles(JFrame backContainer) {
        final JFileChooser fc = new JFileChooser();
        File di = new File(System.getProperty("user.home") + "/Desktop");
        fc.setCurrentDirectory(di);
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int returnVal = fc.showOpenDialog(backContainer);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File dir = fc.getSelectedFile();
            populateList pop = new populateList(dir);
            /**
             * extracts Text from each of the PDF file and stores them in a Map
             * called extractedPDF
             */
            pop.extractTextFromPDF();

        } else {
            return;
        }
    }

    /**
     * normalizedList()is a method which loop the extractedPDF Map, get the
     * extracted Text and pass it to the NLP tool for tokenization,
     * lemmatization and plagiarism check
     */
    public void normalizedList() {
        Set<Map.Entry<String, String>> hashSet = populateList.extractedPDF.entrySet();
        for (Map.Entry<String, String> entry : hashSet) {
            //System.out.println("Key=" + entry.getKey() + ", Value=" + entry.getValue());
            // System.out.println(entry);
            StanfordLemmatizer slem = new StanfordLemmatizer();
            slem.lemmatize(entry.getValue());
            System.out.println(slem.lemmatize(entry.getValue()));
            //  slem.tokenize(entry.getValue());
        }
    }
}
