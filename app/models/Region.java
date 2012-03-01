package models;

import play.*;
import play.data.validation.Required;
import play.db.jpa.*;
import play.i18n.Lang;

import javax.persistence.*;

import java.util.*;

@Entity
public class Region extends Model {
/*
	@OneToMany
    @MapKey(name = "lang")
    public Map<String, SomeText> name;
*/    
    public String name_ru;
    public String name_uk;
    public String name_en;
    @ManyToOne
    public Country country;
    public String toString() {
        return getName();
    }
    public String getName() {
    	if(Lang.get().equals("ru"))
    			return name_ru;
    	else if(Lang.get().equals("uk"))
				return name_uk;
    	else return name_en;
    }

}
