package models;

import play.*;
import play.data.validation.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

@Entity
public class User extends Model {
	@Required
	@ManyToOne
	public LPZ lpz;
	@Required
	public String name;
	@Required
	@Email
	public String email;
	
	@Required
	@ManyToOne
	public Rank rank;
	@Required
	public boolean advisor;
	
	@Required
	@Password
	public String password;
	
	@Required
	@MaxSize(1)
	public String sex;
	@Required
	public Date birthday;

    public String toString() {
        return name;
    }

	
	
}
