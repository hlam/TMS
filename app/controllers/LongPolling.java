package controllers;

import play.*;
import play.mvc.*;
import play.i18n.Lang;
import play.libs.F.*;

import java.util.*;
import com.google.gson.reflect.*;

import models.*;

public class LongPolling extends Controller {
    @Before
    static void addUser() {
    	Application.addUser();
        
    }

    public static void Quest(Long user_id, Long quest_id, String status) {
    	User user = Application.connected();
    	MesssageRoom.get().publish(user_id, new MesssageRoom.QuestEvent(user.id, quest_id, status ) );
    }
    
    
    public static void waitMessages(Long lastReceived) {  
    	User user = Application.connected();
        // Here we use continuation to suspend 
        // the execution until a new message has been received
        List messages = await(MesssageRoom.get().nextMessages(lastReceived, user.id));
        renderJSON(messages, new TypeToken<List<IndexedEvent<MesssageRoom.Event>>>() {}.getType());
    }
    
    
}

