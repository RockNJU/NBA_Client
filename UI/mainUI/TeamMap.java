package mainUI;

import java.util.HashMap;
import java.util.Map;

public class TeamMap {
	  Map<String, String> map=new HashMap<String, String>();
	  
		
	   public TeamMap(){
		   map.put("胜率", "winRate");
		   map.put("罚球命中数", "reboundNum");
		   map.put("进攻回合", "offenseRound");
		   map.put("进攻效率", "offenseEfficiency");
		   map.put("防守效率", "defenseEfficiency");
		   map.put("篮板效率", "reboundEfficiency");
		   map.put("抢断效率", "stealEfficiency");
		   map.put("助攻率", "assistEfficiency");
		   map.put("防守篮板数", "D_Rebound");
		   map.put("进攻篮板数", "O_Rebound");
		   
		   
		   //---------------------
		   map.put("罚球出手数", "freeThrowNum");
		   map.put("三分出手数", "T_shootNum");
		   map.put("三分命中数", "T_fieldGoal");
		   map.put("投篮出手次数", "shootNum");	   
		   
		   map.put("投篮命中率", "shootPercentage");
 
		   map.put("比赛得分", "points");
		   map.put("篮板数", "reboundNum");
		   map.put("助攻数", "assistNum");
		    
		   map.put("盖帽数", "blockNum");
		   map.put("抢断数", "stealNum");
		   map.put("犯规数", "foulNum");
		   map.put("失误数", "turoverNum");
		   //map.put("", "");   
		   
		   map.put("三分命中率", "threePointPercentage");	   
		   
		   map.put("罚球命中率", "freeThrowPercentage");
	   }
	   
	   public String getItem(String item){
		   return map.get(item).toString();
	   }
	
}
