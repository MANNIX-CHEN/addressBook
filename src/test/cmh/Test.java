package test.cmh;

import java.awt.BorderLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class Test {
    public static void main(String[] args) {
        final JSplitPane splitPane = new JSplitPane();
        splitPane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e)
            {
                splitPane.setDividerLocation(0.7);
            }
        });

        JFrame f = new JFrame();
        f.getContentPane().add(splitPane, BorderLayout.CENTER);
        f.setSize(300, 300);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        splitPane.setDividerLocation(0.7);
    }
}