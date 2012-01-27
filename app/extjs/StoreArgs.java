package extjs;

import java.util.List;

import play.db.jpa.GenericModel;
import play.db.jpa.GenericModel.JPAQuery;
import play.mvc.Scope;
import com.google.gson.*;

import extjs.SortOrder.SortDirection;
public class StoreArgs {



    public SortOrder[] sort;

    public int page=1;
    public int start=0;
    public int limit=50;

    public  StoreArgs(){
    	String val; 
    	Scope.Params params = Scope.Params.current();
    	val = params.get("page");
    	if(val!=null) page = Integer.parseInt(val);
    	val = params.get("start");
    	if(val!=null) start = Integer.parseInt(val);
    	val = params.get("limit");
    	if(val!=null) limit = Integer.parseInt(val);
    	val = params.get("sort");
    	if(val!=null){
    		Gson gson = new Gson();
        	sort = gson.fromJson(val, SortOrder[].class);//, sort.getClass());
    	}
    }
    public String OrderString(){
    	String order=null;
    	if(sort!=null && sort.length>0){
        	order="";
    		for(int i=0;i<sort.length;i++){
    			SortOrder s = sort[i];
    			if(i>0)
    			order+=", ";
    			order+=s.property;
    			if(s.direction==SortDirection.DESC)
    				order+=" desc";
    		}
    	}
    	return order;
    }
    public List<Object> ExtProcess(JPAQuery query)
    {
    	
    	if(start>0)
    	query =  query.from(start);
    	if(limit>0)
    		return  query.fetch(limit);
    	else
    		return query.fetch();
    }


}
