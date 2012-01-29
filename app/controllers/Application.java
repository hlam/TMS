package controllers;

import play.*;
import play.data.validation.Valid;
import play.mvc.*;

import java.util.*;

import models.*;
import models.sendObject.UserLogin;

public class Application extends Controller {
    @Before
    static void addUser() {
        User user = connected();
        if(user != null) {
            renderArgs.put("user", user);
        }
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
    private static void initregistartion(){
        renderArgs.put("lpz_list", LPZ.find("order by name").fetch());
        renderArgs.put("rank_list", Rank.find("order by name").fetch());
        renderArgs.put("speciality_list", models.Speciality.find("order by name").fetch());
        renderArgs.put("user", new User());
    
    }
    public static void registartion() {
    	initregistartion();
        render();
    }
     
    public static void registerUser(@Valid User user, String verifyPassword,  Long speciality_id) {
    	validation.required(verifyPassword);
        validation.required(speciality_id);
        validation.equals(verifyPassword, user.password).message("Пароль не совпажает");
        System.out.println(verifyPassword+"="+user.password);
        System.out.println("speciality_id="+speciality_id);

        
        if(validation.hasErrors()) {
        	initregistartion();
            render("@registartion", user, verifyPassword, speciality_id);
        }
        user.create();
        models.Advisor advisor = new models.Advisor();
        advisor.speciality = models.Speciality.findById(speciality_id);
        advisor.user = user;
        advisor.save();
         
        session.put("user", user.id);
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
            renderJSON( new  extjs.Response(true, new UserLogin(user.id, user.name)));
        }
        renderJSON( new  extjs.Response(false, "IncorectLoginOrPassword"));
    }

    public static void logout() {
        session.clear();
        renderJSON(new extjs.Response(true));
    }

}