package ShareClass;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import playerblservice.PlayerBLService;
import teamblservice.TeamBLService;
import matchblservice.*;

public class RMIObject {
		String ip;
		String adress;
		public RMIObject(){
			ip="172.26.1.135";  
			adress="rmi://"+ip;
		}
		
		
		public MatchBLService getMatchRMI() throws MalformedURLException,
		RemoteException, NotBoundException{
			String adr=adress+":8888/matchService";
			
			MatchBLService  mat= (MatchBLService) Naming.lookup(adr);  
			return mat;
		}
		
		
		public PlayerBLService getPlayerRMI () throws MalformedURLException, 
		RemoteException, NotBoundException{
			
			PlayerBLService  pla;
			
			
			
			
			String adress="rmi://"+ip;
			String adr=adress+":8888/playerService";
			
			pla= (PlayerBLService) Naming.lookup(adr);  
			return pla;
		}
		
		public TeamBLService getTeamRMI () throws MalformedURLException, 
		RemoteException, NotBoundException{
			/*String adr=adress+":8888/TeamService";
			TeamBLService  tea= (TeamBLService) Naming.lookup(adr);  */

			String adress="rmi://"+ip;
			String adr=adress+":8888/teamService";
			
           TeamBLService  tea;//= (TeamBLService) Naming.lookup(adr);  
			tea = (TeamBLService) Naming.lookup(adr);
			return tea;
		}
		
		public static void main(String args[]) throws MalformedURLException, RemoteException, NotBoundException{
			
			RMIObject c=new RMIObject();
			TeamBLService t=c.getTeamRMI();
			// t.getAllTeam();
			PlayerBLService p=c.getPlayerRMI();
			
			/*String ip="localhost";   
			String adress="rmi://"+ip;
			String adr=adress+":8888/teamService";
			TeamBLService  tea;//= (TeamBLService) Naming.lookup(adr);  
			tea = (TeamBLService) Naming.lookup(adr);*/
			
			
			System.out.println("--------------");
		}
		
}
