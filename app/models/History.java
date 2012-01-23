package models;

import play.*;
import play.data.validation.*;
import play.db.jpa.*;

import javax.persistence.*;

import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.*;

@Entity
public class History extends Model {
	@Required
	@ManyToOne
	public Quest quest;
	
	@Required
	@ManyToOne
	public User user;
	@Required
	@ManyToOne
	public User advisor;

	@Required
	@ManyToOne
	public Speciality speciality;

	@Required
	public byte statusIn;
	public byte statusOut;
	
	@Lob
	@MaxSize(20000)
	public String question;

	@Required
	public Date dateIn;
	
	@Required
	public Date dateRes;

	@Lob
	@MaxSize(20000)
	public String diagnos;

    @Column(precision=6, scale=2)
	public BigDecimal price= BigDecimal.ZERO;

    public String toString() {
        return question+":"+advisor.toString();
    }

    
}
