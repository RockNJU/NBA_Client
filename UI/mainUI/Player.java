package mainUI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

import javax.swing.DropMode;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

import playerblservice.PlayerBLService;
import teamblservice.TeamBLService;
import ShareClass.RMIObject;
import SinglePlayerUI.SinglePlayerInfo;
import VO.PlayerInfoVO;
import VO.PlayerVO;
import VO.TeamVO;

import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Player extends JPanel {
	RMIObject Rmi=new RMIObject();
	
	JButton find;
	JButton sort;
	JButton top;
	JComboBox  position;
	JComboBox partition;
	JComboBox according;
	JTextField findkey;
	locationMap lm= new locationMap(); 
	PartitionMap pm = new PartitionMap();
	PlayerMap pym = new PlayerMap();
	
	Icon a=new ImageIcon("pictures/肖像.png");
	Icon b=new ImageIcon("pictures/名称.png");
	Icon c=new ImageIcon("pictures/球队.png");

	//String title[], String data[][],int x,int y,int width,int height,int rowHeight,int rowwidth1,int rowwidth2,int rowwidth3,Font fbig,Font fsmall
	String title[]={"照片","球员姓名  ","所属球队"};
	Object data[][];
	TablePanel playerlist;
	ArrayList<PlayerInfoVO> pvo;
	PlayerBLService pbs;
	/**
	 * Create the panel.
	 * @throws RemoteException 
	 * @throws NotBoundException 
	 * @throws MalformedURLException 
	 */
	public Player() throws RemoteException, MalformedURLException, NotBoundException {

		pbs=Rmi.getPlayerRMI();
		this.setLayout(null);
		
		sort = new JButton("New button");
		sort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerBLService p;
				ArrayList<PlayerVO> player = new ArrayList<PlayerVO>();
				try {
					p = Rmi.getPlayerRMI();

					String Position = position.getSelectedItem().toString();
					String Partition = partition.getSelectedItem().toString();
					String According = according.getSelectedItem().toString();
					//判断东西区
					String division = null ; // W是西区 ， E是东区
					if(partition.equals("大西洋")||partition.equals("中部")||partition.equals("东南")||partition.equals("东区")){
						division = "E";
					}
					else if(partition.equals("无")){
						division = null;
					}
					else{
						division = "W";
					}
					player = p.sort(lm.getItem(Position),pm.getItem(Partition),pym.getItem(According));
					
				} catch (MalformedURLException | RemoteException
						| NotBoundException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				
				if(!player.isEmpty()){
					Object[][]  info = new Object[500][3];
					int i = 0;
					for (PlayerVO thisplayer:player) {
						info[i][0] = "pictures/protrait/"+thisplayer.getInfo().getName()+".png";
						info[i][1] = i+1+": "+thisplayer.getInfo().getName();
						info[i][2] = thisplayer.getInfo().getBirth();
						i++;
					}
					playerlist.updateTable(info);
				}
				else{
					JOptionPane.showMessageDialog(null, "未查找到对应结果", "警告", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		sort.setToolTipText("\u5F00\u59CB\u8FDB\u884C\u67E5\u8BE2\u6392\u5217");
		sort.setIcon(new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\\u6392\u5217.png"));
		sort.setBounds(512, 22, 69, 23);
		sort.setBorderPainted(false);
		add(sort);
		
		find = new JButton("New button");
		find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerBLService p;
				PlayerInfoVO player = null;
				try {
					p = Rmi.getPlayerRMI();
					String Findkey = findkey.getText();
					player = p.getPlayerInfo(Findkey);
				} catch (MalformedURLException | RemoteException
						| NotBoundException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				
				if(player!=null){
					Object[][]  info = new Object[500][3];
						info[0][0] = "pictures/pratrait/"+player.getName()+".png";
						info[0][1] = 1+": "+player.getName();
						info[0][2] = player.getBirth();
					playerlist.updateTable(info);
				}
				else{
					JOptionPane.showMessageDialog(null, "未查找到对应结果", "警告", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//findkey
			}
		});
		find.setToolTipText("\u67E5\u8BE2\u5355\u72EC\u7403\u5458\u4FE1\u606F");
		find.setIcon(new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\\u67E5\u627E.png"));
		find.setBounds(512, 64, 69, 24);
		find.setBorderPainted(false);
		add(find);
		
		top = new JButton("New button");
		top.setToolTipText("\u70B9\u51FB\u8868\u5934\u8FDB\u884C\u6B63\u5012\u5E8F\u6392\u5217");
		top.setIcon(new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\\u6B63\u5E8F.png"));
		top.setBounds(437, 22, 69, 23);
		top.setBorderPainted(false);
		add(top);
		
		position = new JComboBox();
		position.setBounds(84, 20, 81, 25);
		position.setMaximumRowCount(100);		
		position.setModel(new DefaultComboBoxModel(new String[] {"\u524D\u950B", "\u4E2D\u950B", "\u540E\u536B"}));	
		position.setToolTipText("");
		position.setEditable(true);
		position.setVisible(true);
		add(position);
		
		
		partition = new JComboBox();
		partition.setModel(new DefaultComboBoxModel(new String[] {"\u65E0", "\u4E1C\u533A", "\u897F\u533A", "\u5927\u897F\u6D0B", "\u4E2D\u90E8", "\u4E1C\u5357", "\u897F\u5357", "\u897F\u5317\u90E8", "\u592A\u5E73\u6D0B"}));
		partition.setEditable(true);
		partition.setBounds(195, 20, 114, 25);
		add(partition);
		partition.setVisible(true);
		according = new JComboBox();
		according.setModel(new DefaultComboBoxModel(new String[] {"\u5F97\u5206", "\u7BEE\u677F", "\u52A9\u653B", "\u5F97\u5206/\u7BEE\u677F/\u52A9\u653B", "\u76D6\u5E3D", "\u62A2\u65AD", "\u72AF\u89C4", "\u5931\u8BEF", "\u5206\u949F", "\u6548\u7387", "\u6295\u7BEE", "\u4E09\u5206", "\u7F5A\u7403", "\u4E24\u53CC"}));
		according.setEditable(true);
		according.setBounds(343, 20, 81, 25);
		add(according);
		according.setVisible(true);
		
		findkey = new JTextField();
		findkey.setFont(new Font("华文行楷", Font.PLAIN, 18));
		findkey.setBounds(84, 65, 421, 25);		
		add(findkey);
		findkey.setColumns(20);
		findkey.setVisible(true);
		
		
		pvo=pbs.getAllPlayer();
		data=getdata(pvo);
		playerlist=new TablePanel(title,a,b,c,data,15,125,555,457,85,102,280,155,new Font("Dialog", 0, 30),new Font("Dialog", 0, 15),178,147);
		
		//双击进入球员界面
	playerlist.getTable().addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
			 if (e.getClickCount() == 2&&playerlist.getSelectedRow()!=-1)
			 { 
				 	String name = playerlist.getValueAt(playerlist.getSelectedRow(),1);
				 	System.out.println(playerlist.getSelectedRow());
		        	SinglePlayerInfo spi=new SinglePlayerInfo(name);
		        	main_query.frame.change(spi);
			 }
		}
	});

		

	this.add(playerlist);

		
		sort.addMouseListener(new MouseListener() {
            
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
            	sort.setIcon(new ImageIcon("pictures//排列.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	
                // TODO Auto-generated method stub
            	sort.setIcon(new ImageIcon("pictures//排列后.png"));
            	
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
            }
        });

		top.addMouseListener(new MouseListener() {
            
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
            	top.setIcon(new ImageIcon("pictures//正序.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	
                // TODO Auto-generated method stub
            	top.setIcon(new ImageIcon("pictures//正序后.png"));
            	
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
            	
            }
        });

		find.addMouseListener(new MouseListener() {
            
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
            	find.setIcon(new ImageIcon("pictures//查找.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	
                // TODO Auto-generated method stub
            	find.setIcon(new ImageIcon("pictures//查找后.png"));
            	
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
            	
            }
        });
		
	}
	
	
	private static final Image IMG = new ImageIcon("pictures/球员显示.png").getImage();
	@Override
	public void paint(Graphics g) {
		g.drawImage(IMG, 0, 0, null);
	}
	
	
	private Object[][] getdata(ArrayList<PlayerInfoVO> showlist){
		Object[][] temp=new Object[showlist.size()][3];		
		System.out.println(showlist.size());
			for(int i=0;i<showlist.size();i++){
				String icon;
				File pic=new File("pictures/portrait/"+showlist.get(i).getName()+".png");
				if(!pic.exists()){
					icon="pictures\\nothing.jpg";
				}else{
					icon="pictures/portrait/"+showlist.get(i).getName()+".png";
				}		
				//System.out.println(showlist.get(i).getName());
				temp[i][0]=icon;
				temp[i][1]=showlist.get(i).getName(); 		
				temp[i][2]=showlist.get(i).getBirth();						 			
		}
		return temp;
		
	}
	
}
