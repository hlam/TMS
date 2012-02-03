Ext.define('WebApp.view.Call.CallWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.callwindow',
    renderTo: Ext.getBody(),
    closeAction:'hide',
    //autoShow: true,
    requires: [
    /*
    'Ext.layout.container.Border'
    */
    ],
    title: 'News Phone Call',
    height: 400,
    width: 500,
    layout: 'border',
/*
    dockedItems: [{
    xtype: 'toolbar',
        margins: "0 0 4 0",
        dock: 'top',
        items: [
            { xtype: 'button', text: 'Dial', action:'dial', iconCls: "DialSettings" },
            { xtype: 'button', text: 'Hung-Up', action:'hungup',iconCls: "HungupSettings", disabled:true },
            { xtype: 'button', text: 'Options', action:'options',iconCls: "OptionSettings" }
        ]
    }],
    */
    items: [ 
    {
        region: 'north',
        xtype: 'toolbar',
        margins: "0 0 4 0",
        dock: 'top',
        items: [
            { xtype: 'button', scale: 'large', iconAlign: 'top', text: 'Dial', action: 'dial', iconCls: "DialSettings" },
            { xtype: 'button', scale: 'large', iconAlign: 'top', text: 'Hung-Up', action: 'hungup', iconCls: "HungupSettings", disabled: true },
            { xtype: 'button', scale: 'large', iconAlign: 'top', text: 'Options', action: 'options', iconCls: "OptionSettings" },
            { xtype: 'button', scale: 'large', iconAlign: 'top', text: 'Login', action: 'loginsip', iconCls: "IconLogin" }
        ]
    },
    
        {
            region: 'center',
            xtype: 'flash',
            name: "callFlash",
            swfWidth:"266",
            swfHeight:"262",
            url: './swf/red5phone.swf'
        }
    ]
}
)