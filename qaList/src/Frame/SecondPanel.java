package Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import QA.xml.XmlSolve;

public class SecondPanel extends JPanel implements ActionListener{
	

	private JButton b1,b2;
	private PanelSet ps;
	private JLabel j1;
	private JTextArea jt1, jt2;
	
	public SecondPanel(PanelSet ps) {
		this.ps = ps;
		setLayout(null);
		setPage();
	}
	
	public void setPage() {
		b1 = new JButton();
		b2 = new JButton();
		j1 = new JLabel();
		jt1 = new JTextArea();
		jt2 = new JTextArea();
		
		b1.setSize(100, 40);
		b1.setLocation(50, 50);
		b1.setText("이전 화면으로");
		
		j1.setText("<XML 입력 필드> 그냥 다 붙여넣으세요.");
		j1.setSize(100,60);
		j1.setLocation(50, 100);
		
		
		jt1.setBounds(j1.getX(), j1.getY()+j1.getHeight(), 200, 400);
		jt2.setBounds(jt1.getX()+jt1.getWidth() + 10, j1.getY()+j1.getHeight(), 200, 400);
		jt2.setVisible(false);
		
		b2.setSize(100, 40);
		b2.setLocation(jt1.getX(), jt1.getY()+jt1.getHeight());
		b2.setText("결과 제출");
		
		add(b1);
		add(b2);
		add(j1);
		add(jt1);
		add(jt2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = e.getActionCommand().trim();
		
		if(msg.equals("이전 화면으로")) {
			ps.change(1);
			ps.setSize(400,300);
		}else if(msg.equals("결과 제출")) {
			XmlSolve xs = new XmlSolve();
			try {
				jt2.setText(xs.solve(jt1.getText()));
			} catch (ParserConfigurationException | SAXException | IOException e1) {
				e1.printStackTrace();
			}
			jt2.setVisible(true);
		}
		
	}

}
