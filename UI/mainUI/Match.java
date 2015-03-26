package mainUI;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import teamblservice.TeamBLService;
import ShareClass.RMIObject;
import VO.MatchVO;
import VO.PlayerVO;
import VO.TeamVO;
import mainUI.TablePanel.MyTableModel;
import matchblservice.MatchBLService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Match extends JPanel {
	RMIObject Rmi=new RMIObject();
	JButton find;
	JTextField findtime;
	JTable matchtable = new JTable();
	/**
	 * Create the panel.
	 */
	public Match() {
		setLayout(null);
		
		find = new JButton("New button");
		find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String time = findtime.getText();
				String team = findtn.getText();
				MatchBLService m;
				ArrayList<String> info = new ArrayList<String>();
				try {
					m = Rmi.getMatchRMI();
					info = m.getMatchByTeamTime(time, team);
				} catch (MalformedURLException | RemoteException
						| NotBoundException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				if(!info.isEmpty()){
					String[][] update = null;
					int i = 0;
				for (String infomation:info) {
					update[i][0] = infomation.split(";")[0];
					update[i][1] = infomation.split(";")[1];
					update[i][2] = infomation.split(";")[2];
					i++;
				}
				updatetable(update);
			}
			else{
				JOptionPane.showMessageDialog(null, "未查找到对应结果", "警告", JOptionPane.ERROR_MESSAGE);
			}
				
			}
		});
		find.setIcon(new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\\u67E5\u627E.png"));
		find.setBounds(509, 42, 69, 24);
		find.setBorderPainted(false);
		add(find);
		
		findtime = new JTextField();
		findtime.setText("\u65F6\u95F4\uFF08\u683C\u5F0F 02-11\uFF09");
		findtime.setFont(new Font("黑体", Font.PLAIN, 12));
		findtime.setBounds(97, 42, 185, 25);
		add(findtime);
		findtime.setColumns(20);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 125, 554, 450);
		scrollPane.setVisible(true);
		scrollPane.updateUI();
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane);
		
		matchtable.setBorder(new LineBorder(new Color(67, 54, 49), 2, true));
		matchtable.setForeground(Color.DARK_GRAY);
		matchtable.setBackground(new Color(246, 164, 21));
		matchtable.setSelectionBackground(new Color(67, 54, 49));
		matchtable.setSelectionForeground(Color.WHITE);
		matchtable.setShowVerticalLines(true);// 是否显示垂直网格线?
		matchtable.setGridColor(new Color(67, 54, 49));
		 //获得表头
		JTableHeader tableH = matchtable.getTableHeader();
	    //设置表头的背景色
	    tableH.setBackground(new Color(67, 54, 49));
	    //设置表头的文字颜色
	    tableH.setForeground(new Color(255, 255, 255));
	    
		matchtable.setDragEnabled(false); // 不许乱拖动
		//matchtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		matchtable.setFillsViewportHeight(true);
		matchtable.getSelectionModel().setSelectionMode(
				ListSelectionModel.SINGLE_SELECTION); // 只允许单选

		
		matchtable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"时间", "主队", "客队"			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		matchtable.getColumnModel().getColumn(0).setPreferredWidth(100);
		matchtable.getColumnModel().getColumn(0).setMinWidth(75);

		scrollPane.setViewportView(matchtable);
		
		findtn = new JTextField();
		findtn.setFont(new Font("黑体", Font.PLAIN, 12));
		findtn.setText("\u6D89\u53CA\u7403\u961F\u540D\u79F0\u7F29\u5199");
		findtn.setBounds(314, 42, 185, 25);
		add(findtn);
		findtn.setColumns(10);
		findtime.setVisible(true);
	
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
	private static final Image IMG = new ImageIcon("pictures/比赛显示.png").getImage();
	private JTextField findtn;
	@Override
	public void paint(Graphics g) {
		g.drawImage(IMG, 0, 0, null);
	}
	
	//更新表格
	public void updatetable(String[][] s){
		matchtable.setModel(new DefaultTableModel(
				s,
				new String[] {
					"\u7403\u5458", "\u65F6\u95F4", "\u6295\u7BEE", "\u4E09\u5206", "\u7F5A\u7403", "\u524D\u7BEE\u677F", "\u540E\u7BEE\u677F", "\u603B\u7BEE\u677F", "\u52A9\u653B", "\u62A2\u65AD", "\u76D6\u5E3D", "\u5931\u8BEF", "\u72AF\u89C4", "\u5F97\u5206"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false, false, false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
	}
}
