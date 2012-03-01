package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.data.validation.Required;
import play.db.jpa.*;
import play.i18n.Lang;
 
@Entity
public class Speciality extends Model {
 
    @Required
    public String name_ru;
    @Required
    public String name_uk;
    @Required
    public String name_en;
    
    public String toString() {
        return getName();
    }
    public String getName() {
    	if(Lang.get().equals("ru"))
    			return name_ru;
    	if(Lang.get().equals("uk"))
				return name_uk;
		return name_en;
    }


}