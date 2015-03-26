package SinglePlayerUI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.SystemColor;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class SinglePlayerInfo extends JPanel {
	JButton basicinfo;
	JButton moreinfo;
	JButton analysis;
	JPanel infopanel;
	String name;
	/**
	 * Create the panel.
	 */
	public SinglePlayerInfo(String Name) {
		this.setLayout(null);
		this.name=Name;
		this.setSize(591, 600);
		
		infopanel=new JPanel();
		infopanel.setBounds(5, 112, 582, 474);
		add(infopanel);
		infopanel.setLayout(null);
    	
		basicinfo = new JButton("New button");
		basicinfo.setIcon(new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\playerinfo\\\u57FA\u7840\u4FE1\u606F.png"));
		basicinfo.setBounds(11, 19, 180, 70);
		basicinfo.setBorderPainted(false);
		add(basicinfo);
		
		moreinfo = new JButton("New button");
		moreinfo.setIcon(new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\playerinfo\\\u8FDB\u9636\u6570\u636E.png"));
		moreinfo.setBounds(203, 19, 180, 70);
		moreinfo.setBorderPainted(false);
		add(moreinfo);
		
		analysis = new JButton("New button");
		analysis.setIcon(new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\playerinfo\\\u5206\u6790\u6570\u636E.png"));
		analysis.setBounds(400, 19, 180, 70);
		analysis.setBorderPainted(false);
		add(analysis);
		

		basicinfo.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub                
            }           
            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub                
            }          
            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
            	basicinfo.setIcon(new ImageIcon("pictures//playerinfo//基础信息.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	
                // TODO Auto-generated method stub
            	basicinfo.setIcon(new ImageIcon("pictures//playerinfo//基础信息后.png"));
            	
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            	BasicInfo bi;
				try {
					bi = new BasicInfo(name);
					changeInfoPanel(bi);
				} catch (MalformedURLException | RemoteException
						| NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            }
        });		
		moreinfo.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub                
            }           
            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub                
            }          
            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
            	moreinfo.setIcon(new ImageIcon("pictures//playerinfo//进阶数据.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	
                // TODO Auto-generated method stub
            	moreinfo.setIcon(new ImageIcon("pictures//playerinfo//进阶数据后.png"));
            	
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
            	MoreInfo bi=new MoreInfo(name);
            	changeInfoPanel(bi);
            }
        });	
		analysis.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub                
            }           
            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub                
            }          
            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
            	analysis.setIcon(new ImageIcon("pictures//playerinfo//分析数据.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	
                // TODO Auto-generated method stub
            	analysis.setIcon(new ImageIcon("pictures//playerinfo//分析数据后.png"));
            	
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
            	AnalysisInfo bi=new AnalysisInfo(name);
            	changeInfoPanel(bi);
            }
        });	
	}

	public void changeInfoPanel(BasicInfo panel){
		infopanel.removeAll();
		infopanel.add(panel);
		panel.setVisible(true);
		panel.setBounds(0,0, 582, 474);
		infopanel.revalidate();
		infopanel.repaint();
		
	}
	public void changeInfoPanel(MoreInfo panel){
		infopanel.removeAll();
		infopanel.add(panel);
		panel.setVisible(true);
		panel.setBounds(0,0, 582, 474);
		infopanel.revalidate();
		infopanel.repaint();
		
	}
	public void changeInfoPanel(AnalysisInfo panel){
		infopanel.removeAll();
		infopanel.add(panel);
		panel.setVisible(true);
		panel.setBounds(0,0,582, 474);
		infopanel.revalidate();
		infopanel.repaint();
		
	}
	private static final Image IMG = new ImageIcon("pictures/playerinfo/显示背景.png").getImage();

	@Override
	public void paint(Graphics g) {
		g.drawImage(IMG, 0, 0, null);
	}
	
	
	
}
