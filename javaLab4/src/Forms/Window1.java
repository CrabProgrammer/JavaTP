package Forms;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Window1 extends JFrame
{
    private JButton button1;
    private JTextField textField1;
    private JTextField textField2;
    public Window1()
    {
        Container container = getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        textField1 = new JTextField("Hello");
        textField1.setPreferredSize(new Dimension(200, 65));
        textField1.setAlignmentX(Component.LEFT_ALIGNMENT);
        container.add(textField1);
        container.add(Box.createVerticalStrut(2));
        textField2 = new JTextField("World!");
        textField2.setPreferredSize(new Dimension(200, 65));
        textField2.setAlignmentX(Component.LEFT_ALIGNMENT);
        container.add(textField2);
        container.add(Box.createVerticalStrut(2));
        button1 = new JButton("Press");
        button1.setMaximumSize(new Dimension(10000, 10000));
        button1.setPreferredSize(new Dimension(200, 65));
        container.add(button1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}