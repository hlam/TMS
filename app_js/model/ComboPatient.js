
Ext.define('WebApp.model.ComboPatient', {
    extend: 'Ext.data.Model',
        proxy: {
        type: 'rest',
        url: 'Patient/combo'
    },

   
    fields: [ 'id','name', 'sex',  'age', 'country','city'
    ]
});
