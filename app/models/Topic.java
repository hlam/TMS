package models;

import play.*;
import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Topic extends Model {
	@Required
    public String subject;
    
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


}
