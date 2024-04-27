package org.example;

import org.example.GUI.Controller;
import org.example.GUI.View;
import org.example.Logic.Operatii;

public class Main {
    public static void main(String[] args) {
        Operatii o =new Operatii();
        View view =new View(o);
        Controller c= new Controller(o,view);

        view.setVisible(true);
    }
}