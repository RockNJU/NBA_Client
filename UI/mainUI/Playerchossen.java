package mainUI;
// 在这里可以选择列表的列，点击确定显示新的表格。列表中每一项建立一个boolean的数组，1代表需要显示，0代表不用。返回后，PLAYER通过for循环，为表格中填入内容(标题+内容)。

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;

public class Playerchossen extends JDialog {
	
	boolean[] Result = new boolean[10];

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public boolean[] main() {
		try {
			Playerchossen dialog = new Playerchossen();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result;
	}

	/**
	 * Create the dialog.
	 */
	public Playerchossen() {
		setBounds(100, 100, 246, 228);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(252, 212, 146));
		contentPanel.setForeground(new Color(67, 54, 49));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		contentPanel.setLayout(new MigLayout("", "[103px][]", "[23px][][][][]"));
		{
			JCheckBox 参赛场数 = new JCheckBox("\u53C2\u8D5B\u573A\u6570");
			参赛场数.setBackground(new Color(252, 212, 146));
			参赛场数.setForeground(new Color(67, 54, 49));
			contentPanel.add(参赛场数, "cell 0 0,alignx left,aligny top");
			
			if(参赛场数.isSelected()){
				Result[0] = true;
			}
		}
		{
			JCheckBox 得分 = new JCheckBox("\u5F97\u5206");
			contentPanel.add(得分, "cell 1 0");
			得分.setBackground(new Color(252, 212, 146));
			得分.setForeground(new Color(67, 54, 49));
			if(得分.isSelected()){
				Result[1] = true;
			}
		}
		{
			JCheckBox 篮板数 = new JCheckBox("\u7BEE\u677F\u6570");
			contentPanel.add(篮板数, "cell 0 1");
			篮板数.setBackground(new Color(252, 212, 146));
			篮板数.setForeground(new Color(67, 54, 49));
			if(篮板数.isSelected()){
				Result[2] = true;
			}
		}
		{
			JCheckBox 效率 = new JCheckBox("\u6548\u7387");
			contentPanel.add(效率, "cell 1 1");
			效率.setBackground(new Color(252, 212, 146));
			效率.setForeground(new Color(67, 54, 49));
			if(效率.isSelected()){
				Result[3] = true;
			}
		}
		{
			JCheckBox 助攻数 = new JCheckBox("\u52A9\u653B\u6570");
			contentPanel.add(助攻数, "cell 0 2");
			助攻数.setBackground(new Color(252, 212, 146));
			助攻数.setForeground(new Color(67, 54, 49));
			if(助攻数.isSelected()){
				Result[4] = true;
			}
		}
		{
			JCheckBox Gmsc效率 = new JCheckBox("Gmsc\u6548\u7387");
			contentPanel.add(Gmsc效率, "cell 1 2");
			Gmsc效率.setBackground(new Color(252, 212, 146));
			Gmsc效率.setForeground(new Color(67, 54, 49));
			if(Gmsc效率.isSelected()){
				Result[5] = true;
			}
		}
		{
			JCheckBox 抢断数 = new JCheckBox("\u62A2\u65AD\u6570");
			contentPanel.add(抢断数, "cell 0 3");
			抢断数.setBackground(new Color(252, 212, 146));
			抢断数.setForeground(new Color(67, 54, 49));
			if(抢断数.isSelected()){
				Result[6] = true;
			}
		}
		{
			JCheckBox 失误数 = new JCheckBox("\u5931\u8BEF\u6570");
			contentPanel.add(失误数, "cell 1 3");
			失误数.setBackground(new Color(252, 212, 146));
			失误数.setForeground(new Color(67, 54, 49));
			if(失误数.isSelected()){
				Result[7] = true;
			}
		}
		{
			JCheckBox 两双数 = new JCheckBox("\u76D6\u5E3D\u6570");
			contentPanel.add(两双数, "cell 0 4");
			两双数.setBackground(new Color(252, 212, 146));
			两双数.setForeground(new Color(67, 54, 49));
			if(两双数.isSelected()){
				Result[8] = true;
			}
		}
		{
			JCheckBox 犯规数 = new JCheckBox("\u72AF\u89C4\u6570");
			contentPanel.add(犯规数, "cell 1 4");
			犯规数.setBackground(new Color(252, 212, 146));
			犯规数.setForeground(new Color(67, 54, 49));
			if(犯规数.isSelected()){
				Result[9] = true;
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(252, 212, 146));
			buttonPane.setForeground(new Color(67, 54, 49));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\u786E\u5B9A\u663E\u793A\u9009\u4E2D\u9879\u76EE");
				okButton.setBackground(new Color(220, 88, 15));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("\u53D6\u6D88");
				cancelButton.setActionCommand("Cancel");
				cancelButton.setBackground(new Color(220, 88, 15));
				buttonPane.add(cancelButton);
			}
		}
		

		
	}

}
