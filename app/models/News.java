package models;

import play.*;
import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.*;

import javax.persistence.*;

import models.User.Status;

import java.util.*;

@Entity
public class News extends Model {
	@Required
    public String subject;

	@Required
    public String sortText;

	@Required
	@Lob
	@MaxSize(2000)
    public String text;

    @Required
    public Integer views = 0;

    @MaxSize(4)
	public String icd_code;
	public Icd icd;

    @ManyToMany
    public List<Tag> tags;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "topic")
    public List<Post> posts;

	@Required
    public Date postedAt;

	@Required
    public Date postedLast;
	
	@Required
	public Blob smallImage; 
	public Blob bigImage; 

	@ManyToOne
	public Speciality speciality;

	@ManyToOne
	public Lpz lpz;
	
    public static enum Types {NEWS, EVENT, VIDEO }
    @Required()
    @Enumerated(EnumType.STRING)
    public Types type;

    public String url;

	
}
