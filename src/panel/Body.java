package panel;

import frame.MyFrame;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class Body extends JSplitPane {
    GridBagConstraints gBody = new GridBagConstraints();
    MyFrame mainFrame;
    JList<String> groupDeatail;//分组详情，正式版需要换种原型！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
    ContactDeatail contactDeatail ;

    int selectedID = 0;

    public Body(int orientation , MyFrame mainFrame){
        super(orientation);
        this.mainFrame = mainFrame;
        this.init();

        setLayout();
    }

    public Body getMyself(){
        return this;
    }

    private void setLayout() {
        gBody.gridx=4;
        gBody.gridy=2;
        gBody.gridheight = 5;
        gBody.gridwidth = 5;
        gBody.fill = GridBagConstraints.BOTH;

    }


    public GridBagConstraints getgBody() {
        return gBody;
    }

    private void init() {
        this.setPreferredSize(new Dimension(600,500));
        this.setMinimumSize(new Dimension(600,500));
        this.setSize(new Dimension(600,500));
        //this.setVisible(true);
        this.setDividerLocation(0.5);//放在这里不能用，需要放在MyFrame里面
        this.setBackground(Color.BLUE);
        this.setContinuousLayout(true);// 拖动分隔条时连续重绘组件


        //以下为初始化版面
        initGroupDeatial();//初始化分组详情信息
        this.add(groupDeatail,this.leftComponent);//向顶部子panel添加分组详情信息
        initContactDeatail();//初始化联系人详细信息界面
        this.add(contactDeatail,this.rightComponent);//向底部子panel添加联系人详细信息
        //System.out.println(this.getSize());
    }

    private void initContactDeatail() {
        contactDeatail = new ContactDeatail();
        contactDeatail.demoMsg.setText("我是"+FindGroupDetail(1)[selectedID]);
        contactDeatail.setBackground(Color.MAGENTA);
    }

    private void initGroupDeatial() {
        //System.out.println(mainFrame.getGroup().getSelectedGroup());
        groupDeatail = new JList<String>();
        int groupID = mainFrame.getGroup().getSelectedGroup();
        String[] groupDeatialString= FindGroupDetail(groupID);
        groupDeatail.setListData(groupDeatialString);

        groupDeatail.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectedID = groupDeatail.getSelectedIndex();
                validate();
            }
        });

    }

    @Override
    public void validate() {
        super.validate();
        contactDeatail.demoMsg.setText("我是"+FindGroupDetail(1)[selectedID]);
    }

    private String[] FindGroupDetail(int GroupID){
        //正式版本这里需要完善
        return new String[]{"小明", "小红","小军"};
    }


}
