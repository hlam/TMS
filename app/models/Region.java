package models;

import play.*;
import play.data.validation.Required;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Region extends Model {
    @Required
    public String name;
    
    public String toString() {
        return name;
    }

}
