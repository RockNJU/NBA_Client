package mainUI;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class SetBack  extends JPanel {
	 private static final long serialVersionUID = 1L;
	 int width = 0, hight = 0;
	 String imgpath = "";
	 public SetBack(int width, int hight, String file) {
	  this.width = width;
	  this.hight = hight;
	  imgpath = file;
	 }
	 protected void paintComponent(Graphics g) {
	  ImageIcon icon = new ImageIcon(imgpath);
	  Image img = icon.getImage();
	  g.drawImage(img, 0, 0, width, hight, this);
	 }
	}