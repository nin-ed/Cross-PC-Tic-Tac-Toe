package P1;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

class Verdict {
    Verdict(char v){
        Frame f = new Frame();
        Dialog d = new Dialog(f, "Verdict", true);
        d.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        d.setLayout(new FlowLayout());
        d.setSize(100, 100);
        d.setLocation(500, 160);
        if(v=='w') {
            d.add(new Label("You Won!!"));
        }
        else if(v=='l') {
            d.add(new Label("You Lose!!"));
        }
        else{
            d.add(new Label("Oops!! That was a draw!!"));
        }
        d.setVisible(true);
    }
}
