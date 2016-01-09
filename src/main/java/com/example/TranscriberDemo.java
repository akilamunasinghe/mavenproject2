/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.example;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class TranscriberDemo {       
                                     
    public static void main(String[] args) throws Exception {
        String str;                             
        Configuration configuration = new Configuration();

        configuration
                .setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration
                .setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        configuration
                .setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");

 //       StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer(configuration);
 //       InputStream stream = new FileInputStream(new File("test.wav"));
//*******************************************************************
        LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
        // Start recognition process pruning previously cached data.
        recognizer.startRecognition(true);
        SpeechResult result;
        // Pause recognition process. It can be resumed then with startRecognition(false).
        do{
            //jskdhfsd
            result = recognizer.getResult();
            //System.out.format("Hypothesis: %s\n", result.getHypothesis());
            str=result.getHypothesis();
            System.out.println(str);
            
        }while (!str.equals("no")) ;
        recognizer.stopRecognition();
//******************************************************************************        
        
//        recognizer.startRecognition(stream);
//        SpeechResult result;
//        while ((result = recognizer.getResult()) != null) {
//            //System.out.format("Hypothesis: %s\n", result.getHypothesis());
//            System.out.println(result.getHypothesis());
//        }
//        recognizer.stopRecognition();
    }
}
