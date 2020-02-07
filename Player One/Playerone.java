package P1;

import java.io.*;
import java.net.*;

public class Playerone{
    static String send="-1",ab;
    static int server = -1, client = -1;
    public static void main(String args[]){
        try {
            Box b = new Box();
            if(b.x) {
                server = 1;
                ServerSocket serv = new ServerSocket(9000);
                Socket sock = serv.accept();
                Server ser = new Server();
                DataInputStream inp = new DataInputStream(new BufferedInputStream(sock.getInputStream()));
                DataOutputStream out = new DataOutputStream(sock.getOutputStream());
                String recv;
                while(true){
                    ab = send;
                    if(ab.equals("-1")){
                        continue;
                    }
                    out.writeUTF(ab);
                    out.flush();
                    ser.count++;
                    if(ser.count==9){
                        System.out.println("DRAW!!");
                        new Verdict('d');
                        System.exit(0);
                    }
                    if(ser.check()){
                        System.exit(0);
                    }
                    send="-1";
                    recv = inp.readUTF();
                    ser.set(recv);
                    ser.count++;
                    if(ser.count==9){
                        System.out.println("DRAW!!");
                        System.exit(0);
                    }
                    if(ser.check()){
                        System.exit(0);
                    }
                }
            }
            else {
                client = 1;
                Client cli = new Client();
                Socket sock = new Socket("192.168.128.248", 9000);
                DataInputStream inp = new DataInputStream(new BufferedInputStream(sock.getInputStream()));
                DataOutputStream out = new DataOutputStream(sock.getOutputStream());
                String recv;
                while (true) {
                    recv = inp.readUTF();
                    cli.set(recv);
                    cli.count++;
                    if (cli.count == 9) {
                        System.out.println("DRAW!!");
                        new Verdict('d');
                        System.exit(0);
                    }
                    if (cli.check()) {
                        System.exit(0);
                    }
                    while (true) {
                        ab = send;
                        if (!ab.equals("-1")) {
                            break;
                        }
                    }
                    out.writeUTF(ab);
                    out.flush();
                    cli.count++;
                    if (cli.count == 9) {
                        System.out.println("DRAW!!");
                        new Verdict('d');
                        System.exit(0);
                    }
                    send = "-1";
                    if (cli.check()) {
                        System.exit(0);
                    }
                }
            }
        }
        catch (Exception e){
            System.out.println("Could not connect to Player 2!!");
        }
    }
}

