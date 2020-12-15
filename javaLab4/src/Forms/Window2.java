package Forms;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Window2 extends JFrame
{
    private JLabel label1;
    private JTextField textField1;
    private JButton but1;
    private JCheckBox checkBox1;

    public Window2()
    {
        Container container = getContentPane();
        container.setLayout(new GridLayout(2, 2, 5, 5));
        label1 = new JLabel("Enter name:");
        container.add(label1);
        textField1 = new JTextField("John snow");
        container.add(textField1);
        but1 = new JButton("All done");
        container.add(but1);
        checkBox1 = new JCheckBox("Are you agree?");
        container.add(checkBox1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}