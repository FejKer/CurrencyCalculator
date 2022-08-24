import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

public class Calculator extends JFrame {
    protected JFormattedTextField inputEUR;                                         //protected ze względu na klasę InputListener, w której jest użyty
    private JPanel mainPanel;
    private JFormattedTextField calculatedOutput;
    protected JComboBox currencyList;
    protected HashMap<String, Double> currencies = new HashMap<String, Double>();                         //hashmap przechowujacy symbol i kurs
    protected DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();            //combobox model, używany do aktualizacji danych w liście walut

    Calculator() {
        Color bg = new Color(43, 43, 43);                      //kolor tła aplikacji
        this.setTitle("CurrencyCalculator");                            //nadanie tytułu aplikacji
        this.setSize(500, 200);                            //zmiana rozmiaru okna
        this.setLocationRelativeTo(null);                              //pojawienie się okna na środku ekranu
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           //zatrzymanie procesu przy zamknięciu okna
        this.setContentPane(mainPanel);
        ImageIcon icon = new ImageIcon("res/icon.png");
        this.setIconImage(icon.getImage());                            //zmiana ikony aplikacji
        this.setVisible(true);
        mainPanel.setBackground(bg);                                    //nadanie koloru tła aplikacji
        inputEUR.setText("0");
        calculatedOutput.setText("0");
    }

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        Calculator c = new Calculator();                                 //wywołanie konstruktora klasy - wyświetlenie okna aplikacji
        new FileHandler(c);                                              //wywołanie konstruktora klasy zajmującej się plikiem
        new InputListener(c);
        c.currencyList.setModel(c.model);                                //aktualizacja danych
    }

    public String getSelectedCurrency(){
        String selectedValue = currencyList.getSelectedItem().toString();       //zwracanie w stringu aktualnego zaznaczenia z listy
        return selectedValue;
    }

    public double getCalculatedCurrency(String s){
        double d = currencies.get(s);
        try{
            d *= Double.parseDouble(inputEUR.getText());                        //zabezpieczenie na wypadek pustej wartości
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    public void setCalculatedCurrency(double d){
        calculatedOutput.setText(Double.toString(d));                          //ustawienie wyniku konwertowania walutowego
    }

    public void updateValues(){
        String s = getSelectedCurrency();                                       //funkcja łącząca powyższe
        Double d = getCalculatedCurrency(s);
        setCalculatedCurrency(d);
    }
}