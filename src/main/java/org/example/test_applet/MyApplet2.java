package org.example.test_applet;

import java.awt.*;
import java.applet.*;
import java.util.*;

public class MyApplet2 extends Applet {
    int sizeStep = 3;
    int Y = sizeStep + 5;
    int widthMain;
    int widthFigure;
    int heightFigure;
    int[] percents;
    String[] per;

    Color[] color = {Color.RED, Color.GREEN, Color.CYAN, Color.yellow, Color.pink, Color.blue, Color.orange};

    public void init() {
// начальные действия, обычно выполняемые в конструкторе и методе main()

        widthMain = getSize().width - sizeStep * 2;
        widthFigure = (getSize().width / 100) * 8;
    }

    public void paint(Graphics g) { // рисует компонент на экране
        g.setColor(Color.black);
        g.fillRect(sizeStep, sizeStep, widthMain, 5);

        StringTokenizer ST = new StringTokenizer(getParameter("data"), "|");  //создает объект, готовый разбить строку str на слова
        percents = new int[ST.countTokens()]; // число оставшихся слов в строке
        int i = 0;
        while (ST.hasMoreTokens())  // получаем слово и что-нибудь делаем с ним
        {
            percents[i] = Integer.parseInt(ST.nextToken()); // String nextToken  позволяет "на ходу" менять разделители
            i++;
        }

        StringTokenizer ST2 = new StringTokenizer(getParameter("data"), "|");
        per = new String[ST2.countTokens()];
        int k = 0;
        while (ST2.hasMoreTokens()) {
            per[k] = ST2.nextToken();
            k++;
        }

        int X = (getSize().width / 100) * sizeStep;
        for (int j = 0; j < i; j++) {
            g.setColor(color[j]);
            heightFigure = (getSize().height * percents[j]) / 100;
            g.fillRect(X, Y, widthFigure, heightFigure); // выводит закрашенный прямоугольник
            g.setColor(Color.black);
            g.drawString(per[j], X + (widthFigure / 2) - 7, ((Y + heightFigure) / 2)); // вывод строки
            X += (widthFigure + ((getSize().width / 100) * sizeStep));
        }
    }
}
