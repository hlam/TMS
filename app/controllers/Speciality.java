package controllers;

import java.util.List;

import models.sendObject.PatientList;
import extjs.StoreArgs;
import play.mvc.*;

public class Speciality extends Controller {

    public static void index() {
        render();
    }
    public static void combo() {
    	String find ="  order by name ";
    	List<models.Speciality> list = models.Speciality.find(find).fetch();
        renderJSON(list);

    }

}
