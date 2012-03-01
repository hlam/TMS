package models.sendObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import models.Rank;

public class RankList  {
	public Long id;
	public String name;
	public String sortName;
	
	public static List<RankList> Convert(List<Rank> items){
		List<RankList> ret; 
		ret = new ArrayList<RankList>();
		
		for(Rank i:items){
			RankList item = new RankList();
			item.id = i.id;
			item.name = i.getName();
			item.sortName = i.getSortName();
			ret.add(item);
			
		}
			
		return ret;
	}
	
}
