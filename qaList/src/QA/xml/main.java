package QA.xml;

import Frame.FirstPanel;
import Frame.PanelSet;
import Frame.SecondPanel;


public class main {
	
	
	public static void main(String[] args) {
		firstSet();
		System.out.println(main.class.getClass());
	}

	private static void firstSet() {
		PanelSet ps;
		FirstPanel fp;
		SecondPanel sp;
		ps = new PanelSet();
		fp = new FirstPanel(ps);
		sp = new SecondPanel(ps);
		ps.setFp(fp);
		ps.setSp(sp);
		ps.add(ps.getFp());
		ps.setTitle("QA�غ��ô�.");
		ps.setSize(400,200);
		ps.setVisible(true);
		ps.setIconImage();
	}

}
