package playerblservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import VO.PlayerInfoVO;
import VO.PlayerVO;

public interface PlayerBLService extends Remote{
	public ArrayList<PlayerVO> getAllPlayer()throws RemoteException;		
	public PlayerVO getPlayer(String name)throws RemoteException;
	public ArrayList<PlayerVO> getPlayerInfo(String name)throws RemoteException;		        //
	public ArrayList<PlayerVO> sort(String position,String paitition,String item)throws RemoteException;	
	
}
