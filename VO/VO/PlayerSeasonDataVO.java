package VO;

import java.io.Serializable;

public class PlayerSeasonDataVO implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;							//球员的姓名
	private String teamName;				//所属球队
	private int matchNum;				//参赛场数
	private int startingNum;				//首发场数
	private double defenseNum;				//防守数
	private double offenseNum;				//������进攻数
	private double time;					//上场时间
	private double BPG; 					//场均盖帽
	private double blockEfficiency;			//盖帽率
	private double efficiency; 				//效率
	private double reboundNum;				//篮板数
	private double assistNum;				//助攻数
	private double turnoverNum;				//失误数
	private double stealNum;				//抢断数
	private double freeThrowPercentage;		//罚球命中率
	private double foulNum;					//犯规数
	private double pointNum; 				//得分
	//�����÷�
	private double threePointPercentage;    //罚球命中率
	private double shootPercentage; 		//Ͷ投篮命中率
	private double shootEfficiency;			//投篮效率
	private double assistEfficiency;        //助攻率
	private double reboundEfficiency;       //篮板率
	private double offensiveReboundEff;     //进攻篮板率
	private double stealEfficiency;			//抢断率
	private double turnoverPercentage;     //失误率
	private double usingPercentage;         //使用率
	private double GmSc;						//GmSc效率值   
	private int seasonDoubleNum;				//2双数
	private int seasonThreeNum;  			//三双数
	
	
	public PlayerSeasonDataVO(String name,String teamName,int matchNum, int startingNum,double defenseNum,
	double offenseNum,double time,double BPG,double blockEfficiency,double efficiency,
	double reboundNum,double assistNum,double turnoverNum,
	double stealNum,double freeThrowPercentage,  double foulNum,double pointNum,
	double threePointPercentage,double shootPercentage,double shootEfficiency,
	double assistEfficiency,double reboundEfficiency,double offensiveReboundEff,
	double stealEfficiency,double turnoverPercenttage,double usingPercentage,
	double GmSc,int doubleNum,int threeNum){
		
				this.name=name;
				this.teamName=teamName;
				this.matchNum=matchNum;
				this.startingNum=startingNum;
				this.defenseNum=defenseNum;
				this.offenseNum=offenseNum;
				this.time=time;
				this.BPG=BPG;
				this.blockEfficiency=blockEfficiency;
				this.efficiency=efficiency;
				this.reboundNum=reboundNum;
				this.assistNum=assistNum;
				this.turnoverNum=turnoverNum;
				this.stealNum=stealNum;
				this.freeThrowPercentage=freeThrowPercentage;this.foulNum=foulNum;this.pointNum=pointNum;
				this.threePointPercentage=threePointPercentage;
				this.shootPercentage=shootPercentage;
				this.shootEfficiency=shootEfficiency;
				this.assistEfficiency=assistEfficiency;
				this.reboundEfficiency=reboundEfficiency;this.offensiveReboundEff=offensiveReboundEff;
				this.stealEfficiency=stealEfficiency;this.turnoverPercentage=turnoverPercentage;
				this.usingPercentage=usingPercentage;
				this.GmSc=GmSc;
				this.seasonDoubleNum=doubleNum;
				this.seasonThreeNum=threeNum;			
	}
	
	
	public String getName(){
		
		return name;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public double getMatchNum() {
		return matchNum;
	}
	public void addMatchNum(){
		 matchNum ++;
	}
	public double getStartingNum() {
		return startingNum;
	}
	public void addStartingNum(double startingNum) {
		 startingNum ++;
	}
	public double getDefenseNum() {
		return defenseNum;
	}
	public void setDefenseNum(int Num) {
		if(matchNum!=0)
			 assistNum = (Num+defenseNum*(matchNum-1))/matchNum;
			else
				defenseNum=Num;
	}
	public double getOffenseNum() {
		return offenseNum;
	}
	public void setOffenseNum(int Num) {
		if(matchNum!=0)
			 assistNum = (Num+offenseNum*(matchNum-1))/matchNum;
			else
				offenseNum=Num;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double Num) {
		if(matchNum!=0)
			 time = (Num+time*(matchNum-1))/matchNum;
			else
				time=Num;
	}
	public double getBlockEfficiency(){
		return blockEfficiency;
	}
	public void setBlockEfficiency(double blockEfficiency) {
		this.blockEfficiency = blockEfficiency;
	}
	public double getEfficiency() {
		return efficiency;
	}
	public void setEfficiency(double efficiency) {
		/*���о�*/
	}
	public double getReboundNum() {
		return reboundNum;
	}
	public void setReboundNum(double Num) {
		if(matchNum!=0)
			 reboundNum = (Num+stealNum*(matchNum-1))/matchNum;
			else
				reboundNum=Num;
	}
	public double getAssistNum() {
		return assistNum;
	}
	public void setAssistNum(double  Num){
		if(matchNum!=0)
			 assistNum = (Num+stealNum*(matchNum-1))/matchNum;
			else
				assistNum=Num;
	}
	public double getTurnoverNum() {
		return turnoverNum;
	}
	public void setTurnoverNum(double Num) {
		if(matchNum!=0)
			turnoverNum =  (Num+turnoverNum*(matchNum-1))/matchNum;
			else
				turnoverNum=Num;
	}
	public double getStealNum(){
		return stealNum;
	}
	public void setStealNum(double  Num) {
		if(matchNum!=0)
		 stealNum =  (Num+stealNum*(matchNum-1))/matchNum;
		else
			stealNum=Num;
	}
	public double getFreeThrowPercentage() {
		return freeThrowPercentage;
	}
	public void setFreeThrowPercentage(int Num) {
		if(matchNum!=0)
			 freeThrowPercentage = (Num+freeThrowPercentage*(matchNum-1))/matchNum;
			else
				freeThrowPercentage=Num;
	}
	public double getFoulNum() {
		return foulNum;
	}
	public void setFoulNum(int Num) {
		if(matchNum!=0)
			 stealNum =  (Num+foulNum*(matchNum-1))/matchNum;
			else
				foulNum=Num;
	}
	public double getPointNum() {
		return pointNum;
	}
	public void setPointNum(int Num) {
		if(matchNum!=0)
			 pointNum =  (Num+pointNum*(matchNum-1))/matchNum;
			else
				pointNum=Num;
	}
	public double getThreePointPercentage() {
		return threePointPercentage;
	}
	public void setThreePointPercentage(double threePointPercentage) {
		/*�˴��д�ϸ��*/
		this.threePointPercentage = threePointPercentage;
	}
	public double getShootPercentage() {
		return shootPercentage;
	}
	public void setShootPercentage(double shootPercentage) {
		this.shootPercentage = shootPercentage;
	}
	public double getShootEfficiency() {
		return shootEfficiency;
	}
	public void setShotEfficiency(double shotEfficiency) {
		this.shootEfficiency = shotEfficiency;
	}
	public double getAssistEfficiency() {
		return assistEfficiency;
	}
	public void setAssistEfficiency(double assistEfficiency) {
		this.assistEfficiency = assistEfficiency;
	}
	public double getReboundEfficiency() {
		return reboundEfficiency;
	}
	public void setReboundEfficiency(double reboundEfficiency) {
		this.reboundEfficiency = reboundEfficiency;
	}
	public double getOffensiveReboundEff() {
		return offensiveReboundEff;
	}
	public void setOffensiveReboundEff(double offensiveReboundEff) {
		this.offensiveReboundEff = offensiveReboundEff;
	}
	public double getStealEfficiency() {
		return stealEfficiency;
	}
	public void setStealEfficiency(double stealEfficiency) {
		this.stealEfficiency = stealEfficiency;
	}
	public double getTurnoverPercenttage() {
		return turnoverPercentage;
	}
	public void setTurnoverPercenttage(double turnoverPercenttage) {
		this.turnoverPercentage = turnoverPercenttage;
	}
	public double getUsingPercentage(){
		return usingPercentage;
	}
	public void setUsingPercentage(double usingPercentage) {
		this.usingPercentage = usingPercentage;
	}
	public double getBPG() {
		return BPG;
	}
	public double getGmSc() {
		return GmSc;
	}



	public int getDoubleNum() {
		return seasonDoubleNum;
	}



	public int getThreeNum() {
		return seasonThreeNum;
	}
	
	
}
