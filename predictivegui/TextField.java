package predictivegui;

import java.util.Observer;
import java.util.Observable;
import javax.swing.JTextArea;

@SuppressWarnings("deprecation")
public class TextField extends JTextArea implements Observer {
    private Model model;

    // constructor to assign the model
    public TextField(Model model) {
        super();
        super.setEditable(false);
        super.setLineWrap(true);
        super.setFont(new java.awt.Font("Arial", 0, 25));
        this.model = model;
    }

    // update method for appending words to the current message
    @Override
    public void update(Observable arg0, Object arg1) {
        setText(model.getMessage() + model.getCurrentWord());
    }
}
