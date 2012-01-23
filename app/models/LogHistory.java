package models;

import play.*;
import play.data.validation.Required;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

@Entity
public class LogHistory extends Model {
	@Required
	@ManyToOne
	public History history;

	@Required
	@ManyToOne
	public User user;
	
	
	@Required
	public Date dateEvent;
	
	@Required
	public byte event;
	
    public String toString() {
        return dateEvent.toString()+" "+history.toString();
    }

}
