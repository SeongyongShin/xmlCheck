package Frame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FirstPanel extends JPanel implements ActionListener{
	
	private JButton b1;
	private PanelSet ps;
	private JLabel j1;
	
	public FirstPanel(PanelSet ps) {
		this.ps = ps;
		setLayout(null);
		b1 = new JButton();
		j1 = new JLabel();
		b1.setSize(100, 40);
		b1.setLocation(50, 50);
		b1.setText("�����ϱ�");
		j1.setText("ù ��° �г�");
		j1.setSize(100,60);
		j1.setLocation(50, 100);
		add(b1);
		add(j1);
		b1.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = e.getActionCommand().trim();
		if(msg.equals("�����ϱ�")) {
			ps.change(2);
		}
		
	}
	
	
}