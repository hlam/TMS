Ext.define('WebApp.controller.Consultations', {
    extend: 'Ext.app.Controller',

    stores: ['Consultations','ComboPatients','Patients', 'Specialities', 'ComboAdvisors'],
    models: ['Consultation','ComboPatient','Patient','Speciality', 'ComboAdvisor'],
    views: ['Consultation.Grid', 'Consultation.Add'],


    refs: [
    { ref: 'addbtn', selector: 'consultationgrid [action=add]' },
    { ref: 'addSpeciality', selector: 'speciality_id' },
    { ref: 'addAdvisor', selector: 'advisor_id' },
    
    {
        ref: 'addWindow', 
        selector: 'addconsultationwindow', 
        autoCreate: true,
        xtype: 'addconsultationwindow'
    },
    { ref: 'addForm', selector: 'addconsultationwindow form' },
    { ref: 'consultationGrid', selector: 'consultationgrid' },
    
    ],
    url_add:'Consultation/add',
    init: function () {
        this.control({
            'consultationgrid button[action=add]': {
                click: this.add
            },
            'addconsultationwindow button[action=add]': {
                click: this.addConsultation
            },
            'addconsultationwindow button[action=close]': {
                click: this.closeConsultation
            },
            'consultationgrid': {
                select: this.rowSelect
            },
            'speciality_id': {
                select: this.selectSpeciality
            }

        });
    },
    closeConsultation: function(){
        var addWindow = this.getAddWindow();
        var addForm =this.getAddForm();
        addForm.getForm().reset()
        addWindow.close();
    },
    addConsultation: function(){
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
	        		var grid= this.getConsultationGrid();
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
                xtype: "addconsultationwindow",
                id: "addconsultationwindow"
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

