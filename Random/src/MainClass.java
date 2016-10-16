import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainClass extends JPanel {

  public void paint(Graphics g) {
    Dimension d = this.getPreferredSize();
    int fontSize = 20;

    g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
     
    g.setColor(Color.red);
    
    g.drawString("www.java2s.com", 15, 20);
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.getContentPane().add(new MainClass());

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200,200);
    frame.setVisible(true);
  }
}