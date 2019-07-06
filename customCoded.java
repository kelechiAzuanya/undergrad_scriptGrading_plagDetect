/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartGrader.Plagiarism;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.StringJoiner;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.SwingWorker;
import static smartGrader.GUI.eGrader_Worker.pip;
//import org.springframework.util.StringUtils;

/**
 *
 * @author LabaPc
 */
public class customCoded {

    Map<String, Map<String, Double>> cosineValues = new HashMap<>();
    Map tt;
    public HashMap<String, Map<String, Float>> NTF = new HashMap<>();
    public Map<String, Float> IDF = new HashMap<>(); //stores IDF for each of the word in the target document
    public Map<String, Map<String, Float>> TFIDF = new HashMap<>();
    private Set<String> stopwords = new HashSet<>();
    ArrayList<String> tokenCache = new ArrayList<>();
    String name;
    StringJoiner stb;
    public static Map<String, String> noisedExtractedPDF = new HashMap<>();
    public static Map<String, String> genericTermFrequency = new HashMap<>();
    String tempValue, tempKey;

    private static final String Default_STOPWORDS = "I a about add ago after all also an and another any"
            + "are as at be because been before being between big both but by came can come could did do"
            + "does due each else end far few for from get got had has have he her here him himself his how "
            + "if in into is it its just let lie like low make many me might more most much must my never no"
            + "nor not now of off old on only or other our out over per pre put re said same see she should since"
            + "so some still such take than that the then there these they this those through to too under up use"
            + "very via want was way , ; 's . we well were what when where which while who would yes you your";

    public customCoded() {
        //String[] stopwordArray = StringUtils.split(Default_STOPWORDS, "");
        String[] tokens = Default_STOPWORDS.split("");
        for (String token : tokens) {
            stopwords.add(token);
        }
        initialiseStanfordLib();
    }

