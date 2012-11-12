/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Andrew Hackler
 */
public class Calculator extends JPanel {

    final JButton[][] mainButtons;
    final JButton[] editButtons;
    final JPanel mainPanel;
    final JPanel editPanel;
    final JTextArea resultsArea;
    int[][] table;
    
    public Calculator() {
        
        this.setLayout(new BorderLayout());
        table = new int[4][4];
        //LISTENER GOES HERE
        ActionListener numberListener = new NumberListener();
        ActionListener editListener = new EditListener();
        //INITIALIZE BUTTONS
        mainButtons = new JButton[4][4];
        
        //Main number button initialzation
        int ndx = 1;
        for (int n = 2; n >= 0; n--){
            for (int m = 0; m < 3; m++){
                mainButtons[n][m] = new JButton("" + ndx);
                mainButtons[n][m].addActionListener(numberListener);
                table[n][m] = ndx;
                ndx++;
            }
        }
        mainButtons[0][3] = new JButton("+");
        mainButtons[1][3] = new JButton("-");
        mainButtons[2][3] = new JButton("*");
        mainButtons[3][3] = new JButton("/");
        mainButtons[3][0] = new JButton("=");
        mainButtons[3][1] = new JButton("0");
        mainButtons[3][2] = new JButton(".");
        
        mainButtons[3][1].addActionListener(numberListener);
        table[3][1] = 0;
        
        editButtons = new JButton[2];
        editButtons[0] = new JButton("C");
        editButtons[1] = new JButton("CE");
        
        editButtons[0].addActionListener(editListener);
        editButtons[1].addActionListener(editListener);
        
        //INITIALIZE GRID PANEL
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4,4));
        for (int n = 0; n < 4; n++){
            for (int m = 0; m < 4; m++){
                mainPanel.add(mainButtons[n][m]);
            }
        }
        this.add(mainPanel,BorderLayout.CENTER);
        
        editPanel = new JPanel();
        editPanel.add(editButtons[0]);
        editPanel.add(editButtons[1]);
        this.add(editPanel,BorderLayout.SOUTH);
        
        resultsArea = new JTextArea("0");
        resultsArea.setEditable(false);
        this.add(resultsArea,BorderLayout.NORTH);
        
        //
    }
    class NumberListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
             for (int n = 2; n >= 0; n--){
                 for (int m = 0; m < 3; m++){
                     if(mainButtons[n][m] == (JButton)event.getSource()
                             && !"0".equals(resultsArea.getText())){
                         resultsArea.append("" + table[n][m]);
                     }
                     else if (mainButtons[n][m] == (JButton)event.getSource())
                         resultsArea.setText("" + table[n][m]);
                 }
             }
             if(mainButtons[3][1] == (JButton)event.getSource()
                     && !"0".equals(resultsArea.getText())){
                 resultsArea.append("" + table[3][1]);}
        }
        
    }
    
    class EditListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            
            if(editButtons[0] == (JButton)event.getSource()){
                resultsArea.setText("0");
            }
            if(editButtons[1] == (JButton)event.getSource()){
                resultsArea.setText("0");
            }
        }
    }
    
    class FunctionListener implements ActionListener {
        
        double input;
        
        @Override
        public void actionPerformed(ActionEvent event){
            if(mainButtons[0][3] == (JButton)event.getSource()){
                
            }
            if(mainButtons[1][3] == (JButton)event.getSource()){
                
            }
            if(mainButtons[2][3] == (JButton)event.getSource()){
                
            }
            if(mainButtons[3][3] == (JButton)event.getSource()){
                
            }
            
        }
    }
    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        frame.setSize(300,300);
        frame.setTitle("Cal-Q-Later");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel calcApp = new Calculator();
        frame.add(calcApp);
        
        frame.setVisible(true);
    }
}
