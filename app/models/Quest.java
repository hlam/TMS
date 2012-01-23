package models;

import play.*;
import play.data.validation.*;
import play.db.jpa.*;

import javax.persistence.*;

import org.joda.time.DateTime;

import java.util.*;

@Entity
public class Quest extends Model {
	@Required
	public Byte version;
	
	@Required
	@ManyToOne
	public LPZ lpz;
	@Required
	@ManyToOne
	public User user;
	
	@Required
	@ManyToOne
	public Patient patient;
	@Required
	public Integer type;
	@Required
	public Date dateIn;
	@Required
	public Date dateRes;
	public Date dateOut;
	
	@Required
	@Lob
	@MaxSize(20000)
	public String diagnosIn;
	@Max(4)
	public String ICD10;
	@Required
	public Integer status;
	
    public String toString() {
        return diagnosIn;
    }

}