    private void initialiseStanfordLib() {
        SwingWorker swi;
        swi = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {;
                pip();
                Object me = new Object();
                return me;
            }

        };
        swi.execute();
    }
  public static StanfordCoreNLP pip() {
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit, pos,lemma");
        //props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        return pipeline;
    }
    /**
     * recogniseStopWords() loops through the extractedPDF Map it gets the value
     * which it stores in tempValue and passes it for further tokenization
     */
    public void recogniseStopWords() {

        Set<Map.Entry<String, String>> hashSet = populateList.extractedPDF.entrySet();
        for (Map.Entry<String, String> entry : hashSet) {
            tempValue = entry.getValue();
            tempKey = entry.getKey();
            /**
             * Tokenize and remove stop words remove stopwords by iterating over
             * the tempValue text and compare each word against the
             * Default_STOPWORDS
             */

            //Stanford nlp library to tokenise and lemmatise
            // create an empty Annotation just with the given text
            Annotation document = new Annotation(tempValue);

            // run all Annotators on this text
            StanfordCoreNLP pipeline = pip();
            pipeline.annotate(document);

            List<CoreMap> sentences = document.get(SentencesAnnotation.class);
            stb = new StringJoiner(" ");
            for (CoreMap sentence : sentences) {
                // traversing the words in the current sentence
                // a CoreLabel is a CoreMap with additional token-specific methods
                for (CoreLabel token : sentence.get(TokensAnnotation.class)) {
                    // this is the text of the token
                    String word = token.get(TextAnnotation.class);
                    String lemma = token.get(CoreAnnotations.LemmaAnnotation.class);
                    if (stopwords.contains(lemma)) {
                        lemma = "";

                    } else {
                        stb.add(lemma);

                    }
                }
                name = stb.toString();

                noisedExtractedPDF.put(tempKey, name);

            }

        }
        Set<Map.Entry<String, String>> hashset = noisedExtractedPDF.entrySet();
        for (Map.Entry<String, String> entryy : hashset) {
            System.out.println("Key=" + entryy.getKey() + ", Value=" + entryy.getValue());

        }
    }

    public void generateTF() {
        for (Map.Entry<String, String> entry : noisedExtractedPDF.entrySet()) {
            Map<String, Float> ntf = new HashMap<>();
            String[] tokens = entry.getValue().split("\\s+");
            for (String token : tokens) {
                token = token.toLowerCase();
                if (ntf.containsKey(token)) {
                    ntf.put(token, ntf.get(token) + 1);
                } else {
                    ntf.put(token, 1f);
                }
            }
            for (String token : ntf.keySet()) {
                float ntfreq = ((float) ntf.get(token) / (float) tokens.length);
                ntf.put(token, ntfreq);
            }
            NTF.put(entry.getKey(), ntf);  //i should be the name of the document
        }
        for (Map.Entry<String, Map<String, Float>> entry : NTF.entrySet()) {
            System.out.println(entry);
        }
    }

    public void checkIDF() {

        for (Map.Entry<String, Map<String, Float>> entry : NTF.entrySet()) {
            for (String token : entry.getValue().keySet()) {
                int numFiles = 0;
                float tf = 0;
                for (String file : NTF.keySet()) {
                    int a = NTF.get(file).containsKey(token) ? 1 : 0;
                    if (a > 0) {
                        numFiles++;
                        tf += NTF.get(file).get(token);
                    }
                }
                float idf = tf * 1.0f / numFiles;
                IDF.put(token, idf);
            }
        }
        for (String string : IDF.keySet()) {
            System.out.println(string + ":" + IDF.get(string));
        }

    }

    public void calTFIDF() {

        for (Map.Entry<String, Map<String, Float>> entry : NTF.entrySet()) {
            /**
             * we are looping through the NTF entryset to get the values of each
             * (key)word in the element so as to calculate the tf-idf of each of
             * the focus word
             */
            Map<String, Float> resultSet = new HashMap<>();
            float tf;
            float tfidf;
            float idf;
            String fileName = null;
            for (String token : entry.getValue().keySet()) {
                fileName = entry.getKey();
                int a = NTF.get(fileName).containsKey(token) ? 1 : 0;
                if (a > 0) {
                    tf = NTF.get(fileName).get(token);
                    idf = IDF.get(token);
                    tfidf = (tf * idf);
                    resultSet.put(token, tfidf);
                }

            }
            TFIDF.put(fileName, resultSet);

        }
        for (Map.Entry<String, Map<String, Float>> entry : TFIDF.entrySet()) {
            System.out.println(entry);
        }
    }

    public void calculateCosineSimiilarity() {
        //loop through documents
        for (Map.Entry<String, Map<String, Float>> e1 : TFIDF.entrySet()) {
            // create an entry in the cosine map for this document
            cosineValues.put(e1.getKey(), new HashMap<>());
            // loop through (other) documents
            for (Map.Entry<String, Map<String, Float>> e2 : TFIDF.entrySet()) {
                //skip the current outer document 
                if (!e2.getKey().equalsIgnoreCase(e1.getKey())) {
                    Map<String, Float> a = e1.getValue();
                    Map<String, Float> b = e2.getValue();
                    // for holding |A| and |B|
                    double absA = 0.0;
                    double absB = 0.0;
                    double v = 0.0;
                    for (String y : b.keySet()) {
                        absB += Math.pow(b.get(y), 2);
                    }
                    for (String t : a.keySet()) {
                        absA += Math.pow(a.get(t), 2);
                    }

                    //loop through tokens
                    for (String token : a.keySet()) {
                        //  absA += Math.pow(a.get(token), 2);

                        //loop through tokens in each of these other documents
                        for (String token2 : b.keySet()) {
                            //  absB += Math.pow(b.get(token2), 2);
                            if (token.equalsIgnoreCase(token2)) {
                                // addup  their tfidf products
                                v += a.get(token) * e2.getValue().get(token2);

                            }

                        }

                    }
                    double cValue = v / (Math.sqrt(absA) * Math.sqrt(absB));
                    cosineValues.get(e1.getKey()).put(e2.getKey(), cValue);
                }
            }
        }
        System.out.println(cosineValues);

    }

    public void populatePlagiarismList(JList jListDisplayScripts) {
        DefaultListModel listModel = new DefaultListModel();
        listModel.clear();
        for (String string : cosineValues.keySet()) {
            listModel.addElement(string);
        }
        jListDisplayScripts.setModel(listModel);
    }

    public Map<String, Map<String, Double>> returnMap() {
        return cosineValues;
    }
}
