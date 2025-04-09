import java.applet.Applet;
import java.awt.*;
import java.util.Date;

public class DigitalClock extends Applet implements Runnable {
    Thread t;
    String time;

    public void init() {
        setBackground(Color.black);
        setForeground(Color.green);
        t = new Thread(this);
        t.start();
    }

    public void run() {
        while (true) {
            repaint();
            try {
                Thread.sleep(1000); // Update every second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paint(Graphics g) {
        Date d = new Date();
        time = d.toString().substring(11, 19); // Extract HH:MM:SS
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString(time, 50, 50);
    }
}
