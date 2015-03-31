package SinglePlayerUI;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MoreInfo extends JPanel {

	PlayerVO pvo;
	String playername;
	RMIObject rmi=new RMIObject();
	PlayerBLService pbl;
	
	
	public MoreInfo(String name) {
		this.playername=name;
		pbl=rmi.getPlayerRMI();
		pvo=pbl.getPlayer(playername);
		
		
		
		setLayout(null);
		this.setSize(582, 474);
		this.setBackground(Color.CYAN);
		
		
	}

}
