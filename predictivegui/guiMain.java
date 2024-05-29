package predictivegui;

import javax.swing.JFrame;

import predictive.DictionaryTreeImpl;

/**
 * This is the main class to run the GUI program
 */
public class guiMain {
    public static void main(String[] args) {
        //create the necessary JFrame object
        JFrame window = new JFrame("Predictive Text");
        
        // set size of window
        window.setSize(400, 690);
        
        // close operation of the frame
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // set the window to appear in the center of the screen
        window.setLocationRelativeTo(null);

        // add all the GUI components
        // insert the location of the "words" file in here
        window.add(new Components(new DictionaryTreeImpl("D:\\ITS 2022\\campus life\\sophomore\\TUGAS\\semester 3\\OOP\\quiz2\\words")));

        // set visibility true
        window.setVisible(true);

    }
}
