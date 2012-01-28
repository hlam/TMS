package controllers;

import java.util.List;

import models.sendObject.AdvisorList;
import models.sendObject.PatientList;
import extjs.StoreArgs;
import groovy.ui.Console;
import play.mvc.*;

public class Advisor extends Controller {

    public static void index() {
        render();
    }
    public static void combo(String query, Integer speciality_id) {
    	query = query.toLowerCase();
    	StoreArgs storeArgs = new StoreArgs();
    	String find ="  (lower(user.name) like ? OR lower(user.rank.name) like ? OR lower(user.lpz.name) like ?)";
    	if(speciality_id==null) speciality_id= 0;
    	
    	if(speciality_id>0)
    		find+=" AND specialit.id=? ";
    	else
    		find+=" AND 0=? ";
    	find+=" order by user.name ";
    	System.out.println("Advisor.find="+find);
    	List<models.Advisor> items = models.Advisor.find(find,  "%"+query+"%", ""+query+"%", ""+query+"%", speciality_id).fetch(storeArgs.page, storeArgs.limit);
    	System.out.println("Advisor.count="+items.size());
    	List<AdvisorList> list = AdvisorList.Conver(items);
        renderJSON(list);
    }

}
