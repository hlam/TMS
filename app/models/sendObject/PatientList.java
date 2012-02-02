package models.sendObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import models.History;
import models.Patient;
import models.Quest;

public class PatientList extends SimplePatient {
	public String address;
	public String tel;
	
	public static List<PatientList> ConverPatient(List<Patient> patients){
		List<PatientList> ret; 
		ret = new ArrayList<PatientList>();
		
		Calendar cal = Calendar.getInstance();
		Calendar dbo = Calendar.getInstance();
		for(Patient i:patients){
			PatientList item = new PatientList();
			ConvertImtem(cal, dbo, i, item);
			item.address = i.address;
			item.tel = i.tel;
			ret.add(item);
			
		}
			
		return ret;
	}
	
}
