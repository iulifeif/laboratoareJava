package sample;

import javafx.embed.swing.JFXPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ConfigPanel extends JFXPanel {
    final MainFrame frame;
    JLabel sidesLabel; // we’re drawing regular polygons
    JSpinner sidesField; // number of sides
    JComboBox<Color> colorCombo; // the color of the shape

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //create the label and the spinner
        JLabel sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6); //default number of sides
        //create the colorCombo, containing the values: Random and Black
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        Color Random= new Color(r,g,b);
        Color[] colors ={Color.black,Random};
        colorCombo= new JComboBox<>(colors);
        add(sidesLabel); //JPanel uses FlowLayout by default
        add(sidesField);
        add(colorCombo);
    }
}
