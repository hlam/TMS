package models.sendObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import models.Speciality;

public class SpecialityList  {
	public Long id;
	public String name;
	
	public static List<SpecialityList> Convert(List<Speciality> items){
		List<SpecialityList> ret; 
		ret = new ArrayList<SpecialityList>();
		
		for(Speciality i:items){
			SpecialityList item = new SpecialityList();
			item.id = i.id;
			item.name = i.getName();
			ret.add(item);
			
		}
			
		return ret;
	}
	
}
