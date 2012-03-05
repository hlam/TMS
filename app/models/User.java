package models;

import play.*;
import play.data.binding.As;
import play.data.validation.*;
import play.db.jpa.*;
import play.i18n.Lang;

import javax.persistence.*;

import java.util.*;

@Entity
public class User extends Model {
	@Required()
	@ManyToOne
	public Lpz lpz;
	@Required()
	public String first_name;
	@Required()
	public String last_name;
	public String middle_name;
	
	@Required()
	@Email
	public String email;

	@Phone
	public String phone;

	@Phone
	public String call_phone;

	@Required()
	@ManyToOne
	public Rank rank;
	
	@Required
	@ManyToOne
	public Speciality speciality;
	
	@Required()
	public boolean advisor=true;
	
	@Required()
	@Password
	public String password;
	
	@Required()
	@MaxSize(1)
	public String sex;
	@Required()
	public Date birthday;

	@Required()
	@MaxSize(2)
	public String lang=Lang.get();

	public Blob smallAvatar; 
	public Blob bigAvatar; 
	
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user",  fetch = FetchType.LAZY)
	public List<Diploma> diplomas;	

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user",  fetch = FetchType.LAZY)
	public List<Patient> patients;	

    public static enum Status {BLOCK, REGISTERED, CONFIRMED }
    public static enum AdminStatus {NONE, ADMIN, SITE }
    
    @Required()
    @Enumerated(EnumType.STRING)
    public Status status;
    
    @Required()
    public Integer rating;
    

    @Required()
    @Enumerated(EnumType.STRING)
    public AdminStatus admin;

	@Required
	public Date create = new Date();
    
    public String toString() {
        return first_name+" "+last_name;
    }

	public String getName() {
		return first_name+" "+last_name;
	}

	
	
}
