/// <reference path="../../ext/ext-all-dev.js" />

Ext.define('WebApp.controller.Menu', {
    extend: 'Ext.app.Controller',
    views: ['Navigation.Menu', 'Viewer', 'Customer.Grid'],
    refs: [
        { ref: 'viewer', selector: 'viewer' },
    ],

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
