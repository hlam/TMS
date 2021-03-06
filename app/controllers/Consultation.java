package controllers;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.management.Query;

import extjs.*;

import models.*;
import models.sendObject.QuestList;	
import models.sendObject.UserLogin;
import play.data.binding.As;
import play.mvc.*;

public class Consultation extends Controller {

    public static void index() {
    	list();
    }
    public static void list() {
    	User user = Application.connected();
    	StoreArgs storeArgs = new StoreArgs();
    	//String find ="  order by ";
    	String find =" user = ? order by ";
    	String sort = storeArgs.OrderString();
    	if(sort==null)
    		find+=" dateIn ";
    	else
    		find+=sort;
    	System.out.println("find="+find);
    	List<Quest> quests = Quest.find(find, user ).fetch(storeArgs.page, storeArgs.limit);
    	List<QuestList> list = QuestList.Convert(quests);
        renderJSON(list);
    }
    
    public static void add(Long patient_id, String diagnosIn, Long speciality_id,  Long advisor_id, String question, @As("MM/dd/yyyy") Date dateRes, BigDecimal price	) {
    	User user = Application.connected();
    	Quest quest=new Quest();
    	quest.user = user;
    	quest.patient = models.Patient.findById(patient_id);
    	quest.diagnosIn = diagnosIn; 
    	quest.dateRes = dateRes;
    	quest.advisor = User.findById(advisor_id);
    	quest.price = price;
    	quest.question = question;
    	quest.save();
    	History history=new History();
    	history.question = question;
    	history.price = price;
    	history.quest = quest;
    	history.save();
    	LongPolling.Quest(advisor_id, quest.id, "new");
        renderJSON( new  extjs.Response(true, quest.id));
    }
    

}
