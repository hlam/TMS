package controllers;

import java.util.List;

import play.i18n.Lang;
import play.mvc.*;

public class Country extends Controller {

    public static void index() {
        render();
    }
    public static void combo() {
    	String find ="  order by name_"+Lang.get()+" ";
    	List<models.Country> list = models.Country.find(find).fetch();
        renderJSON(list);

    }

}
