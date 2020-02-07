package P1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Box{
    boolean x=false;
    Box(){
        Frame f = new Frame();
        Dialog d = new Dialog(f, "Start", true);
        d.setLayout(new FlowLayout());
        d.setSize(100,100);
        Button b = new Button("Start First");
        b.setSize(100,100);
        b.setLocation(0,0);
        Button c = new Button("Cancel");
        c.setSize(100,100);
        c.setLocation(100,0);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                x=true;
                d.setVisible(false);
            }
        });
        c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                x = false;
                d.setVisible(false);
            }
        });
        d.add(b);
        d.add(c);
        d.setLocation(500, 160);
        d.setVisible(true);
    }
}