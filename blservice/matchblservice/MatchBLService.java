package matchblservice;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import VO.MatchVO;


public interface MatchBLService extends Remote{
	
    
ArrayList<String> getMatchByTeamTime(String time,String team)throws RemoteException;	//time是日期 形如01-01，表示1月1日，以后可能会有赛季，再添加，不能同时为空
																						//返回的 string 形式“01-01；主队缩写；客队缩写名”
																						//time和team不能同时为null

MatchVO getMatchByTeam(String time,String teamA,String teamB)throws RemoteException;

}
