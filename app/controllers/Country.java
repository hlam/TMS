package controllers;

import java.util.List;

import play.mvc.*;

public class Country extends Controller {

    public static void index() {
        render();
    }
    public static void combo() {
    	String find ="  order by name ";
    	List<models.Country> list = models.Country.find(find).fetch();
        renderJSON(list);

    }

}
