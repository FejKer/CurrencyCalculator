import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Calculator extends JFrame {
    protected JFormattedTextField inputEUR;
    private JPanel mainPanel;
    private JFormattedTextField calculatedOutput;
    private JComboBox currencyList;
    HashMap<String, Double> currencies = new HashMap<String, Double>();                 //hashmap przechowujacy symbol i kurs
    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();

    Calculator() {
        this.setTitle("CurrencyCalculator");                            //nadanie tytułu aplikacji
        this.setSize(500, 200);                            //zmiana rozmiaru okna
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           //zatrzymanie procesu przy zamknięciu okna
        this.setContentPane(mainPanel);
        ImageIcon icon = new ImageIcon("icon.png");
        this.setIconImage(icon.getImage());                            //zmiana ikony aplikacji
        this.setVisible(true);
    }

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        Calculator c = new Calculator();                                 //wywołanie konstruktora klasy - wyświetlenie okna aplikacji
        FileHandler f = new FileHandler(c);                              //wywołanie konstruktora klasy zajmującej się plikiem
        InputListener i = new InputListener(c);
        c.currencyList.setModel(c.model);                                //aktualizacja danych
    }
}