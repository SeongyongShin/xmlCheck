package Frame;

import java.awt.Container;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainFrame extends JFrame{
	
	public MainFrame() {
		setTitle("QA�غ��ô�.");
		setSize(500,700);
		setVisible(true);
	}
	public Container getContent() {
		return this.getContentPane();
	}
	public void setImg() {
		//Toolkit toolkit = this.getToolkit();
		//Image img = toolkit.createImage("./logo.png");
		File path = new File("src");
		String path1 = MainFrame.class.getResource("").getPath();
	    System.out.println(path.getAbsolutePath());
	    String s = path.getAbsolutePath() + "\\Frame\\resource\\logo.png";
	    System.out.println(s);
		ImageIcon img = new ImageIcon(s);
		this.setIconImage(img.getImage());
//		C:\Users\works\eclipse-workspace\qaList\src\Frame\resource
	}

}
