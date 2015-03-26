package mainUI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.apache.batik.apps.rasterizer.SVGConverterException;
/**
 * 没有用= =
 * @author cc
 *
 */
public class Menu extends JPanel {

	static Team tpanel;
	static Match mpanel;
	static Player  ppanel;
	/**
	 * Create the panel.
	 */
	public Menu() {


		setLayout(null);
		
		//球员信息
		final JButton player = new JButton("New button");
		player.setIcon(new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\\u7403\u5458\u4FE1\u606F2.png"));
		player.setBounds(12, 126, 191, 63);
		player.setBorderPainted(false);
		player.addMouseListener(new MouseListener() {
            
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
            	player.setIcon(new ImageIcon("pictures//球员信息2.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	
                // TODO Auto-generated method stub
            	player.setIcon(new ImageIcon("pictures//球员信息后.png"));
            	
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
            	try {
					ppanel=new Player();
				
            	main_query.frame.change(ppanel);
            	} catch (RemoteException | MalformedURLException
						| NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
		this.add(player);
		//队伍信息
		final JButton team = new JButton("New button");
		team.setIcon(new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\\u961F\u4F0D\u4FE1\u606F.png"));
		team.setBounds(12, 204, 191, 63);
		team.setBorderPainted(false);
		this.add(team);
 
		team.addMouseListener(new MouseListener() {
            
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
            	team.setIcon(new ImageIcon("pictures//队伍信息.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	
                // TODO Auto-generated method stub
            	team.setIcon(new ImageIcon("pictures//队伍信息后.png"));
            	
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
            	try {
					tpanel=new Team();
					main_query.frame.change(tpanel);
				} catch (IOException
						| TransformerFactoryConfigurationError
						| TransformerException | SVGConverterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            }
        });
	 
		//比赛信息
		final JButton match = new JButton("New button");
		match.setIcon(new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\\u6BD4\u8D5B\u4FE1\u606F.png"));
		match.setBounds(12, 282, 191, 63);
		this.add(match);
	
		match.setBorderPainted(false);
		match.addMouseListener(new MouseListener() {
            
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
            	match.setIcon(new ImageIcon("pictures//比赛信息.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	
                // TODO Auto-generated method stub
            	match.setIcon(new ImageIcon("pictures//比赛信息后.png"));
            	
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
            	mpanel=new Match();
            	main_query.frame.change(mpanel);
            }
        });
	}
	
	private static final Image IMG = new ImageIcon("pictures/菜单.png").getImage();
	@Override
	public void paint(Graphics g) {
		g.drawImage(IMG, 0, 0, null);
	}
}
