
Ext.define('WebApp.model.ComboAdvisor', {
    extend: 'Ext.data.Model',
        proxy: {
        type: 'rest',
        url: 'Advisor/combo'
    },

   
    fields: [ 'id', 'name',  'rank', 'speciality','lpzName','lpzCity','level', 'type' ]
});
