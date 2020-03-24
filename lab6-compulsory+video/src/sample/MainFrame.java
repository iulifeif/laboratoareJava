package sample;

import javax.swing.*;
import java.awt.*;

import static javax.swing.SpringLayout.NORTH;
import static javax.swing.SpringLayout.SOUTH;
import static javax.swing.SwingConstants.CENTER;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;
    public MainFrame(){
        super("My Drawing application");
        init();
    }

    private void init(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //create te components
        canvas = new DrawingPanel(this);
        configPanel= new ConfigPanel( this);
        controlPanel = new ControlPanel(this);

        //arrange the components in the container (frame)
        // JFrame uses a BorderLayout by default
        add(canvas, CENTER); //this is BorderLayout.CENTER
        add(configPanel,NORTH);
        add(controlPanel,SOUTH);
        //invoke the layout manager
        pack();
    }
}
