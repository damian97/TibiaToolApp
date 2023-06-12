package org.TibiaApp;

import javax.swing.*;

public class GUI extends JFrame {
    private final int WIDTH = 600;
    private final int HEIGHT = 400;
    private DefaultListModel<String> nickListModel;
    private String[] serverOptions = {
            "Worlds",
            "Adra", "Alumbra", "Antica", "Ardera", "Astera", "Axera", "Bastia", "Batabra", "Belobra", "Bombra",
            "Bona", "Cadebra", "Calmera", "Castela", "Celebra", "Celesta", "Collabra", "Damora", "Descubra", "Dia",
            "Dibra", "Epoca", "Esmera", "Etebra", "Famosa", "Fera", "Ferobra", "Firmera", "Gentebra", "Gladera",
            "Gravitera", "Harmonia", "Havera", "Honbra", "Illusera", "Impulsa", "Inabra", "Issobra", "Jacabra", "Kalibra",
            "Kardera", "Karna", "Libertabra", "Lobera", "Luminera", "Lutabra", "Marbera", "Marcia", "Menera", "Monza",
            "Mudabra", "Mykera", "Nadora", "Nefera", "Nossobra", "Ocebra", "Olima", "Ombra", "Optera", "Ousabra",
            "Pacera", "Peloria", "Premia", "Quelibra", "Quintera", "Refugia", "Reinobra", "Seanera", "Secura", "Serdebra",
            "Solidera", "Suna", "Syrena", "Talera", "Tembra", "Thyria", "Trona", "Utobra", "Venebra", "Versa",
            "Visabra", "Vitera", "Vunira", "Wintera", "Wizera", "Xandebra", "Yonabra", "Zenobra", "Zuna", "Zunera"
    };

    String[] checkBoxLabels = {"Wracks", "Banuta LF", "Walls", "Fury Oramond", "Glooth's",
            "Exotic cave/pirates", "Inq done", "Crit/Mana/HP (Power)", "Baby Rosh", "Checkbox 10"};

    public GUI() {
        super("Tibia Tool App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        nickListModel = new DefaultListModel<>();
        nickListModel.addElement("Nick1");
        nickListModel.addElement("Nick2");
        nickListModel.addElement("Nick3");
        nickListModel.addElement("Nick4");
        nickListModel.addElement("Nick5");

        JList<String> nickList = new JList<>(nickListModel);
        JScrollPane nickScrollPane = new JScrollPane(nickList);
        nickScrollPane.setBounds(10, 10, 175, HEIGHT - 55);

        JComboBox<String> serverComboBox = new JComboBox<>(serverOptions);
        serverComboBox.setBounds(200, 20, 135, 25);

        String[] vocationOptions = {"Vocations", "Druid", "Knight", "Paladin", "Sorcerer"};
        JComboBox<String> vocationComboBox = new JComboBox<>(vocationOptions);
        vocationComboBox.setBounds(345, 20, 115, 25);

        String[] skillOptions = {"Axe", "Club", "Sword", "Distance", "Magic"};
        JComboBox<String> skillComboBox = new JComboBox<>(skillOptions);
        skillComboBox.setBounds(470, 20, 100, 25);

        JLabel textFieldLabel1 = new JLabel("Lvl Range:");
        textFieldLabel1.setBounds(210, 60, 60, 25);
        JTextField lvlStart = new JTextField();
        lvlStart.setBounds(300, 60, 90, 25);

        JTextField lvlStop = new JTextField();
        lvlStop.setBounds(420, 60, 90, 25);

        JLabel textFieldLabel3 = new JLabel("Skill Range:");
        textFieldLabel3.setBounds(207, 90, 80, 25);
        JTextField skillStart = new JTextField();
        skillStart.setBounds(300, 90, 90, 25);

        JTextField skillStop = new JTextField();
        skillStop.setBounds(420, 90, 90, 25);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(250, 290, 150, 50);

        JCheckBox[] checkBoxes = new JCheckBox[checkBoxLabels.length];
        for (int i = 0; i < checkBoxLabels.length; i++) {
            checkBoxes[i] = new JCheckBox(checkBoxLabels[i]);
            checkBoxes[i].setBounds(240 + (i % 2) * 150, 125 + (i / 2) * 30, 150, 25);
            add(checkBoxes[i]);
        }

        add(nickScrollPane);
        add(serverComboBox);
        add(vocationComboBox);
        add(skillComboBox);
        add(textFieldLabel1);
        add(lvlStart);
        add(lvlStop);
        add(textFieldLabel3);
        add(skillStart);
        add(skillStop);
        add(searchButton);

        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}

