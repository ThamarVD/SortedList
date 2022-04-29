import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;

public class SortedGUI extends JFrame {
    JPanel mainPanel;
    SortedList listSort;
    public SortedGUI(){
        mainPanel = new JPanel();
        listSort = new SortedList();
        mainPanel.setLayout(new BorderLayout());

        createUserPanel();
        createTextPanel();
        mainPanel.add(userPanel, BorderLayout.NORTH);
        mainPanel.add(textPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setSize(450, 325);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    JPanel userPanel;
    JTextField strFld;
    JButton addBtn;
    JButton searchBtn;
    private void createUserPanel(){
        userPanel = new JPanel();
        strFld = new JTextField(20);
        strFld.addActionListener(e -> addString());
        addBtn = new JButton("Add String");
        addBtn.addActionListener(e -> addString());
        searchBtn = new JButton("Search");
        searchBtn.addActionListener(e -> searchString());
        userPanel.add(strFld);
        userPanel.add(addBtn);
        userPanel.add(searchBtn);
    }

    JPanel textPanel;
    JTextArea stringArea;
    JScrollPane stringPane;
    private void createTextPanel(){
        textPanel = new JPanel();
        stringArea = new JTextArea(15, 35);
        stringPane = new JScrollPane(stringArea);
        textPanel.add(stringPane);
    }

    private void searchString(){
        int stringIdx= listSort.findIdx(strFld.getText(), 0, listSort.getSortedArray().size()-1);
        if(stringIdx != -1){
            JOptionPane.showMessageDialog(this, "Your search was should be found at index " + stringIdx);
        }
    }

    private void addString(){
        listSort.add(strFld.getText());
        stringArea.setText("");
        for(String str : listSort.getSortedArray())
            stringArea.append(str + "\n");
    }
}
