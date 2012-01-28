Ext.Loader.setConfig({enabled:true});
Ext.Loader.setPath('Ext.ux', 'ext/ux/');
Ext.Error.handle = function(err) {
	console.log(err);
};
Ext.application({
    name: 'WebApp',
    autoCreateViewport: AppGlobalSetting.IsAuthenticated,
    //autoCreateViewport: false,

    appFolder: 'app_js',
    controllers: ['Login', 'Menu', 'Customers', 'Consultations', 'Call'],
    views: ['Call.CallWindow'],
    /* stores: ['Customers'],
    models: ['Customer'],
    */
    launch: function () {
        window.GlobalApp=this;
        if (!this.autoCreateViewport) {
            var login = this.getController("Login")
            login.showLogin();
            Ext.require([this.getModuleClassName('Viewport', 'view')]);
        }
    },
    startApp: function () {
        this.getView('Viewport').create();
        /*

        Ext.create('Ext.container.Viewport', {
        layout: 'fit',
        items: [
        {
        xtype: 'panel',
        title: 'Users',
        html : 'List of users will go here'
        }
        ]
        });
        */
    }
    /*

    }
    */
});
function red5phone_getConfig() {
    //alert("red5phone_getConfig");
    //var call=GlobalApp.getController("Call");
    //call.SipInit()
}

function InitSipPhone() {
    console.log("InitSipPhone");
    var call=GlobalApp.getController("Call");
    call.SipInit()
}
function SipPhone_Connection(success, messages){
    console.log("InitSipPhone");
    var call=GlobalApp.getController("Call");
    call.SipConnect(success, messages)
}