package controllers;

import play.*;
import play.cache.Cache;
import play.data.validation.Email;
import play.data.validation.Required;
import play.data.validation.Valid;
import play.i18n.Lang;
import play.i18n.Messages;
import play.libs.Codec;
import play.libs.Images;
import play.mvc.*;
import play.mvc.Http.Request;
import play.mvc.results.RenderText;

import java.util.*;

import org.joda.time.DateTime;

import models.*;
import models.sendObject.CityList;
import models.sendObject.RankList;
import models.sendObject.RegionList;
import models.sendObject.SpecialityList;
import models.sendObject.UserLogin;

public class Application extends Controller {
    @Before
    static void addUser() {
        User user = connected();
        if(user != null) {
            renderArgs.put("user", user);
        }
        if(params.get("lang")!=null)
        	Lang.change(params.get("lang"));
        //if(Lang.get().equals(null)) Lang.change("uk");
        //renderArgs.put("langs", play.Play.langs);
        
    }
    
    static User connected() {
        if(renderArgs.get("user") != null) {
            return renderArgs.get("user", User.class);
        }
        
        String user_id = session.get("user");
        if(user_id != null) {
        	Long id = Long.parseLong(user_id);
            return User.findById(id);
        } 
        return null;
    }

    public static void index() {
        render();
    }

    public static void how_work() {
        render();
    }
    public static void lookupCity (Long region_id) {
    	List<City> cities = City.find("region.id=? order by name_ru", region_id).fetch();
        renderJSON(CityList.Convert(cities));
    }
    
    public static void lookupLPZ (Long city_id) {
    	List<Lpz> lpz = Lpz.find("city.id=? order by name", city_id).fetch();
        renderJSON(lpz);
    }
    private static void initregistartion(){
    	
    	List<Region> regions = Region.find("order by name_ru").fetch();
        renderArgs.put("region_list", RegionList.Convert(regions));
        
    	List<Rank> ranks = Rank.find("order by name_ru").fetch();
        renderArgs.put("rank_list", RankList.Convert(ranks));
    	List<models.Speciality> specialities = models.Speciality.find("order by name_ru").fetch();
        renderArgs.put("speciality_list", SpecialityList.Convert(specialities ));
        renderArgs.put("user", new User());
    
    }
    
    public static void forgotpassword() {
        String randomID = Codec.UUID();
        renderArgs.put("randomID",randomID);
        render();
    }
    public static void sendpassword(@Required @Email String email,
    		@Required(message="validation.req_code") String code,
    		String randomID) {
       	User user = User.find("email=?", email).first();
       	if(user==null)
       		validation.addError(email, Messages.get("validation.user_not_exist"));
        if(!Play.id.equals("test")) {
            validation.equals(code, Cache.get(randomID)).message(Messages.get("validation.invalid_captche"));
        }
        if(validation.hasErrors()) {
            render("@forgotpassword", email,  randomID);
        }
        Cache.delete(randomID);
        Mails.sendpassword(user);
        flash.success(Messages.get("site.password_sended"));
        forgotpassword();
    }
    
    public static void registartion() {
    	initregistartion();
        String randomID = Codec.UUID();
        renderArgs.put("randomID",randomID);

        render();
    }
    public static void validateCapcher(String randomID, String code){
        
    	if(!Play.id.equals("test")) {
        	renderText(code.equals(Cache.get(randomID)));
        }
        
        renderText(true);
    }
    
    public static void validateExsistUser(String email){
    		User user = User.find("email=?", email).first();
        	renderText(user==null);
    }
    public static void validateNotExsistUser(String email){
		User user = User.find("email=?", email).first();
    	renderText(user!=null);
    }
    
    public static void registerUser(
    		String lpz_id,
    		@Required String first_name,
    		@Required String last_name,
    		String  middle_name,
    		@Required @Email String email,
    		@Required Long rank_id,
    		@Required Long speciality_id,
    		@Required String password,
    		@Required String sex,
    		@Required Date birthday,
    		String verifyPassword,  
            @Required(message="validation.req_code") String code,
            @Required Long region_id,
            Lpz lpz,
            Boolean new_lpz,
    		String randomID
    		) {
    	
    	
        if(!Play.id.equals("test")) {
            validation.equals(code, Cache.get(randomID)).message(Messages.get("validation.invalid_captche"));
        }
        if(new_lpz==null || !new_lpz){
        	validation.required(lpz_id);
        }else{
        	//validation.required(lpz);
        	validation.valid(lpz);
        }
        
    	validation.required(verifyPassword);
        validation.equals(verifyPassword, password).message(Messages.get("validation.password_nomatch"));
        if(email!=null){
        	User user = User.find("email=?", email).first();
        	if(user!=null)
        		validation.addError(email, Messages.get("validation.user_exist"));
        }
        System.out.println(region_id);
        if(validation.hasErrors()) {
        	if(region_id!=null){
        		List<City> cities = City.find("region.id=? order by name_ru", region_id).fetch();
        		renderArgs.put("city_list",CityList.Convert(cities));
            	if(lpz.city!=null)
                    renderArgs.put("lpz_list", Lpz.find("city.id=? order by name", lpz.city.id).fetch());
        	}

        	initregistartion();
            render("@registartion", lpz_id, first_name,last_name ,middle_name , email, rank_id, speciality_id, sex, birthday, region_id, lpz, new_lpz,  randomID);
        }
        if(new_lpz==null || !new_lpz){
        	lpz = Lpz.findById(Long.parseLong(lpz_id));
        }else{
        	lpz.create();
        }

    	User user = new User();
        user.advisor = true;
        user.birthday = birthday;
        user.email = email;
        user.lpz = lpz;
        user.first_name = first_name;
        user.last_name = last_name;
        user.middle_name = middle_name;
        
        user.password = password;
        user.rank = models.Rank.findById(rank_id);
        user.speciality = models.Speciality.findById(speciality_id);
        user.sex = sex;
        user.status = User.Status.REGISTERED;
        if(new_lpz==null || !new_lpz){
            user.admin = User.AdminStatus.NONE;
        }else{
            user.admin = User.AdminStatus.ADMIN;
        }
        user.create();
        
        models.Advisor advisor = new models.Advisor();
        advisor.speciality = user.speciality;
        advisor.user = user;
        advisor.save();
         
        session.put("user", user.id);
        Cache.delete(randomID);
        Mails.welcome(user);

        redirect("Application.sys");
        
    }


    public static void conatcts() {
        render();
    }
    
	public static void sys() {
        render();
    }
    public static void login(String login, String password) {
        User user = User.find("byEmailAndPassword", login, password).first();
        if(user != null) {
            session.put("user", user.id);
            renderJSON( new  extjs.Response(true, new UserLogin(user.id, user.getName())));
        }
        renderJSON( new  extjs.Response(false, "IncorectLoginOrPassword"));
    }
    public static void loginForm(String login, String password) {
        User user = User.find("byEmailAndPassword", login, password).first();
        if(user != null) {
            session.put("user", user.id);
            renderText("ok");
        }
        renderText("error");
    }

    public static void logout() {
        session.clear();
        renderJSON(new extjs.Response(true));
    }
    public static void captcha(String id) {
        Images.Captcha captcha = Images.captcha();
        String code = captcha.getText();
        Cache.set(id, code, "30mn");
        renderBinary(captcha);
    }

}