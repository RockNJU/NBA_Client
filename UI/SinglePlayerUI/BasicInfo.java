package SinglePlayerUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.SystemColor;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DecimalFormat;

import javax.swing.SwingConstants;

import mainUI.locationMap;
import playerblservice.PlayerBLService;
import ShareClass.RMIObject;
import VO.PlayerInfoVO;
import VO.PlayerVO;

public class BasicInfo extends JPanel {

	Color back=new Color(247,162,19);
	Color line=new Color(255,83,1);
	ImageIcon image;
	/**
	 * Create the panel.
	 */
	
	PlayerVO pvo;
	
	String playername;
	RMIObject rmi=new RMIObject();
	PlayerBLService pbl;
	
	public BasicInfo(String name) throws MalformedURLException, RemoteException, NotBoundException  {
		
		this.setSize(582, 474);
		setLayout(null);
		
		this.playername=name;

		
		pbl=rmi.getPlayerRMI();
		pvo=pbl.getPlayer(playername);
		File pic=new File("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\portrait\\"+pvo.getInfo().getName()+".png");
		if(!pic.exists()){
			image=new ImageIcon("pictures\\nothing.jpg");
		}else{
		image= new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\portrait\\"+pvo.getInfo().getName()+".png");
		}
		image.setImage(image.getImage().getScaledInstance(178,147,Image.SCALE_DEFAULT)); 		
		JLabel photo = new JLabel(image);		
		photo.setBounds(11, 13, 178, 147);		
		photo.setOpaque(false);
		//photo.setBackground(back);
		add(photo);
		photo.setBorder(BorderFactory.createLineBorder(line));
		//TODO 编号
		JLabel num_1 = new JLabel(String.valueOf(pvo.getInfo().getNumber()));
		num_1.setForeground(new Color(102, 0, 0));
		num_1.setHorizontalAlignment(SwingConstants.CENTER);
		num_1.setFont(new Font("华文行楷", Font.BOLD, 35));
		num_1.setBounds(185, 18, 73, 54);
		add(num_1);
		//TODO 姓名
		JLabel num_2 = new JLabel(pvo.getInfo().getName());
		num_2.setForeground(Color.DARK_GRAY);
		num_2.setFont(new Font("Century", Font.BOLD, 25));
		num_2.setBounds(283, 20, 250, 29);
		add(num_2);
		//TODO 位置/效力球队
		
		
		JLabel num_3 = new JLabel(getlocation(pvo.getInfo().getPosition())+"/"+pvo.getData().getTeamName());
		num_3.setForeground(new Color(102, 0, 51));
		num_3.setFont(new Font("黑体", Font.BOLD, 15));
		num_3.setBounds(283, 50, 220, 20);
		add(num_3);
		/**
		ImageIcon image1 = new ImageIcon("pictures/labelbg.png"); 
		image1.setImage(image1.getImage().getScaledInstance(374,63,Image.SCALE_DEFAULT)); 
		JLabel num = new JLabel(image1);
		num.setBounds(197, 13, 374, 63);
		num.setOpaque(true);
		//num.setBackground(back);
		num.setBorder(BorderFactory.createLineBorder(line));
		add(num);
		*/
		JLabel weight = new JLabel("\u4F53\u91CD\uFF1A");
		weight.setForeground(Color.DARK_GRAY);
		weight.setFont(new Font("黑体", Font.PLAIN, 14));
		weight.setBounds(208, 80, 50, 16);
		add(weight);
		
		JLabel height = new JLabel("\u8EAB\u9AD8\uFF1A");
		height.setForeground(Color.DARK_GRAY);
		height.setFont(new Font("黑体", Font.PLAIN, 14));
		height.setBounds(208, 95, 50, 16);
		add(height);
		
		JLabel birth = new JLabel("\u751F\u65E5\uFF1A");
		birth.setForeground(Color.DARK_GRAY);
		birth.setFont(new Font("黑体", Font.PLAIN, 14));
		birth.setBounds(208, 112, 50, 16);
		add(birth);
		//TODO
		JLabel weightinfo = new JLabel(String.valueOf(pvo.getInfo().getWeight()));
		weightinfo.setForeground(Color.DARK_GRAY);
		weightinfo.setLabelFor(weight);
		weightinfo.setFont(new Font("黑体", Font.PLAIN, 14));
		weightinfo.setBounds(254, 80, 100, 16);
		add(weightinfo);
		//TODO
		JLabel heightinfo = new JLabel(pvo.getInfo().getHeight());
		heightinfo.setForeground(Color.DARK_GRAY);
		heightinfo.setFont(new Font("黑体", Font.PLAIN, 14));
		heightinfo.setBounds(254, 96, 100, 16);
		add(heightinfo);
		//TODO
		JLabel birthinfo = new JLabel(pvo.getInfo().getBirth());
		birthinfo.setForeground(Color.DARK_GRAY);
		birthinfo.setFont(new Font("黑体", Font.PLAIN, 14));
		birthinfo.setBounds(254, 112, 100, 16);
		add(birthinfo);
		
		JLabel age = new JLabel("\u5E74\u9F84\uFF1A");
		age.setForeground(Color.DARK_GRAY);
		age.setFont(new Font("黑体", Font.PLAIN, 14));
		age.setBounds(387, 80, 50, 16);
		add(age);
		
		JLabel ballage = new JLabel("\u7403\u9F84\uFF1A");
		ballage.setForeground(Color.DARK_GRAY);
		ballage.setFont(new Font("黑体", Font.PLAIN, 14));
		ballage.setBounds(387, 95, 50, 16);
		add(ballage);
		
		JLabel graduation = new JLabel("\u6BD5\u4E1A\u9662\u6821\uFF1A");
		graduation.setForeground(Color.DARK_GRAY);
		graduation.setFont(new Font("黑体", Font.PLAIN, 14));
		graduation.setBounds(387, 112, 70, 16);
		add(graduation);
		//TODO
		JLabel ageinfo = new JLabel(String.valueOf(pvo.getInfo().getAge()));
		ageinfo.setForeground(Color.DARK_GRAY);
		ageinfo.setFont(new Font("黑体", Font.PLAIN, 14));
		ageinfo.setBounds(433, 80, 100, 16);
		add(ageinfo);
		//TODO
		JLabel ballageinfo = new JLabel(String.valueOf(pvo.getInfo().getExp())+"\u5E74");
		ballageinfo.setForeground(Color.DARK_GRAY);
		ballageinfo.setFont(new Font("黑体", Font.PLAIN, 14));
		ballageinfo.setBounds(433, 96, 100, 16);
		add(ballageinfo);
		//TODO
		JLabel graduinfo = new JLabel(pvo.getInfo().getSchool());
		graduinfo.setForeground(Color.DARK_GRAY);
		graduinfo.setFont(new Font("黑体", Font.PLAIN, 14));
		graduinfo.setBounds(450, 112, 100, 16);
		add(graduinfo);
		
	//	ImageIcon image2 = new ImageIcon("pictures/labelbg.png"); 
	//	image2.setImage(image2.getImage().getScaledInstance(374,51,Image.SCALE_DEFAULT)); 
	//	JLabel personalinfo = new JLabel(image2);
	//	personalinfo.setBounds(197, 79, 374, 51);
	//	personalinfo.setOpaque(true);
		//personalinfo.setBackground(back);
	//	personalinfo.setBorder(BorderFactory.createLineBorder(line));
	//	add(personalinfo);
		
		JLabel point = new JLabel("\u5F97\u5206\uFF1A");
		point.setForeground(Color.DARK_GRAY);
		point.setFont(new Font("黑体", Font.PLAIN, 16));
		point.setBounds(208, 136, 70, 20);
		add(point);
		//TODO
		JLabel pointinfo = new JLabel(String.valueOf(pvo.getData().getPointNum()));
		pointinfo.setForeground(Color.DARK_GRAY);
		pointinfo.setFont(new Font("黑体", Font.PLAIN, 16));
		pointinfo.setBounds(260, 136, 100, 20);
		add(pointinfo);
		
		JLabel prate = new JLabel("\u6548\u7387\uFF1A");
		prate.setForeground(Color.DARK_GRAY);
		prate.setFont(new Font("黑体", Font.PLAIN, 16));
		prate.setBounds(321, 136, 70, 20);
		add(prate);
		//TODO
		JLabel prateinfo = new JLabel(String.valueOf(pvo.getData().getEfficiency()));
		prateinfo.setForeground(Color.DARK_GRAY);
		prateinfo.setFont(new Font("黑体", Font.PLAIN, 16));
		prateinfo.setBounds(373, 136, 100, 20);
		add(prateinfo);
		
		JLabel GMSC = new JLabel("GMSC\u6548\u7387\uFF1A");
		GMSC.setForeground(Color.DARK_GRAY);
		GMSC.setFont(new Font("黑体", Font.PLAIN, 16));
		GMSC.setBounds(430, 136, 100, 20);
		add(GMSC);
		//TODO
		JLabel GMSCinfo = new JLabel(String.valueOf(pvo.getData().getGmSc()));
		GMSCinfo.setForeground(Color.DARK_GRAY);
		GMSCinfo.setFont(new Font("黑体", Font.PLAIN, 16));
		GMSCinfo.setBounds(512, 136, 50, 20);
		add(GMSCinfo);
		
		//ImageIcon image3 = new ImageIcon("pictures/labelbg.png"); 
		//image3.setImage(image3.getImage().getScaledInstance(374,27,Image.SCALE_DEFAULT)); 
		//JLabel matchrate = new JLabel(image3);
		//matchrate.setBounds(197, 133, 374, 27);
		//matchrate.setOpaque(true);
		//matchrate.setBackground(back);
		//matchrate.setBorder(BorderFactory.createLineBorder(line));
		//add(matchrate);
		
		JLabel joinnum = new JLabel("\u53C2\u8D5B\u573A\u6570\uFF1A");
		joinnum.setForeground(Color.DARK_GRAY);
		joinnum.setFont(new Font("黑体", Font.PLAIN, 17));
		joinnum.setBounds(50, 168, 90, 25);
		add(joinnum);
		
		JLabel joinnuminfo = new JLabel(String.valueOf(pvo.getData().getMatchNum()));
		joinnuminfo.setForeground(Color.DARK_GRAY);
		joinnuminfo.setFont(new Font("黑体", Font.PLAIN, 17));
		joinnuminfo.setBounds(130, 168, 80, 25);
		add(joinnuminfo);
		
		JLabel firstnum = new JLabel("\u5148\u53D1\u573A\u6570\uFF1A");
		firstnum.setForeground(Color.DARK_GRAY);
		firstnum.setFont(new Font("黑体", Font.PLAIN, 17));
		firstnum.setBounds(218, 168, 90, 25);
		add(firstnum);
		
		JLabel firstnuminfo = new JLabel(String.valueOf(pvo.getData().getStartingNum()));
		firstnuminfo.setForeground(Color.DARK_GRAY);
		firstnuminfo.setFont(new Font("黑体", Font.PLAIN, 17));
		firstnuminfo.setBounds(298, 168, 80, 25);
		add(firstnuminfo);
		
		JLabel ontime = new JLabel("\u5728\u573A\u65F6\u95F4\uFF1A");
		ontime.setForeground(Color.DARK_GRAY);
		ontime.setFont(new Font("黑体", Font.PLAIN, 17));
		ontime.setBounds(411, 168, 90, 25);
		add(ontime);
		
		JLabel ontimeinfo = new JLabel(String.valueOf(pvo.getData().getTime()));
		ontimeinfo.setForeground(Color.DARK_GRAY);
		ontimeinfo.setFont(new Font("黑体", Font.PLAIN, 17));
		ontimeinfo.setBounds(491, 168, 80, 25);
		add(ontimeinfo);
	/**	
		ImageIcon image4 = new ImageIcon("pictures/labelbg.png"); 
		image4.setImage(image4.getImage().getScaledInstance(560,30,Image.SCALE_DEFAULT)); 
		JLabel matchcount = new JLabel(image4);
		matchcount.setBounds(11, 166, 560, 30);
		matchcount.setOpaque(true);
		//matchcount.setBackground(back);
		matchcount.setBorder(BorderFactory.createLineBorder(line));
		add(matchcount);
		
		ImageIcon image5 = new ImageIcon("pictures/labelbg.png"); 
		image5.setImage(image5.getImage().getScaledInstance(560,86,Image.SCALE_DEFAULT)); 
		*/
		JLabel count1 = new JLabel("\u7BEE\u677F\u6570\uFF1A");
		count1.setForeground(Color.DARK_GRAY);
		count1.setFont(new Font("黑体", Font.PLAIN, 18));
		count1.setBounds(70, 207, 80, 22);
		add(count1);
		//TODO 篮板数
		JLabel count1info = new JLabel(String.valueOf(pvo.getData().getReboundNum()));
		count1info.setForeground(Color.DARK_GRAY);
		count1info.setFont(new Font("黑体", Font.PLAIN, 18));
		count1info.setBounds(138, 207, 54, 22);
		add(count1info);
		
		JLabel count2 = new JLabel("\u52A9\u653B\u6570\uFF1A");
		count2.setForeground(Color.DARK_GRAY);
		count2.setFont(new Font("黑体", Font.PLAIN, 18));
		count2.setBounds(70, 234, 80, 22);
		add(count2);
		//TODO 助攻数
		JLabel count2info = new JLabel(String.valueOf(pvo.getData().getAssistNum()));
		count2info.setForeground(Color.DARK_GRAY);
		count2info.setFont(new Font("黑体", Font.PLAIN, 18));
		count2info.setBounds(138, 234, 54, 22);
		add(count2info);
		
		JLabel count3 = new JLabel("\u8FDB\u653B\u6570\uFF1A");
		count3.setForeground(Color.DARK_GRAY);
		count3.setFont(new Font("黑体", Font.PLAIN, 18));
		count3.setBounds(70, 259, 80, 22);
		add(count3);
		//TODO 进攻数
		JLabel count3info = new JLabel(String.valueOf(pvo.getData().getOffenseNum()));
		count3info.setForeground(Color.DARK_GRAY);
		count3info.setFont(new Font("黑体", Font.PLAIN, 18));
		count3info.setBounds(138, 259, 54, 22);
		add(count3info);
		
		JLabel count4 = new JLabel("\u9632\u5B88\u6570\uFF1A");
		count4.setForeground(Color.DARK_GRAY);
		count4.setFont(new Font("黑体", Font.PLAIN, 18));
		count4.setBounds(235, 207, 80, 22);
		add(count4);
		//TODO 防守数
		JLabel count4info = new JLabel(String.valueOf(pvo.getData().getDefenseNum()));
		count4info.setForeground(Color.DARK_GRAY);
		count4info.setFont(new Font("黑体", Font.PLAIN, 18));
		count4info.setBounds(304, 207, 54, 22);
		add(count4info);
		
		JLabel count5 = new JLabel("\u62A2\u65AD\u6570\uFF1A");
		count5.setForeground(Color.DARK_GRAY);
		count5.setFont(new Font("黑体", Font.PLAIN, 18));
		count5.setBounds(235, 234, 80, 22);
		add(count5);
		//TODO 抢断数
		JLabel count5info = new JLabel(String.valueOf(pvo.getData().getStealNum()));
		count5info.setForeground(Color.DARK_GRAY);
		count5info.setFont(new Font("黑体", Font.PLAIN, 18));
		count5info.setBounds(304, 234, 54, 22);
		add(count5info);
		
		JLabel count6 = new JLabel("\u76D6\u5E3D\u6570\uFF1A");
		count6.setForeground(Color.DARK_GRAY);
		count6.setFont(new Font("黑体", Font.PLAIN, 18));
		count6.setBounds(235, 259, 80, 22);
		add(count6);
		//TODO 盖帽数
		JLabel count6info = new JLabel(String.valueOf(pvo.getData().getBPG()));
		count6info.setForeground(Color.DARK_GRAY);
		count6info.setFont(new Font("黑体", Font.PLAIN, 18));
		count6info.setBounds(304, 259, 54, 22);
		add(count6info);
		
		JLabel count7 = new JLabel("\u5931\u8BEF\u6570\uFF1A");
		count7.setForeground(Color.DARK_GRAY);
		count7.setFont(new Font("黑体", Font.PLAIN, 18));
		count7.setBounds(387, 207, 80, 22);
		add(count7);
		//TODO 失误数
		JLabel count7info = new JLabel(String.valueOf(pvo.getData().getTurnoverNum()));
		count7info.setForeground(Color.DARK_GRAY);
		count7info.setFont(new Font("黑体", Font.PLAIN, 18));
		count7info.setBounds(455, 207, 54, 22);
		add(count7info);
		
		JLabel count8 = new JLabel("\u72AF\u89C4\u6570\uFF1A");
		count8.setForeground(Color.DARK_GRAY);
		count8.setFont(new Font("黑体", Font.PLAIN, 18));
		count8.setBounds(387, 234, 80, 22);
		add(count8);
		//TODO 犯规数
		JLabel count8info = new JLabel(String.valueOf(pvo.getData().getFoulNum()));
		count8info.setForeground(Color.DARK_GRAY);
		count8info.setFont(new Font("黑体", Font.PLAIN, 18));
		count8info.setBounds(455, 234, 54, 22);
		add(count8info);
		
		//投篮命中率
		ImageIcon info_1 = new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\1-100\\投篮命中率.png"); 
		info_1.setImage(info_1.getImage().getScaledInstance(97,79,Image.SCALE_DEFAULT)); 
		JLabel info1 = new JLabel(info_1);
		//photo.setIcon(new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\portrait\\Aaron Brooks.png"));
		info1.setBounds(66, 325, 97, 79);
		info1.setOpaque(false);
		add(info1);
		
		ImageIcon percent_1 = new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\1-100\\命中率_"+getpicturename(pvo.getData().getShootPercentage())+".png"); 
		percent_1.setImage(percent_1.getImage().getScaledInstance(188,185,Image.SCALE_DEFAULT)); 
		JLabel percent1 = new JLabel(percent_1);
		//photo.setIcon(new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\portrait\\Aaron Brooks.png"));
		percent1.setBounds(17, 282, 188, 185);
		percent1.setOpaque(false);
		add(percent1);
		
	
		
		ImageIcon info_2 = new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\1-100\\三分命中率.png"); 
		info_2.setImage(info_2.getImage().getScaledInstance(97,79,Image.SCALE_DEFAULT)); 
		JLabel info2 = new JLabel(info_2);
		//photo.setIcon(new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\portrait\\Aaron Brooks.png"));
		info2.setBounds(243, 325, 97, 79);
		info2.setOpaque(false);
		add(info2);
		//158,157
		//197,457
		//三分命中率
		ImageIcon percent_2 = new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\1-100\\命中率_"+getpicturename(pvo.getData().getShootPercentage())+".png"); 
		percent_2.setImage(percent_2.getImage().getScaledInstance(188,185,Image.SCALE_DEFAULT)); 		
		JLabel percent2 = new JLabel(percent_2);
		//photo.setIcon(new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\portrait\\Aaron Brooks.png"));
		percent2.setBounds(196, 282,188,185);
		percent2.setOpaque(false);
		add(percent2);
		
		
		ImageIcon info_3 = new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\1-100\\罚球命中率.png"); 
		info_3.setImage(info_3.getImage().getScaledInstance(97,79,Image.SCALE_DEFAULT)); 
		JLabel info3 = new JLabel(info_3);
		//photo.setIcon(new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\portrait\\Aaron Brooks.png"));
		info3.setBounds(423, 325, 97, 79);
		info3.setOpaque(false);
		add(info3);
		//罚球命中率
		ImageIcon percent_3 = new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\1-100\\命中率_"+getpicturename(pvo.getData().getShootPercentage())+".png"); 
		percent_3.setImage(percent_3.getImage().getScaledInstance(188,185,Image.SCALE_DEFAULT)); 		
		JLabel percent3 = new JLabel(percent_3);
		//photo.setIcon(new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\portrait\\Aaron Brooks.png"));
		percent3.setBounds(374, 282, 188,185);
		percent3.setOpaque(false);
		add(percent3);
		/**
		JLabel match = new JLabel(image5);
		match.setFont(new Font("微软雅黑", Font.BOLD, 16));
		match.setBounds(11, 202, 560, 86);
		match.setOpaque(true);
		//matchcount.setBackground(back);
		match.setBorder(BorderFactory.createLineBorder(line));
		add(match);

		ImageIcon image6 = new ImageIcon("pictures/labelbg.png"); 
		image6.setImage(image6.getImage().getScaledInstance(560,174,Image.SCALE_DEFAULT)); 
		
		JLabel graph = new JLabel(image6);
		graph.setFont(new Font("微软雅黑", Font.BOLD, 16));
		graph.setBounds(11, 294, 560, 174);
		graph.setOpaque(true);
		//matchcount.setBackground(back);
		graph.setBorder(BorderFactory.createLineBorder(line));
		add(graph);
		*/
		
		ImageIcon imagebg = new ImageIcon("pictures\\playerinfo\\球员背景.png"); 
		imagebg.setImage(imagebg.getImage().getScaledInstance(582,474,Image.SCALE_DEFAULT)); 
		JLabel bg = new JLabel(imagebg);
		//photo.setIcon(new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pictures\\portrait\\Aaron Brooks.png"));
		bg.setBounds(0,0,582,474);	
		add(bg);
	}
	
	
	
	private String getpicturename(double rate){
		rate=rate*100;		
		DecimalFormat df = new DecimalFormat( "00000");    
		String temp=String.valueOf(df.format(rate));
		while(temp.length()<5){
			temp="0"+temp;
		}
		System.out.println(temp);
		return temp;
		
	}
	
	
	private String getlocation(String lo){
	    if(lo.equals("G")){
	    	return "后卫";
	    }else if(lo.equals("C")){
	    	return "中锋";
	    }else if(lo.equals("F")){
	    	return "前锋";
	    }else{
	    	return "未知";
	    }
	}
}
