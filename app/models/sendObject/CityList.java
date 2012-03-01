package models.sendObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import models.City;

public class CityList  {
	public Long id;
	public Long region_id;
	public String name;
	
	public static List<CityList> Convert(List<City> items){
		List<CityList> ret; 
		ret = new ArrayList<CityList>();
		
		for(City i:items){
			CityList item = new CityList();
			item.region_id = i.region.id;
			item.id = i.id;
			item.name = i.getName();
			ret.add(item);
			
		}
			
		return ret;
	}
	
}
