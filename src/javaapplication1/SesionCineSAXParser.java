package javaapplication1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Esteban
 */

// Imports de JAXP API
import java.util.Vector;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
// Imports de SAX API
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SesionCineSAXParser extends DefaultHandler {
  
    private Vector sesionesPeliculas;
// Vector con los strings de horarios de todas las sesiones de una pelicula
private Vector sesionesStrPelicula;
// Metadata asociada a una pel�cula
private String codigo, titulo, director, actores;
// Contenido textual de una sesi�n
private String textoSesion;
// Flag que indica si estamos parseando el contenido de texto de una sesi�n
private boolean esTextoSesion = false;        
public SesionCineSAXParser(String url) {
// Obtener referencia al parser factory
SAXParserFactory factory =
SAXParserFactory.newInstance();
 // factory.setNamespaceAware(true);activarnamespaces
try {
// Crear una nueva instancia de un SAX parser
SAXParser saxParser = factory.newSAXParser();
// Parsear el documento apuntado por URL
saxParser.parse(url,this);
} catch (Throwable t) {
t.printStackTrace();
}
}
public void startElement(String namespaceURI, String lName,
String qName,Attributes attrs)
throws SAXException {
// lname --> contiene el nombre local (sin prefijo), o el string vacio
// si procesamiento de namespaces no se lleva a cabo.
// qname --> el nombre cualificado (con prefijo), o el string vac�o si namespaces no activo
if (qName.equals("CarteleraCine")) {
this.sesionesPeliculas = new Vector();
} else if (qName.equals("Pelicula")) {
// Por cada peli preparar vector con horarios de sesiones
this.sesionesStrPelicula = new Vector();
this.codigo = attrs.getValue("codigo");
this.titulo = attrs.getValue("titulo");
this.director = attrs.getValue("director");
this.actores = attrs.getValue("actores");
} else if (qName.equals("Sesion")) {
// S�lo recoger texto si dentro de sesi�n
this.esTextoSesion = true;
this.textoSesion = "";
}
}
public void characters(char[] ch, int start, int
length) {
if (this.esTextoSesion == true) {
// S�lo si estamos dentro de un elemento sesi�n
// recogemos su contenido.
// Si el contenido es largo este m�todo callback puede ser
// invocado varias veces por el parser SAX
this.textoSesion += (new String(ch, start,length)).trim();
}
}
public void endElement(String namespaceURI,
String sName, String qName)
throws SAXException {
if (qName.equals("Pelicula")) {
// Salvamos los detalles de una pelicula en un objeto
Pelicula pelicula = new Pelicula(this.codigo, this.titulo,
this.director,
this.actores);
// A�adimos nuevo objeto SesionesPelicula a vectorsesionesPeliculas
this.sesionesPeliculas.add(new SesionesPelicula(pelicula,
        this.sesionesStrPelicula));
} else if (qName.equals("Sesion")) {
// Por cada sesi�n salvar el texto conteniendo horario sesi�n
this.esTextoSesion = false;
this.sesionesStrPelicula.add(this.textoSesion);
}
}
// M�todo para recuperar vector con
// objetos SesionesPelicula creados
// en parsing
public Vector getSesionesPeliculas() {
return this.sesionesPeliculas;
}

}
