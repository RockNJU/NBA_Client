package VO;

import java.io.Serializable;
import java.util.ArrayList;

public class MatchVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String season;					//����
	private String date;					//����
	private String matchScore;				//��ȷ�
	private ArrayList<String> scores;		//���ڴ���Ľڵıȷ֣�Ϊxx-xx���ַ�����ʽ
	private TeamMatchVO  hostTeam;			//��������
	private TeamMatchVO  guestTeam;			//�Ͷ�����
	
	public MatchVO(String date,String matchScore,
			ArrayList<String>scores,TeamMatchVO ht,TeamMatchVO gt){
		this.season=season;
		this.date=date;
		this.matchScore=matchScore;
		this.scores=scores;
		this.hostTeam=ht;
		this.guestTeam=gt;	
	}

	public String getSeason() {
		return season;
	}

	public String getDate() {
		return date;
	}

	public String getMatchScore() {
		return matchScore;
	}

	public ArrayList<String> getScores() {
		return scores;
	}

	public TeamMatchVO getHostTeam() {
		return hostTeam;
	}

	public TeamMatchVO getGuestTeam() {
		return guestTeam;
	}
}
