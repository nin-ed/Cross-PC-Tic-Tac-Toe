package P1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Server extends Frame {
    private Button[] but = new Button[9];
    protected int count;
    Server() {
        count=0;
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        if(Playerone.server==1) {
            setTitle("Player 1");
        }
        setLocation(500,160);
        setSize(310,330);
        intializeButtons();
        if(check()){
            System.exit(0);
        }
        setLayout(null);
        setVisible(true);
    }
    private void intializeButtons(){
        int k=0;
        for(int i=0;i<300;i+=100){
            for(int j=0;j<300;j+=100){
                but[k] = new Button("-");
                but[k].setFont(new Font("Times New Roman", Font.PLAIN, 20));
                but[k].addActionListener(this::action);
                but[k].setBounds(i+5,j+25,100,100);
                add(but[k]);
                k++;
            }
        }
    }
    private void action(ActionEvent e){
        if(Playerone.server==1) {
            Playerone p = new Playerone();
            for(int i=0;i<9;i++){
                if(e.getSource()==but[i]){
                    if(!but[i].getLabel().equals("O") && count%2==0) {
                        but[i].setLabel("X");
                        p.send=Integer.toString(i);
                    }
                }
            }
        }
    }
    protected void set(String s){
        int i = Integer.parseInt(s);
        if(i>=0 && i<=9) {
            if (!but[i].getLabel().equals("X")) {
                but[i].setLabel("O");
            }
        }
    }
    protected boolean check(){
        if((but[0].getLabel().equals("X") && but[0].getLabel().equals(but[4].getLabel()) && but[4].getLabel().equals(but[8].getLabel())) ||
                (but[2].getLabel().equals("X") && but[2].getLabel().equals(but[4].getLabel()) && but[4].getLabel().equals(but[6].getLabel())) ||
                (but[0].getLabel().equals("X") && but[0].getLabel().equals(but[1].getLabel()) && but[1].getLabel().equals(but[2].getLabel())) ||
                (but[3].getLabel().equals("X") && but[3].getLabel().equals(but[4].getLabel()) && but[4].getLabel().equals(but[5].getLabel())) ||
                (but[6].getLabel().equals("X") && but[6].getLabel().equals(but[7].getLabel()) && but[7].getLabel().equals(but[8].getLabel())) ||
                (but[0].getLabel().equals("X") && but[0].getLabel().equals(but[3].getLabel()) && but[3].getLabel().equals(but[6].getLabel())) ||
                (but[1].getLabel().equals("X") && but[1].getLabel().equals(but[4].getLabel()) && but[4].getLabel().equals(but[7].getLabel())) ||
                (but[2].getLabel().equals("X") && but[2].getLabel().equals(but[5].getLabel()) && but[5].getLabel().equals(but[8].getLabel()))){
            if(Playerone.server==1) {
                System.out.println("Player 1 Won!!");
                new Verdict('w');
            }
            return true;
        }
        else if((but[0].getLabel().equals("O") && but[0].getLabel().equals(but[4].getLabel()) && but[4].getLabel().equals(but[8].getLabel())) ||
                (but[2].getLabel().equals("O") && but[2].getLabel().equals(but[4].getLabel()) && but[4].getLabel().equals(but[6].getLabel())) ||
                (but[0].getLabel().equals("O") && but[0].getLabel().equals(but[1].getLabel()) && but[1].getLabel().equals(but[2].getLabel())) ||
                (but[3].getLabel().equals("O") && but[3].getLabel().equals(but[4].getLabel()) && but[4].getLabel().equals(but[5].getLabel())) ||
                (but[6].getLabel().equals("O") && but[6].getLabel().equals(but[7].getLabel()) && but[7].getLabel().equals(but[8].getLabel())) ||
                (but[0].getLabel().equals("O") && but[0].getLabel().equals(but[3].getLabel()) && but[3].getLabel().equals(but[6].getLabel())) ||
                (but[1].getLabel().equals("O") && but[1].getLabel().equals(but[4].getLabel()) && but[4].getLabel().equals(but[7].getLabel())) ||
                (but[2].getLabel().equals("O") && but[2].getLabel().equals(but[5].getLabel()) && but[5].getLabel().equals(but[8].getLabel()))){
            if(Playerone.server==1) {
                System.out.println("Player 2 Won!!");
                new Verdict('l');
            }
            return true;
        }
        return false;
    }
}
