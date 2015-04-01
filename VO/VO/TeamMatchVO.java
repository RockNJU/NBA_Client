package VO;

import java.io.Serializable;
import java.util.ArrayList;


public class TeamMatchVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * һ��������һ֧��ӵ��������ݣ���ʾ�����ܺ����� ֻ�ɶ��������޸�
	 */
	private String teamName;
	private int points; // �÷�
	private int defenseNum; // ������
	private int offenseNum; // ������
	private int reboundNum; // ��������
	private int O_ReboundNum; // ������ǰ����������
	private int D_ReboundNum; // ���أ��󳡣�������
	private int assistNum; // ������
	private int turnoverNum; // ʧ����
	private int stealNum; // ������
	private int foulNum; // ������
	private int fieldGoal; // Ͷ��������
	private int shootNum; // Ͷ��������
	private int T_fieldGoal; // ������������
	private int T_shootNum; // �����������
	private int freeThrowGoalNum; // ����������
	private int freeThrowNum; // ���������
	private int blockNum; // ��ñ��
	private double offenseRound; // �����غ�
	private double defenseRound; // ���ػغ�

	private double freeThrowPercentage = 0; // ����������
	private double threePointPercentage = 0; // ����������
	private double shootPercentage = 0; // Ͷ��������
	private double assistEfficiency = 0; // ������
	private double O_ReboundEfficiency = 0; // ����������
	private double D_ReboundEfficiency = 0; // ����������
	private double stealEfficiency = 0; // ������
	private double defenseEfficiency = 0; // ����Ч��
	private double offenseEfficiency = 0; // ����Ч��
	private double reboundEfficiency = 0; // ����Ч��

	private ArrayList<SingleMatchPersonalDataVO> individualData; // �ó�������������Ա��������Ϣ

	public TeamMatchVO(String teamName, int pointNum, int defenseNum,
			int offenseNum, int reboundNum, int O_ReboundNum, int D_ReboundNum,
			int assistNum, int turnoverNum, int stealNum, int foulNum,
			int fieldGoal, int shootNum, int T_fieldGoal, int T_shootNum,
			int freeThrowGoalNum, int freeThrowNum, int blockNum,
			double offenseRound, double defenseRound,
			double freeThrowPercentage, double threePointPercentage,
			double shootPercentage, double assistEfficiency,
			double O_ReboundEfficiency,double D_ReboundEfficiency,
			double stealEfficiency,double defenseEfficiency,
			double offenseEfficiency,
			ArrayList<SingleMatchPersonalDataVO> individualData) {
		this.teamName = teamName;
		this.points = pointNum;
		this.defenseNum = defenseNum;
		this.offenseNum = offenseNum;
		this.reboundNum = reboundNum;
		this.O_ReboundNum = O_ReboundNum;
		this.D_ReboundNum = D_ReboundNum;
		this.assistNum = assistNum;
		this.turnoverNum = turnoverNum;
		this.stealNum = stealNum;
		this.foulNum = foulNum;
		this.fieldGoal = fieldGoal;
		this.shootNum = shootNum;
		this.T_fieldGoal = T_fieldGoal;
		this.T_shootNum = T_shootNum;
		this.freeThrowGoalNum = freeThrowGoalNum;
		this.freeThrowNum = freeThrowNum;
		this.blockNum = blockNum;
		this.offenseRound = offenseRound;
		this.defenseRound = defenseRound;
		this.individualData = individualData;

		this.freeThrowPercentage = freeThrowPercentage; // ����������
		this.threePointPercentage = threePointPercentage; // ����������
		this.shootPercentage = shootPercentage; // Ͷ��������
		this.assistEfficiency = assistEfficiency; // ������
		this.O_ReboundEfficiency = O_ReboundEfficiency; // ����������
		this.D_ReboundEfficiency = D_ReboundEfficiency; // ����������
		this.stealEfficiency = stealEfficiency; // ������
		this.defenseEfficiency = defenseEfficiency; // ����Ч��
		this.offenseEfficiency = offenseEfficiency; // ����Ч��

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

	public int getDefenseNum() {
		return defenseNum;
	}

	public void setDefenseNum(int i) {
		this.defenseNum = i;
	}

	public int getOffenseNum() {
		return offenseNum;
	}

	public void setOffenseNum(int i) {
		this.offenseNum = i;
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

	public double getDefenseRound() {
		return defenseRound;
	}

	public void setDefenseRound(double d) {
		this.defenseRound = d;
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

	public double getO_ReboundEfficiency() {
		return O_ReboundEfficiency;
	}

	public void setO_ReboundEfficiency(double d) {
		this.O_ReboundEfficiency = d;
	}

	public double getD_ReboundEfficiency() {
		return D_ReboundEfficiency;
	}

	public void setD_ReboundEfficiency(double d) {
		this.D_ReboundEfficiency = d;
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

	public ArrayList<SingleMatchPersonalDataVO> getIndividualData() {
		return individualData;
	}

}
