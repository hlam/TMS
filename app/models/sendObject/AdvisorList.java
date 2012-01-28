package models.sendObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import play.data.validation.Required;

import models.Advisor;

public class AdvisorList {
	public Long id;
	public String name;
	public String rank;
	public String speciality;
	public String lpzName;
	public String lpzCity;

	public Integer level;
	public Integer type;
	
	
	public static List<AdvisorList> Conver(List<Advisor> advisors){
		List<AdvisorList> ret; 
		ret = new ArrayList<AdvisorList>();
		for(Advisor q:advisors){
			AdvisorList item = new AdvisorList();
			item.id = q.user.id;
			item.name = q.user.name;
			if( q.user.rank!=null)
			item.rank = q.user.rank.name;
			if( q.user.lpz!=null){
				item.lpzName = q.user.lpz.name;
				item.lpzCity = q.user.lpz.city;
			}
			item.level = q.level;
			item.type = q.type;
			item.speciality = q.speciality.name;
			
			ret.add(item);
		}
		return ret;
	}
}
