
Ext.define('WebApp.model.Speciality', {
    extend: 'Ext.data.Model',
        proxy: {
        type: 'rest',
        url: 'Speciality/combo'
    },

   
    fields: [ 'name', 'id' ]
});
