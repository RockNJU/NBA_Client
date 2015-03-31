package mainUI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.batik.apps.rasterizer.DestinationType;
import org.apache.batik.apps.rasterizer.SVGConverter;
import org.apache.batik.apps.rasterizer.SVGConverterException;
import org.w3c.dom.Document;

import ShareClass.RMIObject;
import SingleTeamUI.DOMRasterizer;
import SingleTeamUI.SingleTeamInfo;
import VO.TeamInfoVO;
import VO.TeamVO;
import teamblservice.TeamBLService;

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Team extends JPanel {
	RMIObject Rmi=new RMIObject();
	
	Icon a=new ImageIcon("pictures/logo.png");
	Icon b=new ImageIcon("pictures/名称.png");
	Icon c=new ImageIcon("pictures/建队时间.png");
	String title[]={"LOGO","球队名称  ","建队时间"};
	Object[][] data={{"","",""},{"","",""}};
	TablePanel teamlist=new TablePanel(title,a,b,c,data,23,125,540,457,127,157,253,128,new Font("华文行楷", Font.PLAIN, 18),new Font("华文行楷", Font.PLAIN, 18),157,127);
	JComboBox comboBox = new JComboBox();
	ArrayList<TeamVO> tvo=new ArrayList<TeamVO>();
	TeamBLService tbl;
	RMIObject rmi=new RMIObject();
	 JTextField sortkey = new JTextField();
	/**
	 * Create the panel.
	 */
	/**
	 * Create the panel.
	 * @throws SVGConverterException 
	 * @throws TransformerException 
	 * @throws TransformerFactoryConfigurationError 
	 * @throws IOException 
	 * @throws NotBoundException 
	 */
	public Team() throws IOException, TransformerFactoryConfigurationError, TransformerException, SVGConverterException, NotBoundException {
		
		setLayout(null);
		
		final JButton sort = new JButton("New button");
		sort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeamBLService t;
				ArrayList<TeamVO> team = new ArrayList<TeamVO>();
				Object[][] info = null;
				try {
					t = Rmi.getTeamRMI();
					team = t.sort(comboBox.getSelectedItem().toString());
					info = getdata(team);
				} catch (NotBoundException | IOException | TransformerFactoryConfigurationError | TransformerException | SVGConverterException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				
				if(info.length != 0){
					teamlist.updateTable(info);
				}
				else{
					JOptionPane.showMessageDialog(null, "未查找到对应结果", "警告", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		sort.setToolTipText("\u5F00\u59CB\u8FDB\u884C\u67E5\u8BE2\u6392\u5217");
		sort.setIcon(new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\\u6392\u5217.png"));
		sort.setBounds(513, 21, 69, 24);
		sort.setBorderPainted(false);
		add(sort);
		
		final JButton find = new JButton("New button");
		find.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			public void actionPerformed(ActionEvent e) {
				TeamBLService t;
				ArrayList<TeamVO> team = new ArrayList<TeamVO>();
				Object[][] info = null;
				try {
					t = Rmi.getTeamRMI();
					team.add(t.getTeamInfo(sortkey.getText()));
					info = getdata(team);
				} catch (NotBoundException | IOException | TransformerFactoryConfigurationError | TransformerException | SVGConverterException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				
				
				if(info.length != 0){
					teamlist.updateTable(info);
				}
				else{
					JOptionPane.showMessageDialog(null, "未查找到对应结果", "警告", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		find.setToolTipText("\u67E5\u8BE2\u5355\u72EC\u7403\u5458\u4FE1\u606F");
		find.setIcon(new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\\u67E5\u627E.png"));
		find.setBounds(513, 65, 69, 24);
		find.setBorderPainted(false);
		add(find);
		
		final JButton top = new JButton("New button");
		top.setToolTipText("\u70B9\u51FB\u8868\u5934\u8FDB\u884C\u6B63\u5012\u5E8F\u6392\u5217");
		top.setIcon(new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\\u6B63\u5E8F.png"));
		top.setBounds(437, 22, 69, 23);
		top.setBorderPainted(false);
		add(top);

		sortkey.setFont(new Font("华文行楷", Font.PLAIN, 18));
		sortkey.setBounds(84, 65, 421, 25);
		add(sortkey);
		sortkey.setColumns(20);
		sortkey.setVisible(true);
		

		tbl=rmi.getTeamRMI();
		tvo=tbl.getAllTeam();
		data=getdata(tvo);
		teamlist=new TablePanel(title,a,b,c,data,23,125,540,457,127,157,253,128,new Font("微软雅黑", Font.BOLD, 18),new Font("微软雅黑", Font.BOLD, 18),157,127);
		
		//双击进入球员界面
	
		teamlist.getTable().addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
			 if (e.getClickCount() == 2)
			 { 
				 	String name =teamlist.getValueAt(teamlist.getSelectedRow(),1);
				 	String[] newname=name.split("---");
				 	
		        	SingleTeamInfo spi=new SingleTeamInfo(newname[1]);
		        	main_query.frame.change(spi);
			 }
		}
	});
		this.add(teamlist);	
				
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u6295\u7BEE\u547D\u4E2D\u7387", "\u6295\u7BEE\u51FA\u624B\u6B21\u6570", "\u4E09\u5206\u547D\u4E2D\u6570", "\u4E09\u5206\u51FA\u624B\u6570", "\u7F5A\u7403\u547D\u4E2D\u6570", "\u7F5A\u7403\u51FA\u624B\u6570", "\u8FDB\u653B\u7BEE\u677F\u6570", "\u9632\u5B88\u7BEE\u677F\u6570", "\u7BEE\u677F\u6570", "\u52A9\u653B\u6570", "\u62A2\u65AD\u6570", "\u76D6\u5E3D\u6570", "\u5931\u8BEF\u6570", "\u72AF\u89C4\u6570", "\u6BD4\u8D5B\u5F97\u5206", "\u6295\u7BEE\u547D\u4E2D\u7387", "\u4E09\u5206\u547D\u4E2D\u7387", "\u7F5A\u7403\u547D\u4E2D\u7387", "\u80DC\u7387", "\u8FDB\u653B\u56DE\u5408", "\u8FDB\u653B\u6548\u7387", "\u9632\u5B88\u6548\u7387", "\u7BEE\u677F\u6548\u7387", "\u62A2\u65AD\u6548\u7387", "\u52A9\u653B\u7387"}));
			comboBox.setBounds(84, 21, 338, 23);
			
			add(comboBox);
		
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
	
	
	private static final Image IMG = new ImageIcon("pictures/球队显示.png").getImage();

	@Override
	public void paint(Graphics g) {
		g.drawImage(IMG, 0, 0, null);
	}
	
	private Object[][] getdata(ArrayList<TeamVO> showlist) throws IOException, TransformerFactoryConfigurationError, TransformerException, SVGConverterException{
		Object[][] temp=new Object[showlist.size()][3];	
		DOMRasterizer rasterizer = new DOMRasterizer();
		
		
		System.out.println(showlist.size());
		if(showlist.size()==0){
			Object[][] a={{"","",""}};
			return a;
		}else{
			for(int i=0;i<showlist.size();i++){
				System.out.println(showlist.get(i)==null);
				String teamnameAbb=showlist.get(i).getInfo().getTeamAbb();
				//System.out.println(teamnameAbb);
				String image;
				File svgpic=new File("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\teams\\"+teamnameAbb+".svg");
				File file=new File("pictures/TEAMPNG/"+teamnameAbb+".png");
				if(svgpic.exists()){//svg图片存在
					if(!file.exists()){//png不存在，新建png图片		
						InputStream in = new FileInputStream(svgpic);			
						Document svgXmlDoc = rasterizer.createDocument(in);
					    // Save this SVG into a file (required by SVG -> PNG transformation process)			
						File svgFile = File.createTempFile("graphic-", ".svg");			
						Transformer transformer = TransformerFactory.newInstance().newTransformer();		
						DOMSource source = new DOMSource(svgXmlDoc);			
						FileOutputStream fos = new FileOutputStream(svgFile);			
						try {			
							transformer.transform(source, new StreamResult(fos));			
						} finally {			  
							fos.close();			
						}
					    // Convert the SVG into PNG
					    //TODO 保存为同名文件
					    File outputFile =new File("pictures/TEAMPNG/"+teamnameAbb+".png");
					    SVGConverter converter = new SVGConverter();
					    converter.setDestinationType(DestinationType.PNG);
					    converter.setSources(new String[]{svgFile.toString()});
					    converter.setDst(outputFile);
					    converter.execute();		
					}
					//否则，直接用
					image = "D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\TEAMPNG\\"+teamnameAbb+".PNG";
				}else{//svg图片不存在
					image="pictures\\nothing.jpg";
				}
				//System.out.println(showlist.get(i).getName());
				temp[i][0]=image;
				temp[i][1]=showlist.get(i).getInfo().getFullName()+"---"+showlist.get(i).getInfo().getTeamAbb(); 		
				temp[i][2]=showlist.get(i).getInfo().getFormedTime();						 			
		}
		return temp;
		}
	}
}
