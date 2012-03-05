package models;

import play.*;
import play.data.validation.Email;
import play.data.validation.Required;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

@Entity
public class Diploma extends Model {
	@Required
	@ManyToOne
	public User user;

	@Required()
	public Date end_date;

	@Required()
	public String university_name;
	@Required()
	public String specialty;
	
	@Required()
	public String number;
	
	@Required()
	public Blob scan1; 

	public Blob scan2; 

    public String toString() {
        return university_name+" "+specialty;
    }

}
