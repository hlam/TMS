package models;
import java.util.*;

import play.libs.*;
import play.libs.F.*;

public class MesssageRoom {
    final  Map<Long, UserRoom>  messsageEvents = new HashMap<Long, UserRoom>();
    //ArchivedEventStream<MesssageRoom.Event>

    public Boolean isOnline(Long user_id,Event event) {
    	UserRoom user = this.get(user_id);
    	if(user==null) return false;
    	if(user.isOffline()){
    		messsageEvents.remove(user_id);
    		user = null;
    		return false;
    	}
    	return true;
    }
    public void publish(Long user_id,Event event) {
    	UserRoom user = this.get(user_id);
    	if(user==null) return;
    	user.chatEvents.publish(event);
    }
    /**
     * For long polling, as we are sometimes disconnected, we need to pass 
     * the last event seen id, to be sure to not miss any message
     */
    public Promise<List<IndexedEvent<MesssageRoom.Event>>> nextMessages(long lastReceived, Long user_id) {
    	UserRoom user = this.get(user_id);
    	if(user==null){
    		user = new UserRoom();
    		this.put(user_id, new UserRoom());
    	}
    	user.ping();
        return user.chatEvents.nextEvents(lastReceived);
    }
    public static class UserRoom {
        
        public Long lastActive;
        final public String status;
        final int offline_time = 60000;
        final public ArchivedEventStream<MesssageRoom.Event> chatEvents = new ArchivedEventStream<MesssageRoom.Event>(10);
        
        public UserRoom(String status) {
        	this.status = status;
            this.lastActive = System.currentTimeMillis();
        }
        public UserRoom() {
        	this.status = "system";
            this.lastActive = System.currentTimeMillis();
        }
        public void ping() {
        	this.lastActive = System.currentTimeMillis();
        }
        public Boolean isOffline() {
        	return (System.currentTimeMillis()-this.lastActive)>offline_time;
        }
    }

    public static abstract class Event {
        
        final public String type;
        final public Long timestamp;
        
        public Event(String type) {
            this.type = type;
            this.timestamp = System.currentTimeMillis();
        }
        
    }
    public static class QuestEvent extends Event {
        
        final public Long user_id;
        final public Long quest_id;
        final public String status;
        
        public QuestEvent(long user_id, Long quest_id, String status) {
            super("quest");
            this.user_id = user_id;
            this.quest_id = quest_id;
            this.status = status;
        }
        
    }

    static MesssageRoom instance = null;
    public static MesssageRoom get() {
        if(instance == null) {
            instance = new MesssageRoom();
        }
        return instance;
    }
    public UserRoom get(Long id) {
    	
    	UserRoom room  = this.messsageEvents.get(id);
        return room;
    }
    public void put(Long id, UserRoom room) {
    	this.messsageEvents.put(id, room);
    }
    
}
