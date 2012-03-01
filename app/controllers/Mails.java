package controllers;

import models.User;
import play.i18n.Lang;
import play.i18n.Messages;
import play.mvc.Mailer;

public class Mails extends Mailer {
    public static void welcome(User user) {
    	 setSubject(Messages.get("mail.welcome", user.name));
         addRecipient(user.email);
         setFrom(Messages.get("mail.from_email"));
         send("Mails/welcome."+Lang.get(),user);
    }    
    public static void sendpassword(User user) {
   	 setSubject(Messages.get("mail.sendpassword"));
        addRecipient(user.email);
        setFrom(Messages.get("mail.from_email"));
        send("Mails/sendpassword."+Lang.get(),user);
   }    

}
