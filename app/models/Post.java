package models;

import play.*;
import play.data.validation.Required;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

@Entity
public class Post extends Model {
	@Required
    public String content;
    
	@Required
    public Date postedAt;
    
	@Required
    @OneToOne
    public User postedBy;
    
	@Required
    @ManyToOne
    public Topic topic;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<MedFile> files;	
	
}
