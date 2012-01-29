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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quest")
	public List<History> histories;

	@Required
	@ManyToOne
	public Patient patient;
	@Required
	public Integer type;
	@Required
	public Date dateIn  = new Date();
	@Required
	public Date dateRes;
	public Date dateOut;
	
	@Required
	@Lob
	@MaxSize(20000)
	public String diagnosIn;
	@MaxSize(4)
	public String ICD10;
	@Required
	public byte status=1;
	
	public String getStatusName(){
		switch(this.status){
		case 1: 
			return "запрос";
		case 5: 
			return "в работе";	
		case 20: 
			return "закрытое";	
		}
		return "";
	}
	
    public String toString() {
        return diagnosIn;
    }

}
