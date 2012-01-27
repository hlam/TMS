Ext.define('WebApp.controller.Consultations', {
    extend: 'Ext.app.Controller',

    stores: ['Consultations'],
    models: ['Consultation'],
    views: ['Consultation.Grid'],


    refs: [
    { ref: 'addbtn', selector: 'consultationgrid [action=add]' },
    { ref: 'callWindow', selector: 'callwindow' }

    ],

    init: function () {
        this.control({
            'consultationgrid button[action=call]': {
                click: this.callPhone
            },
            'consultationgrid': {
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

