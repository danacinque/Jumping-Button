// here's a comment
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class myJPanel extends JPanel implements ActionListener
{

    JButton score;
    JButton clickMe;
    JButton start;
    Timer timer;
    Point clickMeLocation;
    int timerDelay;
    Integer currentScore;
    
    public myJPanel()
    {
        super();
        
        start = new JButton("Start");
        start.addActionListener(this);
        add(start);
        
        clickMe = new JButton("Click Me");
        clickMe.addActionListener(this);
        add(clickMe);
        clickMe.setVisible(false);
        
        currentScore = 0;
        score = new JButton("Score");
        add(score);
        
        timerDelay = 2000;
        timer = new Timer(timerDelay, this);
        
        
    }
    
    public void updateScore()
    {
        Integer currentScore = Integer.parseInt(score.getText());
        currentScore++;
        score.setText(currentScore.toString());
    }
    
    public int updateDelay()
    {
        timerDelay -= 500;
        return timerDelay;
    }
    
    public void actionPerformed(ActionEvent event) throws IllegalArgumentException
    {
        Object obj = event.getSource();
        
        
        if (obj == start)
        {
            clickMe.setVisible(true);
            score.setText("0");
            timer.start();
            start.setVisible(false);
        }

        if (obj == timer)
        {
            int newX = (int) (Math.random() * this.getWidth());
            int newY = (int) (Math.random() * this.getHeight());
            clickMe.setLocation(newX, newY);
        }
        
        if (obj == clickMe)
        {
            try 
            {
                updateScore();
                timer.setDelay(updateDelay());
            }
            catch (Exception e)
            {
                System.out.println("Delay has reached 0");
            }
        }
        
    }
}
