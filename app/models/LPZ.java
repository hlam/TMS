package models;

import play.*;
import play.data.validation.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

@Entity
public class LPZ extends Model {

	@Required
	public String name;
	@Required
	@ManyToOne
	public Country country;
	@Required
	@ManyToOne
	public Region region;
	
	@Required
	@MaxSize(5)
	public String zipCode;
	@Required
	public String city;
	@Required
	@MaxSize(150)
	public String address;
	@MaxSize(150)
	public String address1;
	
	@Required
	public Integer level;
	@Required
	public Integer type;
	
	public String boss;
	@Max(14)
	public String zkpo;
	
	@Phone
	public String tel;
	
    public String toString() {
        return name;
    }

}
