package Forms;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Window4 extends JFrame
{
    private JTextArea text1;
    private JButton button1;

    public Window4()
    {
        Container container = getContentPane();
        container.setLayout(new GridLayout(1, 2, 5, 5));

        text1 = new JTextArea();
        container.add(text1);
        button1 = new JButton("Show");
        button1.addActionListener(new ButtonListener());
        container.add(button1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String textStr = text1.getText();
            if (!textStr.equals(""))
            {
                JOptionPane.showMessageDialog(
                        new JFrame(),
                        textStr,
                        "Info",
                        JOptionPane.DEFAULT_OPTION
                );
            }
        }
    }
}