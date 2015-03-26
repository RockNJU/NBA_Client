package mainUI;

import java.util.HashMap;
import java.util.Map;

public class locationMap{
	  Map<String, String> map=new HashMap<String, String>();
	  
		
	   public locationMap(){
		   map.put("前锋", "F");
		   map.put("后卫", "G");
		   map.put("中锋", "C");
		  // map.put("得分/篮板/助攻", "");
	   }
	   public String getItem(String item){
		   return map.get(item).toString();
	   }
}