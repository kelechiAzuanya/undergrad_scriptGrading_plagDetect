/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartGrader.Plagiarism;

import java.io.*;
import java.io.FileWriter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LabaPc
 */
public class readAndWritePlagResult {
//This is just a simulation because the plag result input is uncertain now
    //so I just simulate how to write to file in the my standard format

    Map<Integer, String> scoreIn = new HashMap<>();
    Map<String, Object> scoreOut = new HashMap<>();

    public void fillMap() {
        String name = "kelechi";
        for (int i = 0; i < 1000; i++) {
            scoreIn.put(i, name + i);
        }
    }

    public void writeResultToFile() {
        String FileName = "C:\\Users\\LabaPc\\Desktop\\";
        FileWriter fw = null;
        BufferedWriter bf = null;
       // for (int i = 0; i < scoreIn.size(); i++) {
            try {
                int j=1;
                FileName += scoreIn.get(j);
                fw = new FileWriter(FileName+".txt");
                bf = new BufferedWriter(fw);
                StringBuffer fileContent= new StringBuffer();
                        fileContent.append("Plagiarism Report for " + scoreIn.get(j) + "/n");
                        
               // String content = " Plagiarism Report for " + scoreIn.get(i) + "\n"
               //         + i + " : " + scoreIn.get(i) + "\t";
                for (int i = 0; i < scoreIn.size(); i++) {
                    fileContent.append(System.lineSeparator());
                fileContent.append(  scoreIn.get(i) +" : "+i);
                }
                String fileFinal=fileContent.toString();
                bf.write(fileFinal);
                System.out.println("Done");
            } catch (IOException ex) {
                Logger.getLogger(readAndWritePlagResult.class.getName()).log(Level.SEVERE, null, ex);
            } finally {

                try {

                    if (bf != null) {
                        bf.close();
                    }

                    if (fw != null) {
                        fw.close();
                    }

                } catch (IOException ex) {

                    ex.printStackTrace();

                }
            }
        }
    }

