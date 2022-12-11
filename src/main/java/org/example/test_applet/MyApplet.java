package org.example.test_applet;

import java.awt.*;
import java.applet.*;

public class MyApplet extends Applet {
    Image image;
    AudioClip audioClip;
    Label Label1;
    Label Label2;
    Label Label3;
    Label Label4;
    Label Label5;
    Color curColor[] = {Color.yellow, Color.orange, Color.black, Color.red, Color.white};
    String ImageParam;
    Image myImage;

    public void init() {
        setLayout(null);
        setBackground(Color.gray);
        audioClip = getAudioClip(getCodeBase(), getParameter("sound"));
        audioClip.play();
        Label1 = new Label("First name: Artem");
        Label2 = new Label("Surname: Xryashev");
        Label5 = new Label("Age: 20 years old");
        Label3 = new Label("Study group: EIS-36");
        Label4 = new Label(new java.util.Date(System.currentTimeMillis()).toLocaleString());
        Label1.setFont(new Font("Arial", 0, 15));
        Label1.setForeground(Color.WHITE);
        Label1.setBounds(400, 0, 150, 30);
        add(Label1);
        Label2.setFont(new Font("Arial", 0, 15));
        Label2.setForeground(Color.YELLOW);
        Label2.setBounds(400, 35, 150, 30);
        add(Label2);
        Label5.setFont(new Font("Arial", 0, 15));
        Label5.setForeground(Color.ORANGE);
        Label5.setBounds(400, 70, 150, 30);
        add(Label5);
        Label3.setFont(new Font("Arial", 0, 15));
        Label3.setForeground(Color.RED);
        Label3.setBounds(400, 105, 150, 30);
        add(Label3);
        Label4.setFont(new Font("Arial", 0, 15));
        Label4.setForeground(Color.BLACK);
        Label4.setBounds(400, 140, 150, 30);
        add(Label4);

        ImageParam = getParameter("image");
        myImage = getImage(getDocumentBase(), ImageParam);
    }

    public void paint(Graphics g) {
        g.drawImage(myImage, 200, 0, 100, 200,this);
    }
}
