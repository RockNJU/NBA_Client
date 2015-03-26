package mainUI;


import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.apache.batik.apps.rasterizer.SVGConverterException;

import SinglePlayerUI.SinglePlayerInfo;
import SingleTeamUI.SingleTeamInfo;


public class main_query extends JFrame {

	private JPanel contentPane;
	private static final Image IMG_BG = new ImageIcon("pictures/球队导航.png").getImage();
	static main_query frame;
	//static TeamPanel teampanel;
	//static PlayerPanel playerpanel;
	//static MatchPanel matchpanel;
    JPanel panel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new main_query();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public main_query() {
		
		
		
		setTitle("NBA\u6570\u636E\u67E5\u8BE2\u5206\u6790\u7CFB\u7EDF");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\icon.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 40, 816, 639);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(5,5,800,600);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
	    panel = new SetBack(591,600,"pictures//显示.png");
		panel.setBounds(209, 0, 591, 600);
		contentPane.add(panel);
		panel.setLayout(null);
	
		JPanel menu = new SetBack(214,600,"pictures//菜单.png");
		menu.setBounds(0, 0, 209, 600);
		contentPane.add(menu);
		menu.setLayout(null);
		//球员信息
		final JButton player = new JButton("New button");
		player.setIcon(new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\\u7403\u5458\u4FE1\u606F2.png"));
		player.setBounds(17, 126, 191, 63);
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
            	try {	Player p;
				
					p = new Player();
				       
            	change(p);
            	} catch (RemoteException | MalformedURLException
						| NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}   
            }
        });
		menu.add(player);
		//队伍信息
		final JButton team = new JButton("New button");
		team.setIcon(new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\\u961F\u4F0D\u4FE1\u606F.png"));
		team.setBounds(17, 206, 191, 63);
		team.setBorderPainted(false);
		menu.add(team);
 
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
            	try {	Team p;
				
				p = new Team();
			       
        	change(p);
        	} catch (RemoteException | MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (TransformerFactoryConfigurationError e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (TransformerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SVGConverterException e1) {
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
		match.setBounds(17, 287, 191, 63);
		menu.add(match);
	
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
            	Match m=new Match();
            	change(m);
            }
        });
		//热点信息
				final JButton hot = new JButton("New button");
				hot.setIcon(new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\热门\u4FE1\u606F.png"));
				hot.setBounds(17, 371, 191, 63);
				menu.add(hot);
			
				hot.setBorderPainted(false);
				hot.addMouseListener(new MouseListener() {
		            
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
		            	hot.setIcon(new ImageIcon("pictures//热门信息.png"));
		            }           
		            @Override
		            public void mouseEntered(MouseEvent e) {
		            	
		                // TODO Auto-generated method stub
		            	hot.setIcon(new ImageIcon("pictures//热门信息后.png"));
		            	
		            }            
		            @Override
		            public void mouseClicked(MouseEvent e) {
		                // TODO Auto-generated method stub
		            	Hot m=new Hot();
		            	change(m);
		            }
		        });
			
	}
	
	void change(Player ppanel){
		panel.removeAll();
		panel.add(ppanel);
		ppanel.setVisible(true);
		ppanel.setBounds(0, 0, 591, 600);
		panel.revalidate();
		panel.repaint();
	}
	void change(Team ppanel){
		panel.removeAll();
		panel.add(ppanel);
		ppanel.setVisible(true);
		ppanel.setBounds(0, 0, 591, 600);
		panel.revalidate();
		panel.repaint();
	}
	void change(Hot ppanel){
		panel.removeAll();
		panel.add(ppanel);
		ppanel.setVisible(true);
		ppanel.setBounds(0, 0, 591, 600);
		panel.revalidate();
		panel.repaint();
	}
	void change(Match ppanel){
		panel.removeAll();
		panel.add(ppanel);
		ppanel.setVisible(true);
		ppanel.setBounds(0, 0, 591, 600);
		panel.revalidate();
		panel.repaint();
	}
	void change(SinglePlayerInfo ppanel){
		panel.removeAll();
		panel.add(ppanel);
		ppanel.setVisible(true);
		ppanel.setBounds(0, 0, 591, 600);
		panel.revalidate();
		panel.repaint();
	}
	void change(SingleTeamInfo ppanel){
		panel.removeAll();
		panel.add(ppanel);
		ppanel.setVisible(true);
		ppanel.setBounds(0, 0, 591, 600);
		panel.revalidate();
		panel.repaint();
	}
}
