package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.data.validation.Required;
import play.db.jpa.*;
import play.i18n.Lang;
 
@Entity
public class Rank extends Model {
 
    @Required
    public String name_ru;
    @Required
    public String shortName_ru;
 
    @Required
    public String name_uk;
    @Required
    public String shortName_uk;

    @Required
    public String name_en;
    @Required
    public String shortName_en;
    
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
    public String getSortName() {
    	if(Lang.get().equals("ru"))
    			return shortName_ru;
    	if(Lang.get().equals("uk"))
				return shortName_uk;
		return shortName_en;
    }

}