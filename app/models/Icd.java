package models;

import play.*;
import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.*;
import play.i18n.Lang;

import javax.persistence.*;

import java.util.*;

@Entity
public class Icd extends Model {

    public String name;
    
	@Required
	@MaxSize(10)
    public String code;
	
    public Icd parent;
	

	@MaxSize(10)
    public String parent_code;

	@Required
	public Integer node_count;

	@Lob
	@MaxSize(1000)
	public String additional_info;

    
    public String toString() {
        return name;
    }


}
