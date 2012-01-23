package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.data.validation.Required;
import play.db.jpa.*;
 
@Entity
public class Speciality extends Model {
 
    @Required
    public String name;
    public String toString() {
        return name;
    }

}