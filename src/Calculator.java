import javax.swing.*;

public class Calculator extends JFrame {
    protected JFormattedTextField inputEUR;
    private JPanel mainPanel;
    private JFormattedTextField calculatedOutput;
    private JComboBox currencyList;

    Calculator() {
        this.setTitle("CurrencyCalculator");                            //nadanie tytułu aplikacji
        this.setSize(500, 200);                            //zmiana rozmiaru okna
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           //zatrzymanie procesu przy zamknięciu okna
        this.setContentPane(mainPanel);
        ImageIcon icon = new ImageIcon("icon.png");
        this.setIconImage(icon.getImage());                            //zmiana ikony aplikacji
        this.setVisible(true);
    }

    public static void main(String[] args) {
        FileHandler f = new FileHandler();                                            //wywołanie konstruktora klasy zajmującej się plikiem
        Calculator c = new Calculator();                                             //wywołanie konstruktora klasy - wyświetlenie okna aplikacji i podanie nazwy okna
        new InputListener(c);
    }
}