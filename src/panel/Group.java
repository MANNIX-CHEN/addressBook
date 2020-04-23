package panel;

import javax.swing.*;
import java.awt.*;

public class Group extends JPanel {

    GridBagConstraints gGroup = new GridBagConstraints();
    int SelectedGroupID = 1;
    public Group(){
        this.init();
        setLayoutInGUI();//设置在主界面的排版
        layCom();//布置组件
    }

    private void layCom() {
        add(new JLabel("联系人分组"));
        JList<String> groupList = new JList<String>();

        groupList.setListData(
                new String[]{"全部分组","我的收藏","家人","朋友"
                });
        add(groupList);
    }

    private void setLayoutInGUI() {
        gGroup.gridx=1;
        gGroup.gridy=2;
        gGroup.gridheight = 5;
        gGroup.gridwidth = 3;

    }

    public GridBagConstraints getgGroup() {
        return gGroup;
    }

    private void init() {
        this.setPreferredSize(new Dimension(100,500));
        this.setMinimumSize(new Dimension(100,500));
        this.setBackground(Color.yellow);

    }

    public int getSelectedGroup(){
        return this.SelectedGroupID;
    }
}
