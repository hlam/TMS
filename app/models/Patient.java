package models;

import play.*;
import play.data.validation.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

@Entity
public class Patient extends Model {
	@Required
	public String name;
	@Required
	@MaxSize(1)
	public String sex;
	@Required
	public Date birthday;
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
	public boolean isCity;
	
	@Phone
	public String tel;
	
	public Integer status;
	
    public String toString() {
        return name;
    }


}
