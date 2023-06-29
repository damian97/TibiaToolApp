package org.TibiaApp;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI extends JFrame {
    private final int WIDTH = 600;
    private final int HEIGHT = 400;
    private int charsIndex;

    private JTextField lvlStart, lvlStop;
    private JTextField skillStart, skillStop;

    JButton searchButton;
    private DefaultListModel<String> nickListModel;
    private JComboBox<String> serverComboBox;
    private JComboBox<String> vocationComboBox;
    private JComboBox<String> skillComboBox;
    protected String[] serverOptions = {
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

    private String[] checkBoxLabels = {"Wracks", "Banuta LF", "Walls", "Fury Oramond", "Glooth's",
            "Exotic cave/pirates", "Inq done", "Crit/Mana/HP (Power)", "Baby Rosh", "Checkbox 10"};

    public GUI() {
        super("Tibia Tool App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        charsIndex = 0;

        nickListModel = new DefaultListModel<>();
//        addCharacter("Nick11" , "tibia.com");
//        addCharacter("Nick1" , "tibia.com");

        JList<String> nickList = new JList<>(nickListModel);
        JScrollPane nickScrollPane = new JScrollPane(nickList);
        nickScrollPane.setBounds(10, 10, 175, HEIGHT - 55);

        serverComboBox = new JComboBox<>(serverOptions);
        serverComboBox.setBounds(200, 20, 135, 25);

        String[] vocationOptions = {"Vocations", "Druid", "Knight", "Paladin", "Sorcerer"};
        vocationComboBox = new JComboBox<>(vocationOptions);
        vocationComboBox.setBounds(345, 20, 115, 25);

        String[] skillOptions = {"Skill", "Axe", "Club", "Sword", "Distance", "Magic"};
        skillComboBox = new JComboBox<>(skillOptions);
        skillComboBox.setBounds(470, 20, 100, 25);

        JLabel textFieldLabel1 = new JLabel("Lvl Range:");
        textFieldLabel1.setBounds(210, 60, 60, 25);
        lvlStart = new JTextField();
        lvlStart.setBounds(300, 60, 90, 25);

        JLabel textFieldLabel5 = new JLabel("--");
        textFieldLabel5.setBounds(400, 60, 60, 25);

        JLabel textFieldLabel6 = new JLabel("--");
        textFieldLabel6.setBounds(400, 90, 60, 25);

        lvlStop = new JTextField();
        lvlStop.setBounds(420, 60, 90, 25);

        JLabel textFieldLabel3 = new JLabel("Skill Range:");
        textFieldLabel3.setBounds(207, 90, 80, 25);
        skillStart = new JTextField();
        skillStart.setBounds(300, 90, 90, 25);

        skillStop = new JTextField();
        skillStop.setBounds(420, 90, 90, 25);

        searchButton = new JButton("Search");
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
        add(textFieldLabel5);
        add(textFieldLabel6);
        add(skillStart);
        add(skillStop);
        add(searchButton);

        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void addCharacter(String nick, String link) {

        nickListModel.addElement(nick);
        System.out.println("Dodano postać o nicku: " + nick + " do listy. Index postaci: " + charsIndex++);
        System.out.println("Link do aukcji: " + link);

    }

    public void clearList() {
        nickListModel.clear();
    }

    public String getServerComboBox() {
        String serverName = (String)serverComboBox.getSelectedItem();
        assert serverName != null;
        if (serverName.equals("Worlds")) {
            return "";
        } else {
            return serverName;
        }
    }

    public int getVocationComboBox() {
        int vocIndex = vocationComboBox.getSelectedIndex();
        if (vocIndex > 0) {
            vocIndex++;
        }
        return vocIndex;
    }

    public int getSkillComboBox() {
        switch (skillComboBox.getSelectedIndex()) {
            case 1 :
                return 10;
            case 2 :
                return 9;
            case 3 :
                return 8;
            case 4 :
                return 7;
            case 5 :
                return 1;
            default:
                return 0;
        }
    }


    public int getLvlStart() {
        if (lvlStart.getText().equals("")) {
            return 0;
        }
        return Integer.parseInt(lvlStart.getText());
    }

    public int getLvlStop() {
        if (lvlStop.getText().equals("")) {
            return 0;
        }
        return Integer.parseInt(lvlStop.getText());
    }

    public int getSkillStart() {
        if (skillStart.getText().equals("")) {
            return 0;
        }
        return Integer.parseInt(skillStart.getText());
    }

    public int getSkillStop() {
        if (skillStop.getText().equals("")) {
            return 0;
        }
        return Integer.parseInt(skillStop.getText());
    }


}

