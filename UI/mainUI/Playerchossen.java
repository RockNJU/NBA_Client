package mainUI;
// ���������ѡ���б����У����ȷ����ʾ�µı����б���ÿһ���һ��boolean�����飬1������Ҫ��ʾ��0�������á����غ�PLAYERͨ��forѭ����Ϊ��������������(����+����)��

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
			JCheckBox �������� = new JCheckBox("\u53C2\u8D5B\u573A\u6570");
			��������.setBackground(new Color(252, 212, 146));
			��������.setForeground(new Color(67, 54, 49));
			contentPanel.add(��������, "cell 0 0,alignx left,aligny top");
			
			if(��������.isSelected()){
				Result[0] = true;
			}
		}
		{
			JCheckBox �÷� = new JCheckBox("\u5F97\u5206");
			contentPanel.add(�÷�, "cell 1 0");
			�÷�.setBackground(new Color(252, 212, 146));
			�÷�.setForeground(new Color(67, 54, 49));
			if(�÷�.isSelected()){
				Result[1] = true;
			}
		}
		{
			JCheckBox ������ = new JCheckBox("\u7BEE\u677F\u6570");
			contentPanel.add(������, "cell 0 1");
			������.setBackground(new Color(252, 212, 146));
			������.setForeground(new Color(67, 54, 49));
			if(������.isSelected()){
				Result[2] = true;
			}
		}
		{
			JCheckBox Ч�� = new JCheckBox("\u6548\u7387");
			contentPanel.add(Ч��, "cell 1 1");
			Ч��.setBackground(new Color(252, 212, 146));
			Ч��.setForeground(new Color(67, 54, 49));
			if(Ч��.isSelected()){
				Result[3] = true;
			}
		}
		{
			JCheckBox ������ = new JCheckBox("\u52A9\u653B\u6570");
			contentPanel.add(������, "cell 0 2");
			������.setBackground(new Color(252, 212, 146));
			������.setForeground(new Color(67, 54, 49));
			if(������.isSelected()){
				Result[4] = true;
			}
		}
		{
			JCheckBox GmscЧ�� = new JCheckBox("Gmsc\u6548\u7387");
			contentPanel.add(GmscЧ��, "cell 1 2");
			GmscЧ��.setBackground(new Color(252, 212, 146));
			GmscЧ��.setForeground(new Color(67, 54, 49));
			if(GmscЧ��.isSelected()){
				Result[5] = true;
			}
		}
		{
			JCheckBox ������ = new JCheckBox("\u62A2\u65AD\u6570");
			contentPanel.add(������, "cell 0 3");
			������.setBackground(new Color(252, 212, 146));
			������.setForeground(new Color(67, 54, 49));
			if(������.isSelected()){
				Result[6] = true;
			}
		}
		{
			JCheckBox ʧ���� = new JCheckBox("\u5931\u8BEF\u6570");
			contentPanel.add(ʧ����, "cell 1 3");
			ʧ����.setBackground(new Color(252, 212, 146));
			ʧ����.setForeground(new Color(67, 54, 49));
			if(ʧ����.isSelected()){
				Result[7] = true;
			}
		}
		{
			JCheckBox ��˫�� = new JCheckBox("\u76D6\u5E3D\u6570");
			contentPanel.add(��˫��, "cell 0 4");
			��˫��.setBackground(new Color(252, 212, 146));
			��˫��.setForeground(new Color(67, 54, 49));
			if(��˫��.isSelected()){
				Result[8] = true;
			}
		}
		{
			JCheckBox ������ = new JCheckBox("\u72AF\u89C4\u6570");
			contentPanel.add(������, "cell 1 4");
			������.setBackground(new Color(252, 212, 146));
			������.setForeground(new Color(67, 54, 49));
			if(������.isSelected()){
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