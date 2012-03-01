package models.sendObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import models.Country;

public class CountryList  {
	public Long id;
	public String name;
	
	public static List<CountryList> Convert(List<Country> items){
		List<CountryList> ret; 
		ret = new ArrayList<CountryList>();
		
		for(Country i:items){
			CountryList item = new CountryList();
			item.id = i.id;
			item.name = i.getName();
			ret.add(item);
			
		}
			
		return ret;
	}
	
}
