package SingleTeamUI;

import java.awt.Color;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import playerblservice.PlayerBLService;
import teamblservice.TeamBLService;
import ShareClass.RMIObject;
import VO.PlayerVO;
import VO.TeamVO;

public class MoreInfo_1 extends JPanel {

	TeamVO tvo;
	String teamname;
	RMIObject rmi = new RMIObject();
	TeamBLService tbl;

	public MoreInfo_1(String name) {
		this.teamname = name;
		try {
			tbl = rmi.getTeamRMI();
			tvo = tbl.getTeamInfo(teamname);
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		// 丑陋的表格部分，之后删掉
		JTable matchtable = new JTable();
		matchtable.setBorder(new LineBorder(new Color(67, 54, 49), 2, true));
		matchtable.setForeground(Color.DARK_GRAY);
		matchtable.setBackground(new Color(246, 164, 21));
		matchtable.setSelectionBackground(new Color(67, 54, 49));
		matchtable.setSelectionForeground(Color.WHITE);
		matchtable.setShowVerticalLines(true);// 是否显示垂直网格线?
		matchtable.setGridColor(new Color(67, 54, 49));
		// 获得表头
		JTableHeader tableH = matchtable.getTableHeader();
		// 设置表头的背景色
		tableH.setBackground(new Color(67, 54, 49));
		// 设置表头的文字颜色
		tableH.setForeground(new Color(255, 255, 255));

		matchtable.setDragEnabled(false); // 不许乱拖动
		// matchtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		matchtable.setFillsViewportHeight(true);
		matchtable.getSelectionModel().setSelectionMode(
				ListSelectionModel.SINGLE_SELECTION); // 只允许单选

		matchtable.setModel(new DefaultTableModel(new Object[][] { {
				tvo.getData().getWinRate(),
				tvo.getData().getShootPercentage(), 
				tvo.getData().getThreePointPercentage(), 
				tvo.getData().getFreeThrowPercentage(), 
				tvo.getData().getOffenseEfficiency(), 
				tvo.getData().getDefenseEfficiency(),
				tvo.getData().getReboundEfficiency(), 
				tvo.getData().getStealEfficiency(),
				tvo.getData().getAssistEfficiency()
				 }},
				new String[] { "胜率", "投篮命中率", "三分命中率", "罚球命中率", "进攻效率", "防守效率",
						"篮板效率", "抢断效率" ,"助攻率"}) {
			boolean[] columnEditables = new boolean[] { false, false, false,
					false, false, false, false, false, false, false, false,
					false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		matchtable.getColumnModel().getColumn(0).setPreferredWidth(100);
		matchtable.getColumnModel().getColumn(0).setMinWidth(75);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 15, 554, 450);
		scrollPane.setVisible(true);
		scrollPane.updateUI();
		scrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportView(matchtable);
		add(scrollPane);

		// 到此结束
		setLayout(null);
		this.setSize(582, 474);
		this.setBackground(Color.CYAN);

	}

}
