package mainUI;

import java.util.HashMap;
import java.util.Map;

public class PartitionMap {
	  Map<String, String> map=new HashMap<String, String>();
	  
		
	   public PartitionMap(){
		   map.put("无", " ");
		   map.put("东区", "E");
		   map.put("西区", "W");
		   
		   map.put("太平洋", "Pacific");
		   map.put("大西洋", "Atlantic");
		   map.put("西南", "Southwest");
		   map.put("中部", "Central");
		   map.put("西北部", "Northwest");
		   map.put("东南", "Southeast");
		   
		  // map.put("得分/篮板/助攻", "");
	   }
	   public String getItem(String item){
		   System.out.println("传进来的item："+item);
		   return map.get(item).toString();
	   }
}
