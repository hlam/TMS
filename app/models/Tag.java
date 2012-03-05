package models;

import play.*;
import play.data.validation.Required;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Tag extends Model {
    @Required
    public String label;
    public String toString() {
        return label;
    }
    
}
