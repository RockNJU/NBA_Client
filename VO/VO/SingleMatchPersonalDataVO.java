package VO;

import java.io.Serializable;

public class SingleMatchPersonalDataVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String playerName;				//��Ա����
	 private String playerPosition;			//��Աλ��
	 private String time;					//�����ϳ�ʱ��
	 private int fieldGoal;					//Ͷ��������
	 private int shootNum;					//Ͷ��������
	 private int T_fieldGoal;				//������������
	 private int T_shootNum;				//�����������
	 private int freeThrowGoalNum;			//����������
	 private int freeThrowNum;				//���������
	 private int O_ReboundNum;				//������ǰ����������
	 private int D_ReboundNum;				//���أ��󳡣�������
	 private int reboundNum;				//��������
	 private int assistNum;				    //������
	 private int stealNum;					//������
	 private int blockNum;					//��ñ��
	 private int turnoverNum;				//ʧ����
	 private int foulNum;					//������
	 private int points;					//�÷�
	 
	 private double threePointPercentage=0;    //��������������
		private double shootPercentage=0; 		//Ͷ��������
		private double shootEfficiency=0;			//��ʵ������
		private double assistEfficiency;        //������
		private double reboundEfficiency;       //������
		private double offensiveReboundEff;     //����������
		private double stealEfficiency;			//������
		private double turnoverPercentage=0;     //ʧ����
		private double usingPercentage;         //ʹ����
		private double GmSc;
	 
	 public SingleMatchPersonalDataVO(String name,String p,String time,int fieldGoal,
			 int shootNum,int T_fieldGoal,int T_shootNum,int freeThrowGoalNum,int freeThrowNum,
			 int O_R_N,int D_R_N,int reboundNum,int assistNum,int steal,int blockNum,int turnoverNum,
			 int foulNum,int points ){
		 this.playerName=name;
		 this.playerPosition=p;
		 this.time=time;
		 this.fieldGoal=fieldGoal;
		 this.shootNum=shootNum;
		 this.T_fieldGoal=T_fieldGoal;
		 this.T_shootNum=T_shootNum;
		 this.freeThrowGoalNum=freeThrowGoalNum;
		 this.freeThrowNum=freeThrowNum;
		 this.O_ReboundNum=O_R_N;
		 this.D_ReboundNum=D_R_N;
		 this.reboundNum=reboundNum;
		 this.assistNum=assistNum;
		 this.stealNum=steal;
		 this.blockNum=blockNum;
		 this.turnoverNum=turnoverNum;
		 this.foulNum=foulNum;
		 this.points=points;
		 
		    if(T_shootNum!=0){
		   threePointPercentage=T_fieldGoal/T_shootNum;
		   }
		   
		   if(shootNum!=0){
		 shootPercentage=fieldGoal/shootNum;
		 }
		   if((shootNum+0.44*freeThrowNum)!=0){
		  shootEfficiency=points/(2*(shootNum+0.44*freeThrowNum));
		  }
		   
		 // assistEfficiency;        
			//  reboundEfficiency;       
			 // offensiveReboundEff;   
			  //stealEfficiency;			
		   turnoverPercentage=turnoverNum/((shootNum-T_shootNum)+0.44*
				   freeThrowNum+turnoverNum); 
		   
			  //usingPercentage;    
			  GmSc=points+fieldGoal*0.4-0.7*shootNum-
					  0.4*(freeThrowNum-freeThrowGoalNum)+0.7*O_ReboundNum+0.3*D_ReboundNum
					  +stealNum+0.7*assistNum+0.7*blockNum-0.4*foulNum-turnoverNum;
		 
		 
	 }

	public String getPlayerName() {
		return playerName;
	}

	public String getPlayerPosition() {
		return playerPosition;
	}

	public String getTime() {
		return time;
	}

	public int getFieldGoal() {
		return fieldGoal;
	}

	public int getShootNum() {
		return shootNum;
	}

	public int getT_fieldGoal() {
		return T_fieldGoal;
	}

	public int getT_shootNum() {
		return T_shootNum;
	}

	public int getFreeThrowGoalNum() {
		return freeThrowGoalNum;
	}

	public int getFreeThrowNum() {
		return freeThrowNum;
	}

	public int getO_ReboundNum() {
		return O_ReboundNum;
	}

	public int getD_ReboundNum() {
		return D_ReboundNum;
	}

	public int getReboundNum() {
		return reboundNum;
	}

	public int getAssistNum() {
		return assistNum;
	}

	public int getBlockNum() {
		return blockNum;
	}

	public int getTurnoverNum() {
		return turnoverNum;
	}

	public int getFoulNum() {
		return foulNum;
	}

	public int getPoints(){
		return points;
	}
	public int getStealNum(){
		return stealNum;
	}
	
	public double getThreePointPercentage(){
		return threePointPercentage;
	}
	 
	public double getShootPercentage() {
		return shootPercentage;
	}
	 
	public double getShootEfficiency() {
		return shootEfficiency;
	}
	 
	public double getGmSc() {
		return GmSc;
	}

}
