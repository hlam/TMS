package controllers;

import java.util.List;

import javax.management.Query;

import extjs.*;

import models.*;
import models.sendObject.QuestList;

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
    	List<QuestList> list = QuestList.Conver(quests);
        renderJSON(list);
    }

}
