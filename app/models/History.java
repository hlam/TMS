package models;

import play.*;
import play.data.validation.*;
import play.db.jpa.*;

import javax.persistence.*;

import models.Quest.Status;

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
	public boolean isAdvisor;


	@Required
	public Date date;

    @Required()
    @Enumerated(EnumType.STRING)
    public Quest.Status status;



	@Lob
	@MaxSize(20000)
	public String diagnosIn;

	@Lob
	@MaxSize(2000)
	public String question;
	
	@MaxSize(4)
	public String icd_code;
	public Icd icd;
	
	@Lob
	@MaxSize(20000)
	public String diagnos;
	
    @Column(precision=6, scale=2)
	public BigDecimal price= BigDecimal.ZERO;

    public String toString() {
        return date+":"+status;
    }

    
}
