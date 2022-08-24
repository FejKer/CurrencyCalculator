import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;

public class FileHandler {

    FileHandler(Calculator calc) throws ParserConfigurationException, IOException, SAXException {                          //TODO pobieranie pliku z internetu
        String fileName;
        fileName = JOptionPane.showInputDialog(null, "Podaj nazwę pliku z danymi.", "Podanie nazwy pliku", JOptionPane.INFORMATION_MESSAGE);        //komunikat proszący o podanie nazwy pliku .xml
        File xml = new File(fileName);
        if(!xml.isFile()){
            int a = JOptionPane.showConfirmDialog(null, "Nie znaleziono pliku. Czy pobrać go z internetu?");
            if(a == JOptionPane.YES_OPTION){
                //pobranie pliku z internetu
            } else {
                JOptionPane.showMessageDialog(null, "Anulowanie pracy programu.", "Błąd pliku", JOptionPane.WARNING_MESSAGE);
                System.exit(1);                                                                                                                                         //jeśli użytkownik nie chce pobierać pliku, wychodzimy z programu oraz wyświetlamy mu odpowiedni komunikat
            }
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xml);
        NodeList nodeList = document.getElementsByTagName("Cube");                                                                                                           //plik xml zawiera Cube w nagłówku

        for(int i = 0; i < nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) node;
                if(!element.hasAttribute("rate")){
                    continue;                                                                               //zabezpieczenie na wypadek odczytania danych nie dotyczących walut (np.data)
                }
                String stemp = element.getAttribute("currency");                                      //tymczasowe zmienne do przechowania danych z xml
                Double dtemp = Double.parseDouble(element.getAttribute("rate"));
                calc.currencies.put(stemp, dtemp);                                                          //dodanie danych do hashmapy
                calc.model.addElement(stemp);                                                               //dodanie danych do modelu celem aktualizacji danych w rozwijanej liście
            }
        }
        JOptionPane.showMessageDialog(null, "Poprawno wczytano dane z pliku.", "Informacja", JOptionPane.INFORMATION_MESSAGE);
    }
}
