package org.example.test_applet;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class ListEx extends JApplet {
    String[] bikes = {"Honda Activa", "Honda Aviator", "Honda CB Shine", "Honda CB Trigger", "Honda CB Twister", "Honda CB Unicorn", "Honda CB Unicorn Dazzler",
            "Honda CBF Stunner", "Honda CBR 1000RR", "Honda CBR150R", "Honda CB1000R", "Honda CBR250R", "Honda Dio"};
    DefaultListModel ListModel = new DefaultListModel();
    JList list = new JList(ListModel);
    JTextArea textarea = new JTextArea(bikes.length, 20);
    JButton button = new JButton("Add More bikes");
    ActionListener Action = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (count < bikes.length) {
                ListModel.add(0, bikes[count++]);
            } else {
                button.setEnabled(false);
            }
        }
    };
    ListSelectionListener ListSelection = e -> {
        textarea.setText("");
        Object[] items = list.getSelectedValues();
        for (int i = 0; i < items.length; i++)
            textarea.append(items[i] + "\n");
    };
    int count = 0;

    public void init() {
        Container cont = getContentPane();
        textarea.setEditable(false);
        cont.setLayout(new FlowLayout());
        Border brd = BorderFactory.createMatteBorder(1, 1, 2, 2, Color.black);
        list.setBorder(brd);
        textarea.setBorder(brd);
        for (int i = 0; i < 4; i++)
            ListModel.addElement(bikes[count++]);
        cont.add(textarea);
        cont.add(list);
        cont.add(button);
        list.addListSelectionListener(ListSelection);
        button.addActionListener(Action);
    }
}
