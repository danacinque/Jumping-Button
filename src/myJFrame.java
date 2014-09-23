
import java.awt.*;
import javax.swing.*;

public class myJFrame extends JFrame
{
    public myJFrame(int width, int height)
    {
        super("Student Game");
        myJPanel mjp = new myJPanel();
        getContentPane().add(mjp, "Center");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(width, height);
        setVisible(true);
    }
}
