package controllers;

import play.*;
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
    public static void registartion() {
        render();
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