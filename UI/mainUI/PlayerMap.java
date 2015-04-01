package mainUI;

import java.util.HashMap;
import java.util.Map;

public class PlayerMap {
     Map<String, String> map=new HashMap<String, String>();
 
	
   public PlayerMap(){
	   map.put("得分", "pointNum");
	   map.put("篮板", "reboundNum");
	   map.put("助攻", "assistNum");
	   map.put("得分/篮板/助攻", "PBA");
	   map.put("盖帽", "BPG");
	   map.put("抢断", "stealNum");
	   map.put("犯规", "foulNum");
	   map.put("失误", "turoverNum");
	   map.put("分钟", "time");
	   map.put("效率", "efficiency");
	   
	   
	   //---------------------
	   map.put("投篮", "shootPercentage");
	   map.put("三分", "threePointPercentage");
	   map.put("罚球", "freeThrowPercentage");
	   map.put("两双", "doubleNum");
	   //map.put("", "");   
   }
   
   public String getItem(String item){
	   return map.get(item).toString();
   }
   
   public static void main(String args[]){
	   PlayerMap m=new PlayerMap();
	   System.out.println("999"+"\u524D\u950B");
	   System.out.println("�Ҿͼ죡"+m.getItem("\u524D\u950B"));
   }
   
}
