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
	public Date dateIn;
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
	public byte status;
	
    public String toString() {
        return diagnosIn;
    }

}
