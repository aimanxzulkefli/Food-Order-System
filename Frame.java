
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Frame extends JFrame{

    ButtonGroup group;
    JRadioButton pizza, burger, sandwish, cake;
    String food;

    Connection con;
    PreparedStatement ps;
    
    Frame(){
        this.setTitle("Food-Dash");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(230, 300));
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        // Border left
        JPanel panelLeft = new JPanel();
        panelLeft.setBackground(new Color(51, 51, 51));
        panelLeft.setPreferredSize(new Dimension(10,0));

        // Border right 
        JPanel panelRight = new JPanel();
        panelRight.setBackground(new Color(51, 51, 51));
        panelRight.setPreferredSize(new Dimension(10,0));

        // Title of page
        JPanel panelTop = new JPanel();
        panelTop.setBackground(new Color(51, 51, 51));
        panelTop.setPreferredSize(new Dimension(0,50));
        
        JLabel labelHeader = new JLabel();
        labelHeader.setText("Welcome to Food-Dash");
        labelHeader.setForeground(Color.white);
        labelHeader.setFont(new Font("Sans Serif", Font.BOLD, 18));
        panelTop.add(labelHeader);

        // Main function, display menu
        pizza = new JRadioButton("Pineapple Pizza"); 
        burger = new JRadioButton("Salad Burger");
        sandwish = new JRadioButton("Beef Sandwish");
        cake = new JRadioButton("Banana Cake");
        group = new ButtonGroup();
        group.add(pizza);
        group.add(burger);
        group.add(sandwish);
        group.add(cake);

        JPanel panelMain = new JPanel();
        panelMain.setBackground(new Color(51, 51, 51));
        panelMain.setLayout(new GridLayout(0,1));
        panelMain.add(pizza);
        panelMain.add(burger);
        panelMain.add(sandwish);
        panelMain.add(cake);

        // Submit button
        JPanel panelBottom = new JPanel();
        panelBottom.setBackground(new Color(51, 51, 51));
        panelBottom.setPreferredSize(new Dimension(0,50));
        panelBottom.setLayout(new FlowLayout());
        JButton submit = new JButton("Submit");
        submit.setSize(20, 30);
        submit.setFocusable(false);
        panelBottom.add(submit);
        submit.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                buttonClick(e);
            }

        }); 
        
        this.add(panelMain, BorderLayout.CENTER);
        this.add(panelTop, BorderLayout.NORTH);
        this.add(panelBottom, BorderLayout.SOUTH);
        this.add(panelLeft, BorderLayout.WEST);
        this.add(panelRight, BorderLayout.EAST);
        this.setVisible(true);
    }

    private void buttonClick(ActionEvent e) {

        if(pizza.isSelected()){
            food = pizza.getText();
        }else if(burger.isSelected()){
            food = burger.getText();
        }else if(sandwish.isSelected()){
            food = sandwish.getText();
        }else if(cake.isSelected()){
            food = cake.getText();
        }
        
        inputQuantityF(food);
    }

    private void inputQuantityF(String food) {
        this.dispose();
        InputQuantityFrame iqf = new InputQuantityFrame(food, con, ps);
        iqf.setVisible(true);
    }
}