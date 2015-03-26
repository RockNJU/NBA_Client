package VO;

import java.io.Serializable;



public class TeamSeasonDataVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 一支球队的
	 */

	String teamName; 				// 队名
	int matchNum; 					// 比赛场数
	int fieldGoal; // Ͷ��������
	int shootNum; // Ͷ��������
	int T_fieldGoal; // ������������
	int T_shootNum; // �����������
	int freeThrowGoalNum; // ����������
	int freeThrowNum; // ���������
	int O_ReboundNum; // ������ǰ����������
	int D_ReboundNum; // ���أ��󳡣�������
	int assistNum; // ������
	int stealNum; // ������
	int reboundNum; // ��������
	int blockNum; // ��ñ��
	int turnoverNum; // ʧ����
	int foulNum; // ������
	int points; // �÷�
	double shootPercentage; // Ͷ��������
	double threePointPercentage; // ��������������
	double freeThrowPercentage; // ��������������
	double winRate; // ʤ��
	double offenseRound; // �����غ�
	double offenseEfficiency = 0; // ����Ч��
	double defenseEfficiency = 0; // ����Ч��
	double reboundEfficiency = 0; // ����Ч��
	double stealEfficiency = 0; // ������
	double assistEfficiency = 0; // ������

	public TeamSeasonDataVO(String teamName,int matchNum,int fieldGoal,int shootNum,int T_fieldGoal,int T_shootNum,
	int freeThrowGoalNum,int freeThrowNum,int O_ReboundNum,int D_ReboundNum,int assistNum,int stealNum,int reboundNum,int blockNum,
	int turnoverNum,int foulNum,int points,double shootPercentage,double threePointPercentage,double freeThrowPercentage,
	double winRate,double offenseRound,double offenseEfficiency,double defenseEfficiency,double reboundEfficiency,
	double stealEfficiency ,double assistEfficiency){
		this.teamName = teamName; // �����������
		this.matchNum = matchNum ; // ��������
		this.fieldGoal = fieldGoal ; // Ͷ��������
		this.shootNum = shootNum ; // Ͷ��������
		this.T_fieldGoal = T_fieldGoal ; // ������������
		this.T_shootNum = T_shootNum ; // �����������
		this.freeThrowGoalNum =  freeThrowGoalNum; // ����������
		this.freeThrowNum = freeThrowNum; // ���������
		this.O_ReboundNum = O_ReboundNum ; // ������ǰ����������
		this.D_ReboundNum =  D_ReboundNum; // ���أ��󳡣�������
		this.assistNum =  assistNum; // ������
		this.stealNum = stealNum ; // ������
		this.reboundNum = reboundNum ; // ��������
		this.blockNum = blockNum ; // ��ñ��
		this.turnoverNum = turnoverNum ; // ʧ����
		this.foulNum = foulNum ; // ������
		this.points = points ; // �÷�
		this.shootPercentage =  shootPercentage; // Ͷ��������
		this.threePointPercentage = threePointPercentage ; // ��������������
		this.freeThrowPercentage = freeThrowPercentage ; // ��������������
		this.winRate = winRate ; // ʤ��
		this.offenseRound = offenseRound ; // �����غ�
		this.offenseEfficiency = offenseEfficiency; // ����Ч��
		this.defenseEfficiency = defenseEfficiency; // ����Ч��
		this.reboundEfficiency = reboundEfficiency; // ����Ч��
		this.stealEfficiency = stealEfficiency; // ������
		this.assistEfficiency = assistEfficiency; // ������

	}
	
	
	
	public String getTeamName() {
		return teamName;
	}

	public int getPointNum() {
		return points;
	}

	public void setPointNum(int i) {
		this.points = i;
	}
	
	public int getMatchNum(){
		return matchNum;
	}


	public int getReboundNum() {
		return reboundNum;
	}

	public void setReboundNum(int i) {
		this.reboundNum = i;
	}

	public int getO_ReboundNum() {
		return O_ReboundNum;
	}

	public void setO_ReboundNum(int i) {
		this.O_ReboundNum = i;
	}

	public int getD_ReboundNum() {
		return D_ReboundNum;
	}

	public void setD_ReboundNum(int i) {
		this.D_ReboundNum = i;
	}

	public int getAssistNum() {
		return assistNum;
	}

	public void setAssistNum(int i) {
		this.assistNum = i;
	}

	public int getTurnoverNum() {
		return turnoverNum;
	}

	public void setTurnoverNum(int i) {
		this.turnoverNum = i;
	}

	public int getStealNum() {
		return stealNum;
	}

	public void setStealNum(int i) {
		this.stealNum = i;
	}

	public int getFoulNum() {
		return foulNum;
	}

	public void setFoulNum(int i) {
		this.foulNum = i;
	}

	public int getFieldGoal() {
		return fieldGoal;
	}

	public void setFieldGoal(int i) {
		this.fieldGoal = i;
	}

	public int getShootNum() {
		return shootNum;
	}

	public void setShootNum(int i) {
		this.shootNum = i;
	}

	public int getT_fieldGoal() {
		return T_fieldGoal;
	}

	public void setT_fieldGoal(int i) {
		this.T_fieldGoal = i;
	}

	public int getT_shootNum() {
		return T_shootNum;
	}

	public void setT_shootNum(int i) {
		this.T_shootNum = i;
	}

	public int getFreeThrowGoalNum() {
		return freeThrowGoalNum;
	}

	public void setFreeThrowGoalNum(int i) {
		this.freeThrowGoalNum = i;
	}

	public int getFreeThrowNum() {
		return freeThrowNum;
	}

	public void setFreeThrowNum(int i) {
		this.freeThrowNum = i;
	}

	public int getBlockNum() {
		return blockNum;
	}

	public void setBlockNum(int i) {
		this.blockNum = i;
	}

	public double getOffenseRound() {
		return offenseRound;
	}

	public void setOffenseRound(double d) {
		this.offenseRound = d;
	}

	public double getFreeThrowPercentage() {
		return freeThrowPercentage;
	}

	public void setFreeThrowPercentage(double d) {
		this.freeThrowPercentage = d;
	}

	public double getThreePointPercentage() {
		return threePointPercentage;
	}

	public void setThreePointPercentage(double d) {
		this.threePointPercentage = d;
	}

	public double getShootPercentage() {
		return shootPercentage;
	}

	public void setShootPercentage(double d) {
		this.shootPercentage = d;
	}

	public double getAssistEfficiency() {
		return assistEfficiency;
	}

	public void setAssistEfficiency(double d) {
		this.assistEfficiency = d;
	}

	public double getReboundEfficiency() {
		return reboundEfficiency;
	}

	public void setReboundEfficiency(double d) {
		this.reboundEfficiency = d;
	}

	public double getStealEfficiency() {
		return stealEfficiency;
	}

	public void setStealEfficiency(double d) {
		this.stealEfficiency = d;
	}

	public double getDefenseEfficiency() {
		return defenseEfficiency;
	}

	public void setDefenseEfficiency(double d) {
		this.defenseEfficiency = d;
	}

	public double getOffenseEfficiency() {
		return offenseEfficiency;
	}

	public void setOffenseEfficiency(double d) {
		this.offenseEfficiency = d;
	}

	public double getWinRate(){
		return winRate;
	}
}
