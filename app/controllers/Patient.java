package controllers;

import java.util.List;

import javax.management.Query;

import extjs.*;

import models.User;
import models.sendObject.PatientList;

import play.mvc.*;

public class Patient extends Controller {

    public static void index() {
    	list();
    }
    public static void list() {
    	//User user = Application.connected();
    	StoreArgs storeArgs = new StoreArgs();
    	//String find ="  order by ";
    	String find =" ";
    	String sort = storeArgs.OrderString();
    	if(sort!=null)
    		find+="";
    	else
    		find+=" order by "+sort;
    	System.out.println("find="+find);
    	List<models.Patient> items = models.Patient.find(find).fetch(storeArgs.page, storeArgs.limit);
    	List<PatientList> list = PatientList.ConverPatient(items);
        renderJSON(list);
    }
    public static void combo(String query) {
    	//User user = Application.connected();
    	query = query.toLowerCase();
    	StoreArgs storeArgs = new StoreArgs();
    	String find ="  lower(name) like ? OR lower(city) like ? order by name ";
    	List<models.Patient> items = models.Patient.find(find,  "%"+query+"%", "%"+query+"%").fetch(storeArgs.page, storeArgs.limit);
    	List<PatientList> list = PatientList.ConverPatient(items);
        renderJSON(list);
    }

}
