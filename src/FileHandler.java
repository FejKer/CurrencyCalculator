import javax.swing.*;
import java.io.File;

public class FileHandler {

    FileHandler(){                          //TODO pobieranie pliku z internetu
        String fileName;
        fileName = JOptionPane.showInputDialog("Podanie nazwy pliku.", "Podaj nazwę pliku z danymi.");
        File xml = new File(fileName);
        if(!xml.isFile()){

        }
    }
}
