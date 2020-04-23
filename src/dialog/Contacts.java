package dialog;

import frame.MyFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Contacts extends Dialog {

    Button okBtn = new Button("ok");

    public Contacts(MyFrame owner) {

        super(owner,"联系人信息",true);


        this.setSize(300,600);

        this.setLocationRelativeTo(null);//初始位置居中
        this.setResizable(false);
        this.setLayout(new FlowLayout());

        this.addButton();


        this.setVisible(true);//这个必须放在最后面，否则ok按钮无法添加

    }

    private Contacts getDialog() {
        return this;
    }
    private void addButton() {
        System.out.println(111);
        getDialog().add(okBtn);
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getDialog().dispose();
            }
        });
    }
}
