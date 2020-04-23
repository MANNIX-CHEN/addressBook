package panel;

import dialog.Contacts;
import frame.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Meau extends JPanel {
    JLabel title= new JLabel("我是菜单");
    GridBagConstraints gMeau = new GridBagConstraints();
    MyFrame mainFrame ;

    public Meau(MyFrame mainFrame){
        this.mainFrame = mainFrame;
        this.init();
        setLayoutInGUI();//设置在主界面的排版
        layCom();//布置组件
        add(title);
    }

    private void layCom() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));

        addAdddContanctsBtn();//添加添加联系人按钮


        JButton searchContanctsBtn = new JButton("搜寻联系人");
        add(searchContanctsBtn);

    }

    private void addAdddContanctsBtn() {
        JButton addContanctsBtn = new JButton("添加联系人");
        add(addContanctsBtn);
        addContanctsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Contacts(mainFrame);
            }
        });
    }

    private void setLayoutInGUI() {
        gMeau.gridx = 1;
        gMeau.gridy = 1;
        gMeau.gridheight = 1;
        gMeau.gridwidth = 8;

    }

    public GridBagConstraints getgMeau() {
        return this.gMeau;
    }

    private void init() {
        this.setPreferredSize(new Dimension(800,75));
        this.setMinimumSize(new Dimension(800,75));//似乎要加这两行才可以调整Panel的大小
        this.setBackground(Color.CYAN);

    }

    Meau getMyself(){
        return this;
    }
}
