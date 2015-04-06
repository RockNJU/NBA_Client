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

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Playerchossen dialog = new Playerchossen();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Playerchossen() {
		setBounds(100, 100, 246, 228);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(new Color(252, 212, 146));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		contentPanel.setLayout(new MigLayout("", "[103px][]", "[23px][][][][]"));
		{
			JCheckBox 参赛场数 = new JCheckBox("\u53C2\u8D5B\u573A\u6570");
			contentPanel.add(参赛场数, "cell 0 0,alignx left,aligny top");
		}
		{
			JCheckBox 得分 = new JCheckBox("\u5F97\u5206");
			contentPanel.add(得分, "cell 1 0");
		}
		{
			JCheckBox 篮板数 = new JCheckBox("\u7BEE\u677F\u6570");
			contentPanel.add(篮板数, "cell 0 1");
		}
		{
			JCheckBox 效率 = new JCheckBox("\u6548\u7387");
			contentPanel.add(效率, "cell 1 1");
		}
		{
			JCheckBox 助攻数 = new JCheckBox("\u52A9\u653B\u6570");
			contentPanel.add(助攻数, "cell 0 2");
		}
		{
			JCheckBox Gmsc效率 = new JCheckBox("Gmsc\u6548\u7387");
			contentPanel.add(Gmsc效率, "cell 1 2");
		}
		{
			JCheckBox 抢断数 = new JCheckBox("\u62A2\u65AD\u6570");
			contentPanel.add(抢断数, "cell 0 3");
		}
		{
			JCheckBox 失误数 = new JCheckBox("\u5931\u8BEF\u6570");
			contentPanel.add(失误数, "cell 1 3");
		}
		{
			JCheckBox 盖帽数 = new JCheckBox("\u76D6\u5E3D\u6570");
			contentPanel.add(盖帽数, "cell 0 4");
		}
		{
			JCheckBox 犯规数 = new JCheckBox("\u72AF\u89C4\u6570");
			contentPanel.add(犯规数, "cell 1 4");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
