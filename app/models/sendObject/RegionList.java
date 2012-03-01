package models.sendObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import models.Region;

public class RegionList  {
	public Long id;
	public Long country_id;
	public String name;
	
	public static List<RegionList> Convert(List<Region> items){
		List<RegionList> ret; 
		ret = new ArrayList<RegionList>();
		
		for(Region i:items){
			RegionList item = new RegionList();
			item.country_id = i.country.id;
			item.id = i.id;
			item.name = i.getName();
			ret.add(item);
			
		}
			
		return ret;
	}
	
}
