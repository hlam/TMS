/// <reference path="../../ext/ext-all-dev.js" />

Ext.define('WebApp.controller.Login', {
    extend: 'Ext.app.Controller',

    views: ['Login.Login'],
    url: "login",
    url_logout: "logout",
    refs: [
        {ref: 'loginForm', selector: 'loginwindow form'},
        {ref: 'loginButton', selector: 'loginwindow button'},
        {ref: 'loginField', selector: 'loginwindow textfield[name=login]'},
        {
            ref: 'loginWindow', 
            selector: 'loginwindow', 
            autoCreate: true,
            xtype: 'loginwindow'
        }
    ],

    // At this point things haven't rendered yet since init gets called on controllers before the launch function
    // is executed on the Application
    init: function() {
        this.control({
            'loginwindow button[action=login]': {
                click: this.login
            },
            'loginwindow textfield': {
                specialkey: this.returnKeyHandler,
            },
            'loginwindow form': {
                validitychange : this.formValidation,
            },
            'toolbarmenu button[action=logout]': {
                click: this.logout
            },

        });
    },
    
    
    /**
     * Shows the add feed dialog window
     */
    showLogin: function() {
        this.getLoginWindow().show();
        this.getLoginField().focus();
		this.formValidation();
    },
    
    formValidation:  function( form, valid ) {
		var form  = this.getLoginForm();
		if ( !form.getForm().isValid()) {
			this.getLoginButton().setDisabled( true );
		} else {
			this.getLoginButton().setDisabled( false );
		}
	},
	returnKeyHandler: function( textfield, event ) { // Submit data on RETURN key press
		 if (event.getKey() == event.ENTER) {
			this.login();
         }
	},
    logout_next: function() {
            //Ext.getBody().setLoading("Logout..");
            Ext.Ajax.request({
            waitTitle: "Authenticating....",
            waitMsg:"Please Wait...", 
            method : "POST",
            url: this.url_logout,
            scope: this,
                success: function(response) {
                    window.location.href="./";
                }
            });
    },
    logout: function() {
            Ext.Msg.show({
             title:'Logout?',
             msg: 'Would you like to exit?',
             buttons: Ext.Msg.OKCANCEL,
             icon: Ext.Msg.QUESTION,
             scope: this,
             fn: function(buttonId){
                if(buttonId=="ok"){
                    this.logout_next()
                }
             }
            });


    },
    /**
     * @private
     * Creates a new feed in the store based on a given url. First validates that the feed is well formed
     * using FV.lib.FeedValidator.
     * @param {String} name The name of the Feed to create
     * @param {String} url The url of the Feed to create
     */
    login: function() {
        var win   = this.getLoginWindow(),
            form  = this.getLoginForm(),
            record = form.getRecord(),
            values = form.getValues();
			if(!form.getForm().isValid()) return;

       console.log("Start");
		form.getForm().submit({
            waitTitle: "Authenticating....",
            waitMsg:"Please Wait...", 
			url: this.url,
            scope: this,
            success: function(form, action) {
            		AppGlobalSetting.CurrentUser=action.result.data;
                    this.application.startApp();
    				win.close();
            },
            failure: function(form, action) {
					Ext.MessageBox.show({
                            title:"Login Failed.",
                            msg:"Invalid username or password. Please try again.",
                            buttons: Ext.Msg.OK,
                            icon:Ext.MessageBox.ERROR
                        });
            }
        });

        
    }
});
