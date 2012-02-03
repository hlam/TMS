Ext.define('WebApp.controller.Patients', {
    extend: 'Ext.app.Controller',

    stores: ['Patients','ComboSexs','Countries'],
    models: ['Patient', 'Country'],
    views: ['Patient.Grid', 'Patient.Add'],


    refs: [
    { ref: 'addbtn', selector: 'patientgrid [action=add]' },
    
    {
        ref: 'addWindow', 
        selector: 'addpatientnwindow', 
        autoCreate: true,
        xtype: 'addpatientwindow'
    },
    { ref: 'addForm', selector: 'addpatientwindow form' },
    { ref: 'grid', selector: 'patientgrid' },
    
    ],
    url_add:'Patient/add',
    init: function () {
        this.control({
            'patientgrid button[action=add]': {
                click: this.add
            },
            'addpatientwindow button[action=add]': {
                click: this.addPatient
            },
            'addpatientwindow button[action=close]': {
                click: this.closePatient
            },
            'patientgrid': {
                select: this.rowSelect
            },
            'speciality_id': {
                select: this.selectSpeciality
            }

        });
    },
    closePatient: function(){
        var addWindow = this.getAddWindow();
        var addForm =this.getAddForm();
        addForm.getForm().reset()
        addWindow.close();
    },
    addPatient: function(){
        var win = this.getAddWindow();
        var form =this.getAddForm();
        record = form.getRecord(),
        values = form.getValues();
		if(!form.getForm().isValid()) return;

		form.getForm().submit({
	        //waitTitle: "Authenticating....",
	        //waitMsg:"Please Wait...", 
			url: this.url_add,
	        scope: this,
	        success: function(form, action) {
	        		var grid= this.getGrid();;
	        		grid.store.load();
	        		form.reset()
					win.close();
	        }
	    });
    },
    selectSpeciality: function(){
    	var addAdvisor = this.getAddAdvisor();
    	var addSpeciality = this.getAddSpecialityr();
    	
    	addAdvisor.clearValue();
    	addAdvisor.store.filter('speciality_id', addSpeciality.getValue());
    },
    add: function () {
        console.log("add consultants");
        /*
        var info = {
                xtype: "addpatientwindow",
                id: "addpatientwindow"
            };
        var addWindow = Ext.ComponentManager.create(info, 'component');
        */
        var addWindow = this.getAddWindow();
        console.log(addWindow);
        addWindow.show();
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

