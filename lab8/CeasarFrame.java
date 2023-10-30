import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CeasarFrame extends JFrame{

    private JComboBox charComboBox;
    private JTextField inputField;
    private JButton confirmButton;
    private JTextField outputField;
    
    public CeasarFrame(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("SwingLab");
        setPreferredSize(new Dimension(400,110));
        setLayout(new GridLayout(2,1));
        setUpPanels();
        setResizable(true);
        pack();
    }

    private void setUpPanels(){
        var abc = new Vector<Object>();
        for(char i = 'A'; i <= 'Z'; i++)
            abc.add(i);

        var topPanel = new JPanel(new BorderLayout());

        charComboBox = new JComboBox<Object>(abc);
        inputField = new JTextField();
        //Set max character limit (20 karakter széles???)
        confirmButton = new JButton("Code!");

        topPanel.add(charComboBox, BorderLayout.WEST);
        topPanel.add(inputField, BorderLayout.CENTER);
        topPanel.add(confirmButton, BorderLayout.EAST);
        add(topPanel);

        var botPanel = new JPanel(new GridLayout(1,2));

        var label = new JLabel("Output:");
        outputField = new JTextField();
        outputField.setEditable(false);

        botPanel.add(label);
        botPanel.add(outputField);
        add(botPanel);
    }
}
