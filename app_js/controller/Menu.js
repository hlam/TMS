/// <reference path="../../ext/ext-all-dev.js" />

Ext.define('WebApp.controller.Menu', {
    extend: 'Ext.app.Controller',
    views: ['Navigation.Menu', 'Viewer', 'Customer.Grid'],
    refs: [
        { ref: 'viewer', selector: 'viewer' },
    ],
    message_url:"/room/messages",
    last_message_received: 0,
    msgCt:null,

	createBox: function (t, s){
	   return '<div class="msg"><h3>' + t + '</h3><p>' + s + '</p></div>';
	},
    msg : function(title, format){
        if(!this.msgCt){
        	this.msgCt = Ext.core.DomHelper.insertFirst(document.body, {id:'msg-div'}, true);
        }
        var s = Ext.String.format.apply(String, Array.prototype.slice.call(arguments, 1));
        var m = Ext.core.DomHelper.append(this.msgCt, this.createBox(title, s), true);
        m.hide();
        m.slideIn('t').ghost("t", { delay: 5000, remove: true});
    },

    // At this point things haven't rendered yet since init gets called on controllers before the launch function
    // is executed on the Application
    init: function () {
        this.control({
            'mainMenu menuitem': {
                click: this.menuAction
            },
            'callwindow button[action=loginsip]': {
                click: this.loginsip
            }

        });
    },

    loginsip:function(){
        InitSipPhone();
    },
    displayMessage: function(data){
    	this.msg("notification",data.type);
    	//alert(data);
    },
    getMessages : function () {
    	Ext.Ajax.request({
    	    url: this.message_url,
            scope: this,
    	    timeout: 6000000, 
    	    method: "GET",
    	    params: {
    	    	lastReceived: this.last_message_received
    	    },
    	    success: function(response){
    	        var events = Ext.JSON.decode(response.responseText);
    	        Ext.each(events, function(event) {
    	        	this.displayMessage(event.data)
                    this.last_message_received = event.id
    	        	
    	        }) 
                this.getMessages();
    	        
    	    },
    	    failure: function(){
    	    	setTimeout(function() {
    	    		GlobalApp.getController("Menu").getMessages();
    	    		}, 1000);
    	    }
    	});
    },
    menuAction: function (menuItem, event) {
        if (Ext.isEmpty(menuItem.action)) return;
        var tabs = this.getViewer();
        var tab_id = "tab_" + menuItem.action;
        var tab = tabs.getComponent(tab_id);
        if (!tab) {
            tab_conf = {
                xtype: menuItem.classtype,
                title: menuItem.text,
                iconCls: menuItem.iconCls,
                id: tab_id
            };
            tab = tabs.add(tab_conf);
            tabs.setActiveTab(tab);
            var store = tab.getStore();
            if (store) store.load();
        } else {
            tabs.setActiveTab(tab);
        }
    }

});
