package org.TibiaApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        GUI gui = new GUI();

        gui.searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.addCharacter("Dupa", "adsad");
                Searcher searcher = new Searcher(gui.getServerComboBox(), gui.getVocationComboBox(), gui.getSkillComboBox(), gui.getLvlStart(), gui.getLvlStop(), gui.getSkillStart(), gui.getSkillStop());
                System.out.println(searcher.toString());
            }
        });

    }
}