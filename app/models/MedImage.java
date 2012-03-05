package models;

import play.*;
import play.data.validation.Required;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

@Entity
public class MedImage extends Model {

	@Required
	@ManyToOne
	public MedFile medFile;
	
	@Required()
	public Blob small_image; 

	@Required()
	public Blob image; 

	@Required()
	public Integer number; 

	public String title; 

}
