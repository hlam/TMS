package models;

import play.*;
import play.data.validation.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

@Entity
public class Patient extends Model {
	
	@Required
	@ManyToOne
	public User user;
	
	@Required()
	public String first_name;
	@Required()
	public String last_name;
	public String middle_name;

	@Required
	@MaxSize(1)
	public String sex;
	@Required
	public Date birthday;
	@Required
	@ManyToOne
	public Country country;
	
	@Required
	@MaxSize(5)
	public String zipCode;
	@Required
	@ManyToOne
	public City city;
	@Required
	@MaxSize(150)
	public String address;
	@MaxSize(150)
	public String address1;
	
	
	@Phone
	public String tel;
	
	public String external_id;
	
	public Integer status;
	
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient",  fetch = FetchType.LAZY)
	public List<MedFile> files;	

	@Required
	public Date create = new Date();
	
    public String toString() {
        return getName();
    }

	public String getName() {
		return first_name+" "+last_name;
	}


}
