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
	public byte status;
	public String status_name;
	
	public static List<QuestList> Convert(List<Quest> quests){
		List<QuestList> ret; 
		ret = new ArrayList<QuestList>();
		for(Quest q:quests){
			QuestList item = new QuestList();
			item.patientName = q.patient.name;
			item.dateIn = q.dateIn;
			item.dateRes = q.dateRes;
			item.ICD10 = q.ICD10;
			item.status = q.status;
			item.status_name = q.getStatusName();
			item.diagnosIn = q.diagnosIn.length()>200?q.diagnosIn.substring(0, 200)+" ...":q.diagnosIn;
			if(q.histories.size()>0){
				History history = q.histories.get(0);
				if(history.speciality!=null)				item.speciality = history.speciality.getName();
				if(history.advisor!=null)  item.advisorName = history.advisor.name;
				item.question = history.question.length()>200?history.question.substring(0, 200)+" ...":history.question;
			}
			ret.add(item);
			
		}
		return ret;
	}
	
}
