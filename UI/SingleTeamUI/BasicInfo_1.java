package SingleTeamUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.batik.apps.rasterizer.DestinationType;
import org.apache.batik.apps.rasterizer.SVGConverter;
import org.w3c.dom.Document;

import teamblservice.TeamBLService;
import ShareClass.RMIObject;
import VO.TeamVO;

import java.awt.Font;

import javax.swing.JTable;
import javax.swing.plaf.ScrollPaneUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class BasicInfo_1 extends JPanel {
	
	Color back=new Color(247,162,19);
	Color line=new Color(255,83,1);
	private JTable table;
	ImageIcon  image;
	TeamVO tvo;
	
	String teamnameAbb;
	RMIObject rmi=new RMIObject();
	TeamBLService tbl;
	/**
	 * Create the panel.
	 */
	public BasicInfo_1(String name) throws Exception{
		this.setSize(582, 474);
		setLayout(null);
		this.setBackground(new Color(253,212,146));
		
		this.teamnameAbb=name;
		tbl=rmi.getTeamRMI();
		tvo=tbl.getTeamInfo(teamnameAbb);
		
		DOMRasterizer rasterizer = new DOMRasterizer();
		File svgpic=new File("pictures\\teams\\"+teamnameAbb+".svg");
		File file=new File("pictures/TEAMPNG/"+teamnameAbb+".png");
		if(svgpic.exists()){//svg图片存在
			if(!file.exists()){//png不存在	，新建png图片		
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
			image = new ImageIcon("pictures\\TEAMPNG\\"+teamnameAbb+".PNG");
		}else{//svg图片不存在
			image=new ImageIcon("pictures\\nothing.jpg");
		}
		//显示图片
		image.setImage(image.getImage().getScaledInstance(247,222,Image.SCALE_DEFAULT)); 
		JLabel photo = new JLabel(image);
		//photo.setIcon(new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\portrait\\Aaron Brooks.png"));
		photo.setBounds(12, 13, 247, 222);
		photo.setOpaque(false);
		add(photo);
		photo.setBorder(BorderFactory.createLineBorder(line));
		
		//TODO 球队名称
		System.out.println(tvo.getInfo().getFullName());
		JLabel teamname = new JLabel(tvo.getInfo().getFullName());
		teamname.setForeground(Color.DARK_GRAY);
		teamname.setFont(new Font("微软雅黑", Font.BOLD, 30));
		teamname.setBounds(275, 15, 247, 45);
		add(teamname);
		//TODO 胜负情况
		JLabel winlose = new JLabel(String.valueOf(tbl.getTeamWinNum(teamnameAbb))+"W - "+String.valueOf(
				tvo.getData().getMatchNum()-tbl.getTeamWinNum(teamnameAbb))+"L");
		winlose.setForeground(Color.WHITE);
		winlose.setFont(new Font("微软雅黑", Font.BOLD, 22));
		winlose.setBounds(280, 60, 180, 25);
		add(winlose);
		//TODO 比赛场数
		JLabel matchcounts = new JLabel("\u6BD4\u8D5B\u573A\u6570\uFF1A"+String.valueOf(tvo.getData().getMatchNum()));
		matchcounts.setForeground(Color.WHITE);
		matchcounts.setFont(new Font("微软雅黑", Font.BOLD, 12));
		matchcounts.setBounds(480, 55, 80, 15);
		add(matchcounts);
		//TODO 得分
		JLabel points = new JLabel("\u5F97\u5206\uFF1A"+String.valueOf(tvo.getData().getPointNum()));
		points.setForeground(Color.WHITE);
		points.setFont(new Font("微软雅黑", Font.BOLD, 12));
		points.setBounds(480, 70, 80, 15);
		add(points);
		
		int countnum=tvo.getData().getMatchNum();
		
		
		ImageIcon imagebg = new ImageIcon("pictures\\球队背景.png"); 
		imagebg.setImage(imagebg.getImage().getScaledInstance(582,474,Image.SCALE_DEFAULT)); 
		//TODO
		JLabel toulanchushou = new JLabel("\u6295\u7BEE\u51FA\u624B\uFF1A"+getCalc(tvo.getData().getShootNum(),countnum));
		toulanchushou.setForeground(new Color(51, 0, 51));
		toulanchushou.setFont(new Font("黑体", Font.PLAIN, 15));
		toulanchushou.setBounds(270, 95, 150, 18);
		add(toulanchushou);
		//TODO
		JLabel toulanmingzhong = new JLabel("\u6295\u7BEE\u547D\u4E2D\uFF1A"+getCalc(tvo.getData().getFieldGoal(),countnum));
		toulanmingzhong.setForeground(new Color(51, 0, 51));
		toulanmingzhong.setFont(new Font("黑体", Font.PLAIN, 15));
		toulanmingzhong.setBounds(270, 115, 150, 18);
		add(toulanmingzhong);
		//TODO
		JLabel sanfenchushou = new JLabel("\u4E09\u5206\u51FA\u624B\uFF1A"+getCalc(tvo.getData().getT_shootNum(),countnum));
		sanfenchushou.setForeground(new Color(51, 0, 51));
		sanfenchushou.setFont(new Font("黑体", Font.PLAIN, 15));
		sanfenchushou.setBounds(270, 135, 150, 18);
		add(sanfenchushou);
		//TODO
		JLabel sanfenmingzhong = new JLabel("\u4E09\u5206\u547D\u4E2D\uFF1A"+getCalc(tvo.getData().getT_fieldGoal(),countnum));
		sanfenmingzhong.setForeground(new Color(51, 0, 51));
		sanfenmingzhong.setFont(new Font("黑体", Font.PLAIN, 15));
		sanfenmingzhong.setBounds(270, 153, 150, 18);
		add(sanfenmingzhong);
		//TODO
		JLabel faqiuchushou = new JLabel("\u7F5A\u7403\u51FA\u624B\uFF1A"+getCalc(tvo.getData().getFreeThrowNum(),countnum));
		faqiuchushou.setForeground(new Color(51, 0, 51));
		faqiuchushou.setFont(new Font("黑体", Font.PLAIN, 15));
		faqiuchushou.setBounds(270, 173, 150, 18);
		add(faqiuchushou);
		//TODO
		JLabel faqiumingzhong = new JLabel("\u7F5A\u7403\u547D\u4E2D\uFF1A"+getCalc(tvo.getData().getFreeThrowGoalNum(),countnum));
		faqiumingzhong.setForeground(new Color(51, 0, 51));
		faqiumingzhong.setFont(new Font("黑体", Font.PLAIN, 15));
		faqiumingzhong.setBounds(270, 191, 150, 18);
		add(faqiumingzhong);
		//TODO
		JLabel fangui = new JLabel("\u72AF\u89C4\uFF1A"+getCalc(tvo.getData().getFoulNum(),countnum));
		fangui.setForeground(new Color(51, 0, 51));
		fangui.setFont(new Font("黑体", Font.PLAIN, 15));
		fangui.setBounds(270, 210, 150, 18);
		add(fangui);
		//TODO
		JLabel lanban = new JLabel("\u7BEE\u677F\uFF1A"+getCalc(tvo.getData().getReboundNum(),countnum));
		lanban.setForeground(new Color(51, 0, 51));
		lanban.setFont(new Font("黑体", Font.PLAIN, 15));
		lanban.setBounds(422, 95, 150, 18);
		add(lanban);
		//TODO
		JLabel jingonglanban = new JLabel("\u8FDB\u653B\u7BEE\u677F\uFF1A"+getCalc(tvo.getData().getO_ReboundNum(),countnum));
		jingonglanban.setForeground(new Color(51, 0, 51));
		jingonglanban.setFont(new Font("黑体", Font.PLAIN, 15));
		jingonglanban.setBounds(422, 115, 150, 18);
		add(jingonglanban);
		//TODO
		JLabel fangshoulanban = new JLabel("\u9632\u5B88\u7BEE\u677F\uFF1A"+getCalc(tvo.getData().getD_ReboundNum(),countnum));
		fangshoulanban.setForeground(new Color(51, 0, 51));
		fangshoulanban.setFont(new Font("黑体", Font.PLAIN, 15));
		fangshoulanban.setBounds(422, 135, 150, 18);
		add(fangshoulanban);
		//TODO
		JLabel zhugong = new JLabel("\u52A9\u653B\uFF1A"+getCalc(tvo.getData().getAssistNum(),countnum));
		zhugong.setForeground(new Color(51, 0, 51));
		zhugong.setFont(new Font("黑体", Font.PLAIN, 15));
		zhugong.setBounds(422, 153, 150, 18);
		add(zhugong);
		//TODO
		JLabel qiangduan = new JLabel("\u62A2\u65AD\uFF1A"+getCalc(tvo.getData().getStealNum(),countnum));
		qiangduan.setForeground(new Color(51, 0, 51));
		qiangduan.setFont(new Font("黑体", Font.PLAIN, 15));
		qiangduan.setBounds(422, 173, 150, 18);
		add(qiangduan);
		//TODO
		JLabel gaimao = new JLabel("\u76D6\u5E3D\uFF1A"+"12"+getCalc(tvo.getData().getBlockNum(),countnum));
		gaimao.setForeground(new Color(51, 0, 51));
		gaimao.setFont(new Font("黑体", Font.PLAIN, 15));
		gaimao.setBounds(422, 191, 150, 18);
		add(gaimao);
		//TODO
		JLabel shiwu = new JLabel("\u5931\u8BEF\uFF1A"+getCalc(tvo.getData().getTurnoverNum(),countnum));
		shiwu.setForeground(new Color(51, 0, 51));
		shiwu.setFont(new Font("黑体", Font.PLAIN, 15));
		shiwu.setBounds(422, 210, 150, 18);
		add(shiwu);
		
		table = new JTable(){    //设置jtable的单元格为透明的
			public Component prepareRenderer(TableCellRenderer renderer,int row,int column){
				Component c=super.prepareRenderer(renderer,row,column);
				if(c instanceof JComponent){
				((JComponent)c).setOpaque(false);
				}
				return c;
				}
		};
		table.getTableHeader().setOpaque(false);
		
		 
		table.setRowHeight(30);
		table.setForeground(Color.DARK_GRAY);
		table.setFont(new Font("Century", Font.PLAIN, 28));
		table.setBounds(12, 270, 558, 198);
		table.setOpaque(false);
		table.setEnabled(false);
		//TODO
		Object[][] data=getTeamPlayers(tbl.getTeamAllPlayer(teamnameAbb));
		table.setModel(new DefaultTableModel(data,new String[] {""}));
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		  tcr.setHorizontalAlignment(JLabel.CENTER);
		//tcr.setHorizontalAlignment(SwingConstants.CENTER);// 这句和上句作用一样
		table.setDefaultRenderer(Object.class, tcr);
		JTableHeader tableH = table.getTableHeader();
	    //设置表头的背景色
	    tableH.setBackground(new Color(247,162,19));
		//add(table);
		table.setOpaque(false);  
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();   
        render.setOpaque(false); //将渲染器设置为透明  
        
		JScrollPane roll=new JScrollPane(table);
		JScrollBar bar = roll.getVerticalScrollBar();
		bar.setBackground(new Color(247,162,19));
	
		//roll.setUI(new ScrollPaneUI());
		
		
		roll.setPreferredSize(new Dimension(558,198-10)); 
		roll.setBounds(12,270,558,198);
		roll.setVisible(true);
		roll.getViewport().setOpaque(false);
		roll.setOpaque(false);
        roll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	roll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    	add(roll);
		
		JLabel bg = new JLabel(imagebg);
		//photo.setIcon(new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\portrait\\Aaron Brooks.png"));
		bg.setBounds(0,0,582,474);	
		add(bg);
	}
	
	
	private Object[][] getTeamPlayers(ArrayList<String> players){
		String[][] temp=new String[players.size()][1];
		for(int i=0;i<players.size();i++){
			temp[i][0]=players.get(i);
		}	
		return temp;
	}
	
	
	private String getCalc(int data,int count){
		double result=(double)(data/count);
		DecimalFormat df = new DecimalFormat( "0.00");    
		String temp=String.valueOf(df.format(result));
		return temp;
	}
}
