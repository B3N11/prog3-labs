import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CaesarFrame extends JFrame{

    private JComboBox charComboBox;
    private JTextField inputField;
    private JButton confirmButton;
    private JTextField outputField;
    
    public CaesarFrame(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("SwingLab");
        setPreferredSize(new Dimension(400,110));
        setLayout(new BorderLayout());
        setUpPanels();
        setResizable(true);
        pack();
    }

    private void setUpPanels(){
        var abc = new Vector<Object>();
        for(char i = 'A'; i <= 'Z'; i++)
            abc.add(i);

        var topPanel = new JPanel();

        charComboBox = new JComboBox<Object>(abc);
        inputField = new JTextField(20);
        confirmButton = new JButton("Code!");
        confirmButton.addActionListener(new OkButtonActionListener());

        topPanel.add(charComboBox);
        topPanel.add(inputField);
        topPanel.add(confirmButton);
        add(topPanel, BorderLayout.NORTH);

        var botPanel = new JPanel(new BorderLayout());

        var label = new JLabel("Output:");
        outputField = new JTextField(20);
        outputField.setEditable(false);

        botPanel.add(label, BorderLayout.WEST);
        botPanel.add(outputField);
        add(botPanel);
    }

    class OkButtonActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            var result = Main.caesarCode(inputField.getText(), (char)charComboBox.getSelectedItem());
            outputField.setText(result);
        }
    }
}
