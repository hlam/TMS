/*

This file is part of Ext JS 4

Copyright (c) 2011 Sencha Inc

Contact:  http://www.sencha.com/contact

GNU General Public License Usage
This file may be used under the terms of the GNU General Public License version 3.0 as published by the Free Software Foundation and appearing in the file LICENSE included in the packaging of this file.  Please review the following information to ensure the GNU General Public License version 3.0 requirements will be met: http://www.gnu.org/copyleft/gpl.html.

If you are unsure which license is appropriate for your use, please contact the sales department at http://www.sencha.com/contact.

*/
Ext.define('WebApp.controller.Customers', {
    extend: 'Ext.app.Controller',

    stores: ['Customers'],
    models: ['Customer'],
    views: ['Customer.Grid'],


    refs: [
    { ref: 'callbtn', selector: 'customergrid [action=call]' },
    { ref: 'callWindow', selector: 'callwindow' }

    ],

    init: function () {
        this.control({
            'customergrid button[action=call]': {
                click: this.callPhone
            },
            'customergrid': {
                select: this.rowSelect
            }

        });
    },
    callPhone: function () {
        console.log("callPhone");
        var record = this.getCallWindow();
        var callWindow = this.getCallWindow();
        callWindow.show();
    },
    rowSelect: function (model, record, index, eOpts) {
        console.log("rowSelect", model, record, index, eOpts);
        var mobile = record.get("Mobile");
        var phone = record.get("Phone");
        var callbtn = this.getCallbtn();
        if (mobile == null) mobile = "";
        if (phone == null) phone = "";
        callbtn.setDisabled(mobile == "" && phone == "");
    }

});

