package teamblservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import VO.TeamInfoVO;
import VO.TeamVO;


public interface TeamBLService extends Remote{
	//������Ϊ������ã�������ķ����ظ�
	//public ArrayList<TeamInfoVO> getAllTeamInfo()throws RemoteException;	//��ȡ������ӵĻ�����Ϣ
	public ArrayList<TeamVO> getAllTeam()throws RemoteException;			//��ȡ������ӵĻ�����Ϣ 
	public TeamVO getTeamInfo(String teamAbb)throws RemoteException;		//���������д��ȡ�����Ϣ
	

	//TODO cc��
	//���ʤ��
	public double getTeamWinNum(String teamAbb) throws RemoteException;
	//���һ�����������Ա�������б�
	public ArrayList<String> getTeamAllPlayer(String teamAbb)throws RemoteException;
	
	
	
	
	public ArrayList<TeamVO> sort(String sortItem)throws RemoteException;	//������ӵ�ĳһ�����ݽ�����Ӽ������				//��������ӿ��д����¿��ǣ���û�����


}
