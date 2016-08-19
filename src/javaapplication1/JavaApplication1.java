/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;


import java.io.FileInputStream;  
import java.io.IOException;  
  
import org.xml.sax.InputSource;  
import org.xml.sax.SAXException;  
import org.xml.sax.XMLReader;  
import org.xml.sax.helpers.XMLReaderFactory; 
/**
 *
 * @author Esteban
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     
      SesionCineSAXParser eje;
        eje = new SesionCineSAXParser("file:///C:/Users/Esteban/"
                + "Documents/NetBeansProjects/JavaApplication1/src/"
                + "javaapplication1"
                + "/newXMLDocument.xml");
  
   }  
    }
    

