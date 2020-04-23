package frame;

import dialog.Contacts;
import panel.*;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class MyFrame extends JFrame {

    Container frameContainer = this.getContentPane();//获取窗体容器
    JLabel l1 = new JLabel("这是xxx");
    MyFrame myFrame = this;
    Meau meau ;
    Group group ;
    Body body ;
    Font globalFont;



    public MyFrame(){

        globalFont = new Font("宋体",Font.PLAIN,12);//初始化全局字体
        InitGlobalFont(globalFont);
        this.setTitle("我的通讯录");
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);//初始位置居中
        this.setResizable(true);//设置窗体可以调整大小
        frameContainer.setBackground(Color.WHITE);

        meau = new Meau(this);
        group = new Group();
        body =  new Body(JSplitPane.VERTICAL_SPLIT,this);

        setMyLayout();
        addButton();



        //初始化窗口
    }

    private void setMyLayout() {

        frameContainer.setLayout(new GridBagLayout());
        //设置为网格包布局
        GridBagConstraints gMeau = meau.getgMeau();
        //获取菜单约束条件
        GridBagConstraints gGroup = group.getgGroup();
        //获取Group模块约束条件
        GridBagConstraints gBody = body.getgBody();
        //获取Body模块约束调价

        frameContainer.add(meau,gMeau);
        frameContainer.add(body,gBody);
        frameContainer.add(group,gGroup);

    }

    private void addButton() {
        JButton btn = new JButton("click");
        //frameContainer.add(btn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contacts contact1 =new Contacts(myFrame);
                contact1.setVisible(true);
            }
        });
    }

    public Container getFrameContainer() {
        return frameContainer;
    }

    public void setFrameContainer(Container frameContainer) {
        this.frameContainer = frameContainer;
    }

    public MyFrame getMyFrame() {
        return myFrame;
    }

    public Meau getMeau() {
        return this.meau;
    }

    public Group getGroup() {
        return this.group;
    }

    public Body getBody() {
        return this.body;
    }


    private static void InitGlobalFont(Font font) {//设置全局字体
        FontUIResource fontRes = new FontUIResource(font);
        for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements(); ) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                UIManager.put(key, fontRes);
            }

        }
    }

}
