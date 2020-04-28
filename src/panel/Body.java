package panel;

import component.GroupTable;
import frame.MyFrame;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class Body extends JSplitPane {
    GridBagConstraints gBody = new GridBagConstraints();
    MyFrame mainFrame;
    //JList<String> groupDeatail;//�������飬��ʽ����Ҫ����ԭ�ͣ�������������������������������������������������������������
    ContactDeatail contactDeatail ;

    int selectedID = 0;

    public Body(int orientation , MyFrame mainFrame){
        super(orientation);
        this.mainFrame = mainFrame;
        //setSize(500,400);
        //System.out.println(getSize());
        setDividerLocation(0.7);
        //getMyself().setLayout(new BorderLayout());

        this.init();



        setLayout();
        System.out.println(getSize());
        setDividerLocation(0.6);
    }

    public Body getMyself(){
        return this;
    }

    private void setLayout() {
        //����������˸�body��frame����Ĳ���
        //����������body����Ĳ���
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
        this.setDividerLocation(0.5);//�������ﲻ���ã���Ҫ����MyFrame����
        this.setBackground(Color.BLUE);
        this.setContinuousLayout(true);// �϶��ָ���ʱ�����ػ����




        GroupDeatail topPanel = new GroupDeatail(new BorderLayout());
        this.setLeftComponent(topPanel);
        //����ͨ���½�һ��panel��Ϊbody��topPanel�������������panel���Ը������õ���

        initContactDeatail();//��ʼ����ϵ����ϸ��Ϣ����
        this.add(contactDeatail,this.rightComponent);//��ײ���panel�����ϵ����ϸ��Ϣ
        //System.out.println(this.getSize());
    }

    private void initContactDeatail() {
        contactDeatail = new ContactDeatail();
        contactDeatail.demoMsg.setText("����"+FindGroupDetail(1)[selectedID]);
        contactDeatail.setBackground(Color.MAGENTA);
    }

    @Override
    public void validate() {
        super.validate();
        contactDeatail.demoMsg.setText("����"+FindGroupDetail(1)[selectedID]);
    }

    private String[] FindGroupDetail(int GroupID){
        //��ʽ�汾������Ҫ����
        return new String[]{"С��", "С��","С��"};
    }


}
