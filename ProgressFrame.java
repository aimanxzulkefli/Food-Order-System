import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class ProgressFrame extends JFrame {

    JProgressBar progress1, progress2, progress3;

    ProgressFrame() {
        this.setTitle("Food-Dash");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(230, 300));
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        // Border left
        JPanel panelLeft = new JPanel();
        panelLeft.setBackground(new Color(51, 51, 51));
        panelLeft.setPreferredSize(new Dimension(10, 0));

        // Border right
        JPanel panelRight = new JPanel();
        panelRight.setBackground(new Color(51, 51, 51));
        panelRight.setPreferredSize(new Dimension(10, 0));

        // Border top
        JPanel panelTop = new JPanel();
        panelTop.setBackground(new Color(51, 51, 51));
        panelTop.setPreferredSize(new Dimension(0, 50));

        // Border bottom
        JPanel panelBottom = new JPanel();
        panelBottom.setBackground(new Color(51, 51, 51));
        panelBottom.setPreferredSize(new Dimension(0, 50));

        // Center panel
        JPanel panelMain = new JPanel();
        panelMain.setLayout(new GridLayout(0, 1, 0, 10));
        panelMain.setBackground(new Color(51, 51, 51));

        progress1 = new JProgressBar();
        progress1.setValue(0);
        progress1.setString("Ingredient");
        progress1.setBounds(0, 0, panelMain.getWidth(), 50);
        progress1.setStringPainted(true);
        panelMain.add(progress1);

        progress2 = new JProgressBar();
        progress2.setString("Cooking");
        progress2.setBounds(0, 0, panelMain.getWidth(), 50);
        progress2.setStringPainted(true);
        panelMain.add(progress2);

        progress3 = new JProgressBar();
        progress3.setString("Delivery");
        progress3.setBounds(0, 0, panelMain.getWidth(), 50);
        progress3.setStringPainted(true);
        panelMain.add(progress3);

        this.add(panelMain, BorderLayout.CENTER);
        this.add(panelTop, BorderLayout.NORTH);
        this.add(panelBottom, BorderLayout.SOUTH);
        this.add(panelLeft, BorderLayout.WEST);
        this.add(panelRight, BorderLayout.EAST);
        this.setVisible(true);

        progress();

    }

    public void progress() {

        int counter = 0;

        while (counter <= 100) {
            progress1.setValue(counter);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter += 10;
        }

        progress1.setForeground(Color.green);

        if (progress1.getValue() <= 100) {
            counter = 0;
            while (counter <= 100) {
                progress2.setValue(counter);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter += 10;
            }
        }

        progress2.setForeground(Color.green);

        if (progress2.getValue() <= 100) {
            counter = 0;
            while (counter <= 100) {
                progress3.setValue(counter);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter += 10;
            }
        }
        progress3.setForeground(Color.green);
    }
}