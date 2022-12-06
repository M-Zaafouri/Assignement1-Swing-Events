package gui_swing_events;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public class SwingEventWindow extends JFrame implements ActionListener, ItemListener {

    private int rdoChecked = 1; // it has to be checked

    private JPanel mainPanel = new JPanel();
    private JPanel pnl1 = new JPanel(); // lblMain
    private JPanel pnl2 = new JPanel(); // lblRequest
    private JPanel pnl3 = new JPanel(); // txtNum
    private JPanel pnl4 = new JPanel(); // 4 radio buttons
    private JPanel pnl5 = new JPanel(); // claculate button
    private JPanel pnl6 = new JPanel(); // result label and result output textfield

    private JLabel title = new JLabel("Excel Functions",JLabel.CENTER);                         // title == lblMain
    private JLabel text1 = new JLabel("Enter your numbers separated by spaces:  ",JLabel.LEFT); // text1 == lblRequest 
    private JLabel result = new JLabel("Result:");                                              // result == lblResult

    private JRadioButton rdo1 = new JRadioButton("AutoSum", true);
    private JRadioButton rdo2 = new JRadioButton("Average");
    private JRadioButton rdo3 = new JRadioButton("Max");
    private JRadioButton rdo4 = new JRadioButton("Min");

    private JButton calculate = new JButton("Calculate");   // calculate = btn

    private JTextField input = new JTextField(15);      // input == txtNum
    private JTextField resultOutput = new JTextField(15);         // resultOutput == txtResult

    private ButtonGroup btnGroup = new ButtonGroup(); // btnGroup == functions

    // Style :
    private Color LightBlue = new Color(185,242,227,100);
    private Color LighterBlue = new Color(185,242,227,5);
    private Color DarkBlue = new Color(137,191,255,100);

    public SwingEventWindow(){

        // Creating the frame/window
        super("Excel Formulas Window"); // fonctionne pas je crois 
        JFrame window = new JFrame();
        window.setSize(300, 300);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Grouping the JRadioButton
        btnGroup.add(rdo1);
        btnGroup.add(rdo2);
        btnGroup.add(rdo3);
        btnGroup.add(rdo4);

        // Adding the components to the different panels 
        pnl1.add(title);
        pnl1.setBackground(LighterBlue);

        pnl2.add(text1);
        pnl2.setBackground(LighterBlue);

        pnl3.add(input);
        pnl3.setBackground(LighterBlue);

        pnl4.add(rdo1);
        pnl4.add(rdo2);
        pnl4.add(rdo3);
        pnl4.add(rdo4);
        pnl4.setBackground(LighterBlue);

        pnl5.add(calculate);
        pnl5.setBackground(LighterBlue);

        pnl6.add(result);
        pnl6.add(resultOutput);
        pnl6.setBackground(DarkBlue);

        // Then we add each sub panel (pnl1, pnl2,..., pnl6) to the main panel mainPanel
        mainPanel.add(pnl1);
        mainPanel.add(pnl2);
        mainPanel.add(pnl3);
        mainPanel.add(pnl4);
        mainPanel.add(pnl5);
        mainPanel.add(pnl6);

        mainPanel.setBackground(LightBlue);

        // Finally, we add the mainPanel to the frame / window
        window.getContentPane().add(mainPanel);

        // Adding/attaching the required Events to some components:
        /*
        * We need to add the required events to each radio button
        * and to the submit "Calculate" button only
        */
        rdo1.addItemListener(this); 
        rdo2.addItemListener(this);
        rdo3.addItemListener(this);
        rdo4.addItemListener(this);
        calculate.addActionListener(this);

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getItemSelectable() == rdo1){
            rdoChecked = 1;
        }else if(e.getItemSelectable() == rdo2){
            rdoChecked = 2;
        }else if(e.getSource() == rdo3){
            rdoChecked = 3;
        }else{
            rdoChecked = 4;
        }
        
    }

    public void actionPerformed(ActionEvent e){
        // take the user input and put it into a variable of type String
        String userInput = input.getText();
        System.out.println("User input " +userInput);
        Excel excelFunction = new Excel(userInput);
        double answer;
        if(rdoChecked == 1){
            // call the findTotal() method 
            // output/print the result (value) in the result's textfield
            answer = excelFunction.findTotal();
            resultOutput.setText(String.valueOf(answer));
            System.out.println(answer);
        }else if(rdoChecked == 2){
            answer = excelFunction.findAvg();
            resultOutput.setText(String.valueOf(answer));
        }else if(rdoChecked == 3){
            answer = excelFunction.findMax();
            resultOutput.setText(String.valueOf(answer));
        }else{
            answer = excelFunction.findMin();
            resultOutput.setText(String.valueOf(answer));
        }
        
    }


}

