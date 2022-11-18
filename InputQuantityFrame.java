import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputQuantityFrame extends JFrame{

    InputQuantityFrame(String food, Connection con, PreparedStatement ps){
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

        // Border top
        JPanel panelTop = new JPanel();
        panelTop.setBackground(new Color(51, 51, 51));
        panelTop.setPreferredSize(new Dimension(0,50));

        // Border bottom
        JPanel panelBottom = new JPanel();
        panelBottom.setBackground(new Color(51, 51, 51));
        panelBottom.setPreferredSize(new Dimension(0,80));
        panelBottom.setLayout(new FlowLayout());

        // Center panel
        JPanel panelMain = new JPanel();
        panelMain.setLayout(new BorderLayout());

        // Inside center
        JPanel topMain = new JPanel();
        topMain.setBackground(new Color(51, 51, 51));
        topMain.setPreferredSize(new Dimension(0,60));
        JLabel labelHeader = new JLabel();
        labelHeader.setText("Set a quantity");
        labelHeader.setForeground(Color.white);
        labelHeader.setFont(new Font("Sans Serif", Font.PLAIN, 20));

        JPanel centerMain = new JPanel();
        centerMain.setBackground(new Color(51, 51, 51));
        centerMain.setLayout(new FlowLayout());
        JLabel labelFromMain = new JLabel(food);
        labelFromMain.setText(food);
        labelFromMain.setForeground(Color.white);
        labelFromMain.setFont(new Font("Sans Serif", Font.PLAIN, 17));
        JTextField quantityfield = new JTextField();
        quantityfield.setPreferredSize(new Dimension(30,30));

        panelMain.add(topMain, BorderLayout.NORTH);
        topMain.add(labelHeader);
        panelMain.add(centerMain, BorderLayout.CENTER);
        centerMain.add(labelFromMain);
        centerMain.add(quantityfield);

        JButton submit = new JButton("Submit");
        submit.setSize(20, 30);
        submit.setFocusable(false);
        panelBottom.add(submit);
        submit.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                buttonClick(e, quantityfield, food);
            }

        });

        this.add(panelMain, BorderLayout.CENTER);
        this.add(panelTop, BorderLayout.NORTH);
        this.add(panelBottom, BorderLayout.SOUTH);
        this.add(panelLeft, BorderLayout.WEST);
        this.add(panelRight, BorderLayout.EAST);
        this.setVisible(true);
    }

    protected void buttonClick(ActionEvent e, JTextField quantityfield, String food) {

        String q = quantityfield.getText();

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Rukiah\\OneDrive\\Documents\\FoodOrder.accdb", null, null);
            PreparedStatement ps = con.prepareStatement("Insert into FoodOrder(Foods,Quantity)values (?,?)");
            ps.setString(1,food);
            ps.setString(2,q);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record Added");
        } catch (ClassNotFoundException e1) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null,e1);
            JOptionPane.showMessageDialog(this, e1);
        } catch (SQLException e1) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null,e1);
            JOptionPane.showMessageDialog(this, e1);
        }

        process();
    }

    private void process() {
        this.dispose();
        ProgressFrame pf = new ProgressFrame();
        pf.setVisible(true);
    }
}