package org.example.test_applet;

import java.applet.Applet;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class MyApplet3 extends Applet{

    Label label;
    TextField text;
    Button But;
    int i = 0;
    public void init()
    {
        JPanel Wpanel = new JPanel(); //содержит But
        Wpanel.setLayout(new BorderLayout()); // расположения компонентов
        Wpanel.setBackground(Color.WHITE);
        label =  new Label("Label");
        Wpanel.add(label,BorderLayout.NORTH);
        text = new TextField(" ", 8);
        text.setBackground(Color.WHITE);
        Wpanel.add(text);//,BorderLayout.SOUTH);
        JPanel Epanel = new JPanel();
        Epanel.setLayout(new BorderLayout());
        setLayout(new BorderLayout());
        But = new Button("Click");
        But.setForeground(Color.BLACK);
        add(But,BorderLayout.NORTH);
        add(Wpanel);
        add(Epanel,BorderLayout.EAST);
    }


    public boolean action(Event evt,  Object obj)
    {
        Button btn;
        String str1, str2="", str3;
        if(evt.target instanceof Button) // проверяем, вызвано ли это событие нашей кнопкой
        {

            if(evt.target.equals(But))
            {

                btn = (Button)evt.target;

                str1 = text.getText();
                label.setText(str2);
                for(int k=0;k<str1.length();k++)
                {
                    label.setText(label.getText()+str1.substring(k, k+1)+" ");
                }
                i++;

            }
            else
            {
                return false;
            }
            return true;
        }
        else if(evt.target instanceof Choice)
        {
        }
        return false;
    }
}

