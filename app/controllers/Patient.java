package controllers;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import models.History;
import models.Quest;
import models.User;
import models.sendObject.PatientList;
import models.sendObject.QuestList;
import extjs.StoreArgs;
import play.data.binding.As;
import play.mvc.*;

public class Patient extends Controller {

    public static void index() {
        render();
    }
    public static void list() {
    	User user = Application.connected();
    	StoreArgs storeArgs = new StoreArgs();
    	//String find ="  order by ";
    	String find =" order by ";
    	String sort = storeArgs.OrderString();
    	if(sort==null)
    		find+=" name ";
    	else
    		find+=sort;
    	System.out.println("find="+find);
    	List<models.Patient> items = models.Patient.find(find ).fetch(storeArgs.page, storeArgs.limit);
    	List<PatientList> list = PatientList.ConverPatient(items);

        renderJSON(list);
    }
    
    public static void add(String name, String sex, @As("MM/dd/yyyy") Date birthday, Long country_id,  String zipCode, String city,  String address,  String address1,  String tel	) {
    	User user = Application.connected();
    	models.Patient parient =new models.Patient();
    	 parient.country = models.Country.findById(country_id);
    	 parient.region = models.Region.findById(new Long((long)1));
    	 parient.name = name;
    	 parient.sex = sex;
    	 parient.birthday = birthday;
    	 parient.city = city;
    	 parient.isCity = true;
    	 parient.zipCode = zipCode;
    	 parient.address = address;
    	 parient.address1 = address1;
    	 parient.tel = tel;
    	 parient.save();
        renderJSON( new  extjs.Response(true, parient.id));
    }
    

}
