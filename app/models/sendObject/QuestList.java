package models.sendObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.History;
import models.Quest;

public class QuestList {
	public String patientName;
	public String speciality;
	
	public String advisorName;
	public Date dateIn;
	public Date dateRes
	;
	public String diagnosIn;
	public String question;
	public String ICD10;
	public String status;
	public String status_name;
	
	public static List<QuestList> Convert(List<Quest> quests){
		List<QuestList> ret; 
		ret = new ArrayList<QuestList>();
		for(Quest q:quests){
			QuestList item = new QuestList();
			item.patientName = q.patient.getName();
			item.advisorName = q.advisor.getName();
			item.dateIn = q.dateIn;
			item.dateRes = q.dateRes;
			item.ICD10 = q.icd.code+" "+q.icd.name;
			item.status = q.status.toString();
			item.status_name = q.getStatusName();
			item.diagnosIn = q.diagnosIn.length()>200?q.diagnosIn.substring(0, 200)+" ...":q.diagnosIn;
			item.question = q.question.length()>200?q.question.substring(0, 200)+" ...":q.question;
			ret.add(item);
			
		}
		return ret;
	}
	
}
