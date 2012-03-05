package models;

import play.*;
import play.data.validation.*;
import play.db.jpa.*;

import javax.persistence.*;
import javax.swing.text.StyledEditorKit.BoldAction;

import models.User.Status;

import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.*;

@Entity
public class Quest extends Model {
	
	public String external_id;
	@Required
	@ManyToOne
	public Patient patient;
	
	@Required
	@ManyToOne
	public User user;
	
	@Required
	@ManyToOne
	public User advisor;
	
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<MedFile> files;	

    public static enum Status {NEW, REVIEW, INPROGRESS, CANCEL_ASVISOR, CANCEL_USER, TIMEOUT, POSITIVE, NEGATIVE }
    
    @Required()
    @Enumerated(EnumType.STRING)
    public Status status;

    @Required()
    public Boolean open=true;
	

	@Required
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quest")
	public List<History> histories;

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

	@Required
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

	public String getStatusName(){
		
		if(this.status==Status.NEW){
			return "новая";
		}else if(this.status==Status.INPROGRESS){
			return "в работе";
		}else if(this.status==Status.REVIEW){
			return "просмотрено";
		}else if(this.status==Status.CANCEL_ASVISOR){
			return "отказ консультанта";
		}else if(this.status==Status.CANCEL_ASVISOR){
			return "отказ пользователя";
		}else if(this.status==Status.TIMEOUT){
			return "истек срок свежести";
		}else if(this.status==Status.POSITIVE){
			return "закрытие (+)";
		}else if(this.status==Status.NEGATIVE){
			return "закрытие (-)";
		}
		return "";
	}
	
    public String toString() {
        return diagnosIn;
    }

}
