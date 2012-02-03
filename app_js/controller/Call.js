/*

This file is part of Ext JS 4

Copyright (c) 2011 Sencha Inc

Contact:  http://www.sencha.com/contact

GNU General Public License Usage
This file may be used under the terms of the GNU General Public License version 3.0 as published by the Free Software Foundation and appearing in the file LICENSE included in the packaging of this file.  Please review the following information to ensure the GNU General Public License version 3.0 requirements will be met: http://www.gnu.org/copyleft/gpl.html.

If you are unsure which license is appropriate for your use, please contact the sales department at http://www.sencha.com/contact.

*/
Ext.define('WebApp.controller.Call', {
    extend: 'Ext.app.Controller',
    id:"controller-call",
    phone: null,
    mobile: null,
    url_sipinit:'Account/SipSetting',

    refs: [
        { ref: 'callWindow', selector: 'callwindow' },
        { ref: 'callFlash', selector: 'callwindow flash[name=callFlash]' },
        { ref: 'btnLogin', selector: 'callwindow button[action=login]' }

    ],

    init: function () {
        this.control({
            'callWindow button[action=dial]': {
                click: this.dial
            },
            'callWindow button[action=hangup]': {
                click: this.hangup
            }

        });
    },
    dial: function () {
        console.log("dial");
    },
    hangup: function () {
        console.log("hangup");
    },
    SipConnect: function(success, messages) {
        var btnLogin=this.getBtnLogin();
        btnLogin.setDisabled(success==1);
    },
    SipInit: function() {
            //Ext.getBody().setLoading("Logout..");
            Ext.Ajax.request({
            method : "POST",
            url: this.url_sipinit,
            scope: this,
                success: function(response) {
                    var result=Ext.JSON.decode(response.responseText);
                    var CallFlash=this.getCallFlash();
                    var swf=Ext.getDom(CallFlash.getSwfId());
                    swf.loginSip(result.data.SipPhone,result.data.SipName,result.data.SipPassword, result.data.SipUrl);
                },
                 failure: function(response) {
					Ext.MessageBox.show({
                            title:"File Logading.",
                            msg:"File Logading Si[ Setting.",
                            buttons: Ext.Msg.OK,
                            icon:Ext.MessageBox.ERROR
                        });
            }
            });
    },

});

