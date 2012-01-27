package models.sendObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import models.Patient;

import models.History;
import models.Quest;

public class SimplePatient {
	public String name;
	public int age;
	
	public String sex;
	public String country;
	public String city;
	public Integer status;
	public static List<SimplePatient> Conver(List<Patient> patients){
		List<SimplePatient> ret; 
		ret = new ArrayList<SimplePatient>();
		Calendar cal = Calendar.getInstance();
		Calendar dbo = Calendar.getInstance();
		for(Patient i:patients){
			SimplePatient item = new SimplePatient();
			ConvertImtem(cal, dbo, i, item);
			ret.add(item);
			
		}
		return ret;
	}
	public static void ConvertImtem(Calendar cal, Calendar dbo, Patient i,
			SimplePatient item) {
		item.name = i.name;
		dbo.setTime(i.birthday);
		item.age = cal.get(Calendar.YEAR)-dbo.get(Calendar.YEAR);
		if(dbo.get(Calendar.DAY_OF_YEAR)>=cal.get(Calendar.DAY_OF_YEAR)) item.age--;
		item.sex = i.sex;
		item.country = i.country.name;
		item.city = i.city;
		item.status = i.status;
	}
	
}