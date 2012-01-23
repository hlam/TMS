package models;

import play.*;
import play.data.validation.Required;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

@Entity
public class Advisor extends Model {
	@Required
	@ManyToOne
    public User user;
	@Required
	@ManyToOne
    public Speciality speciality;
	
	@Required
	public Integer level;
	@Required
	public Integer type;
    public String toString() {
        return user.name+":"+speciality.name;
    }

}
