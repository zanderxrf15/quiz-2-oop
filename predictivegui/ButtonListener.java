package predictivegui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ButtonListener implements ActionListener {
    private Model model;
    private int sig;
    
    // constructor to assign model and current char signature
    public ButtonListener(int k, Model model) {
        this.model = model;
        this.sig = k;
    }

    // override is used because it's implemented from ActionListener interface
    // perform addSigChar to the current model's state
    @Override
    public void actionPerformed(ActionEvent e) {
        model.addSigChar(sig);
    }
}
