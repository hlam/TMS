package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.data.validation.Required;
import play.db.jpa.*;
 
@Entity
public class Rank extends Model {
 
    @Required
    public String name;
    @Required
    public String shortName;
 
    public String toString() {
        return name;
    }
}