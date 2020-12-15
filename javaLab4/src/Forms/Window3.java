package Forms;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Window3 extends JFrame
{
    private JLabel label1;
    private JTextArea text1;
    private JButton button1;

    public Window3()
    {
        Container container = getContentPane();
        container.setLayout(new GridLayout(2, 2, 5, 5));
        label1 = new JLabel("Enter number:");
        container.add(label1);
        text1 = new JTextArea();
        text1.setBackground(Color.RED);
        container.add(text1);
        button1 = new JButton("Hide field");
        button1.addActionListener(new ButtonListen());
        container.add(button1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    class ButtonListen implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (text1.isVisible())
            {
                text1.setVisible(false);
                button1.setText("Show field");
            }
            else
            {
                text1.setVisible(true);
                button1.setText("Hide field");
            }
        }
    }
}