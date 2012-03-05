package models;

import play.*;
import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

@Entity
public class MedFile extends Model {
	@ManyToOne
	public Patient patient;

	@Required
	@ManyToOne
	public User user;
	
	@Required()
	public Blob file;
	
	@Required()
	@MaxSize(5)
	public String file_ext;

	@Required()
	public String title;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medFile",  fetch = FetchType.LAZY)
	public List<MedImage> images;	
	
	@Required
	public Date create = new Date();
	
	public Date make;

}
