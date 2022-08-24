import java.awt.*;
import java.awt.event.*;

public class InputListener {

    InputListener(Calculator calc){
        calc.inputEUR.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
                    e.consume();                                      //jeśli wpisana zawartość jest inna niż liczba lub backspace, kropka lub delete, anulujemy input
                }
            }
        });
        calc.inputEUR.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.isControlDown()) {
                    e.consume();                                    //zabezpieczamy input przed ewentualnym wklejeniem zawartości przez ctrl+v
                }
            }
        });
        calc.inputEUR.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                calc.updateValues();                                //update przy puszczeniu klawisza
            }
        });
        calc.currencyList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {            //update przy zmianie waluty docelowej
                calc.updateValues();
            }
        });
    }
}
