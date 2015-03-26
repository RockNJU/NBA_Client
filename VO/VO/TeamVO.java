package VO;

import java.io.Serializable;

public class TeamVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 
	 * ����ֻ���Զ��������޸�
	 * 
	 * 
	 * */
	private TeamInfoVO info;				//	��ӻ�����Ϣ
	private TeamSeasonDataVO data;		//���������Ϣ
	
	public  TeamVO(TeamInfoVO info,TeamSeasonDataVO data){
		this.info=info;
		this.data=data;
	}

	public TeamInfoVO getInfo() {
		return info;
	}

	public TeamSeasonDataVO getData() {
		return data;
	}
}
