package SinglePlayerUI;

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
import ShareClass.RMIObject;
import VO.PlayerVO;

public class MoreInfo extends JPanel {

	PlayerVO pvo;
	String playername;
	RMIObject rmi = new RMIObject();
	PlayerBLService pbl;

	public MoreInfo(String name) {
		this.playername = name;
		try {
			pbl = rmi.getPlayerRMI();
			pvo = pbl.getPlayer(playername);
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
				pvo.getData().getShootEfficiency(),
				pvo.getData().getReboundEfficiency(), 
				pvo.getData().getShootEfficiency(), 
				pvo.getData().getShootEfficiency(), 
				pvo.getData().getAssistEfficiency(), 
				pvo.getData().getStealEfficiency(),
				pvo.getData().getBlockEfficiency()
				, pvo.getData().getTurnoverPercenttage(),
				pvo.getData().getUsingPercentage()
				 }, },
				new String[] { "投篮效率", "篮板率", "进攻篮板率", "防守篮板率", "助攻率", "抢断率",
						"盖帽率", "失误率" ,"使用率"}) {
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
		scrollPane.setBounds(18, 125, 554, 450);
		scrollPane.setVisible(true);
		scrollPane.updateUI();
		scrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane);

		// 到此结束
		setLayout(null);
		this.setSize(582, 474);
		this.setBackground(Color.CYAN);

	}

}
